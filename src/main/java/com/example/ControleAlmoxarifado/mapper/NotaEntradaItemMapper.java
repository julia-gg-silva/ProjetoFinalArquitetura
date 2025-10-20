package com.example.ControleAlmoxarifado.mapper;

import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRespostaDTO;
import com.example.ControleAlmoxarifado.model.Material;
import com.example.ControleAlmoxarifado.model.NotaEntrada;
import com.example.ControleAlmoxarifado.model.NotaEntradaItem;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class NotaEntradaItemMapper {

    public NotaEntradaItem paraEntidade(NotaEntrada notaEntrada, Material material, double quantidade){
        return new NotaEntradaItem(notaEntrada, material, quantidade);
    }
}
