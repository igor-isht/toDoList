package com.example.toDoList.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import com.example.toDoList.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{
  Iterable<Task> findAll(Sort deadLine);
}
