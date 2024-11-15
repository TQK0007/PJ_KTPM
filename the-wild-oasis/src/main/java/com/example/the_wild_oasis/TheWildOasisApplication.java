package com.example.the_wild_oasis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.the_wild_oasis.Model")
@EnableJpaRepositories("com.example.the_wild_oasis.repository")
public class TheWildOasisApplication {
	public static void main(String[] args) {
		SpringApplication.run(TheWildOasisApplication.class, args);

	}


}
