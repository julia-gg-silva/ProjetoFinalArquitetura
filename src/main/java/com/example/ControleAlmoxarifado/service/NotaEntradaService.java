package com.example.ControleAlmoxarifado.service;

import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRespostaDTO;
import com.example.ControleAlmoxarifado.mapper.NotaEntradaItemMapper;
import com.example.ControleAlmoxarifado.mapper.NotaEntradaMapper;
import com.example.ControleAlmoxarifado.model.Material;
import com.example.ControleAlmoxarifado.model.NotaEntrada;
import com.example.ControleAlmoxarifado.model.NotaEntradaItem;
import com.example.ControleAlmoxarifado.repository.MaterialRepository;
import com.example.ControleAlmoxarifado.repository.NotaEntradaRepository;
import com.example.ControleAlmoxarifado.repository.NotaEntradaItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

        HashMap<String, Double> materiais = new HashMap<>();

        requisicaoDTO.materiais().forEach((idMaterial, quantidade) -> {
            Material material = repositoryMaterial.findById(idMaterial).orElseThrow(() -> {
                throw new RuntimeException("O material não encontrado!");
            });
            repositoryItem.save(mapperItem.paraEntidade(notaEntrada, material, quantidade));

            materiais.put(material.getNome(), material.getEstoque());
        });

        return mapper.paraRespostaDto(notaEntrada, materiais);
    }

    public List<CriacaoNotaEntradaRespostaDTO> buscarTodos() {
        List<NotaEntrada> notaEntrada = repository.findAll();
        List<CriacaoNotaEntradaRespostaDTO> resposta = new ArrayList<>();

        for(NotaEntrada nota : notaEntrada){
            HashMap<String, Double> materias = retornarMateriais(nota);
            resposta.add(mapper.paraRespostaDto(nota, materias));
        }

        return resposta;
    }

    public CriacaoNotaEntradaRespostaDTO buscarPorId(Long id) {
        NotaEntrada notaEntrada = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("O Nota de Entrada não encontrada!");
        });

        HashMap<String, Double> materias = retornarMateriais(notaEntrada);

        return mapper.paraRespostaDto(notaEntrada, materias);
    }

    public HashMap<String, Double> retornarMateriais(NotaEntrada notaEntrada){
        HashMap<String, Double> materias = new HashMap<>();

        for(NotaEntradaItem item : notaEntrada.getItens()){
            materias.put(item.getMaterial().getNome(), item.getMaterial().getEstoque());
        }

        return materias;
    }

    public CriacaoNotaEntradaRespostaDTO atualizar(Long id, CriacaoNotaEntradaRequisicaoDTO requisicaoDTO) {
        NotaEntrada notaEntrada = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("O Nota de Entrada não encontrada!");
        });

        HashMap<String, Double> materias = retornarMateriais(notaEntrada);

        NotaEntrada newNotaEntrada = mapper.paraUpdate(requisicaoDTO, notaEntrada);
        repository.save(newNotaEntrada);
        return mapper.paraRespostaDto(newNotaEntrada, materias);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
