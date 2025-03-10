package taco.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import taco.domain.TacoOrder;

import java.util.List;

public interface OrderService {

  void deleteAllOrders();

  TacoOrder save(TacoOrder order);

  TacoOrder findById(Long id);

  void deleteById(Long id);

  Page<TacoOrder> findAll(Pageable pageable);

  List<TacoOrder> findAll();

  void update(TacoOrder tacoOrder);

}
