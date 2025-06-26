package com.mongodb.usercrud.userservice;

import com.mongodb.usercrud.model.User;
import com.mongodb.usercrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
       return userRepository.save(user);

    }

    public List<User> dispalyUser(){
        return userRepository.findAll();
    }

    public User dispalyUser(Integer id){
        return userRepository.findById(id). orElse(null);
    }

    public User updateUser(Integer id, User user) {
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setAddress(user.getAddress());
            existingUser.setAge(user.getAge());
            existingUser.setName(user.getName());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

}
