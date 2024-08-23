package com.example.oddyty.eventhandlers;

import com.example.oddyty.blocks.BlockManifest;
import com.example.oddyty.blocks.RunewoodPylonBase;
import com.example.oddyty.blocks.RunewoodPylonCap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.level.ExplosionEvent;

import java.util.List;

import static net.neoforged.neoforge.common.ItemAbilities.HOE_TILL;

public class RunewoodPylonEvents {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        BlockPos pos = event.getPos();
        Level level = event.getLevel();
        BlockState state = level.getBlockState(pos);
        ItemStack heldItem = event.getItemStack();

        Block blockAbove = level.getBlockState(pos.above(1)).getBlock();
        Block blockBelow = level.getBlockState(pos.below(1)).getBlock();

        if (heldItem.getItem().canPerformAction(heldItem, HOE_TILL)) {
            if (state.getBlock() == BlockManifest.RUNEWOOD_LOG.get()) {
                if (blockAbove == BlockManifest.RUNEWOOD_LOG.get()) {
                    level.setBlock(pos, BlockManifest.RUNEWOOD_PYLON_BASE.get().defaultBlockState(), Block.UPDATE_ALL_IMMEDIATE);
                    level.setBlock(pos.above(1), BlockManifest.RUNEWOOD_PYLON_CAP.get().defaultBlockState(), Block.UPDATE_ALL_IMMEDIATE);
                    level.gameEvent(event.getEntity(), GameEvent.BLOCK_CHANGE, pos);

                    event.setCancellationResult(InteractionResult.SUCCESS);
                    event.setCanceled(true);
                } else if (blockBelow == BlockManifest.RUNEWOOD_LOG.get()) {
                    level.setBlock(pos, BlockManifest.RUNEWOOD_PYLON_CAP.get().defaultBlockState(), Block.UPDATE_ALL_IMMEDIATE);
                    level.setBlock(pos.below(1), BlockManifest.RUNEWOOD_PYLON_BASE.get().defaultBlockState(), Block.UPDATE_ALL_IMMEDIATE);
                    level.gameEvent(event.getEntity(), GameEvent.BLOCK_CHANGE, pos);

                    event.setCancellationResult(InteractionResult.SUCCESS);
                    event.setCanceled(true);
                } else {
                    event.setCancellationResult(InteractionResult.FAIL);
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onDestroyedRunewoodPylon(BlockEvent.BreakEvent event) {
        BlockPos pos = event.getPos();
        Level level = event.getPlayer().level();
        BlockState state = level.getBlockState(pos);

        Block brokenBlock = state.getBlock();
        Block blockAbove = level.getBlockState(pos.above(1)).getBlock();
        Block blockBelow = level.getBlockState(pos.below(1)).getBlock();

        if (brokenBlock == BlockManifest.RUNEWOOD_PYLON_BASE.get()) {
            level.destroyBlock(pos, true);
            level.destroyBlock(pos.above(1), false);
        } else if (brokenBlock == BlockManifest.RUNEWOOD_PYLON_CAP.get()) {
            level.destroyBlock(pos, false);
            level.destroyBlock(pos.below(1), true);
        } else {
            return;
        }
    }

    @SubscribeEvent
    public static void onBrokenByExplosion(ExplosionEvent.Detonate event) {
        List<BlockPos> affectedBlocks = event.getAffectedBlocks();

        for (BlockPos pos : affectedBlocks) {
            Level level = event.getLevel();
            BlockState state = level.getBlockState(pos);
            if (state.getBlock() instanceof RunewoodPylonBase) {
                level.destroyBlock(pos, false);
                level.destroyBlock(pos.above(1), false);
            }
            if (state.getBlock() instanceof RunewoodPylonCap) {
                level.destroyBlock(pos, false);
                level.destroyBlock(pos.below(1), false);
            }
        }
    }
}
