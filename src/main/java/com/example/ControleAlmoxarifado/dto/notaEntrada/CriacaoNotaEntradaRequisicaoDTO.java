package com.example.ControleAlmoxarifado.dto.notaEntrada;

import com.example.ControleAlmoxarifado.model.Material;

import java.time.LocalDate;
import java.util.HashMap;

public record CriacaoNotaEntradaRequisicaoDTO(
        int idFornecedor,
        LocalDate dataEntrada,
        HashMap<Integer, Double> materiais
) {
}
