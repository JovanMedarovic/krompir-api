package com.dragacevoshop.krompirApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KrompirApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KrompirApiApplication.class, args);
	}

}
