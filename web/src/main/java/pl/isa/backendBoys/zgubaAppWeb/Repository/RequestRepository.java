package pl.isa.backendBoys.zgubaAppWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;
import pl.isa.backendBoys.zgubaAppWeb.user.User;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}
