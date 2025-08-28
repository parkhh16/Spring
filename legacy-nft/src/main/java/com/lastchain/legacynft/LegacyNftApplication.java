package com.lastchain.legacynft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LegacyNftApplication {

	public static void main(String[] args) {
		SpringApplication.run(LegacyNftApplication.class, args);
	}

}
