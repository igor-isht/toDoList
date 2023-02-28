package com.example.toDoList.controller;

import com.example.toDoList.entity.Task;
import com.example.toDoList.entity.Views;
import com.example.toDoList.repository.TaskRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("task")
public class TaskController {
  private final TaskRepository taskRepository;

  public TaskController(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }


  @GetMapping
  @JsonView(Views.listOfTasks.class)
  public Iterable<Task> list(){
    return taskRepository.findAll(
        Sort.by(Sort.Order.by("isDone"), Sort.Order.by("deadLine"))
    );
  }

  @GetMapping("{id}")
  @JsonView(Views.details.class)
  public Task getTask(@PathVariable("id") Task task){
    return task;
  }

  @PostMapping
  public Task createTask(@RequestBody Task task) {
    task.setCreatedAt(LocalDateTime.now());
    return taskRepository.save(task);
  }

  @PutMapping("{id}")
  public Task updateTask(@PathVariable ("id") Task taskFromBD, @RequestBody Task task) {
    BeanUtils.copyProperties(task, taskFromBD, "id");
    return taskRepository.save(taskFromBD);
  }

  @DeleteMapping("{id}")
  public void deleteTask(@PathVariable ("id") Task task) {
    taskRepository.delete(task);
  }
}
