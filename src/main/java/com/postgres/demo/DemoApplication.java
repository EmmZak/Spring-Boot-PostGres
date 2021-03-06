package com.postgres.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(PlayerRepo playerRepo, ComputerRepo computerRepo) {
		return args -> {
			System.out.println("Creating player");
			var p = new Player("Manu");
			//playerRepo.save(p);

			//p = null;
			//p = playerRepo.findByName("Manu");
			//System.out.println("Got player back from db " + p.toString());

			var c1 = new Computer("acer", 120);
			var c2 = new Computer("asus", 250);

			c1.setPlayer(p);
			c2.setPlayer(p);

			p.addComputer(c1);
			p.addComputer(c2);

			//System.out.println("Saving player " + p.toString());

			playerRepo.save(p);

			System.out.println("Saved, Getting player");
			List<Player> players = playerRepo.findAll();
			System.out.println(players);

		};
	}
}
