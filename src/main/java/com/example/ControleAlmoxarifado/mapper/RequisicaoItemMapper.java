package com.example.ControleAlmoxarifado.mapper;

import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRespostaDTO;
import com.example.ControleAlmoxarifado.model.Requisicao;
import com.example.ControleAlmoxarifado.model.RequisicaoItem;

import java.util.HashMap;

public class RequisicaoItemMapper {

    public RequisicaoItem paraEntidade(int idRequisicao, int idMaterial, double quantidade){
        return new RequisicaoItem(idRequisicao, idMaterial, quantidade);
    }

    public CriacaoRequisicaoRespostaDTO paraRespostaDTO(Requisicao requisicao, HashMap<String, Double> materiais){
        return new CriacaoRequisicaoRespostaDTO(
                requisicao.getId(), requisicao.getSetor(),
                requisicao.getDataSolicitacao(), requisicao.getStatus(),
                materiais);
    }
}
