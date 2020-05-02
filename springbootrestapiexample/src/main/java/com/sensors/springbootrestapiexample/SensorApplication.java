package com.sensors.springbootrestapiexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SensorApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SensorApplication.class, args);
		
	}
}
