package com.example.demo.users;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;


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



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserByEmail(String Email) {
        return userRepository.getById(Email);
    }


    public void delete(User user) {
        userRepository.delete(user);

    }


    public void deleteById(String userEmail) {
        userRepository.deleteById(userEmail);
    }

    public User Login(User newUser) throws UserNotFoundException{

        User oldUser = userRepository.findByEmailAndPassword(newUser.getEmail(), newUser.getPassword());
        if(oldUser==null){
          throw new UserNotFoundException();
        }
        return oldUser;

    }
}
