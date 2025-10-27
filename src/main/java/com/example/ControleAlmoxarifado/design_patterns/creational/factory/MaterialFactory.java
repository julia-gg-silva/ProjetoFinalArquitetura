package com.example.ControleAlmoxarifado.design_patterns.creational.factory;

import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRequisicaoDTO;
import com.example.ControleAlmoxarifado.mapper.MaterialMapper;
import com.example.ControleAlmoxarifado.model.Material;
import org.springframework.stereotype.Component;

@Component
public class MaterialFactory implements EntityFactory<Material, CriacaoMaterialRequisicaoDTO>{

    private final MaterialMapper mapper;

    public MaterialFactory(MaterialMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Material criar(CriacaoMaterialRequisicaoDTO dto) {
        return mapper.paraEntidade(dto);
    }
}
