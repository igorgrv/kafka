package com.igor.producer.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.igor.producer.dto.PagamentoDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProducerService {

  @Value("${topics.payment.request.topic}")
  private String topic;
  private final KafkaTemplate<String, String> kafkaTemplate;

  private ObjectMapper objectMapper = new ObjectMapper();

  public String sendToTopic(PagamentoDTO pagamento) throws JsonProcessingException {
    String request = objectMapper.writeValueAsString(pagamento);
    kafkaTemplate.send(topic, request);
    return "Pagamento enviado";
  }
  
}
