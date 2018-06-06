
package com.example.coursemanagerserver.repositories;
import com.example.coursemanagerserver.models.Assignment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AssignmentRepository
extends CrudRepository<Assignment, Integer>{
	


}
