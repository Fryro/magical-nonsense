package com.example.oddyty.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ExampleOddytyItem extends OddytyItem {
    public static final String itemName = "example_food_item";
    public static final Item.Properties properties = new Item.Properties().food(new FoodProperties.Builder()
                    .alwaysEdible().nutrition(1).saturationModifier(2f).build());


    public ExampleOddytyItem(Properties properties) {
        super(properties);
    }
}
