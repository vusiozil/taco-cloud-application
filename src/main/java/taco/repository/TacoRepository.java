package taco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taco.domain.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {

}
