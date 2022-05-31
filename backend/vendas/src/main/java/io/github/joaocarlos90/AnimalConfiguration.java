package io.github.joaocarlos90;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfiguration {
    @Bean(name="cachorro")
    public Animal cachorro(){
        return new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("late late");
            }
        };
    }
    @Bean(name = "pato")
    public Animal pato(){
        return new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("QUACK QUACK");
            }
        };
    }
}
