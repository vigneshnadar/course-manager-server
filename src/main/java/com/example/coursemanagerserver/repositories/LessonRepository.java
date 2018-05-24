package com.example.coursemanagerserver.repositories;
import com.example.coursemanagerserver.models.Lesson;
import com.example.coursemanagerserver.models.Module;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository
extends CrudRepository<Lesson, Integer>{}