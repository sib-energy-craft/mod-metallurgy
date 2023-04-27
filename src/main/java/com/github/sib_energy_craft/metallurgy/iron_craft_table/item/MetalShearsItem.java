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
public class MetalShearsItem extends Item implements IronCraftingTableTool {
    public MetalShearsItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onUse(PlayerEntity player, ItemStack toolStack, ItemStack craftedStack) {
        player.world.playSound(player, player.getBlockPos(), SoundEvents.ENTITY_SHEEP_SHEAR,
                SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
}
