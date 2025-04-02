package taco.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import taco.domain.Order;

import java.util.List;

public interface OrderService {

  void deleteAllOrders();

  Order save(Order order);

  Order findById(Long id);

  void deleteById(Long id);

  Page<Order> findAll(Pageable pageable);

  List<Order> findAll();

  void update(Order order);

}
