package com.example.demo.users;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.projects.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testAddNewUser() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setFname("Fname");
        user.setLname("Lname");
        user.setUserProjects(new ArrayList<Project>());
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setFname("Fname");
        user1.setLname("Lname");
        user1.setUserProjects(new ArrayList<Project>());
        assertThrows(IllegalStateException.class, () -> this.userServiceImpl.addNewUser(user1));
        verify(this.userRepository).findByEmail((String) any());
    }

    @Test
    void testAddNewUser2() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setFname("Fname");
        user.setLname("Lname");
        user.setUserProjects(new ArrayList<Project>());
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.<User>empty());

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setFname("Fname");
        user1.setLname("Lname");
        user1.setUserProjects(new ArrayList<Project>());
        this.userServiceImpl.addNewUser(user1);
        verify(this.userRepository).findByEmail((String) any());
        verify(this.userRepository).save((User) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        when(this.userRepository.findById((String) any())).thenThrow(new IllegalStateException("foo"));
        assertThrows(IllegalStateException.class, () -> this.userServiceImpl.loadUserByUsername("jane.doe@example.org"));
        verify(this.userRepository).findById((String) any());
    }

    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        when(this.userRepository.findById((String) any())).thenReturn(Optional.<User>empty());
        assertThrows(UsernameNotFoundException.class,
                () -> this.userServiceImpl.loadUserByUsername("jane.doe@example.org"));
        verify(this.userRepository).findById((String) any());
    }

    @Test
    void testGetAllUsers() {
        ArrayList<User> userList = new ArrayList<User>();
        when(this.userRepository.findAll()).thenReturn(userList);
        List<User> actualAllUsers = this.userServiceImpl.getAllUsers();
        assertSame(userList, actualAllUsers);
        assertTrue(actualAllUsers.isEmpty());
        verify(this.userRepository).findAll();
    }

    @Test
    void testGetUserByEmail() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setFname("Fname");
        user.setLname("Lname");
        user.setUserProjects(new ArrayList<Project>());
        when(this.userRepository.getById((String) any())).thenReturn(user);
        assertSame(user, this.userServiceImpl.getUserByEmail("jane.doe@example.org"));
        verify(this.userRepository).getById((String) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testSave() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setFname("Fname");
        user.setLname("Lname");
        user.setUserProjects(new ArrayList<Project>());
        when(this.userRepository.save((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setFname("Fname");
        user1.setLname("Lname");
        user1.setUserProjects(new ArrayList<Project>());
        assertSame(user, this.userServiceImpl.save(user1));
        verify(this.userRepository).save((User) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testDelete() {
        doNothing().when(this.userRepository).delete((User) any());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setFname("Fname");
        user.setLname("Lname");
        user.setUserProjects(new ArrayList<Project>());
        this.userServiceImpl.delete(user);
        verify(this.userRepository).delete((User) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.userRepository).deleteById((String) any());
        this.userServiceImpl.deleteById("jane.doe@example.org");
        verify(this.userRepository).deleteById((String) any());
        assertTrue(this.userServiceImpl.getAllUsers().isEmpty());
    }
}

