package com.example.coursemanagerserver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coursemanagerserver.models.Module;
import com.example.coursemanagerserver.models.Course;
import com.example.coursemanagerserver.models.Lesson;
import com.example.coursemanagerserver.repositories.ModuleRepository;
import com.example.coursemanagerserver.repositories.LessonRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonService {
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	LessonRepository lessonRepository;
	
	
	@GetMapping("/api/lesson")
	public Iterable<Lesson> findAllLessons() {
		return lessonRepository.findAll(); 
	}

	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson")
	public Lesson createLesson(@PathVariable("moduleId") int courseId,@PathVariable("moduleId") int moduleId, @RequestBody Lesson newLesson) {
		Optional<Module> data = moduleRepository.findById(moduleId);

		if (data.isPresent()) {
			Module module = data.get();
			newLesson.setModule(module);
			return lessonRepository.save(newLesson);

		}
		return null;
	}
	
	@GetMapping("/api/course/{cid}/module/{mid}/lesson")
	public List<Lesson> findAllLessonsForModule(@PathVariable("cid") int cid,@PathVariable("mid") int mid) {
		Optional<Module> data = moduleRepository.findById(mid);

		if (data.isPresent()) {
			Module module = data.get();
			return module.getLessons();

		}
		return null;
	}
	
	@DeleteMapping("/api/lesson/{lessonId}")
	public void deleteLesson(@PathVariable("lessonId") int lessonId) {
		lessonRepository.deleteById(lessonId);
	}
}
