package com.postgres.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.postgres.demo.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long>{
    Player findByName(String name);
}
