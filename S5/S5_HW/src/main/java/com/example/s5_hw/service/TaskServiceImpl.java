package com.example.s5_hw.service;

/**
 * Класс TaskServiceImpl сервис для работы с задачами.
 * Имплементирует все методы из интерфейса TaskService.
 *
 * @author Nick
 * @version 1.0
 */

import com.example.s5_hw.domain.Task;
import com.example.s5_hw.domain.TaskStatus;
import com.example.s5_hw.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    /**
     * Репозиторий для хранения данных о задачах.
     */
    private TaskRepository repository;

    /**
     * Сохранение задачи в БД и её возврат.
     *
     * @param task
     * @return Task
     * @see TaskRepository#save
     */
    @Override
    public Task save(Task task) {
        return repository.save(task);
    }

    /**
     * Возвращает список всех задач.
     *
     * @return List
     * @see TaskRepository#findAll
     */
    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    /**
     * Возвращает задачу по id.
     *
     * @param id
     * @return Task
     * @see TaskRepository#findById
     */
    @Override
    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    /**
     * Возвращает список задач по статусу.
     *
     * @param status
     * @return List
     * @see TaskRepository#findByStatus
     */
    @Override
    public List<Task> findByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    /**
     * Возвращает задачу обновленную задачу по id.
     *
     * @param id
     * @param task
     * @return Task
     * @see TaskRepository#findByStatus
     */
    @Override
    public Task updateTaskByStatus(Long id, Task task) {
        Optional<Task> existNote = getTaskById(id);
        if (existNote.isPresent()) {
            Task task1 = existNote.get();
            task1.setStatus(task.getStatus());
            return repository.save(task1);
        } else {
            throw new IllegalArgumentException("Note not found by this ID" + id);
        }
    }

    /**
     * Удаляет запись о задаче из БД по id задачи.
     *
     * @param id
     * @see TaskRepository#deleteById
     */
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
