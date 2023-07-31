package taco.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import taco.domain.Taco;

import java.util.List;

public interface TacoRepository extends CrudRepository<Taco,Long> {

  List<Taco> findAll(Pageable pageable);
}
