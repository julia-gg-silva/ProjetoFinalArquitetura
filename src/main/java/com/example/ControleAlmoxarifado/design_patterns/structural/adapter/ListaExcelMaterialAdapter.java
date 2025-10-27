package com.example.ControleAlmoxarifado.design_patterns.structural.adapter;

import com.example.ControleAlmoxarifado.model.ExcelMaterial;
import com.example.ControleAlmoxarifado.model.Fornecedor;
import com.example.ControleAlmoxarifado.model.Material;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListaExcelMaterialAdapter {

    // recebe a lista de materiais da planilha
    private final List<ExcelMaterial> materiaisExcel;

    // converte todos os dados da planilha em entidades material
    public List<Material> toMateriais(){
        return materiaisExcel.stream()
                .map(material -> new ExcelMaterialAdapter(material).toMaterial())
                .toList();
    }

    // converte todos os dados da planilha em entidades fornecedor
    public List<Fornecedor> toFornecedores(){
        return materiaisExcel.stream()
                .map(fornecedor -> new ExcelMaterialAdapter(fornecedor).toFornecedor())
                .toList();
    }
}
