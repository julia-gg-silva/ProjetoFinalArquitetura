package com.example.ControleAlmoxarifado.model.mapper;

import com.example.ControleAlmoxarifado.model.Material;
import com.example.ControleAlmoxarifado.model.NotaEntrada;
import com.example.ControleAlmoxarifado.model.NotaEntradaItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class NotaEntradaItemMapper {

    public NotaEntradaItem paraEntidade(NotaEntrada notaEntrada, Material material, BigDecimal quantidade){
        return new NotaEntradaItem(notaEntrada, material, quantidade);
    }
}
