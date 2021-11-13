package com.jocuriledelfinului.delfinul.services;

import com.jocuriledelfinului.delfinul.DTOs.Location;
import com.jocuriledelfinului.delfinul.generators.ImportantLocations;
import com.jocuriledelfinului.delfinul.models.Terrain;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class UserService {
    public Mono<List<List<Terrain>>> generateBoard(int size) {
        var table = generateTable(size);
        ImportantLocations.builder().upperBound(size).build()
                .getLocationList()
                .forEach((importantLocation) -> setTerrain(table, importantLocation));

        return Mono.just(table);
    }

    private void setTerrain(List<List<Terrain>> table, Pair<Location, Terrain> locationTerrainPair) {
        table.get(locationTerrainPair.getFirst().getY())
                .set(locationTerrainPair.getFirst().getX(), locationTerrainPair.getSecond());
    }

    List<List<Terrain>> generateTable(int size) {
        return IntStream.rangeClosed(1, size)
                .boxed()
                .map(($) -> generateRow(size))
                .collect(Collectors.toList());
    }

    private List<Terrain> generateRow(int size) {
        return IntStream.rangeClosed(1, size)
                .boxed()
                .map(this::generateTile)
                .collect(Collectors.toList());
    }

    private Terrain generateTile(int $) {
        return new Random().nextBoolean() ? Terrain.GROUND : Terrain.WATER;
    }


}
