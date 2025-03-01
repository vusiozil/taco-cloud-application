package taco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import taco.domain.TacoOrder;
import taco.helper.TacoOrderNotFoundException;
import taco.repository.OrderRepository;
import taco.service.OrderMessagingService;

import java.util.List;

@RestController
@RequestMapping(value = "api/orders", consumes = "application/json", produces = "application/json")
public class OrderApiController {

  private final OrderRepository orderRepository;

  private final OrderMessagingService messagingService;

  public OrderApiController(OrderRepository orderRepository,
                            OrderMessagingService messagingService){
    this.orderRepository = orderRepository;
    this.messagingService = messagingService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TacoOrder saveOrder(@RequestBody TacoOrder order){

    messagingService.sendOrder(order);
    return orderRepository.save(order);
  }

  @PutMapping("/{id}")
  public TacoOrder updateOrder(@RequestBody TacoOrder tacoOrder, @PathVariable("id") Long id){

    return orderRepository
            .findById(id)
            .map(order -> {
              order.setCcCVV(tacoOrder.getCcCVV());
              order.setCcExpiration(tacoOrder.getCcExpiration());
              order.setCcNumber(tacoOrder.getCcNumber());
              order.setDeliveryCity(tacoOrder.getDeliveryCity());
              order.setDeliveryState(tacoOrder.getDeliveryState());
              order.setDeliveryZip(tacoOrder.getDeliveryZip());
              order.setDeliveryName(tacoOrder.getDeliveryName());
              order.setDeliveryStreet(tacoOrder.getDeliveryStreet());
              order.setUser(tacoOrder.getUser());
              order.setTacos(tacoOrder.getTacos());
              return orderRepository.save(order);
            }).orElseGet(() -> {
              tacoOrder.setId(id);
              return orderRepository.save(tacoOrder);
            });
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTacoOrder(@PathVariable("id") Long id){

    orderRepository.deleteById(id);
  }

  @GetMapping("/{id}")
  public TacoOrder getOrderById(@PathVariable("id") Long id){
    TacoOrder tacoOrder = orderRepository
            .findById(id)
            .orElseThrow(() -> new TacoOrderNotFoundException(id));

    //      return EntityModel.of(tacoOrder, //
    //              linkTo(methodOn(OrderApiController.class).one(id)).withSelfRel(),
    //              linkTo(methodOn(OrderApiController.class).all()).withRel("api/orders"));

    return tacoOrder;
  }

  @GetMapping
  public List<TacoOrder> getOrders(){
    return orderRepository.findAll();
  }

}
