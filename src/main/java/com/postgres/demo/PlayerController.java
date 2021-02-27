package com.postgres.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    private PlayerRepo repo;

    PlayerController(PlayerRepo repo){
        this.repo=repo;
    }

    // requests
    @GetMapping("/get-map")
    List<Player> getMap(){
        return repo.findAll();
    }

    @PostMapping("/post-map")
    String postMap(){
        return "post";
    }
}
