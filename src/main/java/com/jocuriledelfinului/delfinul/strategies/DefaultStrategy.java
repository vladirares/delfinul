package com.jocuriledelfinului.delfinul.strategies;

import com.jocuriledelfinului.delfinul.DTOs.Location;
import com.jocuriledelfinului.delfinul.enums.StrategyName;
import com.jocuriledelfinului.delfinul.enums.Terrain;
import com.jocuriledelfinului.delfinul.generators.ImportantLocations;
import com.jocuriledelfinului.delfinul.services.RandomService;
import org.springframework.data.util.Pair;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultStrategy extends Strategy {
    public DefaultStrategy() {
        super(
                EnumSet.of(Terrain.DOLPHIN, Terrain.START, Terrain.FINISH),
                EnumSet.of(Terrain.GROUND, Terrain.WATER),
                StrategyName.DEFAULT
        );
    }


    public List<List<Terrain>> makeTable(int size) {
        var table = generateTable(size);
        ImportantLocations.builder().upperBound(size).strategy(this).build()
                .getLocationList()
                .forEach((importantLocation) -> setTerrain(table, importantLocation));
        return table;
    }

    private void setTerrain(List<List<Terrain>> table, Pair<Location, Terrain> locationTerrainPair) {
        table.get(locationTerrainPair.getFirst().getY())
                .set(locationTerrainPair.getFirst().getX(), locationTerrainPair.getSecond());
    }

    private List<List<Terrain>> generateTable(int size) {
        return IntStream.rangeClosed(1, size)
                .boxed()
                .map(($) -> generateRow(size))
                .collect(Collectors.toList());
    }

    private List<Terrain> generateRow(int size) {
        return IntStream.rangeClosed(1, size)
                .boxed()
                .map(($) -> generateTile())
                .collect(Collectors.toList());
    }

    private Terrain generateTile() {
        return RandomService.getNextStandardTerrain(this);
    }
}
