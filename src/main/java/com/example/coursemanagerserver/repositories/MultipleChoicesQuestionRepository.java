package com.example.coursemanagerserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.coursemanagerserver.models.MultipleChoiceQuestion;



public interface MultipleChoicesQuestionRepository
	extends CrudRepository<MultipleChoiceQuestion, Integer> {
	
}