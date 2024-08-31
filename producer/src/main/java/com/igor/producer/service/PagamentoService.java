package com.igor.producer.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.igor.producer.dto.PagamentoDTO;
import com.igor.producer.producer.ProducerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagamentoService {

  private final ProducerService producerService;

  public String create(PagamentoDTO pagamento) {
    try {
      producerService.sendToTopic(pagamento);
      return "Pagamento sent to topic: " + pagamento;
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return "Error while trying to send Pagamento: " + pagamento;
    }
  }

}
