package com.workshopMongoDB.domain.entities.user;

import com.workshopMongoDB.domain.entities.user.User;
import com.workshopMongoDB.domain.entities.user.UserInput;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;


@Component("userIO")
public class UserIO {

    private ModelMapper modelMapper;
    final Converter<UserInput, User> userConverter = new Converter<UserInput, User>() {
        @Override
        public User convert(MappingContext<UserInput, User> mappingContext) {
            UserInput userInput = mappingContext.getSource();
            User user = new User();
            user.setId(userInput.getId());
            user.setName(userInput.getName());
            user.setEmail(userInput.getEmail());

            return user;
        }
    };

    public UserIO(){
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public User mapTo(UserInput userInput){
        return this.modelMapper.map(userInput, User.class);
    }

}
