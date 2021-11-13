package com.jocuriledelfinului.delfinul.models;


import java.util.EnumSet;

public enum Terrain {

    WATER('W'),
    GROUND('G'),
    FINISH('F'),
    START('S'),
    DOLPHIN('D');

    public final Character LABEL;

    private static final EnumSet<Terrain> DEFAULT_SET
            = EnumSet.of(Terrain.DOLPHIN, Terrain.START, Terrain.FINISH);

    Terrain(Character label) {
        this.LABEL = label;
    }

    @Override
    public String toString() {
        return LABEL.toString();
    }

    public static EnumSet<Terrain> getDefaultSet() {
        return DEFAULT_SET;
    }
}

