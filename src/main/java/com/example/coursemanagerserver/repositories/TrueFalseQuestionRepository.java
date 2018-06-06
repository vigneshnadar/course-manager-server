package com.example.coursemanagerserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.coursemanagerserver.models.TrueFalseQuestion;


public interface TrueFalseQuestionRepository
	extends CrudRepository<TrueFalseQuestion, Integer> {
	
}