package com.example.ControleAlmoxarifado.service;

import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRespostaDTO;
import com.example.ControleAlmoxarifado.mapper.RequisicaoItemMapper;
import com.example.ControleAlmoxarifado.mapper.RequisicaoMapper;
import com.example.ControleAlmoxarifado.model.Requisicao;
import com.example.ControleAlmoxarifado.repository.RequisicaoDAO;
import com.example.ControleAlmoxarifado.repository.RequisicaoItemDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisicaoService {

    private RequisicaoDAO repository;
    private RequisicaoItemDAO repositoryItem;
    private RequisicaoMapper mapper;
    private RequisicaoItemMapper itemMapper;



    public RequisicaoService(RequisicaoDAO repository, RequisicaoMapper mapper, RequisicaoItemDAO itemRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.repositoryItem = itemRepository;
    }

    public CriacaoRequisicaoRespostaDTO criar(CriacaoRequisicaoRequisicaoDTO requisicaoDTO) {
       Requisicao requisicao = repository.save(mapper.paraEntidade(requisicaoDTO));

        requisicaoDTO.materiais().forEach((idMaterial, quantidade) -> {
            repositoryItem.save(itemMapper.paraEntidade(requisicao.getId(), idMaterial, quantidade));
        });
    }

    public List<CriacaoRequisicaoRespostaDTO> buscarTodos(){

    }

    public CriacaoRequisicaoRespostaDTO buscarPorId(int id) {

    }

    public CriacaoRequisicaoRespostaDTO atualizar(int id, CriacaoRequisicaoRequisicaoDTO requisicaoDTO) {

    }


    public void deletar(int id) {

    }

}
