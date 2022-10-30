package axsos.java.jspdemo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication

@Controller
public class DisplayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
	
	@RequestMapping("/")
	 public String index() {
        return "index.jsp";
    }
	
	@RequestMapping("/date")
	 public String date(Model model) {
		 LocalDate date = LocalDate.now(); 
	       model.addAttribute("date",date );
	        return "Date.jsp";
	    }
	
	@RequestMapping("/time")
	 public String time(Model model) {
		LocalDateTime time = LocalDateTime.now() ;
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");

       model.addAttribute("time",time.format(myFormatObj) );
		
	        return "Day.jsp";
	    }

}
