package com.example.ControleAlmoxarifado.dto.requisicao;

import com.example.ControleAlmoxarifado.model.Material;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;


public record CriacaoRequisicaoRequisicaoDTO(
        @NotBlank(message = "O setor é obrigatório")
        String setor,

        @NotEmpty(message = "A lista de materiais não pode ser vazia!")
        HashMap<Long, BigDecimal> materiais,

        String status
) {
}
