package com.github.sib_energy_craft.metallurgy.iron_craft_table.load;

import com.github.sib_energy_craft.metallurgy.iron_craft_table.block.entity.IronCraftingTableBlockEntity;
import com.github.sib_energy_craft.sec_utils.load.ModRegistrar;
import com.github.sib_energy_craft.sec_utils.utils.EntityUtils;
import net.minecraft.block.entity.BlockEntityType;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public final class Entities implements ModRegistrar {
    public static final BlockEntityType<IronCraftingTableBlockEntity> IRON_CRAFTING_TABLE;

    static {
        IRON_CRAFTING_TABLE = EntityUtils.register(Blocks.IRON_CRAFTING_TABLE, IronCraftingTableBlockEntity::new);
    }
}
