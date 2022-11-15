package com.axsos.projectmanager.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.projectmanager.models.LoginUser;
import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.Task;
import com.axsos.projectmanager.models.User;
import com.axsos.projectmanager.repositories.ProjectRepository;
import com.axsos.projectmanager.repositories.TaskRep;
import com.axsos.projectmanager.repositories.UserRepository;

    

    
@Service
public class UserService {
    
    @Autowired
    private final  UserRepository userRepo;
    
    private final ProjectRepository projectRepo;
    private final TaskRep taskRep;

    
    public UserService(UserRepository userRepo,ProjectRepository projectRepo,TaskRep taskRep){
    	this.userRepo = userRepo;
    	this.projectRepo = projectRepo;
    	this.taskRep = taskRep;
    }
    
   
 

    public User find(Long id) {
    	
    	return  userRepo.findById(id).get();
    }
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());

    	
    	if(result.hasErrors()) {
        	return null;

    	}else {
    		if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    		    
    		}
    		else {
    			
    			if(!potentialUser.isPresent()) {
        			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());

    				newUser.setPassword(hashed);
        			userRepo.save(newUser);
        			return newUser;
    			}
    		}

    	}
    	return null;


    }
    public User findbyemail(String email) {
    	return userRepo.findByEmail(email).get();
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	if(result.hasErrors()) {
        	return null;

    	}
    		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    		if(potentialUser.isPresent()) {
    			
    			if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
    			    result.rejectValue("password", "Matches", "Invalid Password!");
    	        	return null;

    			}
    			}
    		
    		if(!potentialUser.isPresent()) {
			    result.rejectValue("email", "Matches", "Invalid email!");

				return null;

    		}
    		
    		
    		return potentialUser.get();

    	
    	

    }
    
    public  List<Project> findallproject(){
    	
    	
    	return projectRepo.findAllProjects();
    }
    	public  List<Project> findprojectforperson(Long id){
    	
    	return (List<Project>) projectRepo.findprojectbyuser(id);
    }
    
     	public  List<Project> findprojectforpersonnot(Long id){
        	
        	return (List<Project>) projectRepo.findprojectnocontainperson(id);
        }
     	public Project createproject(Long id,Project p) {
     		
     		p.setTeamLead(userRepo.findById(id).get());
     	
     		return 	projectRepo.save(p);
     		
     		
     	}
     	public Project addmembertoproject(User user,Long id) {
     		
     		Project p = projectRepo.findById(id).get();
     		System.out.println(p.getTitle());
     		
     		List<User> u=p.getParticipant();
     		if(u.contains(user)) {
     			return null;
     		}
     		u.add(user);
     		p.setParticipant(u);
     		
     		return projectRepo.save(p);
     	}
    	public Project deletemembertoproject(User user,Long id) {
     		Project p = projectRepo.findById(id).get();
     			
     		List<User> u=p.getParticipant();
     		u.remove(p);
     		p.setParticipant(u);
     		List<Project> p2=user.getMemberin();
     		p2.remove(p);
     		userRepo.save(user);
     		return projectRepo.save(p);
     	}
    	
    	public Project findproject(Long id) {
     		Project p = projectRepo.findById(id).get();
     			
     	
     		return p;
     	}
    	
    	
    	public Project updateproject(Long id,Project p) {
     		
     		Project p2 =findproject(id);
     		p2.setDate(p.getDate());
     		p2.setTitle(p.getTitle());
     		p2.setDescription(p.getDescription());

     		return 	projectRepo.save(p2);
     		
     		
     	}
public void deleteproject(Long id) {
     		
     		Project p2 =findproject(id);
     		projectRepo.delete(p2);
     		
     		
     	}
public Task createTas(User user,Project p,String s) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate = LocalDate.now();
        Date date = new Date(localDate.atStartOfDay(ZoneId.of("America/New_York")).toEpochSecond() * 1000);
		Task t =new Task();
		t.setDate(date);
		t.setTitle(s);
		t.setOwner(user);
		t.setProject(p);
		taskRep.save(t);
	
		return null;
		
		
	}
 public List<Task> getalltask(Project p) {
	 return taskRep.findAllTasksbyproject(p.getId());
	 
 }
 public List<Task> findtask(Project p) {
	 return taskRep.findAllTasksbyproject(p.getId());
	 
 }

}