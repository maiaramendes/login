package com.login.utils;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ReaderUtils {

    public static JSONArray read(final String filePath) throws IOException {
        final JSONParser jsonParser = new JSONParser();
        try (final FileReader reader = new FileReader(filePath)) {
            final Object object = jsonParser.parse(reader);
            return (JSONArray) object;
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

    public static ArrayList<?> convertToObject(final JSONArray jsonArray, final Class<?> type) {
        final ArrayList<?> list = new ArrayList<>();
        jsonArray.stream().forEach(array -> list.add(new Gson().fromJson(array.toString(), (Type) type)));
        return list;
    }
}
