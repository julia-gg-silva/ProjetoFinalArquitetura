package com.example.ControleAlmoxarifado.mapper;

import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRespostaDTO;
import com.example.ControleAlmoxarifado.model.Material;
import org.springframework.stereotype.Component;

@Component
public class MaterialMapper {

    public Material paraEntidade(CriacaoMaterialRequisicaoDTO requisicaoDTO){
        return new Material(requisicaoDTO.nome(), requisicaoDTO.unidade(), requisicaoDTO.estoque());
    }

    public CriacaoMaterialRespostaDTO paraRespostaDto(Material material){
        return new CriacaoMaterialRespostaDTO(material.getId(), material.getNome(), material.getUnidade(), material.getEstoque());
    }

    public Material paraUpdate(Material material, CriacaoMaterialRequisicaoDTO requisicaoDTO){
        if(!requisicaoDTO.nome().equals(material.getNome()) && !requisicaoDTO.nome().isEmpty()){
            material.setNome(requisicaoDTO.nome());
        }

        if(!requisicaoDTO.unidade().equals(material.getUnidade()) && !requisicaoDTO.unidade().isEmpty()){
            material.setNome(requisicaoDTO.nome());
        }

        if(requisicaoDTO.estoque() != material.getEstoque() && requisicaoDTO.estoque() != 0){
            material.setNome(requisicaoDTO.nome());
        }

        return material;
    }
}
