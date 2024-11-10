package com.example.demo.DTO;

import java.time.LocalDateTime;

public record EstoqueDTO(String Nome, String Tipo, String Valor, Integer Quantidade, String DtValidade) {
}
