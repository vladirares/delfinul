package com.jocuriledelfinului.delfinul.services;

import com.jocuriledelfinului.delfinul.DTOs.Location;
import com.jocuriledelfinului.delfinul.generators.LocationsGenerator;
import com.jocuriledelfinului.delfinul.models.Terrain;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class UserService {
    public Mono<List<List<Terrain>>> generateBoard(int size) {
        List<List<Terrain>> table=IntStream.rangeClosed(1,size).boxed()
                .map(
                        ($)-> IntStream.rangeClosed(1,size)
                .boxed()
                .map(($1)->(new Random().nextBoolean()? Terrain.GROUND :Terrain.WATER))
                                .collect(Collectors.toList())
                )
                .collect(Collectors.toList());
        var generator=new LocationsGenerator(size);
        setTerrain(table,generator.getStart() ,Terrain.START);
        setTerrain(table,generator.getFinish() ,Terrain.FINISH);
        setTerrain(table,generator.getDolphin() ,Terrain.DOLPHIN);
        return Mono.just(table);
    }

    private void setTerrain(List<List<Terrain>> table, Location location, Terrain terrain) {
        table.get(location.getY()).set(location.getX(),terrain);
    }
}
