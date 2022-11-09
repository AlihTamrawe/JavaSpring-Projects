package com.axsos.loginregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.loginregistration.models.LoginUser;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.repositories.UserRepository;
    

    
@Service
public class UserService {
    
    @Autowired
    private final  UserRepository userRepo;
    
    public UserService(UserRepository userRepo){
    	this.userRepo = userRepo;
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

    	}else {
    		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    		if(potentialUser.isPresent()) {
    			
    			if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
    			    result.rejectValue("password", "Matches", "Invalid Password!");
    	        	return null;

    			}else {
    				return potentialUser.get();
    			}
    		}

    	}
    	

    	return null;
    }
}