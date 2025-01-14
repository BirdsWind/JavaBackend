package com.demo.service;

import com.demo.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class TaskService {
   
    private final ObjectMapper objectMapper = new ObjectMapper();


    public List<Task> loadTasksFromJson() throws IOException {
        // Load the file as a resource from the classpath
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("tasks.json");
        if (inputStream == null) {
            throw new IOException("File not found in classpath: tasks.json");
        }

        // Deserialize JSON into a List<Task>
        return objectMapper.readValue(inputStream, new TypeReference<List<Task>>() {});
    }
}
