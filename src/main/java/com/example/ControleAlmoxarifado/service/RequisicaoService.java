package com.example.ControleAlmoxarifado.service;

import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRespostaDTO;
import com.example.ControleAlmoxarifado.mapper.RequisicaoItemMapper;
import com.example.ControleAlmoxarifado.mapper.RequisicaoMapper;
import com.example.ControleAlmoxarifado.model.Material;
import com.example.ControleAlmoxarifado.model.Requisicao;
import com.example.ControleAlmoxarifado.model.RequisicaoItem;
import com.example.ControleAlmoxarifado.repository.MaterialRepository;
import com.example.ControleAlmoxarifado.repository.RequisicaoRepository;
import com.example.ControleAlmoxarifado.repository.RequisicaoItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequisicaoService {

    private RequisicaoRepository repository;
    private RequisicaoItemRepository repositoryItem;
    private MaterialRepository repositoryMaterial;
    private RequisicaoMapper mapper;
    private RequisicaoItemMapper itemMapper;



    public CriacaoRequisicaoRespostaDTO criar(CriacaoRequisicaoRequisicaoDTO requisicaoDTO) {
        Requisicao requisicao = repository.save(mapper.paraEntidade(requisicaoDTO, LocalDate.now(), "PENDENTE"));

        HashMap<String, Double> nomeMateriais = new HashMap<>();

        requisicaoDTO.materiais().forEach((idMaterial, quantidade) -> {
            Material material = repositoryMaterial.findById(idMaterial).orElseThrow(() -> {
               throw new RuntimeException("Material não encontrado!");
            });
            repositoryItem.save(itemMapper.paraEntidade(requisicao, material, quantidade));

            nomeMateriais.put(material.getNome(), quantidade);
        });

        return mapper.paraRespostaDTO(requisicao, nomeMateriais);
    }

    public HashMap<String, Double> retornarMateriais(Requisicao requisicao){
        HashMap<String, Double>  materiais = new HashMap<>();

        for(RequisicaoItem item : requisicao.getItens()){
            materiais.put(item.getMaterial().getNome(), item.getQuantidade());
        }

        return materiais;
    }

    public List<CriacaoRequisicaoRespostaDTO> buscarTodos() {
        List<Requisicao> requisicao = repository.findAll();
        List<CriacaoRequisicaoRespostaDTO> resposta = new ArrayList<>();

        for(Requisicao r : requisicao){
            HashMap<String, Double> materiais = retornarMateriais(r);
            resposta.add(mapper.paraRespostaDTO(r, materiais));
        }

        return resposta;
    }

    public CriacaoRequisicaoRespostaDTO buscarPorId(Long id) {
        Requisicao requisicao = repository.findById(id).orElseThrow(() ->{
            throw new RuntimeException("A Requisicao não encontrada!");
        });

        HashMap<String, Double> materiais = retornarMateriais(requisicao);

        return mapper.paraRespostaDTO(requisicao, materiais);

    }


    public CriacaoRequisicaoRespostaDTO atualizar(Long id, CriacaoRequisicaoRequisicaoDTO requisicaoDTO) {
        Requisicao requisicao = repository.findById(id).orElseThrow(() ->{
            throw new RuntimeException("A Requisicao não encontrada!");
        });

        HashMap<String, Double> materiais = retornarMateriais(requisicao);

        Requisicao newRequisicao = mapper.paraUpdate(requisicaoDTO, requisicao);
        repository.save(newRequisicao);
        return mapper.paraRespostaDTO(newRequisicao, materiais);
    }


    public void deletar(Long id) {
        Requisicao requisicao = repository.findById(id).orElseThrow(() ->{
            throw new RuntimeException("A Requisicao não encontrada!");
        });

        repository.deleteById(id);

    }

}
