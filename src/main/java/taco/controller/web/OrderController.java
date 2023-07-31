package taco.controller.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import taco.domain.TacoOrder;
import taco.domain.User;
import taco.repository.OrderRepository;
import taco.service.OrderMessagingService;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@ConfigurationProperties(prefix = "taco.orders")

public class OrderController {

  private int pageSize = 20;

  private final OrderMessagingService messagingService;

  public void setPageSize(int pageSize){
    this.pageSize = pageSize;
  }

  private final OrderRepository orderRepository;

  public OrderController(OrderMessagingService messagingService, OrderRepository orderRepository){
    this.messagingService = messagingService;
    this.orderRepository = orderRepository;
  }

  @GetMapping("/current")
  private String orderForm(){

    return "orderForm";
  }

  @GetMapping
  public String ordersForUser(
          @AuthenticationPrincipal User user, Model model) {
    Pageable pageable = PageRequest.of(0, pageSize);
    model.addAttribute("orders",
            orderRepository.findByUserOrderByPlacedAtDesc(user, pageable));
    return "orderList";
  }
  
  @PostMapping
  String processCheckout(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus,
                         @AuthenticationPrincipal User user){
    System.out.println("tacoOrder = " + tacoOrder);
//    if(errors.hasErrors()){
//      return "orderForm";
//    }

    tacoOrder.setUser(user);
    messagingService.sendOrder(tacoOrder);
    orderRepository.save(tacoOrder);
    sessionStatus.setComplete();
    return "redirect:/design";
  }
}
