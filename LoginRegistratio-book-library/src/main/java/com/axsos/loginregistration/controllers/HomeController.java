package com.axsos.loginregistration.controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.loginregistration.models.Book;
import com.axsos.loginregistration.models.LoginUser;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.services.UserService;


@Controller
public class HomeController {
	private final UserService userServ;
	
	public HomeController(UserService userServ) {
		this.userServ = userServ;
	}
	 @RequestMapping("/")
	    public String index(Model model,HttpSession session) {
	    
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        
	        
	        if((boolean) session.getAttribute("islogin")) {
	        	if(session.getId()=="id") {
	    	        return "redirect:/books";

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

		        return "redirect:/books";

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
	            return "redirect:/books";
	        }
	        
            model.addAttribute("newUser", new User());

            return "index.jsp";

	        
	        
	    }
	    @GetMapping("/books")
	    public String home(Model model,HttpSession session) {
        	System.out.println(session.getAttribute("id"));

	    	if((!(boolean)session.getAttribute("islogin"))&&session.getAttribute("id")==null ){
	    		
	    		return "redirect:/";
	    		
	    	}
	    	User user = userServ.find((Long)session.getAttribute("id"));
	    	if(user!=null) {
	    	model.addAttribute("user", user);
	    	
	    	model.addAttribute("Books",userServ.allBook() );
	        return "home.jsp";
	    	}
	        return "home.jsp";

 
	    	
	    	
	    }
	    @GetMapping("/books/new")
	    public String gotonew(HttpSession session,Model model,	@ModelAttribute("book")Book book) {
        	System.out.println(session.getAttribute("id"));

	    	return "/book/book.jsp";
	    }
	    @PostMapping("/books/add")
	    public String newBook( @Valid @ModelAttribute("book")Book book,HttpSession session ,  BindingResult result) throws IOException {
	    	if(result.hasErrors()) {	
		    	return "/book/book.jsp";	
	    	}
	    	if(session.getAttribute("id")==null)
	    	{
	    		return "redirect:/";
	    	}
	    	
        	Object id = session.getAttribute("id");
        	Long i = (Long) id;
        	
        	System.out.println(i);
        	User user=userServ.find(i);
        	System.out.println(user.getUserName());
        	book.setUser(user);
	    	Book book2=userServ.createBook(book);
//	    	userServ.AddBooktouser(book2, user);
	    	
	    	return "redirect:/books/"+book2.getId()+"/";
	    }
	    @GetMapping("/books/{id}")
	    public String showBook(@PathVariable("id") Long id,  Model model,HttpSession session)  {
	    	
	    	Book book = userServ.findBook(id);
	    	model.addAttribute("book", book);
		    	return "/book/showbook.jsp";

	    		
	    	
	    	
	    }
	    
	    @GetMapping("/logout")
	    public String clearSession(HttpSession session) {
	    	session.removeAttribute("id");
	        session.setAttribute("islogin", false);
	    	session.removeAttribute("email");


	    	return "redirect:/";
	    }
	    
}
