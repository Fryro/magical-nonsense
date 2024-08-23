package com.example.oddyty.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class OddytyBlock extends Block {
    private String blockName;
    private BlockBehaviour.Properties properties;

    public OddytyBlock(Properties properties) {
        super(properties);
    }



    public String getBlockName() {
        return this.blockName;
    }

    public BlockBehaviour.Properties getProperties() {
        return this.properties;
    }
}
