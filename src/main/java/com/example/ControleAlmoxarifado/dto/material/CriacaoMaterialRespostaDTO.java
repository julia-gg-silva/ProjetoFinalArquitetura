package com.example.ControleAlmoxarifado.dto.material;

public record CriacaoMaterialRespostaDTO(
        Long id,
        String nome,
        String unidade,
        double estoque
) {
}
