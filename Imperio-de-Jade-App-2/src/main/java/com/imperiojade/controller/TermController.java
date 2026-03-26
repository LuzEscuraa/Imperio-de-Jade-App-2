package com.imperiojade.controller;

import com.imperiojade.dto.TermDTO;
import com.imperiojade.dto.TermUpdateDTO;
import com.imperiojade.service.TermService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terms")
public class TermController {

    private final TermService service;

    public TermController(TermService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TermDTO>> listar() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TermDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByIdDTO(id));
    }

    @PostMapping
    public ResponseEntity<TermDTO> criar(@RequestBody @Valid TermDTO dto) {
        return ResponseEntity.ok(service.saveDTO(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TermDTO> atualizar(
            @PathVariable Long id,
            @RequestBody TermUpdateDTO dto
    ) {
        return ResponseEntity.ok(service.updateDTO(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}