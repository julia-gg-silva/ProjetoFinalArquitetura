package com.example.ControleAlmoxarifado.mapper;

import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRespostaDTO;
import com.example.ControleAlmoxarifado.model.NotaEntrada;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class NotaEntradaMapper {

    public NotaEntrada paraEntidade(CriacaoNotaEntradaRequisicaoDTO requisicaoDTO){
        return new NotaEntrada(requisicaoDTO.idFornecedor(), requisicaoDTO.dataEntrada());
    }

    public CriacaoNotaEntradaRespostaDTO paraRespostaDto(NotaEntrada notaEntrada, HashMap<String, Double> materiais){
        return new CriacaoNotaEntradaRespostaDTO(notaEntrada.getId(),
                notaEntrada.getIdFornecedor(),
                notaEntrada.getDataEntrega(),
                materiais);
    }
}
