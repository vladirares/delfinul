package com.jocuriledelfinului.delfinul.services;

import com.jocuriledelfinului.delfinul.enums.Terrain;
import com.jocuriledelfinului.delfinul.strategies.Strategy;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomService {
    private static final Random random = new Random();

    public static int getNextUnsigned(int upperBound) {
        return random.nextInt(upperBound);
    }

    public static Terrain getNextStandardTerrain(Strategy strategy) {
        return strategy.STANDARD_TILE_SET.stream()
                .skip(random.nextInt(strategy.STANDARD_TILE_SET.size()))
                .findFirst().get();
    }
}