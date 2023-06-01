package com.github.sib_energy_craft.metallurgy.iron_craft_table.item;

import com.github.sib_energy_craft.iron_craft_table.api.IronCraftingTableTool;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public class IronHammerItem extends Item implements IronCraftingTableTool {
    public IronHammerItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onUse(PlayerEntity player, ItemStack toolStack, ItemStack craftedStack) {
        var world = player.getWorld();
        world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_ANVIL_USE,
                SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
}
