package taco.service;

import org.springframework.data.domain.Pageable;
import taco.domain.Taco;

import java.util.List;
import java.util.Optional;

public interface TacoService {


	List<Taco> findAll();

	Optional<Taco> findById(Long id);

	boolean existsById(Long id);

	Taco save(Taco entity);

	void deleteById(Long id);

	void delete(Taco entity);
}
