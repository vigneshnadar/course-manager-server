package com.example.coursemanagerserver.repositories;
import com.example.coursemanagerserver.models.Module;
import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository
extends CrudRepository<Module, Integer>{}

