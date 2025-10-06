package com.example.ControleAlmoxarifado.dto.material;

public record CriacaoMaterialRespostaDTO(
        int id,
        String nome,
        String unidade,
        double estoque
) {
}
