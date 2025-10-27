package com.example.ControleAlmoxarifado.design_patterns.structural.adapter;

import com.example.ControleAlmoxarifado.model.ExcelMaterial;
import com.example.ControleAlmoxarifado.model.Fornecedor;
import com.example.ControleAlmoxarifado.model.Material;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExcelMaterialAdapter implements MaterialAdapter{
    //recebendo uma planilha de material
    private final ExcelMaterial excelMaterial;

    // converte os dados da planilha para material
    @Override
    public Material toMaterial() {
        return new Material(excelMaterial.getNomeMaterial(),
                excelMaterial.getUnidade(),
                excelMaterial.getEstoque());
    }

    // converte os dados da planilha para fornecedor
    @Override
    public Fornecedor toFornecedor() {
        return new Fornecedor(excelMaterial.getNomeFornecedor(),
                excelMaterial.getCnpjFornecedor());
    }
}
