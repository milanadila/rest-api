package com.api.resto.pop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class PopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopApplication.class, args);
	}

}
