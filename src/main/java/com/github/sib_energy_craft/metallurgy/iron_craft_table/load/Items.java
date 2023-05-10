package com.github.sib_energy_craft.metallurgy.iron_craft_table.load;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import com.github.sib_energy_craft.metallurgy.iron_craft_table.item.IronHammerItem;
import com.github.sib_energy_craft.metallurgy.iron_craft_table.item.MetalShearsItem;
import com.github.sib_energy_craft.sec_utils.load.ModRegistrar;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Rarity;

import static com.github.sib_energy_craft.sec_utils.utils.ItemUtils.register;
import static com.github.sib_energy_craft.sec_utils.utils.ItemUtils.registerBlockItem;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public final class Items implements ModRegistrar {
    public static final BlockItem IRON_CRAFTING_TABLE;
    public static final IronHammerItem IRON_HAMMER;
    public static final MetalShearsItem METAL_SHEARS;

    static {
        IRON_CRAFTING_TABLE = registerBlockItem(ItemGroups.FUNCTIONAL,Blocks.IRON_CRAFTING_TABLE);

        var hammerSettings = new Item.Settings()
                .maxCount(1)
                .rarity(Rarity.COMMON)
                .maxDamage(80);
        var ironHammerItem = new IronHammerItem(hammerSettings);
        IRON_HAMMER = register(ItemGroups.TOOLS, Identifiers.of("iron_hammer"), ironHammerItem);

        var shearsSettings = new Item.Settings()
                .maxCount(1)
                .rarity(Rarity.COMMON)
                .maxDamage(60);
        var metalShearsItem = new MetalShearsItem(shearsSettings);
        METAL_SHEARS = register(ItemGroups.TOOLS, Identifiers.of("metal_shears"), metalShearsItem);
    }
}
