package com.example.oddyty.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import static net.neoforged.neoforge.common.ItemAbilities.SHOVEL_FLATTEN;

public class StrippedRunewoodLog extends OddytyBlock {
    public static final String blockName = "stripped_runewood_log";
    public static final Properties properties = Properties.of()
            .mapColor(MapColor.WOOD)
            .destroyTime(1.00f)
            .ignitedByLava()
            .sound(SoundType.WOOD);

    public StrippedRunewoodLog(Properties properties) {
        super(properties);
    }
}
