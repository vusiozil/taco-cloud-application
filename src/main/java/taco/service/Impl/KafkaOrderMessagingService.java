package taco.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import taco.domain.Order;
import taco.service.OrderMessagingService;

@Service
@Profile("Kafka")
public class KafkaOrderMessagingService implements OrderMessagingService {

  private static final Logger LOG = LoggerFactory.getLogger(KafkaOrderMessagingService.class);
  private final KafkaTemplate<String, Order> kafkaTemplate;

  public KafkaOrderMessagingService(KafkaTemplate<String, Order> kafkaTemplate){
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void sendOrder(Order order){
    kafkaTemplate.send("tacocloud.orders.topic",order);
    LOG.info("Sent oder to kafka message broker");

  }
}
