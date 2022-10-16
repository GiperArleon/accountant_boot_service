package com.acc.service;

import com.acc.dao.TasksRepository;
import com.acc.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TasksService {
    private final TasksRepository tasksRepository;

    public List<Task> getAllTasks() {
        return tasksRepository.findAll();
    }

    public List<Task> getAllByDate(Long days) {
        LocalDate date = LocalDate.now().minusDays(days);
        return tasksRepository.getAllByDate(date);
    }

    public List<Task> findTaskByUserIdAndDate(Integer id, Long days) {
        LocalDate date = LocalDate.now().minusDays(days);
        return tasksRepository.findTaskByUserIdAndDate(id, date);
    }

    public void save(Task task) {
        task.setDate(LocalDate.now());
        tasksRepository.save(task);
    }
}
