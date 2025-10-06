package com.example.ControleAlmoxarifado.factory;

import com.example.ControleAlmoxarifado.dto.DTObase;

public interface CadastroFactory<object> {
    object criar(DTObase... dtos);
}
