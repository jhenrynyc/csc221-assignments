package com.example.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Task task) {
        return taskService.update(task);
    }

    @PostMapping("/update")
    public boolean update(Task task) {
        if (task.getId() != null) {
            try {
                Optional<Task> currentTask = taskService.getTaskById(task.getId());
                taskService.update(currentTask);
                return true;
            } catch (Exception ex) {
                // Log the exception for debugging
                return false;
            }
        } else {
            // Handle the case where task does not exist
            return false;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            boolean result = taskService.delete(id);
            return ResponseEntity.ok().body("Task deleted successfully.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }



}
