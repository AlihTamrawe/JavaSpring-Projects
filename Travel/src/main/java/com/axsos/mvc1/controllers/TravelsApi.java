package com.axsos.mvc1.controllers;
import java.io.IOException;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.axsos.mvc1.models.Travel;
import com.axsos.mvc1.services.TravelService;


@RestController
public class TravelsApi {
    private final TravelService travelService;
    public TravelsApi(TravelService travelService){
        this.travelService = travelService;
    }
    @RequestMapping("/")
    public void welcome(HttpServletResponse response) throws IOException {
        response.sendRedirect("/api/travels");
    }
    
    @RequestMapping("/api/travels")
    public List<Travel> index() {
        return travelService.allTravel();
    }
    
    @RequestMapping(value="/api/travels", method=RequestMethod.POST)//, , 
    public Travel create(@RequestParam(value="expense")String expense, @RequestParam(value="vendor") String vendor,@RequestParam(value="description") String description, @RequestParam(value="amount") long amount) {
    	Travel tra = new Travel( expense,  vendor,  amount, description);
        return travelService.createTravel(tra);
    }
    
    @RequestMapping("/api/travels/{id}")
    public Travel show(@PathVariable("id") Long id) {
    	Travel book = travelService.findTravel(id);
        return book;
    }
    
    @RequestMapping(value="/api/travels/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id ,HttpServletResponse response) throws IOException {
       
    
    	travelService.deleteTravel(id);
        
        response.sendRedirect("/showdelete");
        
    }
    @RequestMapping(value="/api/travels/{id}", method=RequestMethod.PUT)
    public String Update(@PathVariable("id") Long id ,@RequestParam(value="expense") String expense, @RequestParam(value="description") String desc, @RequestParam(value="vendor") String vendor, @RequestParam(value="amount") Integer amount) throws IOException {
       
    
        
        
        return travelService.Updatedexpense(id, expense)+travelService.Updateddesc(id, desc)+travelService.Updatedvendor(id, vendor)+travelService.Updatedamount(id, amount);
        }
    
    @RequestMapping("/showdelete")
    public String show() {
     
        return "Delete it successufully";
    }
    
}