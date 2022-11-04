package com.axsos.mvc1;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.mvc1.models.Travel;
import com.axsos.mvc1.services.TravelService;

@SpringBootApplication
@Controller
public class TravelApplication {
	private final TravelService travelService;
	public TravelApplication(TravelService travelService) {
		this.travelService = travelService;
	}
	
	


	public static void main(String[] args) {
		SpringApplication.run(TravelApplication.class, args);
	}

	
	
//	
//    
//	@RequestMapping("/")
//    public String all(Model model) throws IOException  {
//		 ArrayList<Travel>  tra = (ArrayList<Travel>) travelService.allTravel();
//       
//        model.addAttribute("travels", tra);
//       
//        
//        return "expense.jsp";
//    }
}
