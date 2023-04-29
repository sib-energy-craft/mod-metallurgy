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
public final class PurifiedCrushedOres implements ModRegistrar {
    public static final Item COPPER_PURIFIED_CRUSHED_ORE;
    public static final Item GOLD_PURIFIED_CRUSHED_ORE;
    public static final Item IRON_PURIFIED_CRUSHED_ORE;
    public static final Item TIN_PURIFIED_CRUSHED_ORE;
    public static final Item SILVER_PURIFIED_CRUSHED_ORE;

    static {
        var commonItem = new Item.Settings()
                .rarity(Rarity.COMMON);

        COPPER_PURIFIED_CRUSHED_ORE = register(ItemGroups.INGREDIENTS, Identifiers.of("copper_purified_crushed_ore"), commonItem);
        GOLD_PURIFIED_CRUSHED_ORE = register(ItemGroups.INGREDIENTS, Identifiers.of("gold_purified_crushed_ore"), commonItem);
        IRON_PURIFIED_CRUSHED_ORE = register(ItemGroups.INGREDIENTS, Identifiers.of("iron_purified_crushed_ore"), commonItem);
        TIN_PURIFIED_CRUSHED_ORE = register(ItemGroups.INGREDIENTS, Identifiers.of("tin_purified_crushed_ore"), commonItem);
        SILVER_PURIFIED_CRUSHED_ORE = register(ItemGroups.INGREDIENTS, Identifiers.of("silver_purified_crushed_ore"), commonItem);
    }
}
