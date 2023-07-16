package pl.isa.backendBoys.zgubaAppWeb.database;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.isa.backendBoys.zgubaAppWeb.Repository.RequestRepository;
import pl.isa.backendBoys.zgubaAppWeb.Repository.UserRepository;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;
import pl.isa.backendBoys.zgubaAppWeb.user.User;

import java.util.List;

@Service
@Transactional
public class MySqlService {

    private final UserRepository userRepository;
    private final RequestRepository requestRepository;

    @Autowired
    public MySqlService(UserRepository userRepository,
                        RequestRepository requestRepository) {
        this.userRepository = userRepository;
        this.requestRepository = requestRepository;
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public void updateUserPassword(User user, String newPassword) {
        user.setPassword(newPassword);
    }

    public void updateUserName(User user, String newName) {
        user.setName(newName);
    }

    public void updateUserCity(User user, String newCity) {
        user.setCity(newCity);
    }

    public void updateUserContactNumber(User user, String newContactNumber) {
        user.setContactNumber(newContactNumber);
    }

    public void updateUserEmailLogin(User user, String newEmailLogin) {
        user.setLoginEmail(newEmailLogin);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void addNewRequest(Request request) {
        requestRepository.save(request);
    }

    public void fillUsers() {
        List<User> userList = JsonService.getUsersFromJsonFile();

        for (User user : userList) {
            try {
                userRepository.save(user);
            } catch (Exception ignored) {
            }
        }

    }

    public void fillRequests() {
        List<Request> requestList = JsonService.getRequestsfromJsonFile();

        for (Request request : requestList) {
            request.setUser(userRepository.findUserByLoginEmail(request.getUser().getLoginEmail()));
            try {
                requestRepository.save(request);
            } catch (Exception ignored) {
            }
        }
    }

    public List<User> getUsers() {
        return userRepository.findAll().stream()
                .toList();
    }

    public List<Request> getRequests() {
        return requestRepository.findAll().stream()
                .toList();
    }

    public void deleteRequest(Request request) {
        requestRepository.delete(request);
    }

    public void updateRequest(Request request) {
        requestRepository.save(request);
    }
}
