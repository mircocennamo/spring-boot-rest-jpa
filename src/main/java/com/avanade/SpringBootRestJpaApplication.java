package com.avanade;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestJpaApplication {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());



    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestJpaApplication.class, args);
    }

}
