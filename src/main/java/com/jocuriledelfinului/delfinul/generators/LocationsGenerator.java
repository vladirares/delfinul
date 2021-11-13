package com.jocuriledelfinului.delfinul.generators;

import com.jocuriledelfinului.delfinul.DTOs.Location;
import lombok.Data;
import lombok.Getter;


@Getter
public class LocationsGenerator {
    public LocationsGenerator(int upperBound)
    {
        start=new Location(upperBound);

        do
        {
        finish=new Location(upperBound);
        }while(start.equals(finish));

        do
        {
            dolphin=new Location(upperBound);
        }while(start.equals(dolphin)||finish.equals(dolphin));
    }

    private Location start;
    private Location finish;
    private Location dolphin;

}
