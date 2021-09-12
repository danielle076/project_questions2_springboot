package nl.danielle.demo_springboot.repository;

import nl.danielle.demo_springboot.model.Persoon;
import org.springframework.data.repository.CrudRepository;

public interface PersoonRepository extends CrudRepository<Persoon, Long> {
}
