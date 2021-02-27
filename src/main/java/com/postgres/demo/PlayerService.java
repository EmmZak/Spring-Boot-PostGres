package com.postgres.demo;

import org.springframework.stereotype.Service;

@Service
public interface PlayerService {
    public Player findByName(String name);
}
