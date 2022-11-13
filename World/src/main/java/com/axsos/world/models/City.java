package com.axsos.world.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="cities")
public class City {
		
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	

	 	 @NotNull
	     @Size(min=3, max=30, message="name must be between 3 and 30 characters")
	     private String name;
	 	
	 	
	 	
	 	

	 	 @NotNull
	     @Size(min=3, max=30, message="countrycode must be between 3 and 30 characters")
	     private String countrycode;
	 	 

	 	 @NotNull
	     @Size(min=3, max=30, message="district must be between 3 and 30 characters")
	     private String district;
	 	
	 	@NotNull
	     @Min(value=0, message="population must be large than 0 ")
	 	@Value("0")
	     private int population;
	 	
	 	
	 	
	 	
	 	
	 	@ManyToOne(fetch = FetchType.LAZY)
	     @JoinColumn(name="country_id")
	     private Country countries;
}
