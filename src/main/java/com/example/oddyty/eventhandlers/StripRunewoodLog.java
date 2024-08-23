package com.example.oddyty.eventhandlers;

import com.example.oddyty.blocks.BlockManifest;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import static net.neoforged.neoforge.common.ItemAbilities.AXE_STRIP;

public class StripRunewoodLog {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        BlockPos pos = event.getPos();
        Level level = event.getLevel();
        BlockState state = level.getBlockState(pos);
        ItemStack heldItem = event.getItemStack();

        if (heldItem.getItem().canPerformAction(heldItem, AXE_STRIP)) {
            if (state.getBlock() == BlockManifest.RUNEWOOD_LOG.get()) {
                level.setBlock(pos, BlockManifest.STRIPPED_RUNEWOOD_LOG.get().defaultBlockState(), Block.UPDATE_ALL_IMMEDIATE);
                level.gameEvent(event.getEntity(), GameEvent.BLOCK_CHANGE, pos);

                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }
    }
}
