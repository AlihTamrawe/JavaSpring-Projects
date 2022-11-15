package com.axsos.projectmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.Task;

@Repository
public interface TaskRep extends CrudRepository<Task,Long> {
	
	 @Query("select b from Task b where  b.project.id=?1")
	 List<Task> findAllTasksbyproject(Long id);

}
