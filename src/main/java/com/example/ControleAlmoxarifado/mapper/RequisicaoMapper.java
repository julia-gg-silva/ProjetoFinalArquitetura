package com.example.ControleAlmoxarifado.mapper;

import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRespostaDTO;
import com.example.ControleAlmoxarifado.model.Requisicao;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class RequisicaoMapper {


    public Requisicao paraEntidade(CriacaoRequisicaoRequisicaoDTO requisicaoDTO){
        return new Requisicao(requisicaoDTO.setor(), requisicaoDTO.dataSolicitacao(), requisicaoDTO.status());
    }

    public CriacaoRequisicaoRespostaDTO paraRespostaDTO(Requisicao requisicao, HashMap<String, Double> materiais){
        return new CriacaoRequisicaoRespostaDTO(
                requisicao.getId(), requisicao.getSetor(),
                requisicao.getDataSolicitacao(), requisicao.getStatus(),
                materiais);
    }
}
