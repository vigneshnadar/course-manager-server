package com.example.coursemanagerserver.repositories;
import com.example.coursemanagerserver.models.Lesson;
import com.example.coursemanagerserver.models.Module;
import com.example.coursemanagerserver.models.Topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository
extends CrudRepository<Topic, Integer>{}