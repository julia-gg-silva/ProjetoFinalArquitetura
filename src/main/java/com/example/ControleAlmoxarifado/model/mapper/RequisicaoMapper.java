package com.example.ControleAlmoxarifado.model.mapper;

import com.example.ControleAlmoxarifado.model.StatusRequisicao;
import com.example.ControleAlmoxarifado.model.dto.requisicao.CriacaoRequisicaoRequisicaoDTO;
import com.example.ControleAlmoxarifado.model.dto.requisicao.CriacaoRequisicaoRespostaDTO;
import com.example.ControleAlmoxarifado.model.Requisicao;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

@Component
public class RequisicaoMapper {


    public Requisicao paraEntidade(CriacaoRequisicaoRequisicaoDTO requisicaoDTO, LocalDate dataSolicitacao, StatusRequisicao status){
        return new Requisicao(requisicaoDTO.setor(), dataSolicitacao, status);
    }

    public CriacaoRequisicaoRespostaDTO paraRespostaDTO(Requisicao requisicao, HashMap<String, BigDecimal> materiais){
        return new CriacaoRequisicaoRespostaDTO(
                requisicao.getId(), requisicao.getSetor(),
                requisicao.getDataSolicitacao(), requisicao.getStatus(),
                materiais);
    }

    public Requisicao paraUpdate(CriacaoRequisicaoRequisicaoDTO requisicaoDTO, Requisicao requisicao){
        if(!requisicaoDTO.status().equals(requisicao.getStatus())){
            requisicao.setStatus(requisicaoDTO.status());
        }

        return requisicao;
    }
}
