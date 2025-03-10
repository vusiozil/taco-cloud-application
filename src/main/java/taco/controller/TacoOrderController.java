package taco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taco.domain.OrderStage;
import taco.domain.TacoOrder;
import taco.service.OrderMessagingService;
import taco.service.OrderService;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class TacoOrderController {

  private OrderService orderService;

  private final OrderMessagingService messagingService;

  @Autowired
  public TacoOrderController(OrderService orderService,
                             OrderMessagingService messagingService){
    this.orderService = orderService;
    this.messagingService = messagingService;
  }

  @PostMapping
  public ResponseEntity<String> save(@RequestBody TacoOrder order){

    order.setOrderStage(OrderStage.PLACED);

    messagingService.sendOrder(order);

    TacoOrder tacoOrder = orderService.save(order);
    return ResponseEntity
            .created(URI.create("/orders/" + tacoOrder.getId()))
            .body("Taco order created successfully");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@RequestBody TacoOrder tacoOrder,
                                       @PathVariable("id") Long id){

    tacoOrder.setId(id);
    orderService.update(tacoOrder);
    return ResponseEntity
            .ok("Order updated successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@NotNull @PathVariable("id") Long id){

    orderService.deleteById(id);

    return ResponseEntity
            .ok("Order deleted successfully");
  }

  @GetMapping("/{id}")
  public ResponseEntity<TacoOrder> getOrderById(@NotNull @PathVariable("id") Long id){

    TacoOrder tacoOrder = orderService.findById(id);

    return ResponseEntity.ok(tacoOrder);

  }

  @GetMapping
  public ResponseEntity<List<TacoOrder>> getOrders(){
    return ResponseEntity.ok(orderService.findAll());
  }

}
