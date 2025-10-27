package com.example.ControleAlmoxarifado.model.dto.material;

import java.math.BigDecimal;

public record CriacaoMaterialRespostaDTO(
        Long id,
        String nome,
        String unidade,
        BigDecimal estoque
) {
}
