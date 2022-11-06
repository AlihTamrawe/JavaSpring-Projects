package com.axsos.langmvc.controllers;

import java.io.IOException;
import java.util.ArrayList;

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

import com.axsos.langmvc.models.Language;
import com.axsos.langmvc.services.LanguageService;


@Controller
public class LanguageController {
	private final LanguageService languageService;
	public LanguageController( LanguageService languageService) {
		this.languageService=languageService;
	}
	
	 @RequestMapping("/")
	 public String Welcome() {
		 return "redirect:/Languages";
	 }
	 @GetMapping("/Languages")
	    public String all(Model model, @ModelAttribute("lang") Language language,BindingResult result)  throws IOException  {
			
	       
			 ArrayList<Language>  languages = (ArrayList<Language>) languageService.allTlang();
		       
		        model.addAttribute("languages", languages);
	        
	        return "/lang/dash.jsp";
	    }
		 
	 @PostMapping("/Languages/create")
	    public String Createnew(Model model,@Valid @ModelAttribute("lang") Language language,BindingResult result)   {
			 
		 ArrayList<Language>  languages = (ArrayList<Language>) languageService.allTlang();
	       
	        model.addAttribute("languages", languages);

	         if (result.hasErrors()) {
	 	        return "/lang/dash.jsp";
	         } else {
	        	 languageService.createLang(language);
	             return "redirect:/Languages";
	         }   
	        

	         
	         }
	 
	 
	 
	 
	 @GetMapping("/Languages/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Language lang = languageService.findLanguage(id);
	        model.addAttribute("language", lang);
			model.addAttribute("id",id);

         return "/lang/edit.jsp";
	    }
	
	 @PutMapping("/Languages/edit/{id}")
 public String editTravel(Model model,@Valid @ModelAttribute("language") Language language,BindingResult result,@PathVariable("id") Long id) throws IOException   {
	       
		 model.addAttribute("language",language);
		 model.addAttribute("id",id);

		  
      if (result.hasErrors()) {
     	 
          return "/lang/edit.jsp";
      } else {
    	  languageService.Updated(id, language);
       
//          travelService.Updatedexpense(id, travel.getExpense());
//          travelService.Updateddesc(id, travel.getDescription());
//          travelService.Updatedamount(id, travel.getAmount());
//          travelService.Updatedvendor(id, travel.getVendor());
          return "redirect:/Languages";
      }   
     

      
      }
	 @GetMapping("/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
		 languageService.deleteTLanguage(id);
         return "redirect:/Languages";
	    }
	 @GetMapping("/Languages/{id}")
	 public String show(Model model,@PathVariable("id") Long id) {
	        model.addAttribute("id",id);

		   Language lang = languageService.findLanguage(id);
	        model.addAttribute("language",lang);
	        return "/lang/show.jsp";
	    }
	

}
