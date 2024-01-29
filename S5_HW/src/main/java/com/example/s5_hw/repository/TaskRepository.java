package com.example.s5_hw.repository;

/**
 * Интерфейс TaskRepository репозиторий задач.
 *
 * @author Nick
 * @version 1.0
 */

import com.example.s5_hw.domain.Task;
import com.example.s5_hw.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Кастомная функция, с помощью которой Spring Data составит запрос к БД для поиска данных по статусу.
     *
     * @param status
     * @return List
     */
    List<Task> findByStatus(TaskStatus status);
}
