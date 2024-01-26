package com.example.project.controller;

import com.example.project.model.Task;
import com.example.project.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    /**
     * Конструктор
     * @param taskService
     */
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable UUID id){
        return taskService.getTaskById(id);
    }

    @PostMapping()
    public Task addById(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @PutMapping("/{id}")
    public Task updateById(@PathVariable UUID id, @RequestBody Task task){
        return taskService.updateTaskById(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        taskService.deleteTaskById(id);
    }

}
