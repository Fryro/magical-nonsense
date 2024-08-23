package com.example.oddyty.items;

import net.minecraft.world.item.Item;

public class OddytyItem extends Item {
    private String itemName;
    private Item.Properties properties;

    public OddytyItem(Properties properties) {
        super(properties);
    }


    public String getItemName() {
        return this.itemName;
    }

    public Item.Properties getProperties() {
        return this.properties;
    }
}
