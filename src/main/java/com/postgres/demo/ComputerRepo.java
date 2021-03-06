package com.postgres.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepo extends JpaRepository<Computer, Long> {
}
