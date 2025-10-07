package com.example.ControleAlmoxarifado.service;

import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRespostaDTO;
import com.example.ControleAlmoxarifado.mapper.NotaEntradaItemMapper;
import com.example.ControleAlmoxarifado.mapper.NotaEntradaMapper;
import com.example.ControleAlmoxarifado.model.NotaEntrada;
import com.example.ControleAlmoxarifado.model.NotaEntradaItem;
import com.example.ControleAlmoxarifado.repository.NotaEntradaDAO;
import com.example.ControleAlmoxarifado.repository.NotaEntradaItemDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotaEntradaService {

    private NotaEntradaDAO repository;
    private NotaEntradaItemDAO repositoryItem;
    private NotaEntradaMapper mapper;
    private NotaEntradaItemMapper mapperItem;

    public NotaEntradaService(NotaEntradaDAO repository, NotaEntradaItemDAO repositoryItem, NotaEntradaMapper mapper, NotaEntradaItemMapper mapperItem) {
        this.repository = repository;
        this.repositoryItem = repositoryItem;
        this.mapper = mapper;
        this.mapperItem = mapperItem;
    }

    public CriacaoNotaEntradaRespostaDTO criar(CriacaoNotaEntradaRequisicaoDTO requisicaoDTO) {
        NotaEntrada notaEntrada = repository.criar(mapper.paraEntidade(requisicaoDTO));

        List<NotaEntradaItem> itens = new ArrayList<>();

        requisicaoDTO.materiais().forEach((idMaterial, quantidade) -> {
            itens.add(repositoryItem.criar
                    (mapperItem.paraEntidade
                            (notaEntrada.getId(), idMaterial, quantidade)));
        });

        HashMap<String, Double> materiais = new HashMap<>();

        return mapper.paraRespostaDto(notaEntrada, materiais);
    }

    public List<CriacaoNotaEntradaRespostaDTO> buscarTodos() {

    }

    public CriacaoNotaEntradaRespostaDTO buscarPorId(int id) {

    }

    public CriacaoNotaEntradaRespostaDTO atualizar(int id, CriacaoNotaEntradaRequisicaoDTO requisicaoDTO) {

    }

    public void excluir() {

    }
}
