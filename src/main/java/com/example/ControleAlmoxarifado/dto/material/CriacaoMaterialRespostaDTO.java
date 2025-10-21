package com.example.ControleAlmoxarifado.dto.material;

import java.math.BigDecimal;

public record CriacaoMaterialRespostaDTO(
        Long id,
        String nome,
        String unidade,
        BigDecimal estoque
) {
}
