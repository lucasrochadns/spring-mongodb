package com.workshopMongoDB.domain.repository;

import com.workshopMongoDB.domain.entities.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findOneById(String id);
}
