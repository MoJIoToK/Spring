package com.example.s8_hw.controller;

/**
 * Класс TaskController контроллер задач.
 *
 * @author Nick
 * @version 1.0
 */

import com.example.s8_hw.domain.Task;
import com.example.s8_hw.domain.TaskStatus;
import com.example.s8_hw.gateway.FileGateway;
import com.example.s8_hw.service.TaskService;
import com.example.s8_hw.service.TaskServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    /**
     * Сервис для работы с задачами.
     */
    private final TaskService service;

    private final FileGateway fileGateway;

    /**
     * Метод позволяет получить список всех пользователей.
     *
     * @return List<Task>
     * @see TaskServiceImpl#getAllTasks
     */
    @GetMapping
    public List<Task> getAllNotes() {
        return service.getAllTasks();
    }

    /**
     * Метод позволяет создать пользователя и добавить в БД.
     *
     * @return Task
     * @see TaskServiceImpl#save
     */
    @PostMapping
    public Task createNote(@RequestBody Task task) {
        task.setTimeSet(LocalDateTime.now());
        fileGateway.writeToFile("tasks.txt", task);
        return service.save(task);
    }

    /**
     * Метод позволяет получить список пользователей по статусу.
     *
     * @param status
     * @return List<Task>
     * @see TaskServiceImpl#findByStatus
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return service.findByStatus(status);
    }

    /**
     * Метод позволяет обновить статус пользователя по id.
     *
     * @param id
     * @param task
     * @return List<Task>
     * @see TaskServiceImpl#updateTaskByStatus
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTaskByStatus(id, task);
    }

    /**
     * Метод позволяет удалить пользователя по id.
     *
     * @param id
     * @see TaskServiceImpl#delete
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }

}
