package pl.isa.backendBoys.zgubaAppWeb.database;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.isa.backendBoys.zgubaAppWeb.Repository.RequestRepository;
import pl.isa.backendBoys.zgubaAppWeb.Repository.UserRepository;
import pl.isa.backendBoys.zgubaAppWeb.user.User;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;

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

    public void addNewRequest(Request request){
        requestRepository.save(request);
    }
}
