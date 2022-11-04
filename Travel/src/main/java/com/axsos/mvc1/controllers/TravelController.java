package com.axsos.mvc1.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.mvc1.TravelApplication;
import com.axsos.mvc1.models.Travel;
import com.axsos.mvc1.services.TravelService;


@Controller
public class TravelController {
	private final TravelService travelService;
	
	
	public TravelController(TravelService travelService) throws IOException {
		this.travelService = travelService;
	}
	
	
	
	 @GetMapping("/Expense/New")
    public String all(Model model,@ModelAttribute("expensess") Travel travel)  throws IOException  {
		
       
		 ArrayList<Travel>  tra = (ArrayList<Travel>) travelService.allTravel();
	       
	        model.addAttribute("travels", tra);
        
        return "/Travel/expense.jsp";
    }
	 
	@PostMapping("/Travel")
    public String CreateTravel(Model model,@Valid @ModelAttribute("expensess") Travel travel,BindingResult result)   {
		 
		 ArrayList<Travel>  tra = (ArrayList<Travel>) travelService.allTravel();
	       
	        model.addAttribute("travels", tra);
         if (result.hasErrors()) {
             return "/Travel/expense.jsp";
         } else {
             travelService.createTravel(travel);
             return "redirect:/Expense/New";
         }   
        

         
         }
	
	
	

    

}
