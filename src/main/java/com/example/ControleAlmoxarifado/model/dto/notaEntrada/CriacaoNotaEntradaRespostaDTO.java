package com.example.ControleAlmoxarifado.model.dto.notaEntrada;

import com.example.ControleAlmoxarifado.model.Fornecedor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

public record CriacaoNotaEntradaRespostaDTO(
        Long id,
        String nomeFornecedor,
        LocalDate dataEntrada,
        HashMap<String, BigDecimal> materiais
){
}
