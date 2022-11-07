package com.axsos.DojoNinja.services;



import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.DojoNinja.models.Dojos;
import com.axsos.DojoNinja.models.Ninjas;
import com.axsos.DojoNinja.repositories.DojoRepository;
import com.axsos.DojoNinja.repositories.NinjaRepository;


@Service
public class NinjaService {
	private final NinjaRepository  ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	
	    // returns all the books
	    public List<Ninjas> all() {
	        return ninjaRepository.findAll();
	    }
	    // creates a book
	    public Ninjas create( Ninjas ninja) {
	        return ninjaRepository.save(ninja);
	    }
	    // retrieves a book
	    public Ninjas find(Long id) {
	        Optional<Ninjas> optionaldninja = ninjaRepository.findById(id);
	        if(optionaldninja.isPresent()) {
	            return optionaldninja.get();
	        } else {
	            return null;
	        }
	    }
	    public void delete(Long id) {
	        Optional<Ninjas> optionaldninja = ninjaRepository.findById(id);
	    	 
	         if(optionaldninja.isPresent()) {
	        	 ninjaRepository.delete(optionaldninja.get());
	         } else {
	        	 
	         }	
	    }
	    
	    public Ninjas Updated(Long id,Ninjas ninja)  throws IOException{
	        Optional<Ninjas> optionaldninja = ninjaRepository.findById(id);

	        optionaldninja.get().setFirstName(ninja.getFirstName());
	        optionaldninja.get().setLastName(ninja.getLastName());
	        optionaldninja.get().setFirstName(ninja.getFirstName());
	          return  ninjaRepository.save(optionaldninja.get());


	     
	      
	  }
}
