package com.imperiojade.dto;

import jakarta.validation.constraints.NotBlank;

public record TermDTO(
        @NotBlank(message = "O nome não pode estar vazio")
        String name,

        @NotBlank(message = "A descrição não pode estar vazia")
        String description
) {}