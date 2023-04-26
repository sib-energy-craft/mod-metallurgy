package com.github.sib_energy_craft.metallurgy.iron_craft_table.load;

import com.github.sib_energy_craft.metallurgy.iron_craft_table.block.entity.IronCraftingTableBlockEntity;
import com.github.sib_energy_craft.sec_utils.utils.EntityUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraft.block.entity.BlockEntityType;

/**
 * @since 0.0.1
 * @author sibmaks
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Entities {
    public static final BlockEntityType<IronCraftingTableBlockEntity> IRON_CRAFTING_TABLE;

    static {
        IRON_CRAFTING_TABLE = EntityUtils.register(Blocks.IRON_CRAFTING_TABLE, IronCraftingTableBlockEntity::new);
    }
}
