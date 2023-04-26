package com.github.sib_energy_craft.iron_craft_table.block.entity;

import com.github.sib_energy_craft.iron_craft_table.block.IronCraftingTableBlock;
import com.github.sib_energy_craft.iron_craft_table.load.Entities;
import com.github.sib_energy_craft.iron_craft_table.screen.handler.IronCraftingTableScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public class IronCraftingTableBlockEntity extends AbstractIronCraftingTableBlockEntity {
    public IronCraftingTableBlockEntity(BlockPos pos, BlockState state, IronCraftingTableBlock block) {
        super(Entities.IRON_CRAFTING_TABLE, pos, state, block.getContainerNameCode());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new IronCraftingTableScreenHandler(syncId, inv, player, getPos());
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(pos);
    }

}

