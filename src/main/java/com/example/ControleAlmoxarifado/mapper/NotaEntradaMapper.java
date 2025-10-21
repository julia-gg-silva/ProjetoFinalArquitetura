package com.example.ControleAlmoxarifado.mapper;

import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRespostaDTO;
import com.example.ControleAlmoxarifado.model.NotaEntrada;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

@Component
public class NotaEntradaMapper {

    public NotaEntrada paraEntidade(CriacaoNotaEntradaRequisicaoDTO requisicaoDTO, LocalDate dataEntrada){
        return new NotaEntrada(requisicaoDTO.fornecedor(), dataEntrada);
    }

    public CriacaoNotaEntradaRespostaDTO paraRespostaDto(NotaEntrada notaEntrada, HashMap<String, BigDecimal> materiais){
        return new CriacaoNotaEntradaRespostaDTO(notaEntrada.getId(),
                notaEntrada.getFornecedor(),
                notaEntrada.getDataEntrega(),
                materiais);
    }

    public NotaEntrada paraUpdate(CriacaoNotaEntradaRequisicaoDTO requisicaoDTO, NotaEntrada notaEntrada){
        if(!requisicaoDTO.fornecedor().equals(notaEntrada.getFornecedor())){
            notaEntrada.setFornecedor(requisicaoDTO.fornecedor());
        }

        return notaEntrada;
    }
}
