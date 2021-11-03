package com.login.user.service;

import com.login.exceptions.UserNotFoundException;
import com.login.user.model.User;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.login.utils.ReaderUtils.convertToObject;
import static com.login.utils.ReaderUtils.read;

@Service
public class UserService {

    private final static String PATH = "/home/maiara/login/src/main/resources/users/users.json";

    public User find(final String userName) throws UserNotFoundException {
        return getAll().stream().filter(t -> t.getUserName().equalsIgnoreCase(userName)).findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    @SneakyThrows
    public ArrayList<User> getAll() {
        return (ArrayList<User>) convertToObject(read(PATH), User.class);
    }
}
