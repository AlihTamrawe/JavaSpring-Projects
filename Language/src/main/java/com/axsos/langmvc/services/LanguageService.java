package com.axsos.langmvc.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.langmvc.models.Language;
import com.axsos.langmvc.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	@SuppressWarnings("unused")
	private final LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository=languageRepository;
	}
    public List<Language> allTlang() {
        return languageRepository.findAll();
    }
    // creates a Language
    public Language createLang( Language language) {
        return languageRepository.save(language);
    }
    // retrieves a Language
    public Language findLanguage(Long id) {
        Optional<Language> optionallang = languageRepository.findById(id);
        if(optionallang.isPresent()) {
            return optionallang.get();
        } else {
            return null;
        }
    }
    public void deleteTLanguage(Long id) {
    	 Optional<Language> optionallang = languageRepository.findById(id);
    	 
         if(optionallang.isPresent()) {
        	 languageRepository.delete(optionallang.get());
         } else {
        	 
         }	
    }
    
    public Language Updated(Long id,Language language)  throws IOException{
   	 Optional<Language> optionallang = languageRepository.findById(id);

   	optionallang.get().setName(language.getName());
   	optionallang.get().setCreator(language.getCreator());
   	optionallang.get().setVersion(language.getVersion());

   	 
         return  languageRepository.save(optionallang.get());


    
     
 }

   

}
