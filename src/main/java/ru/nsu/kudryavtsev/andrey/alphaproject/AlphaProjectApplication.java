package ru.nsu.kudryavtsev.andrey.alphaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"ru.nsu.kudryavtsev.andrey.alphaproject.model"})
public class AlphaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaProjectApplication.class, args);
    }

}
