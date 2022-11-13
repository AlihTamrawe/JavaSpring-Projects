package com.axsos.world.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.world.repositories.WorldRepo;

@Service
public class WorldService {
	
	private final WorldRepo worldRepo;
	
	public WorldService(WorldRepo worldRepo) {
		this.worldRepo = worldRepo;
	}
	
	 public  List<Object[]> findallcountries(){
		 return worldRepo.allCountries();
	 }
	 
	 public  List<Object[]> totalnumofcity(){
		 return worldRepo.getTotalNumofcityeachcountry();
	 }
	 public  List<Object[]> getMexicoCity(){
		 return worldRepo.getMexicoCity();
	 }
	 public  List<Object[]> getlanguagesincountry(){
		 return worldRepo.getalllanguages();
	 }
	 
	 
	 
	 public  List<Object[]> getallcountryWithAurface(){
		 return worldRepo.getallthecountriesinWithSerface();
	 }
	 
	 public  List<Object[]> getcountryConstitutionalMonarchy(){
		 return worldRepo.getcountryConstitutionalMonarchy();
	 }
	 public  List<Object[]> getcityArgentina(){
		 return worldRepo.getcityArgentina();

	 }
	 
	 public  List<Object[]> getnumberofcountrieseachregion(){
		 return worldRepo.getcityArgentina();

	 }

}
