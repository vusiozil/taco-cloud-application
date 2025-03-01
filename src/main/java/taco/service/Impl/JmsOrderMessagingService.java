package taco.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import taco.domain.TacoOrder;
import taco.service.OrderMessagingService;

@Service
@Profile("jms")
public class JmsOrderMessagingService implements OrderMessagingService {

  private static final Logger LOG = LoggerFactory.getLogger(JmsOrderMessagingService.class);

  private final JmsTemplate template;

  public JmsOrderMessagingService(JmsTemplate template){
    this.template = template;
  }

  @Override
  public void sendOrder(TacoOrder order){

    template.convertAndSend("tacocloud.order.queue", order,
            message -> {
              message.setStringProperty("X_ORDER_SOURCE", "WEB");
              return message;
            });
    LOG.info("Sent order {}", order);
  }
}
