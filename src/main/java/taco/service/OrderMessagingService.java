package taco.service;

import taco.domain.TacoOrder;

public interface OrderMessagingService {

  public void sendOrder(TacoOrder order);
}
