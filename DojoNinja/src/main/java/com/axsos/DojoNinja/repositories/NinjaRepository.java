package com.axsos.DojoNinja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.DojoNinja.models.Ninjas;


@Repository
public interface NinjaRepository extends CrudRepository<Ninjas, Long> {




    // this method retrieves all the Dojos from the database
    List<Ninjas> findAll();
    // this method finds Dojos with descriptions containing the search string
    List<Ninjas> findByageContaining(String search);
    // this method counts how many Expense contain a certain string
    Long countByageContaining(String search);
    
    Long deleteByageStartingWith(String search);
    
    
}