package com.github.sib_energy_craft.metals.load;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Rarity;

import static com.github.sib_energy_craft.sec_utils.utils.ItemUtils.register;

/**
 * @since 0.0.1
 * @author sibmaks
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Plates {

    public static final Item IRON_PLATE;
    public static final Item COPPER_PLATE;
    public static final Item TIN_PLATE;
    public static final Item BRONZE_PLATE;

    static {
        var commonItem = new Item.Settings()
                .rarity(Rarity.COMMON);

        IRON_PLATE = register(ItemGroups.INGREDIENTS, Identifiers.of("iron_plate"), commonItem);
        COPPER_PLATE = register(ItemGroups.INGREDIENTS, Identifiers.of("copper_plate"), commonItem);
        TIN_PLATE = register(ItemGroups.INGREDIENTS, Identifiers.of("tin_plate"), commonItem);
        BRONZE_PLATE = register(ItemGroups.INGREDIENTS, Identifiers.of("bronze_plate"), commonItem);
    }
}
