package com.login.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.login.user.model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ReaderUtils {

    public static ArrayList<User> read(final String filePath) throws IOException {
        try (final InputStream reader = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(filePath)) {
            return new ObjectMapper().readValue(reader, new TypeReference<>() {});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
