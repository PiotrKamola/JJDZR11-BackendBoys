package pl.isa.backendBoys.zgubaAppWeb.database;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.isa.backendBoys.zgubaAppWeb.Repository.RequestRepository;
import pl.isa.backendBoys.zgubaAppWeb.Repository.UserRepository;
import pl.isa.backendBoys.zgubaAppWeb.user.User;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;

import pl.isa.backendBoys.zgubaAppWeb.database.JsonService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class MySqlService {

    private final UserRepository userRepository;
    private final RequestRepository requestRepository;

    @Autowired
    public MySqlService(UserRepository userRepository,
                        RequestRepository requestRepository){
        this.userRepository = userRepository;
        this.requestRepository = requestRepository;
    }

    public void addNewUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(User user) { userRepository.delete(user);}

    public void addNewRequest(Request request){
        requestRepository.save(request);
    }

    public void fillDatabase(){
        List<User> userList = JsonService.getUsersFromJsonFile();
        List<Request> requestList = JsonService.getRequestsfromJsonFile();

        try{
            userRepository.saveAll(userList);
            requestRepository.saveAll(requestList);
        }catch (Exception e){}
    }

    public List<User> getUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                        .toList();
    }
}
