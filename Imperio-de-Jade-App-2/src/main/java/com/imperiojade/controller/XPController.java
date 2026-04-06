package com.imperiojade.controller;


import com.imperiojade.dto.XPRequestDTO;
import com.imperiojade.dto.XPResponseDTO;
import com.imperiojade.service.XPService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/xp")
public class XPController {

    private final XPService service;

    public XPController(XPService service) {
        this.service = service;
    }

    @PostMapping("/calculate")
    public XPResponseDTO calcularXP(@RequestBody @Valid XPRequestDTO request) {
        return service.calcularXP(request);
    }
}