package com.imperiojade.service;

import com.imperiojade.dto.XPRequestDTO;
import com.imperiojade.dto.XPResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class XPService {

    public XPResponseDTO calcularXP(XPRequestDTO request) {

        int numPlayers = request.numPlayers();
        var enemyLevels = request.enemyLevels();

        int nd = enemyLevels.stream()
                .mapToInt(Integer::intValue)
                .sum();


        int totalXP = nd * 300;


        int xpPorJogador = (int) Math.ceil((double) totalXP / numPlayers);

        return new XPResponseDTO(totalXP, xpPorJogador);
    }
}