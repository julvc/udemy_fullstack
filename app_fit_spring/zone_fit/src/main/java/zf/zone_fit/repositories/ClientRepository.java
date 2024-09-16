package zf.zone_fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zf.zone_fit.models.Clients;


public interface ClientRepository extends JpaRepository<Clients, Integer>{

}
