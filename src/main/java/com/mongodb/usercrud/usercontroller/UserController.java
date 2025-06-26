package com.mongodb.usercrud.usercontroller;

import com.mongodb.usercrud.model.User;
import com.mongodb.usercrud.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
       return userService.addUser(user);

    }
    @GetMapping("/display")
    public List<User> displayUser(){
        return userService.dispalyUser();
    }

    @GetMapping("/display/{id}")
    public User displayUser(@PathVariable Integer id){
        return userService.dispalyUser(id);
    }

    @PutMapping("/update/{id}")
    public User displayUser(@RequestBody User user, @PathVariable Integer id){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);

    }

}
