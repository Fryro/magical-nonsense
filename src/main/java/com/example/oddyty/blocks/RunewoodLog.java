package com.example.oddyty.blocks;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import static net.neoforged.neoforge.common.ItemAbilities.AXE_STRIP;

public class RunewoodLog extends OddytyBlock {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final String blockName = "runewood_log";
    public static final BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD)
            .destroyTime(1.00f)
            .ignitedByLava()
            .sound(SoundType.WOOD);

    public RunewoodLog(Properties properties) {
        super(properties);
    }
}
