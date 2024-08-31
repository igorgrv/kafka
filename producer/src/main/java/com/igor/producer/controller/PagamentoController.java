package com.igor.producer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.producer.dto.PagamentoDTO;
import com.igor.producer.service.PagamentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {
  private final PagamentoService service;

  @PostMapping
  public String create(@RequestBody PagamentoDTO pagamento) {
    return service.create(pagamento);
  }

}
