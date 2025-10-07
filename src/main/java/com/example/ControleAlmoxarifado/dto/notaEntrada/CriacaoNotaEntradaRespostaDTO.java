package com.example.ControleAlmoxarifado.dto.notaEntrada;

import java.time.LocalDate;
import java.util.HashMap;

public record CriacaoNotaEntradaRespostaDTO(
        int id,
        int idFornecedor,
        LocalDate dataEntrada,
        HashMap<String, Double> materiais
){
}
