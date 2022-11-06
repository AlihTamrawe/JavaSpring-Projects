package com.axsos.langmvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.langmvc.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language,Long> {
		
    // this method retrieves all the Language from the database
    List<Language> findAll();
    // this method finds Language with Name containing the search string
    List<Language> findByNameContaining(String search);
    // this method counts how many Name contain a certain string
    Long countByCreatorContaining(String search);
    // this method deletes a Language that starts with a specific Name
    Long deleteBynameStartingWith(String search);
}
