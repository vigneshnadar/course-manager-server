package com.example.coursemanagerserver.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.coursemanagerserver.models.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
