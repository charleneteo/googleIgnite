package com.example.demo.users;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(){
        super();
    }

    public UserNotFoundException(String email){
        super(email + " user not found");
    }
}
