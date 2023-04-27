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
public final class Dusts implements ModRegistrar {
    public static final Item COPPER_DUST;
    public static final Item GOLD_DUST;
    public static final Item IRON_DUST;
    public static final Item TIN_DUST;
    public static final Item SILVER_DUST;
    public static final Item BRONZE_DUST;

    static {
        var commonItem = new Item.Settings()
                .rarity(Rarity.COMMON);

        COPPER_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("copper_dust"), commonItem);
        GOLD_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("gold_dust"), commonItem);
        IRON_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("iron_dust"), commonItem);
        TIN_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("tin_dust"), commonItem);
        SILVER_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("silver_dust"), commonItem);
        BRONZE_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("bronze_dust"), commonItem);
    }
}
