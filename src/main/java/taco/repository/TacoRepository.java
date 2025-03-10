package taco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taco.domain.Taco;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {

}
