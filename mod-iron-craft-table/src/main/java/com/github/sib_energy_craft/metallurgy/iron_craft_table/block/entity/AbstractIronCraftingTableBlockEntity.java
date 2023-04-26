package com.github.sib_energy_craft.metallurgy.iron_craft_table.block.entity;

import lombok.Getter;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public abstract class AbstractIronCraftingTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory {

    @Getter
    private final Text containerName;

    protected AbstractIronCraftingTableBlockEntity(BlockEntityType<?> blockEntityType,
                                                   BlockPos pos,
                                                   BlockState state,
                                                   String containerNameCode) {
        super(blockEntityType, pos,state);
        this.containerName = Text.translatable(containerNameCode);
    }

    @Override
    public Text getDisplayName() {
        return containerName;
    }

}

