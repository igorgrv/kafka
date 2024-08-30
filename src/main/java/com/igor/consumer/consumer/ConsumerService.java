package com.igor.consumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

  @KafkaListener(topics = "${topics.payment.request.topic}", groupId = "pagamento-request-1")
  public void consumeMessage(String message) {
    System.out.println("Mensagem recebida=========\n" + message);
  }
}