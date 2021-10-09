package com.example.demo.users;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private UserRepository userRepository;
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    User getUserByEmail(String Email){
        User user= userRepository.getById(Email);
        return user;
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
