package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.utils.ProductGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initProductInDatabase(ProductRepository repository) {
        return args -> {
            for (int i = 0; i < 100; i++) {
                log.info("Preloading " + repository.save(ProductGenerator.getRandomProduct()));
            }
        };
    }

    @Bean
    CommandLineRunner initPersonInDatabase(UserRepository repository) {
        return args -> {
            Address address = new Address("Сектор", "Солнце", "Земля");
            log.info("Preloading " + repository.save(new Person("berkam", "1111",
                    new BigDecimal("1000"), new Basket(), address)));
        };
    }
}
