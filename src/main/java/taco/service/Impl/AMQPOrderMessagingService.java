package taco.service.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import taco.domain.TacoOrder;
import taco.service.OrderMessagingService;

@Service
@Profile("rabbitmq")
public class AMQPOrderMessagingService implements OrderMessagingService {

  private final static Logger LOG = LoggerFactory.getLogger(AMQPOrderMessagingService.class);
  private final RabbitTemplate template;

  public AMQPOrderMessagingService(RabbitTemplate template){
    this.template = template;
  }

  @Override
  public void sendOrder(TacoOrder order){
   template.convertAndSend("amq.topic","kitchen_keys",order);
    LOG.info("Sent Taco order to Rabbit Message Broker");
  }
}
