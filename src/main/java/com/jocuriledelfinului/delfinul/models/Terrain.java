package com.jocuriledelfinului.delfinul.models;


public enum Terrain {

    WATER('W'),
    GROUND('G'),
    FINISH('F'),
    START('S'),
    DOLPHIN('D');

    public final Character LABEL;
    Terrain(Character label)
    {
        this.LABEL =label;
    }

    @Override
    public String toString() {
        return LABEL.toString();
    }
}

