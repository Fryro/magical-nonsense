package com.example.oddyty.blocks;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class RunewoodBarrel extends OddytyBlock {
    public static final String blockName = "runewood_barrel";
    public static final Properties properties = Properties.of()
            .mapColor(MapColor.WOOD)
            .destroyTime(1.00f)
            .ignitedByLava()
            .sound(SoundType.WOOD);

    public RunewoodBarrel(Properties properties) {
        super(properties);
    }
}
