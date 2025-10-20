package com.example.ControleAlmoxarifado.dto.notaEntrada;

import com.example.ControleAlmoxarifado.model.Fornecedor;
import com.example.ControleAlmoxarifado.model.Material;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.FormatterClosedException;
import java.util.HashMap;

public record CriacaoNotaEntradaRequisicaoDTO(
        @NotNull(message = "O id do fornecedor é obrigatório!")
        @Positive(message = "O id do fornecedor tem que ser maior que zero!")
        Fornecedor fornecedor,
        @NotEmpty(message = "A lista de materiais é obrigatória!")
        HashMap<Long, Double> materiais
) {
}
