package com.login.user.service;

import com.login.exceptions.UserNotFoundException;
import com.login.user.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldReturnAllUsers() {
        final ArrayList<User> list = userService.getAll();
        assertNotNull(list);
    }

    @Test
    public void shouldFindUser() throws UserNotFoundException {
        final User expected = expectedUser();
        final User user = userService.find("maiaramendes");
        assertEquals(expected, user);
        assertEquals("Maiara", user.getName());
    }

    @Test
    public void shouldThrowsIfNotFindUser() {
        assertThrows(UserNotFoundException.class, () -> userService.find(""));
    }

    private User expectedUser() {
        final User user = new User();
        user.setName("Maiara");
        user.setUserName("maiaramendes");
        user.setEmail("maiarampereira@live.com");
        return user;
    }
}
