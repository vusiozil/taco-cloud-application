package taco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import taco.domain.OrderStage;
import taco.domain.TacoOrder;
import taco.helper.TacoOrderNotFoundException;
import taco.repository.OrderRepository;
import taco.service.OrderMessagingService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/orders", consumes = "application/json", produces = "application/json")
public class TacoOrderController {

  private final OrderRepository orderRepository;

  private final OrderMessagingService messagingService;

  @Autowired
  public TacoOrderController(OrderRepository orderRepository,
                             OrderMessagingService messagingService){
    this.orderRepository = orderRepository;
    this.messagingService = messagingService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TacoOrder saveOrder(@RequestBody TacoOrder order){

    order.setOrderStage(OrderStage.PLACED);

    messagingService.sendOrder(order);
    return orderRepository.save(order);
  }

  @PutMapping("/{id}")
  public TacoOrder updateOrder(@RequestBody TacoOrder tacoOrder, @PathVariable("id") Long id){

    return orderRepository
            .findById(id)
            .map(order -> {
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
  public EntityModel<TacoOrder> getOrderById(@PathVariable("id") Long id){
    TacoOrder tacoOrder = orderRepository
            .findById(id)
            .orElseThrow(() -> new TacoOrderNotFoundException(id));

    return EntityModel.of(tacoOrder, //
            linkTo(methodOn(TacoOrderController.class).getOrderById(id)).withSelfRel(),
            linkTo(methodOn(TacoOrderController.class).getOrders()).withRel("api/orders"));

    //    return tacoOrder;
  }

  @GetMapping
  public List<TacoOrder> getOrders(){
    return orderRepository.findAll();
  }

}
