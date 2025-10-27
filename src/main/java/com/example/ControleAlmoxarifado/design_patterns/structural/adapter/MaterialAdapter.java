package com.example.ControleAlmoxarifado.design_patterns.structural.adapter;

import com.example.ControleAlmoxarifado.model.Fornecedor;
import com.example.ControleAlmoxarifado.model.Material;

public interface MaterialAdapter {

    Material toMaterial();
    Fornecedor toFornecedor();
}
