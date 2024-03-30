package com.workshopMongoDB.domain.entities.post;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

public class PostIO {

    private ModelMapper modelMapper;
    final Converter<PostInput, Post> postConverter = new Converter<PostInput, Post>() {
        @Override
        public Post convert(MappingContext<PostInput, Post> mappingContext) {
            PostInput postInput = mappingContext.getSource();
            Post post = new Post();
            post.setId(postInput.getId());
            post.setInstant(postInput.getInstant());
            post.setTitle(postInput.getTitle());
            post.setBody(postInput.getBody());

            return post;
        }
    };

    public PostIO(){
        modelMapper = new ModelMapper();
        modelMapper.addConverter(postConverter);
    }

    public Post mapTo(PostInput postInput){
        return this.modelMapper.map(postInput, Post.class);
    }
}
