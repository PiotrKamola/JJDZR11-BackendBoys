package org.example.jsonService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.user.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class JsonController {
    ExampleData exampleData = new ExampleData();

    public static void updateJsonFile(List<User> users, String fileName) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

    }

    public static List<User> getfromJsonFile(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();


    }

    public void initializeData(){

    }
}
