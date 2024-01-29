package com.example.s5_hw.service;

/**
 * Интерфейс TaskService сервис для работы с задачами.
 *
 * @author Nick
 * @version 1.0
 */

import com.example.s5_hw.domain.Task;
import com.example.s5_hw.domain.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    /**
     * Сохранение записи в БД.
     *
     * @param task
     * @return task
     */
    Task save(Task task);

    /**
     * Позволяет получить список всех задач.
     *
     * @return List
     */
    List<Task> getAllTasks();

    /**
     * Возвращает задачу по id.
     *
     * @param id
     * @return Task
     */
    Optional<Task> getTaskById(Long id);

    /**
     * Возвращает список пользователей с заданным статусом.
     *
     * @param status
     * @return List
     */
    List<Task> findByStatus(TaskStatus status);

    /**
     * Возвращает обновленную задачу. Обновление происходит по id.
     *
     * @param id
     * @param task
     * @return Task
     */
    Task updateTaskByStatus(Long id, Task task);

    /**
     * Удаляет задачу.
     *
     * @param id
     */
    void delete(Long id);

}
