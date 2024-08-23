package com.example.oddyty.menus;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.example.oddyty.items.ItemManifest;
import static com.example.oddyty.Oddyty.MODID;

public class CreativeTabManifest {
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "oddyty" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a creative tab with the id "oddyty:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ODDYTY_ITEMS_TAB = CREATIVE_MODE_TABS.register("oddytyitems", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.oddytyitems")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemManifest.EXAMPLE_ODDYTY_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ItemManifest.EXAMPLE_ODDYTY_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ODDYTY_BLOCKS_TAB = CREATIVE_MODE_TABS.register("oddytyblocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.oddytyblocks")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemManifest.RUNEWOOD_LOG_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ItemManifest.RUNEWOOD_LOG_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(ItemManifest.STRIPPED_RUNEWOOD_LOG_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(ItemManifest.RUNEWOOD_BARREL.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());
}
