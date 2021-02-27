package com.postgres.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    private PlayerRepo repo;

    PlayerController(PlayerRepo repo){
        this.repo=repo;
    }

    // requests
    @GetMapping("/map")
    List<Player> getMap(){
        return repo.findAll();
    }

    @PostMapping("/map")
    String postMap(@RequestBody Player p){
        System.out.println("POST: received player " + p.toString());
        repo.save(p);
        return "OK";
    }
}
