package com.JonathanGzzBen.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(CustomerRepository customersRepo) {
        return (args) -> {
            customersRepo.save(new Customer("Jack", "Bauer"));
            customersRepo.save(new Customer("Chloe", "Brian"));
            customersRepo.save(new Customer("Kim", "Bauer"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer: customersRepo.findAll()) {
                log.info(customer.toString());
            }
            log.info("");
        };
    }
}
