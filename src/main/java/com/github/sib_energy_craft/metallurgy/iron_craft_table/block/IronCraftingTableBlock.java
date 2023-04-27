package com.github.sib_energy_craft.metallurgy.iron_craft_table.block;

import com.github.sib_energy_craft.metallurgy.iron_craft_table.block.entity.IronCraftingTableBlockEntity;
import lombok.Getter;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public class IronCraftingTableBlock extends AbstractIronCraftingTableBlock {
    @Getter
    private final String containerNameCode;

    public IronCraftingTableBlock(Settings settings, String containerNameCode) {
        super(settings);
        this.containerNameCode = containerNameCode;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new IronCraftingTableBlockEntity(pos, state, this);
    }
}
