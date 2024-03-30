package com.workshopMongoDB.domain.services;

import com.workshopMongoDB.domain.entities.post.Post;
import com.workshopMongoDB.domain.exceptions.ObjectNotFoundException;
import com.workshopMongoDB.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findById(String id){
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Not Found"));
    }

    public Post insert(Post post){
        return postRepository.save(post);
    }

    public void deleteById(String id){
        postRepository.deleteById(id);
    }

    public Post update(Post post){
       Post ps = postRepository.findOneById(post.getId());
       ps.setInstant(post.getInstant());
       ps.setTitle(post.getTitle());
       ps.setBody(post.getBody());
       return postRepository.save(ps);
    }
}
