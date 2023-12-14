package com.example.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public boolean update(Optional<Task> task) {
        try{
            taskRepository.save(task);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean delete(Long id) {
        try{
            taskRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        if (id != null) {
            return taskRepository.findById(id);
        }
        return Optional.empty();
    }

}
