package com.github.sib_energy_craft.metallurgy.metals.load;

import com.github.sib_energy_craft.sec_utils.load.DefaultModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import static com.github.sib_energy_craft.sec_utils.utils.ItemUtils.registerBlockItem;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public final class BlockItems implements DefaultModInitializer {
    public static final Item BRONZE_BLOCK;
    public static final Item STEEL_BLOCK;

    static {
        BRONZE_BLOCK = registerBlockItem(ItemGroups.BUILDING_BLOCKS, Blocks.BRONZE_BLOCK);
        STEEL_BLOCK = registerBlockItem(ItemGroups.BUILDING_BLOCKS, Blocks.STEEL_BLOCK);
    }
}
