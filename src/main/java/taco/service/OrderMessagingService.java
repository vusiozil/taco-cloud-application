package taco.service;

import taco.domain.Order;

public interface OrderMessagingService {

	void sendOrder(Order order);
}
