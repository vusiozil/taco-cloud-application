package taco.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taco.domain.OrderStage;
import taco.domain.Order;
import taco.service.OrderMessagingService;
import taco.service.OrderService;

import jakarta.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/orders")
@Tag(name = "Order API", description = "Endpoints for managing taco orders")
public class TacoOrderController {

  private final OrderService orderService;

  private final OrderMessagingService messagingService;

  @Autowired
  public TacoOrderController(OrderService orderService,
                             OrderMessagingService messagingService){
    this.orderService = orderService;
    this.messagingService = messagingService;
  }

  @PostMapping
  @Operation(
          summary = "Create a new order",
          description = "Saves a new taco order and assigns it the status 'PLACED'. The order is " +
                  "also sent to the messaging service."
  )
  public ResponseEntity<String> save(@Valid @RequestBody Order order){

    order.setOrderStage(OrderStage.PLACED);

    messagingService.sendOrder(order);

    Order tacoOrder = orderService.save(order);
    return ResponseEntity
            .created(URI.create("/orders/" + tacoOrder.getId()))
            .body("Taco order created successfully");
  }

  @PutMapping("/{id}")
  @Operation(
          summary = "Update an existing order",
          description = "Updates the details of an existing order based on the given ID."
  )
  public ResponseEntity<String> update(@Valid @RequestBody Order order,
                                       @Parameter(description = "ID of the order to update")
                                       @PathVariable("id") Long id){

    order.setId(id);
    orderService.update(order);
    return ResponseEntity
            .ok("Order updated successfully");
  }

  @DeleteMapping("/{id}")
  @Operation(
          summary = "Delete an order",
          description = "Deletes an order by the given ID."
  )
  public ResponseEntity<String> delete(@Parameter(description = "ID of the order to delete")
                                       @PathVariable("id") Long id){

    orderService.deleteById(id);

    return ResponseEntity
            .ok("Order deleted successfully");
  }

  @GetMapping("/{id}")
  @Operation(
          summary = "Retrieve an order",
          description = "Fetches an order by the given ID."
  )
  public ResponseEntity<Order> getOrderById(@Parameter(description = "ID of the order to " +
          "retrieve") @PathVariable("id") Long id){

    Order order = orderService.findById(id);

    return ResponseEntity.ok(order);

  }

  @GetMapping
  @Operation(
          summary = "Retrieve all orders",
          description = "Fetches all orders with optional pagination and sorting."
  )
  public ResponseEntity<?> getOrders(@Parameter(description = "Pagination and sorting options") @PageableDefault(size = 10) Pageable pageable){

    if(pageable.isUnpaged()){

      return ResponseEntity.ok(orderService.findAll());
    }

    return ResponseEntity
            .ok(orderService.findAll(pageable));
  }

  @DeleteMapping
  @Operation(
          summary = "Delete all orders",
          description = "Deletes all orders. This operation should be restricted to administrators."
  )
  public ResponseEntity<String> deleteAll(){

    orderService.deleteAllOrders();
    return ResponseEntity.ok("Deleted all orders");

  }

}
