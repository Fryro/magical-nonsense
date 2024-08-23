package com.example.oddyty.blocks;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static com.example.oddyty.Oddyty.MODID;

public class BlockManifest {
    private static final Logger LOGGER = LogUtils.getLogger();

    // Create a Deferred Register to hold Blocks which will all be registered under the "oddyty" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    // A map for registered items, for ease-of-access in other classes.
    // Mutator method required to update map.
    // This method is called by block classes, upon instantiation.
    public static Map<String, Object> registeredBlocks = new HashMap<String, Object>();
    public static void putBlockInRegisterMap(String blockName, DeferredHolder blockHolder) {
        registeredBlocks.put(blockName, blockHolder);
    }

    // List of blocks from Oddyty, organized by Block Type
    // Bog-Standard Blocks
    public static DeferredHolder<Block, OddytyBlock> RUNEWOOD_LOG = BLOCKS.register(
            RunewoodLog.blockName,
            () -> new OddytyBlock(RunewoodLog.properties)
    );
    public static DeferredHolder<Block, OddytyBlock> STRIPPED_RUNEWOOD_LOG = BLOCKS.register(
            StrippedRunewoodLog.blockName,
            () -> new OddytyBlock(RunewoodLog.properties)
    );
    public static DeferredHolder<Block, OddytyBlock> RUNEWOOD_BARREL = BLOCKS.register(
            RunewoodBarrel.blockName,
            () -> new OddytyBlock(RunewoodLog.properties)
    );
    public static DeferredHolder<Block, OddytyBlock> RUNEWOOD_PYLON_BASE = BLOCKS.register(
            RunewoodPylonBase.blockName,
            () -> new OddytyBlock(RunewoodPylonBase.properties)
    );
    public static DeferredHolder<Block, OddytyBlock> RUNEWOOD_PYLON_CAP = BLOCKS.register(
            RunewoodPylonCap.blockName,
            () -> new OddytyBlock(RunewoodPylonCap.properties)
    );
}