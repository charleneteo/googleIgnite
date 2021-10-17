package com.example.demo.users;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    User getUserByEmail(String Email){
        Optional<User> user= userRepository.findById(Email);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    User save(User newUser){
        return userRepository.save(newUser);
    }

    void deleteById(User user){
        userRepository.deleteById(user.getEmail());
    }

    void delete(User user){
        userRepository.delete(user);
    }

    public void addNewUser(User user) {
        //checks if email exist
        boolean userExists = userRepository
                .findById(user.getEmail())
                .isPresent();
        //if yes throw error
        if (userExists) {
            throw new IllegalStateException("email already taken");
        }
        userRepository.save(user);
    }
}
