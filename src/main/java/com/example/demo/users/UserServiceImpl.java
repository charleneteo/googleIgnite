package com.example.demo.users;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void addNewUser(User user) {
        //checks if email exist
        boolean userExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();
        //if yes throw error
        if (userExists) {
            throw new IllegalStateException("email already taken");
        }
        //encrypting password
        String encodedPassword = passwordEncoder.bCryptPasswordEncoder()
                .encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findById(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("user with email %s is not found", email)));
    }


//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//
//    public String getPassword() {
//        return null;
//    }
//
//    public String getUsername() {
//        return null;
//    }
//
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    public boolean isEnabled() {
//        return false;
//    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserByEmail(String Email) {
        return userRepository.getById(Email);
    }


    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public void delete(User user) {
        userRepository.delete(user);

    }


    public void deleteById(String userEmail) {
        userRepository.deleteById(userEmail);
    }
}
