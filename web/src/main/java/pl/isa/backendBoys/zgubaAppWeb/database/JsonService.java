package pl.isa.backendBoys.zgubaAppWeb.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;
import pl.isa.backendBoys.zgubaAppWeb.user.User;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JsonService {
    private static final String USERS_JSONFILE_PATH = "web/src/main/resources/data/users.json";
    private static final String REQUESTS_JSONFILE_PATH = "web/src/main/resources/data/requests.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonService() {
    }

    public static List<User> getUsersFromJsonFile() {
        try {
            return Arrays.asList(objectMapper.readValue(Paths.get(USERS_JSONFILE_PATH).toFile(), User[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static List<Request> getRequestsfromJsonFile() {
        try {
            return Arrays.asList(objectMapper.readValue(Paths.get(REQUESTS_JSONFILE_PATH).toFile(), Request[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
