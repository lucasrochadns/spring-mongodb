package com.workshopMongoDB;

import com.workshopMongoDB.domain.entities.post.Post;
import com.workshopMongoDB.domain.entities.user.User;
import com.workshopMongoDB.domain.repository.PostRepository;
import com.workshopMongoDB.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class WorkshopMongoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    public static void main(String[] args) {
        SpringApplication.run(WorkshopMongoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        List<User> users = Arrays.asList(
                new User("1", "Anna Clara Bernardino Rocha", "suport.developer@acbr.com.br"),
                new User("2", "Lucas Rocha dos Santos", "suporte.developer@acbr.com.br"),
                new User("3", "Luciene Jose dos Santos", "lucienesantosjp@hotmail.com"),
                new User("4", "Vicente José da Rocha", "vicenterochajp@gmail.com"));

        userRepository.saveAll(users);

        List<Post> posts = Arrays.asList(
                new Post("1", Instant.now(), "Go", "Ya no hay camino que recorra tu pasado"),
                new Post("2", Instant.now(), "Go Go", "Tan solo cicatrices de batallas por ganar"),
                new Post("3", Instant.now(), "Go Go Go", "El tiempo dice quien se quedará a tu lado"),
                new Post("4", Instant.now(), "Go Go Go Go", "Y quien dará la vuelta para nunca regresar"),
                new Post("5", Instant.now(), "Go Go Go Go Go", "Toda persona tiene su forma de amar"),
                new Post("6", Instant.now(), "Go Go Go Go Go Go", "Pero pocas con amor y solo queda soñar"));

        postRepository.saveAll(posts);
    }
}
