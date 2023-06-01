package com.github.sib_energy_craft.metallurgy.iron_craft_table.load;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import com.github.sib_energy_craft.metallurgy.iron_craft_table.block.IronCraftingTableBlock;
import com.github.sib_energy_craft.sec_utils.common.Identified;
import com.github.sib_energy_craft.sec_utils.load.DefaultModInitializer;
import com.github.sib_energy_craft.sec_utils.utils.BlockUtils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public final class Blocks implements DefaultModInitializer {
    public static final Identified<IronCraftingTableBlock> IRON_CRAFTING_TABLE;

    static {
        var metalBlockSettings = AbstractBlock.Settings.create()
                .mapColor(MapColor.IRON_GRAY)
                .sounds(BlockSoundGroup.METAL)
                .strength(5, 6)
                .requiresTool();
        var ironCraftingTable = new IronCraftingTableBlock(metalBlockSettings, "container.iron_crafting_table");
        IRON_CRAFTING_TABLE = BlockUtils.register(Identifiers.of("iron_crafting_table"), ironCraftingTable);
    }
}
