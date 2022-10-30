package axsos.java.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class firstproject {




	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	@RequestMapping(value="/daikichi", method=RequestMethod.GET )
//	public String index() {
//		return "<h1>   Welcome!</h1>";
//	}
	@RequestMapping("/daikichi/travel/{city}")
	public String Travel(@PathVariable("city") String city) {
		return "<h1>  'Congratulations! You will soon travel to "+city+" !</h1>";
	}
//	@RequestMapping(value="/daikichi/Tomorrow", method=RequestMethod.GET)
//	public String Tomorrow() {
//		return "<h1>   Tomorrow, an opportunity will arise, so be sure to be open to new ideas! </h1>";
//	}
	
	@RequestMapping("/daikichi/lotto/{num}")
	public String index(@PathVariable("num") int num ) {
		
		if(num%2==0)
		return "<h1> You will take a grand journey in the near future, but be weary of tempting offers</h1>";
		else
		{
			return "<h2> You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.</h2>";
		}
	}

}
//
//@RestController
//public class DemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}

//	@RequestMapping("/hello")
//	public String Hello() {
//		return "<button href=\"https://drive.google.com/file/d/1SeNEEP720-GPc2JSPIwd0on7eRo747X7/view?usp=share_link\">ali</button>";
//	}
//	  @RequestMapping("/greeting")
//	    public String greeting(){
//	      return "Hello user!";
//	    }
//	    // you can be explicit about the request as well
//	    @RequestMapping(value="/greeting/hello", method=RequestMethod.GET)
//	    public String hello(){
//	      return "Hello world! What route did you use to access me?";
//	    }
//	    @RequestMapping("/greeting/goodbye")
//	    public String world(){
//	      return "Goodbye world!";
//	    }
//
//}
//
