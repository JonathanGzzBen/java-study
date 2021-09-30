package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			var mariam = new Student(
				"Mariam",
				"mariam.jamal@gmail.com",
				LocalDate.of(2000, Month.JANUARY, 5)
			);
			var alex = new Student(
				"Alex",
				"alex@gmail.com",
				LocalDate.of(2001, Month.FEBRUARY, 7)
			);

			repository.saveAll(List.of(mariam, alex));

		};
	}
	
}
