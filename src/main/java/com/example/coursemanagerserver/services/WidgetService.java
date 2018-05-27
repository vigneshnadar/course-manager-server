package com.example.coursemanagerserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.coursemanagerserver.models.Widget;
import com.example.coursemanagerserver.repositories.WidgetRepository;

@RestController
public class WidgetService {
	
	@Autowired
	WidgetRepository repository;
	
	public List<Widget> findAllWidgets(){
		
		return (List<Widget>) repository.findAll();
		
	}

}
