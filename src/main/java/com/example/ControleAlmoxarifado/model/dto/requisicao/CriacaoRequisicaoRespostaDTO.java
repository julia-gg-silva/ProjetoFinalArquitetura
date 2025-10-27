package com.example.ControleAlmoxarifado.model.dto.requisicao;

import com.example.ControleAlmoxarifado.model.StatusRequisicao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

public record CriacaoRequisicaoRespostaDTO(
        Long id,
        String setor,
        LocalDate dataSolicitacao,
        StatusRequisicao status,
        HashMap<String, BigDecimal> materiais
) {
}
