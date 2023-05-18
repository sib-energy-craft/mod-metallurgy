package com.github.sib_energy_craft.metallurgy.metals.load;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import com.github.sib_energy_craft.sec_utils.load.DefaultModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Rarity;

import static com.github.sib_energy_craft.sec_utils.utils.ItemUtils.register;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public final class Plates implements DefaultModInitializer {

    public static final Item IRON_PLATE;
    public static final Item COPPER_PLATE;
    public static final Item TIN_PLATE;
    public static final Item BRONZE_PLATE;
    public static final Item GOLD_PLATE;
    public static final Item STEEL_PLATE;

    static {
        var commonItem = new Item.Settings()
                .rarity(Rarity.COMMON);

        IRON_PLATE = register(ItemGroups.INGREDIENTS, Identifiers.of("iron_plate"), commonItem);
        COPPER_PLATE = register(ItemGroups.INGREDIENTS, Identifiers.of("copper_plate"), commonItem);
        TIN_PLATE = register(ItemGroups.INGREDIENTS, Identifiers.of("tin_plate"), commonItem);
        BRONZE_PLATE = register(ItemGroups.INGREDIENTS, Identifiers.of("bronze_plate"), commonItem);
        GOLD_PLATE = register(ItemGroups.INGREDIENTS, Identifiers.of("gold_plate"), commonItem);
        STEEL_PLATE = register(ItemGroups.INGREDIENTS, Identifiers.of("steel_plate"), commonItem);
    }
}
