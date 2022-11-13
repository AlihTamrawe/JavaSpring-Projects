package com.axsos.world.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.world.services.WorldService;


@RestController
public class HomeControllers {
	
	@Autowired
	WorldService worldService;
	
	
	@RequestMapping("/api/theq1")
	public List<Object[]> allCountry() {
		List<Object[]> all = worldService.findallcountries();
		
		return all;
	}
	
	@RequestMapping("/api/theq2")
	public List<Object[]> totalcity() {
		List<Object[]> all = worldService.totalnumofcity();
		
		return all;
	}
	@RequestMapping("/api/theq3")
	public List<Object[]> getMexicocity() {
		List<Object[]> all = worldService.getMexicoCity();
		
		return all;
	}
	@RequestMapping("/api/theq4")
	public List<Object[]> alllanguage() {
		List<Object[]> all = worldService.getlanguagesincountry();
		
		return all;
	}
	
	@RequestMapping("/api/theq5")
	public List<Object[]> ALLSURFACES() {
		List<Object[]> all = worldService.getallcountryWithAurface();
		
		return all;
	}
	
	@RequestMapping("/api/theq6")
	public List<Object[]> getcountryConstitutionalMonarchy() {
		List<Object[]> all = worldService.getcountryConstitutionalMonarchy();
		
		return all;
	}
	
	@RequestMapping("/api/theq7")
	public List<Object[]> getcityArgentina() {
		List<Object[]> all = worldService.getcityArgentina();
		
		return all;
	}
	
	 
	@RequestMapping("/api/theq8")
	public List<Object[]>getnumberofcountrieseachregion(){
List<Object[]> all = worldService.getnumberofcountrieseachregion();
		
		return all;
	}
}
