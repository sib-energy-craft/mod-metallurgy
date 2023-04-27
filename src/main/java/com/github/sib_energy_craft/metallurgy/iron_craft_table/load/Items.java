package com.github.sib_energy_craft.metallurgy.iron_craft_table.load;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import com.github.sib_energy_craft.metallurgy.iron_craft_table.item.IronHammerItem;
import com.github.sib_energy_craft.metallurgy.iron_craft_table.item.MetalShearsItem;
import com.github.sib_energy_craft.sec_utils.load.ModRegistrar;
import com.github.sib_energy_craft.sec_utils.utils.ItemUtils;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Rarity;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public final class Items implements ModRegistrar {
    public static final BlockItem IRON_CRAFTING_TABLE;
    public static final IronHammerItem IRON_HAMMER;
    public static final MetalShearsItem METAL_SHEARS;

    static {
        var tableSettings = new Item.Settings();

        var ironCraftingTable = new BlockItem(Blocks.IRON_CRAFTING_TABLE.entity(), tableSettings);
        IRON_CRAFTING_TABLE = ItemUtils.register(ItemGroups.FUNCTIONAL, Identifiers.of("iron_crafting_table"),
                ironCraftingTable);

        var hammerSettings = new Item.Settings()
                .maxCount(1)
                .rarity(Rarity.COMMON)
                .maxDamage(80);
        var ironHammerItem = new IronHammerItem(hammerSettings);
        IRON_HAMMER = ItemUtils.register(ItemGroups.TOOLS, Identifiers.of("iron_hammer"), ironHammerItem);

        var shearsSettings = new Item.Settings()
                .maxCount(1)
                .rarity(Rarity.COMMON)
                .maxDamage(60);
        var metalShearsItem = new MetalShearsItem(shearsSettings);
        METAL_SHEARS = ItemUtils.register(ItemGroups.TOOLS, Identifiers.of("metal_shears"), metalShearsItem);
    }
}
