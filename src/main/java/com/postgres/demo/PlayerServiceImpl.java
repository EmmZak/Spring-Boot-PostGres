package com.postgres.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepo repo;

    @Override
    public Player findByName(String name) {
        return repo.findByName(name);
    }
}
