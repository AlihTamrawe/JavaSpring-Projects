package com.axsos.mvc1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.mvc1.models.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long>{
    // this method retrieves all the Travels from the database
    List<Travel> findAll();
    // this method finds Travels with descriptions containing the search string
    List<Travel> findByDescriptionContaining(String search);
    // this method counts how many Expense contain a certain string
    Long countByExpenseContaining(String search);
    // this method deletes a Travels that starts with a specific title
    Long deleteByExpenseStartingWith(String search);
    
    
}