package pl.isa.backendBoys.zgubaAppWeb.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;
import pl.isa.backendBoys.zgubaAppWeb.user.User;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {
}
