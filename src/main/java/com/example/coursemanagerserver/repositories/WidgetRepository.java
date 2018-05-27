package com.example.coursemanagerserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.coursemanagerserver.models.Widget;

public interface WidgetRepository 
extends CrudRepository<Widget, Integer>{

}
