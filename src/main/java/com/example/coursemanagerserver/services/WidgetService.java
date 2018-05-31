package com.example.coursemanagerserver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coursemanagerserver.models.Course;
import com.example.coursemanagerserver.models.Lesson;
import com.example.coursemanagerserver.models.Module;
import com.example.coursemanagerserver.models.Widget;
import com.example.coursemanagerserver.repositories.LessonRepository;
import com.example.coursemanagerserver.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class WidgetService {
	
	@Autowired
	WidgetRepository repository;
	@Autowired
	LessonRepository lessonRepository;
	
	
	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets(){
		
		return (List<Widget>) repository.findAll();
		
	}
	

	
	@PostMapping("/api/widget/save")
	public void saveAllWidgets
	(@RequestBody List<Widget> widgets) {
//		System.out.println(widget.getText());
		System.out.println("here");
		repository.deleteAll();
		for(Widget widget: widgets){
			 repository.save(widget);
		}
		
	}
	
	
	@PostMapping("/api/lesson/{lessonId}/widget/save")
	public void createWidgets(@PathVariable("lessonId") int lessonId, @RequestBody List<Widget> widgets) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		

		if (data.isPresent()) {
			Lesson les = data.get();
			List<Widget> prevWidgets = les.getWidgets();
			
			for(Widget widget: prevWidgets){
				 repository.deleteById(widget.getId());
			}
			
//			repository.deleteAll();
			for(Widget widget: widgets){
				widget.setLesson(les);
				 repository.save(widget);
			}
		}
//		return null;
	}
	
	@GetMapping("/api/lesson/{lessonId}/widget")
	public List<Widget> findAllWidgetsForLesson(@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);

		if (data.isPresent()) {
			Lesson module = data.get();
			return module.getWidgets();

		}
		return null;
	}

}
