package com.workshopMongoDB.domain.services;

import com.workshopMongoDB.domain.entities.user.User;
import com.workshopMongoDB.domain.exceptions.ObjectNotFoundException;
import com.workshopMongoDB.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).stream().toList();
    }


    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found !"));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        try {
            User userDB = userRepository.findOneById(user.getId());
            userDB.setName(user.getName());
            userDB.setEmail(user.getEmail());
            return userRepository.save(userDB);
        } catch (Exception error) {
            throw new ObjectNotFoundException("Erro Update");
        }
    }

    public void deleteById(String id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception error) {
            throw new ObjectNotFoundException("Erro Delete");
        }
    }
}
