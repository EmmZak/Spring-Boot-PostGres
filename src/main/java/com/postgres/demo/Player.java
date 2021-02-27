package com.postgres.demo;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Transient
    private Collection<Integer> grades;

    Player() {}
    Player(String name) {
        this.name=name;
        Integer[] integers = new Integer[10];
        Arrays.fill(integers, 0);
        this.grades = Arrays.asList(integers);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
