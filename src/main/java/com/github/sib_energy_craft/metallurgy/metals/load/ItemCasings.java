package com.github.sib_energy_craft.metallurgy.metals.load;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import com.github.sib_energy_craft.sec_utils.load.ModRegistrar;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Rarity;

import static com.github.sib_energy_craft.sec_utils.utils.ItemUtils.register;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public final class ItemCasings implements ModRegistrar {
    public static final Item IRON_ITEM_CASING;
    public static final Item COPPER_ITEM_CASING;
    public static final Item TIN_ITEM_CASING;
    public static final Item BRONZE_ITEM_CASING;

    static {
        var commonItem = new Item.Settings()
                .rarity(Rarity.COMMON);

        IRON_ITEM_CASING = register(ItemGroups.INGREDIENTS, Identifiers.of("iron_item_casing"), commonItem);
        COPPER_ITEM_CASING = register(ItemGroups.INGREDIENTS, Identifiers.of("copper_item_casing"), commonItem);
        TIN_ITEM_CASING = register(ItemGroups.INGREDIENTS, Identifiers.of("tin_item_casing"), commonItem);
        BRONZE_ITEM_CASING = register(ItemGroups.INGREDIENTS, Identifiers.of("bronze_item_casing"), commonItem);
    }
}
