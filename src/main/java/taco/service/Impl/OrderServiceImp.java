package taco.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import taco.domain.TacoOrder;
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
  public TacoOrder save(TacoOrder order){
    return orderRepository.save(order);
  }

  @Override
  public TacoOrder findById(Long id){
    return orderRepository
            .findById(id)
            .orElseThrow(() -> new DataNotFoundException("Order of Id " + id));
  }

  @Override
  public void deleteById(Long id){

    TacoOrder tacoOrder = findById(id);

    orderRepository.delete(tacoOrder);
  }

  @Override
  public Page<TacoOrder> findAll(Pageable pageable){
    return orderRepository.findAll(pageable);
  }

  @Override
  public List<TacoOrder> findAll(){
    return orderRepository.findAll();
  }

  @Override
  public void update(TacoOrder tacoOrder){

    findById(tacoOrder.getId());

    orderRepository.save(tacoOrder);
  }
}
