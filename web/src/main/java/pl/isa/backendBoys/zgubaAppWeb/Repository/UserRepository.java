package pl.isa.backendBoys.zgubaAppWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.isa.backendBoys.zgubaAppWeb.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLoginEmail(String login);
}
