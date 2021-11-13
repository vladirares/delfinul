package com.jocuriledelfinului.delfinul.DTOs;


import com.jocuriledelfinului.delfinul.services.RandomService;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
public class Location {
private int x;
private int y;

    public Location(int upperBound) {
        x= RandomService.getNextUnsigned(upperBound);
        y= RandomService.getNextUnsigned(upperBound);
    }
}
