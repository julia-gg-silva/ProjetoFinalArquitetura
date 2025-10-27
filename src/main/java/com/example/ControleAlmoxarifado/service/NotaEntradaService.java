package com.example.ControleAlmoxarifado.service;

import com.example.ControleAlmoxarifado.model.dto.notaEntrada.CriacaoNotaEntradaRequisicaoDTO;
import com.example.ControleAlmoxarifado.model.dto.notaEntrada.CriacaoNotaEntradaRespostaDTO;
import com.example.ControleAlmoxarifado.model.mapper.NotaEntradaItemMapper;
import com.example.ControleAlmoxarifado.model.mapper.NotaEntradaMapper;
import com.example.ControleAlmoxarifado.model.Material;
import com.example.ControleAlmoxarifado.model.NotaEntrada;
import com.example.ControleAlmoxarifado.model.NotaEntradaItem;
import com.example.ControleAlmoxarifado.repository.MaterialRepository;
import com.example.ControleAlmoxarifado.repository.NotaEntradaRepository;
import com.example.ControleAlmoxarifado.repository.NotaEntradaItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class NotaEntradaService {

    private NotaEntradaRepository repository;
    private NotaEntradaItemRepository repositoryItem;
    private NotaEntradaMapper mapper;
    private NotaEntradaItemMapper mapperItem;
    private MaterialRepository repositoryMaterial;

    public CriacaoNotaEntradaRespostaDTO criar(CriacaoNotaEntradaRequisicaoDTO requisicaoDTO) {
        NotaEntrada notaEntrada = repository.save(mapper.paraEntidade(requisicaoDTO, LocalDate.now()));

        HashMap<String, BigDecimal> materiais = new HashMap<>();

        requisicaoDTO.materiais().forEach((idMaterial, quantidade) -> {
            Material material = repositoryMaterial.findById(idMaterial).orElseThrow(() -> {
                throw new RuntimeException("Material não encontrado!");
            });
            repositoryItem.save(mapperItem.paraEntidade(notaEntrada, material, quantidade));

            materiais.put(material.getNome(), quantidade);
        });

        return mapper.paraRespostaDto(notaEntrada, materiais);
    }

    public List<CriacaoNotaEntradaRespostaDTO> buscarTodos() {
        List<NotaEntrada> notaEntrada = repository.findAll();
        List<CriacaoNotaEntradaRespostaDTO> resposta = new ArrayList<>();

        for(NotaEntrada nota : notaEntrada){
            HashMap<String, BigDecimal> materias = retornarMateriais(nota);
            resposta.add(mapper.paraRespostaDto(nota, materias));
        }

        return resposta;
    }

    public CriacaoNotaEntradaRespostaDTO buscarPorId(Long id) {
        NotaEntrada notaEntrada = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Nota de Entrada não encontrada!");
        });

        HashMap<String, BigDecimal> materias = retornarMateriais(notaEntrada);

        return mapper.paraRespostaDto(notaEntrada, materias);
    }

    public HashMap<String, BigDecimal> retornarMateriais(NotaEntrada notaEntrada){
        HashMap<String, BigDecimal> materias = new HashMap<>();

        for(NotaEntradaItem item : notaEntrada.getItens()){
            materias.put(item.getMaterial().getNome(), item.getQuantidade());
        }

        return materias;
    }

    public CriacaoNotaEntradaRespostaDTO atualizar(Long id, CriacaoNotaEntradaRequisicaoDTO requisicaoDTO) {
        NotaEntrada notaEntrada = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Nota de Entrada não encontrada!");
        });

        HashMap<String, BigDecimal> materias = retornarMateriais(notaEntrada);

        NotaEntrada newNotaEntrada = mapper.paraUpdate(requisicaoDTO, notaEntrada);
        repository.save(newNotaEntrada);
        return mapper.paraRespostaDto(newNotaEntrada, materias);
    }

    public void excluir(Long id) {
        NotaEntrada notaEntrada = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Nota de Entrada não encontrada!");
        });

        repository.deleteById(id);
    }
}
