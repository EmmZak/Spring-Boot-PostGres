package com.postgres.demo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Arrays;
import java.util.*;

@Entity(name="player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //@Transient
    //@LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Integer> grades;

    //@OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "player",  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Computer> computers;// = new ArrayList<Computer>();

    public Player() {}

    public Player(String name) {
        this.name=name;
        Integer[] integers = new Integer[10];
        Arrays.fill(integers, 99);
        this.grades = Arrays.asList(integers);
        this.computers = new ArrayList<Computer>();
    }

    public void addComputer(Computer c) {
        this.computers.add(c);
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

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                ", computers=" + computers +
                '}';
    }
}
