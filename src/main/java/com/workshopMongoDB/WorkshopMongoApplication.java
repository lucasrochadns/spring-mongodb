package com.workshopMongoDB;

import com.workshopMongoDB.domain.entities.user.User;
import com.workshopMongoDB.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class WorkshopMongoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(WorkshopMongoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        List<User> users = Arrays.asList(new User("1", "Anna Clara Bernardino Rocha", "suport.developer@acbr.com.br"),
                new User("2", "Lucas Rocha dos Santos", "suporte.developer@acbr.com.br"),
                new User("3", "Luciene Jose dos Santos", "lucienesantosjp@hotmail.com"),
                new User("4", "Vicente José da Rocha", "vicenterochajp@gmail.com"));
        userRepository.saveAll(users);
    }
}
