package taco.config;

import jakarta.jms.Queue;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import taco.domain.Order;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("jms")
public class JMSConfig {

  @Bean
  public Queue defaultQueue() {
    return new ActiveMQQueue("tacocloud.order.queue");  // Define the queue here
  }

  @Bean
  public MappingJackson2MessageConverter messageConverter(){
    MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
    messageConverter.setTypeIdPropertyName("_typeId");

    Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
    typeIdMappings.put("order", Order.class);
    messageConverter.setTypeIdMappings(typeIdMappings);
    return messageConverter;
  }

}
