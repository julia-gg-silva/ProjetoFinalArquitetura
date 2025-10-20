package com.example.ControleAlmoxarifado.controller;

import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRespostaDTO;
import com.example.ControleAlmoxarifado.service.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiais")
public class MaterialController {

    private MaterialService service;

    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CriacaoMaterialRespostaDTO> criar(@RequestBody CriacaoMaterialRequisicaoDTO requisicaoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(requisicaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<CriacaoMaterialRespostaDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriacaoMaterialRespostaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriacaoMaterialRespostaDTO> atualizar(@PathVariable Long id,
                                                                @RequestBody CriacaoMaterialRequisicaoDTO requisicaoDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, requisicaoDTO));
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluir(@PathVariable Long id) {
            service.excluir(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
