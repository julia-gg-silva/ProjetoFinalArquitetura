package com.example.ControleAlmoxarifado.dto.fornecedor;

import jakarta.validation.constraints.NotBlank;

public record CriacaoFornecedorRequisicaoDTO(
        @NotBlank(message = "O nome é obrigatório!")
        String nome,
        @NotBlank(message = "O CNPJ é obrigatório!")
        String cnpj
) {
}
