package pl.isa.backendBoys.zgubaAppWeb.Repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import pl.isa.backendBoys.zgubaAppWeb.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
