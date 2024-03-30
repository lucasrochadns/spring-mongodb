package com.workshopMongoDB.domain.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component("mapperUtil")
public class MapperUtil {


    protected ModelMapper modelMapper;

    public MapperUtil(){
        this.modelMapper= new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    }


    public <S, D> D mapTo(S source, Class<D> destClass){
       return this.modelMapper.map(source, destClass);
    }

    public <S, D> List<D> toList(List<S> source, Type destClass){
         return this.modelMapper.map(source, destClass);
    }
}
