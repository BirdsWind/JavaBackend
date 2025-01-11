package com.demo.service;

import com.demo.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class TaskService {
   
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Task> loadTasksFromJson() throws IOException {
        File file = new File("taskmanager/src/main/resources/tasks.json");
        

        if (!file.exists() || !file.canRead()) {
            System.err.println("File not found or not readable: " + file.getAbsolutePath());
            throw new IOException("File not found or not readable: " + file.getAbsolutePath());
        }
    
        System.out.println("Reading file: " + file.getAbsolutePath());
        try {
            List<Task> tasks = objectMapper.readValue(file, new TypeReference<List<Task>>() {});
            System.out.println("Deserialized tasks: " + tasks);
            return tasks;
        } catch (Exception e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    
    }
}






