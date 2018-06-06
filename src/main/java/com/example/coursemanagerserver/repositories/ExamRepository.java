package com.example.coursemanagerserver.repositories;
import com.example.coursemanagerserver.models.Exam;

import org.springframework.data.repository.CrudRepository;

public interface ExamRepository
extends CrudRepository<Exam, Integer>{

}
