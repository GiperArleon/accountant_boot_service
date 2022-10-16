package com.acc.controller;

import com.acc.model.Task;
import com.acc.service.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/accountant")
public class TasksController {

    private final TasksService tasksService;

    @GetMapping("/gll_all_records")
    List<Task> getAllTasks() {
      return tasksService.getAllTasks();
    }

    @GetMapping("/gll_all_records_for_days/{days}")
    List<Task> GetAllTasksByDate(@PathVariable("days") Long days) {
        return tasksService.getAllByDate(days);
    }

    @GetMapping("/gll_all_records_for_days")
    List<Task> GetAllTasksByDateX(@RequestParam(name = "days") Long days) {
        return tasksService.getAllByDate(days);
    }

    @GetMapping("/get_user_by_id")
    List<Task> GetRecordsByUserIdByDate(@RequestParam(name = "user_id") Integer id,
                                        @RequestParam(name = "days") Long days) {
        return tasksService.findTaskByUserIdAndDate(id, days);
    }

    @PostMapping("/create_record")
    public ResponseEntity<Void> saveTask(@RequestBody Task task) {
            tasksService.save(task);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
