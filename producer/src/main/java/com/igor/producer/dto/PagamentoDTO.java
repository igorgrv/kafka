package com.igor.producer.dto;

import java.math.BigDecimal;

public record PagamentoDTO(

    Integer numero,
    String descricao,
    BigDecimal valor) {

}
