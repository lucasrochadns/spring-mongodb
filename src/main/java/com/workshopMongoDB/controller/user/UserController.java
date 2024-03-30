package com.workshopMongoDB.controller.user;

import com.workshopMongoDB.domain.entities.user.User;
import com.workshopMongoDB.domain.entities.user.UserIO;
import com.workshopMongoDB.domain.entities.user.UserInput;
import com.workshopMongoDB.domain.entities.user.UserOutput;
import com.workshopMongoDB.domain.services.UserService;
import com.workshopMongoDB.domain.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserIO userIO;

    @Autowired
    private MapperUtil mapperUtil;


    @GetMapping({"/", ""})
    @ResponseBody
    public Page<UserOutput> findAll(@PageableDefault(size = 12, sort={"id"})Pageable  pageable) {
        return new PageImpl<UserOutput>(
                userService.findAll(pageable).stream()
                        .map(u -> mapperUtil.mapTo(u, UserOutput.class)).collect(Collectors.toList()));

    }

    @GetMapping({"/{id}/", "/{id}"})
    @ResponseBody
    public UserOutput findById(@PathVariable("id") String id){
        return mapperUtil.mapTo(userService.findById(id), UserOutput.class);
    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserOutput update(@RequestBody UserInput userInput){
         var user = userService.update(mapperUtil.mapTo(userInput, User.class));
         return mapperUtil.mapTo(user, UserOutput.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteById(@PathVariable("id") String id){
         userService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserOutput insert(@RequestBody UserInput userInput){
        return mapperUtil.mapTo(userService.insert(mapperUtil.mapTo(userInput, User.class)), UserOutput.class);

    }
}
