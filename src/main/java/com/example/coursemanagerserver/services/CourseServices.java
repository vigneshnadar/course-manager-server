package com.example.coursemanagerserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coursemanagerserver.models.Course;
import com.example.coursemanagerserver.repositories.CourseRepository;

@RestController
@CrossOrigin(origins = "*", maxAge =3600)
public class CourseServices {
	@Autowired
	CourseRepository courseRepository;	
	
	@GetMapping("/api/course")
	public Iterable<Course> findAllCourses() {
		return courseRepository.findAll(); 
	}
	
	@PostMapping("/api/course")
	public Course createCourse
	(@RequestBody Course course) {
			return courseRepository.save(course);
	}

}

