package com.axsos.DojoNinja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.DojoNinja.models.Dojos;

@Repository
public interface DojoRepository extends CrudRepository<Dojos, Long> {




    // this method retrieves all the Dojos from the database
    List<Dojos> findAll();
    // this method finds Dojos with descriptions containing the search string
    List<Dojos> findBynameContaining(String search);
    // this method counts how many Expense contain a certain string
    Long countBynameContaining(String search);
    // this method deletes a Travels that starts with a specific title
    Long deleteBynameStartingWith(String search);
    
    
}