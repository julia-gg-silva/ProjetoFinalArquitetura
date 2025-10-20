package com.example.ControleAlmoxarifado.dto.requisicao;

import com.example.ControleAlmoxarifado.model.Material;

import java.time.LocalDate;
import java.util.HashMap;


public record CriacaoRequisicaoRequisicaoDTO(
        String setor,
        LocalDate dataSolicitacao,
        String status,
        HashMap<Long, Double> materiais
) {
}
