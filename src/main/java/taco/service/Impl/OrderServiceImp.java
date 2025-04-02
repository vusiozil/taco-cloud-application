package taco.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import taco.domain.Order;
import taco.helper.DataNotFoundException;
import taco.repository.OrderRepository;

import java.util.List;

@Service

public class OrderServiceImp implements taco.service.OrderService {

  private final OrderRepository orderRepository;

  public OrderServiceImp(OrderRepository orderRepository){
    this.orderRepository = orderRepository;
  }

  @Override
  public void deleteAllOrders(){

    //    orderRepository.deleteAllInBatch();
    orderRepository.deleteAll();
  }

  @Override
  public Order save(Order order){
    return orderRepository.save(order);
  }

  @Override
  public Order findById(Long id){
    return orderRepository
            .findById(id)
            .orElseThrow(() -> new DataNotFoundException("Order of Id " + id));
  }

  @Override
  public void deleteById(Long id){

    Order order = findById(id);

    orderRepository.delete(order);
  }

  @Override
  public Page<Order> findAll(Pageable pageable){
    return orderRepository.findAll(pageable);
  }

  @Override
  public List<Order> findAll(){
    return orderRepository.findAll();
  }

  @Override
  public void update(Order order){

    findById(order.getId());

    orderRepository.save(order);
  }
}
