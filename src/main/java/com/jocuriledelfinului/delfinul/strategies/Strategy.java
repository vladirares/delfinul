package com.jocuriledelfinului.delfinul.strategies;

import com.jocuriledelfinului.delfinul.enums.StrategyName;
import com.jocuriledelfinului.delfinul.enums.Terrain;

import java.util.EnumSet;
import java.util.List;


public abstract class Strategy {
    public final EnumSet<Terrain> IMPORTANT_TILE_SET;
    public final EnumSet<Terrain> STANDARD_TILE_SET;
    public final StrategyName NAME;

    public Strategy(EnumSet<Terrain> IMPORTANT_TILE_SET, EnumSet<Terrain> STANDARD_TILE_SET, StrategyName NAME) {
        this.IMPORTANT_TILE_SET = IMPORTANT_TILE_SET;
        this.STANDARD_TILE_SET = STANDARD_TILE_SET;
        this.NAME = NAME;
    }

    public abstract List<List<Terrain>> makeTable(int size);
}
