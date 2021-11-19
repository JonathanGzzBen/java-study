package com.JonathanGzzBen.JpaApi;

import com.JonathanGzzBen.JpaApi.Customer.Customer;
import com.JonathanGzzBen.JpaApi.Customer.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class JpaApiApplication {
	private static final Logger log = LoggerFactory.getLogger(JpaApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return args -> {
			repository.save(new Customer("Jonathan", "Gonzalez"));
			repository.save(new Customer("Eduardo", "Lim"));
			repository.save(new Customer("Victor", "Ancira"));

			log.info("Customers found with findAll():");
			log.info("-------------------------------");

			for(var customer: repository.findAll()) {
				log.info(customer.toString());
			}


			log.info("Customer found with findById(1L):");
			log.info("-------------------------------");
			var customer = repository.findById(1L);
			log.info(customer.toString());


			log.info("Customer found with findByName('Gonzalez'):");
			log.info("-------------------------------");
			repository.findByLastName("Gonzalez").forEach(found -> {
				log.info(found.toString());
			});

		};
	}
}

