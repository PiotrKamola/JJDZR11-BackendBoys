package pl.isa.backendBoys.zgubaAppWeb.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;
import pl.isa.backendBoys.zgubaAppWeb.user.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class JsonService {
    private static final String USERS_JSONFILE_PATH = "web/src/main/resources/data/users.json";
    private static final String REQUESTS_JSONFILE_PATH = "web/src/main/resources/data/requests.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void updateUsersJsonFile(List<User> users) {
        File jsonFileUsers = new File(USERS_JSONFILE_PATH);

        try {
            objectMapper.writeValue(jsonFileUsers, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateRequestsJsonFile(List<Request> requests) {
        File jsonFileRequests = new File(REQUESTS_JSONFILE_PATH);

        try {
            objectMapper.writeValue(jsonFileRequests, requests);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void importToSql() throws ClassNotFoundException, SQLException {
        List<User> userList = null;
        try {
            userList = Arrays.asList(objectMapper.readValue(Paths.get(USERS_JSONFILE_PATH).toFile(), User[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3307/zgubaDatabase";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");

        for(User user: userList){
            String city = user.getCity();
            System.out.println(city);

            String contactNumber = user.getContactNumber();
            System.out.println(contactNumber);

            String email = user.getLoginEmail();
            System.out.println(email);

            String name = user.getName();
            System.out.println(name);

            String password = user.getPassword();
            System.out.println(password);

            String sql = "insert into USERS (city, contactNumber, loginEmail, name, password)\n" +
                    "values (\""+city+"\", \""+contactNumber+"\", \""+email+"\", \""+name+"\", \""+password+"\");";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);

            try {
                preparedStmt.execute();
            }catch (Exception e){
                System.out.println("User exist.");
            }
            System.out.println("....................");
        }
        conn.close();
    }

}
