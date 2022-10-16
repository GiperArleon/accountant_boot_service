package com.acc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks", schema = "accountant")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "record_date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "minutes")
    private Integer minutes;
}
