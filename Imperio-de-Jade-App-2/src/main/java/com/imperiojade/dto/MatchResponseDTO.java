package com.imperiojade.dto;

import java.util.List;

public record MatchResponseDTO(
        List<Integer> enemyLevels // Lista com nível de cada inimigo
) {}