package com.example.oddyty.items;

import com.example.oddyty.blocks.BlockManifest;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import static com.example.oddyty.Oddyty.MODID;

public class ItemManifest {
    private static final Logger LOGGER = LogUtils.getLogger();

    // Create a Deferred Register to hold Items which will all be registered under the "oddyty" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // List of items from Oddyty, organized by Item Type
    // Block Items
    public static DeferredItem<BlockItem> RUNEWOOD_LOG_ITEM = ITEMS.registerSimpleBlockItem(
            RunewoodLogItem.blockItemName,
            BlockManifest.RUNEWOOD_LOG
    );
    public static DeferredItem<BlockItem> STRIPPED_RUNEWOOD_LOG_ITEM = ITEMS.registerSimpleBlockItem(
            StrippedRunewoodLogItem.blockItemName,
            BlockManifest.STRIPPED_RUNEWOOD_LOG
    );
    public static DeferredItem<BlockItem> RUNEWOOD_BARREL = ITEMS.registerSimpleBlockItem(
            RunewoodBarrelItem.blockItemName,
            BlockManifest.RUNEWOOD_BARREL
    );

    // Food Items
    public static DeferredItem<Item> EXAMPLE_ODDYTY_ITEM = ITEMS.registerSimpleItem(
            ExampleOddytyItem.itemName,
            ExampleOddytyItem.properties
    );

    // Clickable Items


    // Items without Uses

}