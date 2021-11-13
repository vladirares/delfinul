package com.jocuriledelfinului.delfinul.generators;

import com.jocuriledelfinului.delfinul.DTOs.Location;
import com.jocuriledelfinului.delfinul.models.Terrain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.util.Pair;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Getter
@AllArgsConstructor
public class ImportantLocations {

    final List<Pair<Location, Terrain>> locationList;

    @Builder
    public static ImportantLocations generateLocations(int upperBound, EnumSet<Terrain> terrain) {
        if (terrain == null) {
            terrain = Terrain.getDefaultSet();
        }

        Map<Location, Terrain> locationMap = new HashMap<>();
        terrain.forEach(
                (t) -> {
                    Location location;
                    do {
                        location = new Location(upperBound);
                    } while (locationMap.containsKey(location));
                    locationMap.put(location, t);
                }
        );

        return new ImportantLocations(
                locationMap.entrySet().stream()
                        .map((entry) -> Pair.of(entry.getKey(), entry.getValue()))
                        .collect(Collectors.toList())

        );
    }


}
