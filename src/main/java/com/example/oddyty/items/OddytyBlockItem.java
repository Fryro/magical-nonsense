package com.example.oddyty.items;

import net.minecraft.world.item.Item;

public class OddytyBlockItem extends Item {
    private String blockItemName;
    private Properties properties;

    public OddytyBlockItem(Properties properties) {
        super(properties);
    }

    public String getBlockItemName() { return this.blockItemName; }
    public Properties getProperties() { return this.properties; }
}
