package com.example.coursemanagerserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coursemanagerserver.models.Course;
import com.example.coursemanagerserver.models.Widget;
import com.example.coursemanagerserver.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class WidgetService {
	
	@Autowired
	WidgetRepository repository;
	
	
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

}
