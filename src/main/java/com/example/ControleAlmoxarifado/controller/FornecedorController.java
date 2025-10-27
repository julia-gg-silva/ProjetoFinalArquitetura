package com.example.ControleAlmoxarifado.controller;

import com.example.ControleAlmoxarifado.model.dto.fornecedor.CriacaoFornecedorRequisicaoDTO;
import com.example.ControleAlmoxarifado.model.dto.fornecedor.CriacaoFornecedorRespostaDTO;
import com.example.ControleAlmoxarifado.service.FornecedorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
@AllArgsConstructor
public class FornecedorController {

    private FornecedorService service;

    @PostMapping
    public ResponseEntity<CriacaoFornecedorRespostaDTO> criar(
            @RequestBody CriacaoFornecedorRequisicaoDTO requisicaoDTO) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.criar(requisicaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<CriacaoFornecedorRespostaDTO>> buscarTodos() {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriacaoFornecedorRespostaDTO> buscarPorId(@PathVariable Long id) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriacaoFornecedorRespostaDTO> atualizar(
            @PathVariable Long id, @RequestBody CriacaoFornecedorRequisicaoDTO requisicaoDTO
    ){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.atualizar(id, requisicaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
            service.deletar(id);
            return  ResponseEntity.status(HttpStatus.OK)
                    .build();
    }
}
