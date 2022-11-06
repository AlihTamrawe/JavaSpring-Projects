package com.axsos.mvc1.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.mvc1.models.Travel;
import com.axsos.mvc1.repositories.TravelRepository;

@Service
public class TravelService {
    private final TravelRepository travelRepository ;
    
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }
    // returns all the books
    public List<Travel> allTravel() {
        return travelRepository.findAll();
    }
    // creates a book
    public Travel createTravel( Travel travel) {
        return travelRepository.save(travel);
    }
    // retrieves a book
    public Travel findTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepository.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
    public void deleteTravel(Long id) {
    	 Optional<Travel> optionalTravel = travelRepository.findById(id);
    	 
         if(optionalTravel.isPresent()) {
        	 travelRepository.delete(optionalTravel.get());
         } else {
        	 
         }	
    }
    public String Updatedexpense(Long id,String expense)  throws IOException{
    	 Optional<Travel> optionalTravel = travelRepository.findById(id);

        if(optionalTravel.isPresent()) {
        	Travel b = optionalTravel.get();
        	b.setExpense(expense);
        	

        	travelRepository.save(b);

            return "Successful";


        } else {
        	
        	return "Failed";

        }
        
    }
    public String Updateddesc(Long id,String desc)  throws IOException{
   	 Optional<Travel> optionalTravel = travelRepository.findById(id);

       if(optionalTravel.isPresent()) {
    	   Travel b = optionalTravel.get();
       	b.setDescription(desc);
       	
       	travelRepository.save(b);

           return "Successful";


       } else {
       	
       	return "Failed";

       }
       
   }
    public String Updatedvendor(Long id,String vendor)  throws IOException{
      	 Optional<Travel> optionalTravel = travelRepository.findById(id);

       if(optionalTravel.isPresent()) {
    	   Travel b = optionalTravel.get();
       	b.setVendor(vendor);
       	
       	travelRepository.save(b);

           return "Successful";


       } else {
       	
       	return "Failed Vendor";

       }
       
   }
    public String Updatedamount(Long id,long l)  throws IOException{
     	 Optional<Travel> optionalTravel = travelRepository.findById(id);

       if(optionalTravel.isPresent()) {
    	   Travel b = optionalTravel.get();
       	b.setAmount(l);
       	travelRepository.save(b);
           return "Successful Amount";


       } else {
       	
       	return "Failed setNumberOfPages";

       }
       
   }
//    public String Updateall(Travel travel) throws IOException {
//    	return this.Updatedamount(travel.getId(), travel.getAmount())+this.Updateddesc(travel.getId(), travel.getDescription())+this.Updatedexpense(travel.getId(), travel.getExpense())+this.Updatedvendor(travel.getId(),travel.getVendor());
//    	
//    	
//    }
    
}