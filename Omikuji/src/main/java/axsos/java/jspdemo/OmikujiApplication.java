package axsos.java.jspdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@Controller
public class OmikujiApplication {
	Omikujiclass om ;
	public static void main(String[] args) {
		SpringApplication.run(OmikujiApplication.class, args);
	}
	@RequestMapping("/")
	public String first() {
		
		
		return "redirect:/omikuji";
	}
	@RequestMapping("/omikuji")
	public String okayama() {
		
		
		return "index.jsp";
	}
	@RequestMapping("/omikuji/show")
	public String showing(Model model) {
		 model.addAttribute("Omikuji",om);
		
		return "Show.jsp";
	}
	
	
	@PostMapping("/login")	
	public String show( @RequestParam(value="person")
	String person, @RequestParam(value="number") String num,
		    @RequestParam(value="hobby") String hobby,
		    @RequestParam(value="live") String live,
		    @RequestParam(value="comment") String comment,@RequestParam(value="city") String city,Model model) {
		
		
		 om = new Omikujiclass( city,  person,  comment, Integer.parseInt(num) ,  live,hobby);
		
		
		return "redirect:/omikuji/show";
	}
	
}

//value="/",method=RequestMethod.POST