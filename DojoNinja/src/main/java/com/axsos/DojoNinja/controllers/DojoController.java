package com.axsos.DojoNinja.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.DojoNinja.models.Dojos;
import com.axsos.DojoNinja.models.Ninjas;
import com.axsos.DojoNinja.services.DojoService;
import com.axsos.DojoNinja.services.NinjaService;

@Controller
public class DojoController {
	
	private final DojoService dojoService;
	private final NinjaService ninjaservice;

	
	public DojoController(DojoService dojoService,NinjaService ninjaservice) 	 {
		this.dojoService = dojoService;
		this.ninjaservice = ninjaservice;
		
	}
	
	
	@RequestMapping("/dojo")
	public String dojo(@Valid @ModelAttribute("dojo") Dojos dojo,BindingResult result) {
		return "/dojo/new.jsp";
	}


	@PostMapping("/dojo/new")
	public String addidojo(@Valid @ModelAttribute("dojo") Dojos dojo,BindingResult result, Model model) {
		
	if(result.hasErrors()){
		return "/dojo/new.jsp";
	}else{
		dojoService.create(dojo);
			return "redirect:/dojos/" + dojo.getId();
		}
		

	}
	
//	@PostMapping("/dorms/{dojoId}/ninjas/new")
//	public String addNinja(
//			@PathVariable("dojoId") Long id, 
//			@Valid @ModelAttribute("ninja") Ninja ninja,
//			BindingResult result, 
//			Model model) {
//		if(result.hasErrors()){
//			model.addAttribute("dojo", dojoService.find(id));
//			return "showDojo.jsp";
//		}else{
//			ninjaService.create(ninja);
//			return "redirect:/dojos/" + id;
//		}
//	}
//	
	@RequestMapping("/ninja")
	public String ninja(@Valid @ModelAttribute("ninja") Ninjas ninja,BindingResult result, Model model) {
		model.addAttribute("dojos",dojoService.all() );

		return "/ninja/new.jsp";
	}

	@PostMapping("/ninja/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninjas ninja,BindingResult result, Model model) {
		
		model.addAttribute("dojos",dojoService.all() );
	if(result.hasErrors()){
		return "/ninja/new.jsp";
	}else{
		ninjaservice.create(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
		

	}
	@GetMapping("/dojos/{dojoId}")
	public String addNinja(@Valid @ModelAttribute("dojo") Dojos dojo,BindingResult result,
			@PathVariable("dojoId") Long id, 
			Model model) {
			ArrayList<Ninjas> ninjas =new  ArrayList<Ninjas>();
			for(Ninjas ninja:dojoService.find(id).getNinjas())
			{
				ninjas.add(ninja);
			}
			model.addAttribute("dojo", dojoService.find(id));
			model.addAttribute("ninjas", ninjas);

			return "/ninja/ninjashow.jsp";
		
	}

}
