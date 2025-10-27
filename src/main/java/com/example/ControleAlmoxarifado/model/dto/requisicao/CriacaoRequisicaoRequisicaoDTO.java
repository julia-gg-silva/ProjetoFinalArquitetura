package com.example.ControleAlmoxarifado.model.dto.requisicao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.HashMap;


public record CriacaoRequisicaoRequisicaoDTO(
        @NotBlank(message = "O setor é obrigatório")
        String setor,

        @NotEmpty(message = "A lista de materiais não pode ser vazia!")
        HashMap<Long, BigDecimal> materiais,

        String status
) {
}
