package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users/getAll")
    public List<User> getUsers(){
        List<User> toReturn=userService.getAllUsers();
        if(toReturn.size()==0){
            throw new UserNotFoundException();

        }
        return toReturn;
    }

    @PostMapping("/Register")
    public void Register(@RequestBody User newUser){

        userService.addNewUser(newUser);
    }

    @PostMapping("/Login")
    public void Login(@RequestBody User newUser){
        userService.Login(newUser);
    }


    @GetMapping("/users/get/{email}")
    public User getUserByEmail(@PathVariable String email){

        User user=userService.getUserByEmail(email);

        if(user==null){
            // throw an exception
            throw new UserNotFoundException(email);
        }
        return user;
    }


    @DeleteMapping("/del/{email}")
    void deleteUser(@PathVariable String email ){
        User user= userService.getUserByEmail(email);
        if(user==null){
            // throw an exception
            throw new UserNotFoundException(email);
        }
        userService.delete(user);
    }



}
