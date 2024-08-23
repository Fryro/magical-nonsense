package com.example.oddyty.blocks;

import com.example.oddyty.items.ItemManifest;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;

public class RunewoodPylonBase extends OddytyBlock {
    public static final String blockName = "runewood_pylon_base";
    public static final Properties properties = Properties.of()
            .mapColor(MapColor.WOOD)
            .destroyTime(1.00f)
            .ignitedByLava()
            .sound(SoundType.WOOD)
            .pushReaction(PushReaction.BLOCK);

    public RunewoodPylonBase(Properties properties) {
        super(properties);
    }
}
