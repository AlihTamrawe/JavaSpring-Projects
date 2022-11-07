package com.axsos.DojoNinja.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.DojoNinja.models.Dojos;
import com.axsos.DojoNinja.repositories.DojoRepository;


@Service
public class DojoService {
	private final DojoRepository  dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	
	    // returns all the books
	    public List<Dojos> all() {
	        return dojoRepository.findAll();
	    }
	    // creates a book
	    public Dojos create( Dojos dojo) {
	        return dojoRepository.save(dojo);
	    }
	    // retrieves a book
	    public Dojos find(Long id) {
	        Optional<Dojos> optionaldojo = dojoRepository.findById(id);
	        if(optionaldojo.isPresent()) {
	            return optionaldojo.get();
	        } else {
	            return null;
	        }
	    }
	    public void delete(Long id) {
	        Optional<Dojos> optionaldojo = dojoRepository.findById(id);
	    	 
	         if(optionaldojo.isPresent()) {
	        	 dojoRepository.delete(optionaldojo.get());
	         } else {
	        	 
	         }	
	    }
	    
	    public Dojos Updated(Long id,Dojos dojo)  throws IOException{
	    	 Optional<Dojos> optionaldojo = dojoRepository.findById(id);

	    	 optionaldojo.get().setName(dojo.getName());
	    		    	 
	          return  dojoRepository.save(optionaldojo.get());


	     
	      
	  }
}
