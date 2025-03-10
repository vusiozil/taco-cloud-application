package taco.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import taco.domain.Taco;

import java.util.List;

public interface TacoService {

  List<Taco> findAll();

  Page<Taco> findAll(Pageable page);

  Taco findById(Long id);

  boolean existsById(Long id);

  Taco save(Taco entity);

  void deleteById(Long id);

  Taco update(Taco taco);

  void delete(Taco entity);
}
