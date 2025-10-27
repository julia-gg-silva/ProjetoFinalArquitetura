package com.example.ControleAlmoxarifado.model.dto.material;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record CriacaoMaterialRequisicaoDTO(
        @NotBlank(message = "O nome é obrigatório!")
        String nome,
        @NotBlank(message = "A unidade é obrigatório!")
        String unidade,
        @NotNull(message = "O valor do estoque é obrigatório!")
        @PositiveOrZero(message = "O valor do estoque não pode ser negativo!")
        BigDecimal estoque
) {
}
