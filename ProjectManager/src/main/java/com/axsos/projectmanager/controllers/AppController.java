package com.axsos.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.projectmanager.models.LoginUser;
import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.Task;
import com.axsos.projectmanager.models.User;
import com.axsos.projectmanager.repositories.UserRepository;
import com.axsos.projectmanager.services.UserService;



@Controller
public class AppController {
	
private final UserService userServ;
	
	public AppController(UserService userServ) {
		this.userServ = userServ;
	}
	 @RequestMapping("/")
	    public String index(Model model,HttpSession session) {
	    
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        
	        if(session.getId()=="id") {
	        if((boolean) session.getAttribute("islogin")) {
	        	if(session.getId()=="id") {
	    	        return "redirect:/dashboard";

	        	}
	        }else {
		        session.setAttribute("islogin", false);

	        }}
	        
	        return "index.jsp";
	    }
	 
	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // TO-DO Later -- call a register method in the service 
	        // to do some extra validations and create a new user!
	        
	        if(result.hasErrors()) {
	            // Be sure to send in the empty LoginUser before 
	            // re-rendering the page.
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
	        User user =userServ.register(newUser, result);
	       if(user!=null) {
	    	   session.setAttribute("id", user.getId());
	    	   session.setAttribute("islogin", true);

   	        return "redirect:/dashboard";
	       }
        return "index.jsp";

	        
	    }
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // Add once service is implemented:
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            
	            return "index.jsp";

	        }
	        
	        User user = userServ.login(newLogin, result);
	        if(user!=null) {
	        	
	        	
	        	session.setAttribute("id", user.getId());
	        	session.setAttribute("islogin", true);
	        	System.out.println(session.getAttribute("id"));
    	        return "redirect:/dashboard";
	        }
	        
            model.addAttribute("newUser", new User());

            return "index.jsp";

	        
	        
	    }
	    
	    @RequestMapping("/dashboard")
	    public String dashboard(Model model,HttpSession session) {
	    	
 	if((!(boolean)session.getAttribute("islogin"))&&session.getAttribute("id")==null ){
	    		
	    		return "redirect:/";
	    		
	    		
	    	}
 	
	User user = userServ.find((Long)session.getAttribute("id"));
	List<Project> allpro = user.getMyproject();
	model.addAttribute("user", user);
	model.addAttribute("projects", userServ.findprojectforpersonnot(user.getId()));
	
    allpro.addAll(user.getMemberin());
	model.addAttribute("myprojects",allpro) ;
	
	

	    	
	        return "home.jsp";

	    	
	    }
	    
	    @RequestMapping("/project/new")
	    public String createproject(@ModelAttribute("project")Project project ,HttpSession session) 
	    	{
	    		
	    		return "/project/project.jsp";
	    	}
	    
	    @PostMapping("/create/project")
	    public String newproject(@Valid @ModelAttribute("project") Project project , BindingResult result,Model model,HttpSession session) 
	    	{
	    	
	    		if(result.hasErrors()) {
	    		return "/project/project.jsp";}
	    		
	    		User user = userServ.find((Long)session.getAttribute("id"));

	    		userServ.createproject(user.getId(), project);
    	        return "redirect:/dashboard";
	    	}
	    
	    @RequestMapping("/join/{id}")
	    public String joinproject(@PathVariable("id") Long id, @ModelAttribute("project")Project project ,HttpSession session) 
	    	{
	    		System.out.println(id);
    		User user = userServ.find((Long)session.getAttribute("id"));
    		userServ.addmembertoproject(user, id);
	    		return "redirect:/dashboard";
	    	}
	    @RequestMapping("/unjoin/{id}")
	    public String unjoinproject(@PathVariable("id") Long id, @ModelAttribute("project")Project project ,HttpSession session) 
	    	{
    		User user = userServ.find((Long)session.getAttribute("id"));
    		userServ.deletemembertoproject(user, id);
	    		return "redirect:/dashboard";
	    	}
	    
	    @GetMapping("/logout")
	    public String clearSession(HttpSession session) {
	    	session.removeAttribute("id");
	        session.setAttribute("islogin", false);
	    	session.removeAttribute("email");


	    	return "redirect:/";
	    }
	    @RequestMapping("/show/{id}")
	    public String showproject(@PathVariable("id") Long id ,Model model,HttpSession session) 
	    	{
	    		System.out.println(id);
		    		User user = userServ.find((Long)session.getAttribute("id"));
    		Project p = userServ.findproject(id);
    		model.addAttribute("project", p);
    		model.addAttribute("user", user);

	    		return "/project/showproject.jsp";
	    	}
	    
	    @RequestMapping("/edit/{id}")
	    public String editproject(@PathVariable("id") Long id, @ModelAttribute("project")Project project ,Model model,HttpSession session) 
	    	{
	    		System.out.println(id);
		    		User user = userServ.find((Long)session.getAttribute("id"));
    		Project p = userServ.findproject(id);
    		model.addAttribute("project", p);
    		model.addAttribute("user", user);

	    		return "/project/editproject.jsp";
	    	}
	    @PostMapping("/project/edit/{id}")
	    public String newproject(@PathVariable("id") Long id,@Valid @ModelAttribute("project") Project project , BindingResult result,Model model,HttpSession session) 
	    	{
	    	
	    		if(result.hasErrors()) {
	    			
	    		return "/project/editproject.jsp";}
	    		
	    		User user = userServ.find((Long)session.getAttribute("id"));

	    		userServ.updateproject(id, project);
    	        return "redirect:/dashboard";
	    	}
	    @RequestMapping("/delete/{id}")
	    public String deleteproject(@PathVariable("id") Long id ,Model model,HttpSession session) 
	    	{
	    		userServ.deleteproject(id);

	        return "redirect:/dashboard";
	    	}
	    
	    @RequestMapping("/task/{id}")
	    public String show(@PathVariable("id") Long id ,Model model,HttpSession session) 
	    	{
	    	
    		Project p = userServ.findproject(id);
    		model.addAttribute("project", p);

    		User user = userServ.find((Long)session.getAttribute("id"));

	    		List<Task> tasks =userServ.findtask(p);
	    		model.addAttribute("tasks", tasks);

	        return "/project/taskshow.jsp";
	    	}
	    
	    @PostMapping("/new/task/{id}")
	    public String task(@RequestParam("title")String s,@PathVariable("id") Long id ,Model model,HttpSession session) 
	    	{
	    	
	    	Project p = userServ.findproject(id);
    		List<Task> tasks =userServ.findtask(p);
	    	
    		
    		User user = userServ.find((Long)session.getAttribute("id"));

	    	userServ.createTas(user,p,s);
	    		

	        return "redirect:/task/"+id;
	    	}
	    
	    

}
