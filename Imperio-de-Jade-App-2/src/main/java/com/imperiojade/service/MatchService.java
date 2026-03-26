package com.imperiojade.service;

import com.imperiojade.dto.MatchDTO;
import com.imperiojade.dto.MatchResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class MatchService {

    private final Random random = new Random();

    public MatchResponseDTO generate(MatchDTO dto) {
        int numPlayers = dto.numPlayers();
        int totalLevel = dto.totalPlayerLevel();

        // Calcula dificuldade arredondando sempre para cima
        int encounterDifficulty = (numPlayers <= 4)
                ? (int) Math.ceil((double) totalLevel / 3)
                : (int) Math.ceil((double) totalLevel / 4);


        int maxEnemies = Math.min(encounterDifficulty, 20);
        int numEnemies = 1 + random.nextInt(maxEnemies); // entre 1 e maxEnemies


        int averageLevel = (int) Math.ceil((double) encounterDifficulty / numEnemies);

        // garante nivel médio entre os inimigos
        List<Integer> enemyLevels = new ArrayList<>();
        for (int i = 0; i < numEnemies; i++) {
            enemyLevels.add(averageLevel);
        }


        int totalAssigned = averageLevel * numEnemies;
        int difference = totalAssigned - encounterDifficulty;


        while (difference > 0) {
            int index = random.nextInt(enemyLevels.size());
            if (enemyLevels.get(index) > 1) { // não permite nível < 1
                enemyLevels.set(index, enemyLevels.get(index) - 1);
                difference--;
            }
        }


        while (difference < 0) {
            int index = random.nextInt(enemyLevels.size());
            enemyLevels.set(index, enemyLevels.get(index) + 1);
            difference++;
        }


        Collections.shuffle(enemyLevels, random);

        return new MatchResponseDTO(enemyLevels);
    }
}