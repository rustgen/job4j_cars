package ru.job4j.cars.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "driver")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
