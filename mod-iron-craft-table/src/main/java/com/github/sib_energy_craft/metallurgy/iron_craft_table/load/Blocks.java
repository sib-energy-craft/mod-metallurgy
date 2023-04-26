package com.github.sib_energy_craft.metallurgy.iron_craft_table.load;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import com.github.sib_energy_craft.metallurgy.iron_craft_table.block.IronCraftingTableBlock;
import com.github.sib_energy_craft.sec_utils.common.Identified;
import com.github.sib_energy_craft.sec_utils.utils.BlockUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

/**
 * @since 0.0.1
 * @author sibmaks
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Blocks {
    public static final Identified<IronCraftingTableBlock> IRON_CRAFTING_TABLE;

    static {
        var metalBlockSettings = FabricBlockSettings.of(Material.METAL)
                .sounds(BlockSoundGroup.METAL)
                .strength(5, 6)
                .requiresTool();
        var ironCraftingTable = new IronCraftingTableBlock(metalBlockSettings, "container.iron_crafting_table");
        IRON_CRAFTING_TABLE = BlockUtils.register(Identifiers.of("iron_crafting_table"), ironCraftingTable);
    }
}
