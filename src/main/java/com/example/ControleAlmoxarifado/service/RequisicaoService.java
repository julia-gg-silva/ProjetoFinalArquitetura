package com.example.ControleAlmoxarifado.service;

import com.example.ControleAlmoxarifado.model.StatusRequisicao;
import com.example.ControleAlmoxarifado.model.dto.requisicao.CriacaoRequisicaoRequisicaoDTO;
import com.example.ControleAlmoxarifado.model.dto.requisicao.CriacaoRequisicaoRespostaDTO;
import com.example.ControleAlmoxarifado.model.mapper.RequisicaoItemMapper;
import com.example.ControleAlmoxarifado.model.mapper.RequisicaoMapper;
import com.example.ControleAlmoxarifado.model.Material;
import com.example.ControleAlmoxarifado.model.Requisicao;
import com.example.ControleAlmoxarifado.model.RequisicaoItem;
import com.example.ControleAlmoxarifado.design_patterns.behavioral.observer.AtualizarEstoqueObserver;
import com.example.ControleAlmoxarifado.design_patterns.behavioral.observer.RequisicaoEventManager;
import com.example.ControleAlmoxarifado.repository.MaterialRepository;
import com.example.ControleAlmoxarifado.repository.RequisicaoRepository;
import com.example.ControleAlmoxarifado.repository.RequisicaoItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RequisicaoService {

    private RequisicaoRepository repository;
    private RequisicaoItemRepository repositoryItem;
    private MaterialRepository repositoryMaterial;
    private RequisicaoMapper mapper;
    private RequisicaoItemMapper itemMapper;
    private RequisicaoEventManager eventManager;

    public RequisicaoService(RequisicaoRepository repository, RequisicaoItemRepository repositoryItem, MaterialRepository repositoryMaterial, RequisicaoMapper mapper, RequisicaoItemMapper itemMapper) {
        this.repository = repository;
        this.repositoryItem = repositoryItem;
        this.repositoryMaterial = repositoryMaterial;
        this.mapper = mapper;
        this.itemMapper = itemMapper;

        this.eventManager = new RequisicaoEventManager();
        eventManager.registrarObserver(new AtualizarEstoqueObserver(repositoryMaterial));
    }

    public CriacaoRequisicaoRespostaDTO criar(CriacaoRequisicaoRequisicaoDTO requisicaoDTO) {
        Requisicao requisicao = repository.save(mapper.paraEntidade(requisicaoDTO, LocalDate.now(), StatusRequisicao.PENDENTE));

        HashMap<String, BigDecimal> nomeMateriais = new HashMap<>();

        requisicaoDTO.materiais().forEach((idMaterial, quantidade) -> {
            Material material = repositoryMaterial.findById(idMaterial).orElseThrow(() -> {
               throw new RuntimeException("Material não encontrado!");
            });
            repositoryItem.save(itemMapper.paraEntidade(requisicao, material, quantidade));

            nomeMateriais.put(material.getNome(), quantidade);
        });

        return mapper.paraRespostaDTO(requisicao, nomeMateriais);
    }

    public HashMap<String, BigDecimal> retornarMateriais(Requisicao requisicao){
        HashMap<String, BigDecimal>  materiais = new HashMap<>();

        for(RequisicaoItem item : requisicao.getItens()){
            materiais.put(item.getMaterial().getNome(), item.getQuantidade());
        }

        return materiais;
    }

    public List<CriacaoRequisicaoRespostaDTO> buscarTodos() {
        List<Requisicao> requisicao = repository.findAll();
        List<CriacaoRequisicaoRespostaDTO> resposta = new ArrayList<>();

        for(Requisicao r : requisicao){
            HashMap<String, BigDecimal> materiais = retornarMateriais(r);
            resposta.add(mapper.paraRespostaDTO(r, materiais));
        }

        return resposta;
    }

    public CriacaoRequisicaoRespostaDTO buscarPorId(Long id) {
        Requisicao requisicao = repository.findById(id).orElseThrow(() ->{
            throw new RuntimeException("A Requisicao não encontrada!");
        });

        HashMap<String, BigDecimal> materiais = retornarMateriais(requisicao);

        return mapper.paraRespostaDTO(requisicao, materiais);

    }


    public CriacaoRequisicaoRespostaDTO atualizar(Long id, CriacaoRequisicaoRequisicaoDTO requisicaoDTO) {
        Requisicao requisicao = repository.findById(id).orElseThrow(() ->{
            throw new RuntimeException("A Requisicao não encontrada!");
        });

        if (!requisicao.getStatus().equals(StatusRequisicao.PENDENTE)) {
            throw new RuntimeException("A requisição já foi atendida.");
        }

        HashMap<String, BigDecimal> materiais = retornarMateriais(requisicao);

        eventManager.notificar(requisicao);

        Requisicao newRequisicao = mapper.paraUpdate(requisicaoDTO, requisicao);
        repository.save(newRequisicao);
        return mapper.paraRespostaDTO(newRequisicao, materiais);
    }


    public void deletar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("A Requisicao não encontrada!");
        }

        repository.deleteById(id);
    }

}
