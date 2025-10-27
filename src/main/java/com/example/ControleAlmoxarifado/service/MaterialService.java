package com.example.ControleAlmoxarifado.service;

import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRespostaDTO;
import com.example.ControleAlmoxarifado.design_patterns.creational.factory.MaterialFactory;
import com.example.ControleAlmoxarifado.mapper.MaterialMapper;
import com.example.ControleAlmoxarifado.model.Material;
import com.example.ControleAlmoxarifado.repository.MaterialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MaterialService {

    private MaterialRepository repository;
    private MaterialMapper mapper;
    private MaterialFactory factory;

    public CriacaoMaterialRespostaDTO criar(CriacaoMaterialRequisicaoDTO requisicaoDTO){
        if(repository.existsByNome(requisicaoDTO.nome())){
            throw new RuntimeException("O nome do material já existe!");
        }

        Material material = factory.criar(requisicaoDTO);

        return mapper.paraRespostaDto(repository.save(material));
    }

    public List<CriacaoMaterialRespostaDTO> buscarTodos(){
        return repository.findAll().stream()
                .map(mapper::paraRespostaDto)
                .toList();
    }

    public CriacaoMaterialRespostaDTO buscarPorId(Long id){
        Material material = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Material não existe!"));

        return mapper.paraRespostaDto(material);
    }

    public CriacaoMaterialRespostaDTO atualizar(Long id, CriacaoMaterialRequisicaoDTO requisicaoDTO){
        Material material = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Material não existe!"));

        Material newMaterial = mapper.paraUpdate(material, requisicaoDTO);
        repository.save(newMaterial);
        return mapper.paraRespostaDto(newMaterial);
    }

    public void excluir(Long id){
        Material material = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Material não existe!"));

        repository.delete(material);
    }
}
