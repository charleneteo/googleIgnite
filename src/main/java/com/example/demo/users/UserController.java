package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getUsers(){
        List<User> toReturn=userService.getAllUsers();
        if(toReturn.size()==0){
            throw new UserNotFoundException();

        }
        return toReturn;
    }

    @PostMapping("/create")
    public void newUser(@RequestBody User newUser){
        userService.addNewUser(newUser);
    }


    @GetMapping("/get/{email}")
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
