package com.example.ControleAlmoxarifado.dto.material;

public record CriacaoMaterialRequisicaoDTO(
        String nome,
        String unidade,
        double estoque
) {
}
