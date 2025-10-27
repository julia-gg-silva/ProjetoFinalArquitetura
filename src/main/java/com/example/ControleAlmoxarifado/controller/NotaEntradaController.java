package com.example.ControleAlmoxarifado.controller;

import com.example.ControleAlmoxarifado.model.dto.notaEntrada.CriacaoNotaEntradaRequisicaoDTO;
import com.example.ControleAlmoxarifado.model.dto.notaEntrada.CriacaoNotaEntradaRespostaDTO;
import com.example.ControleAlmoxarifado.service.NotaEntradaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notasEntrada")
@AllArgsConstructor
public class NotaEntradaController {

    private NotaEntradaService service;

    @PostMapping
    public ResponseEntity<CriacaoNotaEntradaRespostaDTO> criar(@RequestBody CriacaoNotaEntradaRequisicaoDTO requisicaoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(requisicaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<CriacaoNotaEntradaRespostaDTO>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriacaoNotaEntradaRespostaDTO> buscarPorId(@PathVariable Long id){
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriacaoNotaEntradaRespostaDTO> atualizar(@PathVariable Long id,
                                                                   @RequestBody CriacaoNotaEntradaRequisicaoDTO requisicaoDTO){
            return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, requisicaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
