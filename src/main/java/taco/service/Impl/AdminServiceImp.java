package taco.service.Impl;

import org.springframework.stereotype.Service;
import taco.repository.OrderRepository;
import taco.service.AdminService;

@Service
public class AdminServiceImp implements AdminService {

  private final OrderRepository orderRepository;

  public AdminServiceImp(OrderRepository orderRepository){
    this.orderRepository = orderRepository;
  }

  @Override
  public void deleteAllOrders(){
    orderRepository.deleteAll();
  }
}
