package com.finalapp;

import com.finalapp.model.Customer;
import com.finalapp.service.CustomerRepository;
import org.apache.juli.logging.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalappApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalappApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

        };
    }

}
