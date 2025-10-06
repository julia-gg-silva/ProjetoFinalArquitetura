package com.example.ControleAlmoxarifado.service;

import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRespostaDTO;
import com.example.ControleAlmoxarifado.mapper.MaterialMapper;
import com.example.ControleAlmoxarifado.model.Material;
import com.example.ControleAlmoxarifado.repository.MaterialDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MaterialService {

    private MaterialDAO repository;
    private MaterialMapper mapper;

    public MaterialService(MaterialDAO repository, MaterialMapper mapper) throws SQLException {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CriacaoMaterialRespostaDTO criar(CriacaoMaterialRequisicaoDTO requisicaoDTO) throws SQLException{
        if(repository.nomeExiste(requisicaoDTO.nome())){
            throw new RuntimeException("O nome do material já existe!");
        }

        if(requisicaoDTO.nome() == null){
            throw new RuntimeException("O nome do material é obrigatório!");
        }

        return mapper.paraRespostaDto(repository.criar(mapper.paraEntidade(requisicaoDTO)));
    }

    public List<CriacaoMaterialRespostaDTO> buscarTodos() throws SQLException{
        return repository.buscarTodos().stream()
                .map(mapper::paraRespostaDto)
                .toList();
    }

    public CriacaoMaterialRespostaDTO buscarPorId(int id) throws SQLException{
        Material material = repository.buscarPorId(id);

        if(material == null){
            throw new RuntimeException("Material não existe!");
        }

        return mapper.paraRespostaDto(material);
    }

    public CriacaoMaterialRespostaDTO atualizar(int id, CriacaoMaterialRequisicaoDTO requisicaoDTO) throws SQLException{
        Material material = repository.buscarPorId(id);

        if(material == null){
            throw new RuntimeException("Material não existe!");
        }

        Material newMaterial = mapper.paraUpdate(material, requisicaoDTO);
        repository.atualizar(id, newMaterial);
        return mapper.paraRespostaDto(newMaterial);
    }

    public void excluir(int id) throws SQLException{
        Material material = repository.buscarPorId(id);

        if(material == null){
            throw new RuntimeException("Material não existe!");
        }

        repository.excluir(id);
    }
}
