package com.example.ControleAlmoxarifado.adapter;

import com.example.ControleAlmoxarifado.model.ExcelMaterial;
import com.example.ControleAlmoxarifado.model.Fornecedor;
import com.example.ControleAlmoxarifado.model.Material;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExcelMaterialAdapter implements MaterialAdapter{

    private final ExcelMaterial excelMaterial;

    @Override
    public Material toMaterial() {
        return new Material(excelMaterial.getNomeMaterial(),
                excelMaterial.getUnidade(),
                excelMaterial.getEstoque());
    }

    @Override
    public Fornecedor toFornecedor() {
        return new Fornecedor(excelMaterial.getNomeFornecedor(),
                excelMaterial.getCnpjFornecedor());
    }
}
