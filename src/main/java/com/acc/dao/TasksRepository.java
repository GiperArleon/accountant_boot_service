package com.acc.dao;

import com.acc.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task, Integer> {

    @Query(value = "SELECT * " +
            "FROM accountant.tasks t " +
            "WHERE t.record_date >= :date",
            nativeQuery = true)
    List<Task> getAllByDate(@Param("date") LocalDate date);

    @Query(value = "SELECT * " +
            "FROM accountant.tasks t " +
            "WHERE t.user_id = :userId " +
            "AND t.record_date >= :date ",
            nativeQuery = true)
    List<Task> findTaskByUserIdAndDate(@Param("userId") Integer userId, @Param("date") LocalDate date);
}
