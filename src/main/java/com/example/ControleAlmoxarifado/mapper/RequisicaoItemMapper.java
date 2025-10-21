package com.example.ControleAlmoxarifado.mapper;

import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRespostaDTO;
import com.example.ControleAlmoxarifado.model.Material;
import com.example.ControleAlmoxarifado.model.Requisicao;
import com.example.ControleAlmoxarifado.model.RequisicaoItem;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class RequisicaoItemMapper {

    public RequisicaoItem paraEntidade(Requisicao idRequisicao, Material idMaterial, double quantidade){
        return new RequisicaoItem(idRequisicao, idMaterial, quantidade);
    }

    public CriacaoRequisicaoRespostaDTO paraRespostaDTO(Requisicao requisicao, HashMap<String, Double> materiais){
        return new CriacaoRequisicaoRespostaDTO(
                requisicao.getId(), requisicao.getSetor(),
                requisicao.getDataSolicitacao(), requisicao.getStatus(),
                materiais);
    }
}
