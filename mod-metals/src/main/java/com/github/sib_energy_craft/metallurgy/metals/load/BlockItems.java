package com.github.sib_energy_craft.metallurgy.metals.load;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import static com.github.sib_energy_craft.sec_utils.utils.ItemUtils.registerBlockItem;

/**
 * @since 0.0.1
 * @author sibmaks
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BlockItems {
    public static final Item BRONZE_BLOCK;

    static {
        BRONZE_BLOCK = registerBlockItem(ItemGroups.BUILDING_BLOCKS, Blocks.BRONZE_BLOCK);
    }
}
