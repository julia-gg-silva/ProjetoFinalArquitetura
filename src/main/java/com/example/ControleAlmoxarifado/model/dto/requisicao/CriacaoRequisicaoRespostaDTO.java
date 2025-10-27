package com.example.ControleAlmoxarifado.model.dto.requisicao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

public record CriacaoRequisicaoRespostaDTO(
        Long id,
        String setor,
        LocalDate dataSolicitacao,
        String status,
        HashMap<String, BigDecimal> materiais
) {
}
