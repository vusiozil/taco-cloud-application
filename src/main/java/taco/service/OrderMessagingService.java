package taco.service;

import taco.domain.TacoOrder;

public interface OrderMessagingService {

	void sendOrder(TacoOrder order);
}
