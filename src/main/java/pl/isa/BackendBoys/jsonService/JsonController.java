package pl.isa.BackendBoys.jsonService;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.isa.BackendBoys.request.Request;
import pl.isa.BackendBoys.user.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class JsonController {
    private static final String USERS_JSONFILE_PATH = "./users.json";
    private static final String REQUESTS_JSONFILE_PATH = "./requests.json";

    public static void updateUsersJsonFile(List<User> users) {
        ObjectMapper objectMapper = new ObjectMapper();

        File jsonFileUsers = new File(USERS_JSONFILE_PATH);

        try {
            objectMapper.writeValue(jsonFileUsers, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateRequestsJsonFile(List<Request> requests) {
        ObjectMapper objectMapper = new ObjectMapper();

        File jsonFileRequests = new File(REQUESTS_JSONFILE_PATH);

        try {
            objectMapper.writeValue(jsonFileRequests, requests);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> getUsersFromJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return Arrays.asList(objectMapper.readValue(Paths.get(USERS_JSONFILE_PATH).toFile(), User[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static List<Request> getRequestsfromJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return Arrays.asList(objectMapper.readValue(Paths.get(REQUESTS_JSONFILE_PATH).toFile(), Request[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static void initializeExampleData() {
        ExampleData exampleData = new ExampleData();

        updateUsersJsonFile(exampleData.createExampleUsers());
        updateRequestsJsonFile(exampleData.createExampleRequests());
    }
}
