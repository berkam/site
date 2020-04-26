package com.example.demo;

import com.example.demo.model.ProductRepository;
import com.example.demo.utils.ProductGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(ProductGenerator.getRandomProduct()));
        };
    }
}
