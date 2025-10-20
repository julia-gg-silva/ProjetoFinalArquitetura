package com.example.ControleAlmoxarifado.dto.requisicao;

import java.time.LocalDate;
import java.util.HashMap;

public record CriacaoRequisicaoRespostaDTO(
        Long id,
        String setor,
        LocalDate dataSolicitacao,
        String status,
        HashMap<String, Double> materiais
) {
}
