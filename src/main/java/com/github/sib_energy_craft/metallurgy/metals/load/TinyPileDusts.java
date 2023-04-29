package com.github.sib_energy_craft.metallurgy.metals.load;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import com.github.sib_energy_craft.sec_utils.load.ModRegistrar;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Rarity;

import static com.github.sib_energy_craft.sec_utils.utils.ItemUtils.register;

/**
 * @since 0.0.9
 * @author sibmaks
 */
public final class TinyPileDusts implements ModRegistrar {
    public static final Item COPPER_TINY_PILE_DUST;
    public static final Item GOLD_TINY_PILE_DUST;
    public static final Item IRON_TINY_PILE_DUST;
    public static final Item TIN_TINY_PILE_DUST;
    public static final Item SILVER_TINY_PILE_DUST;
    public static final Item BRONZE_TINY_PILE_DUST;

    static {
        var commonItem = new Item.Settings()
                .rarity(Rarity.COMMON);

        COPPER_TINY_PILE_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("copper_tiny_pile_dust"), commonItem);
        GOLD_TINY_PILE_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("gold_tiny_pile_dust"), commonItem);
        IRON_TINY_PILE_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("iron_tiny_pile_dust"), commonItem);
        TIN_TINY_PILE_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("tin_tiny_pile_dust"), commonItem);
        SILVER_TINY_PILE_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("silver_tiny_pile_dust"), commonItem);
        BRONZE_TINY_PILE_DUST = register(ItemGroups.INGREDIENTS, Identifiers.of("bronze_tiny_pile_dust"), commonItem);
    }
}
