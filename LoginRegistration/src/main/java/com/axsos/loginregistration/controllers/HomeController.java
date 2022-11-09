package com.axsos.loginregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.loginregistration.models.LoginUser;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.services.UserService;


@Controller
public class HomeController {
	private final UserService userServ;
	
	public HomeController(UserService userServ) {
		this.userServ = userServ;
	}
	 @GetMapping("/")
	    public String index(Model model, HttpSession session) {
	    
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        if(session.getId()=="islogin") {
	        	if(session.getId()=="id") {
	    	        return "redirect:/home";

	        	}
	        }else {
		        session.setAttribute("islogin", false);

	        }
	        
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

		        return "redirect:/home";

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
	        else {
	        User user = userServ.login(newLogin, result);
	        	session.setAttribute("id", user.getEmail());
	        	session.setAttribute("islogin", true);
	        	return "redirect:/home";

	        }
	        
	    }
	    @GetMapping("/home")
	    public String home(Model model,HttpSession session) {
	    	if((!(boolean)session.getAttribute("islogin"))||session.getAttribute("id")==null ){
	    		
	    		return "redirect:/";
	    		
	    	}
	    	User user = userServ.find((Long)session.getAttribute("id"));
	    	model.addAttribute("user", user);
	        return "home.jsp";

 
	    	
	    	
	    }
	    
}
