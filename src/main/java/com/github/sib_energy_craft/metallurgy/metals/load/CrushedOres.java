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
public final class CrushedOres implements ModRegistrar {
    public static final Item COPPER_CRUSHED_ORE;
    public static final Item GOLD_CRUSHED_ORE;
    public static final Item IRON_CRUSHED_ORE;
    public static final Item TIN_CRUSHED_ORE;
    public static final Item SILVER_CRUSHED_ORE;

    static {
        var commonItem = new Item.Settings()
                .rarity(Rarity.COMMON);

        COPPER_CRUSHED_ORE = register(ItemGroups.INGREDIENTS, Identifiers.of("copper_crushed_ore"), commonItem);
        GOLD_CRUSHED_ORE = register(ItemGroups.INGREDIENTS, Identifiers.of("gold_crushed_ore"), commonItem);
        IRON_CRUSHED_ORE = register(ItemGroups.INGREDIENTS, Identifiers.of("iron_crushed_ore"), commonItem);
        TIN_CRUSHED_ORE = register(ItemGroups.INGREDIENTS, Identifiers.of("tin_crushed_ore"), commonItem);
        SILVER_CRUSHED_ORE = register(ItemGroups.INGREDIENTS, Identifiers.of("silver_crushed_ore"), commonItem);
    }
}
