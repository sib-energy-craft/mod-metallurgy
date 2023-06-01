package com.github.sib_energy_craft.metallurgy.metals.load;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import com.github.sib_energy_craft.sec_utils.common.Identified;
import com.github.sib_energy_craft.sec_utils.load.DefaultModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

import static com.github.sib_energy_craft.sec_utils.utils.BlockUtils.register;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public final class Blocks implements DefaultModInitializer {
    public static final Identified<Block> BRONZE_BLOCK;
    public static final Identified<Block> STEEL_BLOCK;

    static {
        var metalBlockSettings = AbstractBlock.Settings.create()
                .mapColor(MapColor.IRON_GRAY)
                .sounds(BlockSoundGroup.METAL)
                .strength(5, 6)
                .requiresTool();

        BRONZE_BLOCK = register(Identifiers.of("bronze_block"), metalBlockSettings);

        var stealBlockSettings = AbstractBlock.Settings.create()
                .mapColor(MapColor.IRON_GRAY)
                .sounds(BlockSoundGroup.METAL)
                .strength(25, 600)
                .requiresTool();
        STEEL_BLOCK = register(Identifiers.of("steel_block"), stealBlockSettings);
    }
}
