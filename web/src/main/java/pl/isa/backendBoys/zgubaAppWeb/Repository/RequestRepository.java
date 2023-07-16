package pl.isa.backendBoys.zgubaAppWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}
