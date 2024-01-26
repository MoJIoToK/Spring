package com.example.project.service;

import com.example.project.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    /**
     * Метод возвращает список всех задач.
     *
     * @return List<Task>
     */
    public List<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Метод возвращает конкретную задачу по id или null.
     *
     * @param id
     * @return Task
     */
    public Task getTaskById(UUID id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst().orElse(null);
    }

    /**
     * Метод добавляет задачу.
     *
     * @param task
     * @return Task
     */
    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    /**
     * Метод удаляет задачу по id
     *
     * @param id
     */
    public void deleteTaskById(UUID id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }

    /**
     * Метод обновляет задачу
     * @param id
     * @param task
     * @return Task
     */
    public Task updateTaskById(UUID id, Task task){
        Task oldTask = getTaskById(id);
        if (oldTask != null){
            oldTask.setDescription(task.getDescription());
            oldTask.setName(task.getName());
            oldTask.setStatus(task.getStatus());
            oldTask.setCompleteDate(task.getCompleteDate());
        }
        return oldTask;
    }


}
