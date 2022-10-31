package axsos.java.jspdemo;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller

public class CounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}
	

	@RequestMapping("/")
	 public String welcom(Model model,HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);	
			model.addAttribute("countToShow", 0);}
			else {
//				session.setAttribute("count",(Integer)session.getAttribute("count")+1);		

				Integer currentCount = (Integer) session.getAttribute("count");

				model.addAttribute("countToShow", currentCount);
				}
		
	    return "show.jsp";
	    }
	@RequestMapping("/show")
	public String showCount(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);	
			model.addAttribute("countToShow", 0);}
			else {
				session.setAttribute("count",(Integer)session.getAttribute("count")+1);		

				Integer currentCount = (Integer) session.getAttribute("count");

				model.addAttribute("countToShow", currentCount);
				}
		return "index.jsp";
	}
		@RequestMapping("/clear")
		public String clear(HttpSession session, Model model) {
			
				session.setAttribute("count", 0);	
	
		
		return "index.jsp";
		}
		
		@RequestMapping("/reset")
		public String reset(HttpSession session, Model model) {
			
				session.setAttribute("count", 0);	
				
		
		return "index.jsp";
		
	}
		@RequestMapping("/add2")
		public String add2(HttpSession session, Model model) {
			
				session.setAttribute("count", (Integer) session.getAttribute("count")+2);	
				Integer currentCount = (Integer) session.getAttribute("count");

				model.addAttribute("countToShow", currentCount);
		
		return "index.jsp";
		
	}

}
