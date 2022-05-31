package io.github.joaocarlos90;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@DEV
public class MyConfiguration {
    @Bean
    public CommandLineRunner executar(){
        return args ->{
            System.out.println("Ambiente de DEV");
        };
    }
}
