package com.workshopMongoDB.domain.repository;

import com.workshopMongoDB.domain.entities.post.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,  String> {

    Post findOneById(String id);
}
