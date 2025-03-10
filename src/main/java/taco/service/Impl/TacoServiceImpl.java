package taco.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import taco.domain.Taco;
import taco.helper.DataNotFoundException;
import taco.repository.TacoRepository;
import taco.service.TacoService;

import java.util.List;

@Service
public class TacoServiceImpl implements TacoService {

  private final TacoRepository tacoRepository;

  public TacoServiceImpl(TacoRepository tacoRepository){
    this.tacoRepository = tacoRepository;
  }

  @Override
  public List<Taco> findAll(){

    return tacoRepository.findAll();
  }

  @Override
  public Page<Taco> findAll(Pageable page){

    return tacoRepository
            .findAll(page);
  }

  @Override
  public Taco findById(Long id){

    Taco taco = tacoRepository
            .findById(id)
            .orElseThrow(() -> new DataNotFoundException("Taco " + id));
    return taco;
  }

  @Override
  public boolean existsById(Long id){
    return tacoRepository.existsById(id);
  }

  @Override
  public Taco save(Taco entity){

    return tacoRepository.save(entity);
  }

  @Override
  public void deleteById(Long id){

    if(!existsById(id)){
      throw new DataNotFoundException("Taco " + id);
    }

    tacoRepository.deleteById(id);
  }

  @Override
  public Taco update(Taco taco){

    if(!existsById(taco.getId())){
      throw new DataNotFoundException("Taco " + taco.getId());
    }

    return tacoRepository.save(taco);
  }

  @Override
  public void delete(Taco taco){

    if(!existsById(taco.getId())){
      throw new DataNotFoundException("Taco " + taco.getId());
    }

    tacoRepository.delete(taco);
  }

}
