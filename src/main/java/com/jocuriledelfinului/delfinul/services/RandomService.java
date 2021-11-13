package com.jocuriledelfinului.delfinul.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomService {
    private static final Random random=new Random();

    public static int getNextUnsigned(int upperBound) {
        return Math.abs(random.nextInt())%upperBound;
    }
}
