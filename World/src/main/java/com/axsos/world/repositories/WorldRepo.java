package com.axsos.world.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.axsos.world.models.Country;

public interface WorldRepo extends CrudRepository<Country,Long> {
	
	
	@Query(value="select c.name , b.language, b.percentage from countries As c JOIN languages As b where b.language='Slovene' ORDER BY b.percentage DESC ", nativeQuery=true)
	List<Object[]> allCountries();
	//q1
	
	@Query(value="select c.name , count(c.code) AS NumberOfCities from countries As c JOIN cities As i where i.country_code=c.code  group by c.code order by NumberOfCities desc ", nativeQuery=true)
	List<Object[]> getTotalNumofcityeachcountry();
	//q2
	
	
	@Query(value="select * from cities c where c.population > 500000   order by c.population desc ", nativeQuery=true)
	List<Object[]> getMexicoCity();
	//q3
	
	@Query(value="select c.name , i.language from countries As c JOIN languages As i on i.country_code=c.code where i.percentage > 89  order by i.percentage desc ", nativeQuery=true)
	List<Object[]> getalllanguages();
	//q4
	
	
	@Query(value="SELECT * FROM countries where surface_area < 501 and  population> 100000; ", nativeQuery=true)
	List<Object[]>  getallthecountriesinWithSerface();
	//q5

	@Query(value="SELECT name,government_form,capital,life_expectancy FROM countries where  government_form='Constitutional Monarchy' and surface_area>200 and  life_expectancy> 75; ", nativeQuery=true)
	List<Object[]>  getcountryConstitutionalMonarchy();
	//q6
	
	@Query(value="select c.name AS Country, i.name AS City , i.district , i.population from countries As c JOIN cities As i where i.district='Buenos Aires' and i.population>500000; ", nativeQuery=true)
	List<Object[]>  getcityArgentina();
	
	
	@Query(value="select name,region ,count(code) AS Numofcountry  from countries  group by region order by Numofcountry desc; ", nativeQuery=true)
	List<Object[]>    getnumberofcountrieseachregion();
	
}
