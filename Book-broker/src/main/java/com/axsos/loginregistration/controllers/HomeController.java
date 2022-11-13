package com.axsos.loginregistration.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	        
	        if(session.getId()=="id") {
	        if((boolean) session.getAttribute("islogin")) {
	        	if(session.getId()=="id") {
	    	        return "redirect:/books";

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
	    	
	    	 if((boolean) session.getAttribute("islogin")) {
		        	if(session.getId()=="id") {
		    	        return "redirect:/books";

		        	}
		        }
        	System.out.println(session.getAttribute("id"));

	    	if((!(boolean)session.getAttribute("islogin"))&&session.getAttribute("id")==null ){
	    		
	    		return "redirect:/";
	    		
	    	}
	    	User user = userServ.find((Long)session.getAttribute("id"));
	    	
	    	
	    	if(user!=null) {
	    		
	    	model.addAttribute("user", user);
	    	
	    	List<Book> all = userServ.allBook();
	    	if(user.getBorrowBooks().size()>0)
	    	for(int i =0;i<all.size();i++) {
	    		for(int c =0; user.getBorrowBooks().size()-1>c;c++)
	    		if(all.get(i)==user.getBorrowBooks().get(c)) {
	    			all.remove(i);
	    			
	    		}
	    		

	    	}
	    	
	    
	    	
//	    	List<Book> all = userServ.allBook();

	    	
	    	model.addAttribute("Books", userServ.findbookotborrow());


	        return "home.jsp";
	    	}
	        return "home.jsp";

 
	    	
	    	
	    }
	    @GetMapping("/books/new")
	    public String gotonew(HttpSession session,Model model,	@ModelAttribute("book")Book book) {
	    	 if((boolean) session.getAttribute("islogin")) {
		        	if(session.getId()=="id") {
		    	        return "redirect:/books";

		        	}
		        }
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
	    	
	    	return "redirect:/books/"+book2.getId();
	    }
	    @GetMapping("/books/{id}")
	    public String showBook(@PathVariable("id") Long id,  Model model,HttpSession session)  {
	    	 if((boolean) session.getAttribute("islogin")) {
		        	if(session.getId()=="id") {
		    	        return "redirect:/books";

		        	}
		        }

	        	Object id2 = session.getAttribute("id");
	        	Long i = (Long) id2;
	        	
	        	System.out.println(i);
	        	User user=userServ.find(i);
	    	
	    		Book book = userServ.findBook(id);
	    		model.addAttribute("book", book);
	        	if(book.getUser().getId()==user.getId())
	        	{
	        		
	        		model.addAttribute("flag", 1);
	        	}else {
        		model.addAttribute("flag", 0);}


		    	return "/book/showbook.jsp";

	    }
	    
	    @GetMapping("/logout")
	    public String clearSession(HttpSession session) {
	    	session.removeAttribute("id");
	        session.setAttribute("islogin", false);
	    	session.removeAttribute("email");


	    	return "redirect:/";
	    }
	    
	    @GetMapping("/books/edit/{id}")
	    public String editBook(@PathVariable("id") Long id,  Model model,HttpSession session)  {
	    	 if((boolean) session.getAttribute("islogin")) {
		        	if(session.getId()=="id") {
		    	        return "redirect:/books";

		        	}
		        }
	    	 Book book1=userServ.findBook(id);
	    	 model.addAttribute("book",book1 );
	    		Object id2 = session.getAttribute("id");
	        	Long i = (Long) id2;
	        	
	        	System.out.println(i);
	        	User user=userServ.find(i);
	        	model.addAttribute("user", user);
	    	 
	    	 
	    	
	    		
		    	return "/book/editbook.jsp";

	    }
	    
	    
	    @PostMapping("/books/edit/{id}/edit")
	    public String puteditbook(@PathVariable("id") Long id,@Valid @ModelAttribute("book") Book book, BindingResult result) throws IOException {
	    	
	    	if(result.hasErrors()) {
		    	return "/book/editbook.jsp";
 
	    	}
	    	
	    	userServ.UpdatedBook(id, book);
	    	
	    	return "redirect:/books/"+id;
	    	
	    	
	    }
	    @PostMapping("/delete/{id}")
	    public String deletebook(@PathVariable("id") Long id) {
	    	userServ.deletebook(id);
	    	return "redirect:/books";
	    }
	    @GetMapping("/books/borrow/{id}")
	    public String borrow(@PathVariable("id") Long id,HttpSession session,Model model) {
	    	Book book =userServ.findBook(id);
	    	
	    	Object id2 = session.getAttribute("id");
        	Long i = (Long) id2;
        	
        	System.out.println(i);
        	User user=userServ.find(i);
        	
           	userServ.borrowbook(book, user);
	    	
//           	model.addAttribute("user", user);
	    	
	    	return "redirect:/books";
	    }
	    @GetMapping("/books/undoborrow/{id}")
	    public String undoborrow(@PathVariable("id") Long id,HttpSession session,Model model) {
	    	Book book =userServ.findBook(id);
	    	
	    	Object id2 = session.getAttribute("id");
        	Long i = (Long) id2;
        	
        	System.out.println(i);
        	User user=userServ.find(i);
        	userServ.undoborrowbook(book, user);
         	
//           	model.addAttribute("user", user);

	    	
	    	
	    	return "redirect:/books";
	    }
	    
	    
	    
}
