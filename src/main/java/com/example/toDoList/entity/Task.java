package com.example.toDoList.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonView(Views.listOfTasks.class)
  private Integer taskId;
  @JsonView(Views.listOfTasks.class)
  private String description;
  @JsonView(Views.details.class)
  private String text;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
  @JsonView(Views.listOfTasks.class)
  private LocalDateTime deadLine;
  @Column(updatable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  @JsonView(Views.details.class)
  private LocalDateTime createdAt;
  @JsonView(Views.listOfTasks.class)
  private Boolean isDone = Boolean.FALSE;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public LocalDateTime getDeadLine() {
    return deadLine;
  }

  public void setDeadLine(LocalDateTime deadLine) {
    this.deadLine = deadLine;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public Boolean getDone() {
    return isDone;
  }

  public void setDone(Boolean done) {
    isDone = done;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  Task(){}
}
