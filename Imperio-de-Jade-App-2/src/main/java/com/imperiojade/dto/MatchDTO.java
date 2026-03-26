package com.imperiojade.dto;

import jakarta.validation.constraints.Min;

public record MatchDTO(
        @Min(value = 1, message = "O número de jogadores deve ser pelo menos 1")
        int numPlayers,

        @Min(value = 1, message = "O nível total dos jogadores deve ser pelo menos 1")
        int totalPlayerLevel
) {}
