package pl.isa.BackendBoys.jsonService;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.isa.BackendBoys.user.User;

import java.io.IOException;
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
