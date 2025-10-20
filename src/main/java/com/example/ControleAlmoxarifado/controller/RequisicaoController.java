package com.example.ControleAlmoxarifado.controller;

import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRespostaDTO;
import com.example.ControleAlmoxarifado.service.RequisicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requisicoes")
public class RequisicaoController {

    private RequisicaoService service;

    public RequisicaoController(RequisicaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CriacaoRequisicaoRespostaDTO> criar(
            @RequestBody CriacaoRequisicaoRequisicaoDTO requisicaoDTO) {

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.criar(requisicaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<CriacaoRequisicaoRespostaDTO>> buscarTodos() {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriacaoRequisicaoRespostaDTO> buscarId(@PathVariable Long id) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.buscarPorId(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<CriacaoRequisicaoRespostaDTO> atualizar(
            @PathVariable Long id, @RequestBody CriacaoRequisicaoRequisicaoDTO requisicaoDTO
    ) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.atualizar(id, requisicaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
            service.deletar(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .build();
    }
}
