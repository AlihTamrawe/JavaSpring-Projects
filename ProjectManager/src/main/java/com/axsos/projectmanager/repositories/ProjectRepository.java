package com.axsos.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.User;


@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
	
	
	 @Query("select b from Project b")
	 List<Project> findAllProjects();
    
	
    @Query("select b from Project b where b.teamLead=?1   ")
	 List<Project> findprojectbyuser(Long id);
    
    
	@Query(value="select * from projects c where c.leader_id!=?1 ", nativeQuery=true)
    List<Project> findprojectnocontainperson(Long id);
    
   
	
}
