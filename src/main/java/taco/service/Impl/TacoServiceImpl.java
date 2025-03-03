package taco.service.Impl;

import org.springframework.stereotype.Service;
import org.togglz.core.manager.FeatureManager;
import taco.domain.Ingredient;
import taco.domain.Taco;
import taco.repository.TacoRepository;
import taco.service.TacoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static taco.helper.FeatureFlags.DISCOUNT_APPLIED;

@Service
public class TacoServiceImpl implements TacoService {

  private final TacoRepository tacoRepository;

  private final FeatureManager featureManager;

  public TacoServiceImpl(TacoRepository tacoRepository, FeatureManager featureManager){
    this.tacoRepository = tacoRepository;
    this.featureManager = featureManager;
  }

  @Override
  public List<Taco> findAll(){

    System.out.println("featureManager.isActive(DISCOUNT_APPLIED) = " + featureManager.isActive(DISCOUNT_APPLIED));

    if(featureManager.isActive(DISCOUNT_APPLIED)){

      return tacoRepository
              .findAll()
              .parallelStream().map(d -> {
                double amount = d.getIngredients()
                        .parallelStream()
                        .mapToDouble(Ingredient::getPrice)
                        .sum();
                d.setPrice(amount - amount * 0.05);
                return d;
              }).collect(Collectors.toList());

    }
    return tacoRepository
            .findAll()
            .parallelStream().map(d -> {
              double amonut = d.getIngredients()
                      .parallelStream()
                      .mapToDouble(Ingredient::getPrice)
                      .sum();
              d.setPrice(amonut);
              return d;
            }).collect(Collectors.toList());
  }

  @Override
  public Optional<Taco> findById(Long id){

    return tacoRepository.findById(id);
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
    tacoRepository.deleteById(id);
  }

  @Override
  public void delete(Taco entity){
    tacoRepository.delete(entity);
  }
}
