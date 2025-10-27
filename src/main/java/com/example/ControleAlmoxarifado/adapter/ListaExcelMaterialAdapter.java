package com.example.ControleAlmoxarifado.adapter;

import com.example.ControleAlmoxarifado.model.ExcelMaterial;
import com.example.ControleAlmoxarifado.model.Fornecedor;
import com.example.ControleAlmoxarifado.model.Material;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListaExcelMaterialAdapter {

    private final List<ExcelMaterial> materiaisExcel;
    private final List<ExcelMaterial> fornecedoresExcel;

    public List<Material> toMateriais(){
        return materiaisExcel.stream()
                .map(material -> new ExcelMaterialAdapter(material).toMaterial())
                .toList();
    }

    public List<Fornecedor> toFornecedores(){
        return fornecedoresExcel.stream()
                .map(fornecedor -> new ExcelMaterialAdapter(fornecedor).toFornecedor())
                .toList();
    }
}
