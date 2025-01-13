package com.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.io.IOException;

import com.demo.service.TaskService;
import com.demo.model.Task;


@RestController

//Define the base path for all endpoints
//@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String home() {
        return "Welcome to the Java Backend API!";
    }
    
    @GetMapping("/tasks")
    public List<Task> getTasks() throws IOException {
        return taskService.loadTasksFromJson();
    }
}
