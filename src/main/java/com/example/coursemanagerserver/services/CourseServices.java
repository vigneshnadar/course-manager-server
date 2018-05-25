package com.example.coursemanagerserver.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	 @GetMapping("/api/course/{id}")
		public Course findCourseById(@PathVariable("id") int id) {
			Optional<Course> data = courseRepository.findById(id); 
			
			if(data.isPresent())
				return data.get();
			
			return null;
			
		}
	
	@PostMapping("/api/course")
	public Course createCourse
	(@RequestBody Course course) {
			return courseRepository.save(course);
	}
	
	@DeleteMapping("/api/course/{courseId}")
	public void deleteCourse(
	@PathVariable("courseId") int id) {
		courseRepository.deleteById(id);
	}


}

