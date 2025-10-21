package com.example.ControleAlmoxarifado.mapper;

import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRespostaDTO;
import com.example.ControleAlmoxarifado.model.Requisicao;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;

@Component
public class RequisicaoMapper {


    public Requisicao paraEntidade(CriacaoRequisicaoRequisicaoDTO requisicaoDTO, LocalDate dataSolicitacao, String status){
        return new Requisicao(requisicaoDTO.setor(), dataSolicitacao, status);
    }

    public CriacaoRequisicaoRespostaDTO paraRespostaDTO(Requisicao requisicao, HashMap<String, Double> materiais){
        return new CriacaoRequisicaoRespostaDTO(
                requisicao.getId(), requisicao.getSetor(),
                requisicao.getDataSolicitacao(), requisicao.getStatus(),
                materiais);
    }

    public Requisicao paraUpdate(CriacaoRequisicaoRequisicaoDTO requisicaoDTO, Requisicao requisicao){

        if(!requisicaoDTO.status().equals(requisicao.getStatus())){
            requisicao.setStatus(requisicaoDTO.status());
        }

        if(!requisicaoDTO.setor().equals(requisicao.getSetor())){
            requisicao.setSetor(requisicaoDTO.setor());
        }

        return requisicao;
    }
}
