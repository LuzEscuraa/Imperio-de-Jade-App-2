package com.imperiojade.controller;

import com.imperiojade.dto.MatchDTO;
import com.imperiojade.dto.MatchResponseDTO;
import com.imperiojade.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public ResponseEntity<MatchResponseDTO> generate(@RequestBody @Valid MatchDTO dto) {
        MatchResponseDTO response = service.generate(dto);
        return ResponseEntity.ok(response);
    }
}