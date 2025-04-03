package com.avanade;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients
public class SpringBootRestJpaApplication {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());



    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        lista.add("Mirco");
        lista.add("Cennamo");
        lista.add("Avanade");
        lista.add("Java");


        String result = String.join( "","Hello", "World");
        System.out.println("risultato " + result);

        String message = lista.stream().collect(Collectors.joining("" ));
        System.out.println("risultato " + message);
        SpringApplication.run(SpringBootRestJpaApplication.class, args);


        String base64String = "SGVsbG8gV29ybGQ="; // Esempio di stringa Base64
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);

        System.out.println("Dimensione della stringa Base64: " + base64String.length());
        System.out.println("Dimensione dell'array di byte: " + decodedBytes.length);
    }

}
