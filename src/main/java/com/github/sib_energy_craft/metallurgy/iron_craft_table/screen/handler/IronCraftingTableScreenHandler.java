package com.github.sib_energy_craft.metallurgy.iron_craft_table.screen.handler;

import com.github.sib_energy_craft.metallurgy.iron_craft_table.load.client.Screens;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.math.BlockPos;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public class IronCraftingTableScreenHandler extends AbstractIronCraftingTableScreenHandler {

    public IronCraftingTableScreenHandler(int syncId, PlayerInventory playerInventory, PlayerEntity player, BlockPos pos) {
        super(Screens.IRON_CRAFTING_TABLE, syncId, playerInventory, ScreenHandlerContext.create(player.getWorld(), pos));
    }

    public IronCraftingTableScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf packetByteBuf) {
        super(Screens.IRON_CRAFTING_TABLE, syncId, playerInventory);

    }
}
