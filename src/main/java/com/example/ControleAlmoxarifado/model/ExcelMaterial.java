package com.example.ControleAlmoxarifado.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExcelMaterial {

    private String nomeMaterial;
    private String unidade;
    private BigDecimal estoque;
    private String nomeFornecedor;
    private String cnpjFornecedor;
}
