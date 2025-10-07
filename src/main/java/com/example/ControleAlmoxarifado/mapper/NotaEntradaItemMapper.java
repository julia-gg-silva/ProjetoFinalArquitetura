package com.example.ControleAlmoxarifado.mapper;

import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRespostaDTO;
import com.example.ControleAlmoxarifado.model.NotaEntrada;
import com.example.ControleAlmoxarifado.model.NotaEntradaItem;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class NotaEntradaItemMapper {

    public NotaEntradaItem paraEntidade(int idNotaEntrada, int idMaterial, double quantidade){
        return new NotaEntradaItem(idNotaEntrada, idMaterial, quantidade);
    }
}
