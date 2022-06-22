package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.model.Cliente;
import org.example.model.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class ClientesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);
    }
}
