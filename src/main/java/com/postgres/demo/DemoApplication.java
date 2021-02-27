package com.postgres.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(PlayerRepo repo) {
		return args -> {

			System.out.println("saving player");
			Player p = new Player("Manu");
			repo.save(p);

			System.out.println("Getting player");
			List<Player> players = repo.findAll();
			System.out.println(players);
		};
	}
}
