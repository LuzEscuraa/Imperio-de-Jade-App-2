package com.imperiojade.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record XPRequestDTO(

        @Min(value = 1, message = "Deve haver pelo menos 1 jogador")
        int numPlayers,

        @NotEmpty(message = "Deve haver pelo menos 1 inimigo")
        List<@Min(value = 1, message = "Nível mínimo é 1") Integer> enemyLevels

) {}