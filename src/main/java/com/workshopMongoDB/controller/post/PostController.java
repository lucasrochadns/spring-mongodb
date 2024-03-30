package com.workshopMongoDB.controller.post;

import com.workshopMongoDB.domain.entities.post.Post;
import com.workshopMongoDB.domain.entities.post.PostInput;
import com.workshopMongoDB.domain.entities.post.PostOutput;
import com.workshopMongoDB.domain.services.PostService;
import com.workshopMongoDB.domain.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private MapperUtil mapperUtil;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PostOutput> findAll(){
        return postService.findAll().stream().map(x -> mapperUtil.mapTo(x, PostOutput.class)).collect(Collectors.toList());
    }

    @GetMapping({"/{id}/", "/{id}"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PostOutput findById(@PathVariable("id") String id){
        return mapperUtil.mapTo(postService.findById(id), PostOutput.class);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PostOutput update(@RequestBody PostInput postInput){
        return mapperUtil.mapTo(postService.update(mapperUtil.mapTo(postInput, Post.class)), PostOutput.class);
    }

    @DeleteMapping({"/{id}/", "/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteById(@PathVariable("id") String id){
          postService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PostOutput insert(@RequestBody PostInput postInput){
        return mapperUtil.mapTo(postService.insert(mapperUtil.mapTo(postInput, Post.class)), PostOutput.class);
    }


}
