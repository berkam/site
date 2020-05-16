package com.example.demo;

import com.example.demo.model.ProductRepository;
import com.example.demo.model.Person;
import com.example.demo.model.UserRepository;
import com.example.demo.utils.ProductGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(ProductRepository repository, UserRepository userRepository) {
        return args -> {
            for (int i = 0; i < 100; i++) {
                log.info("Preloading " + repository.save(ProductGenerator.getRandomProduct()));
            }
            //log.info("Preloading " + userRepository.save(new Person()));
        };
    }
}
