package com.axsos.projectmanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
//    @Query("")
//    Optional<Project> findByProjectsNotContains(User user);
//   
    
    
    
}