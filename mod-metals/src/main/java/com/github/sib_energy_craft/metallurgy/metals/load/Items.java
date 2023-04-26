package com.github.sib_energy_craft.metallurgy.metals.load;

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
public final class Items {
    public static final Item BRONZE_INGOT;
    public static final Item BRONZE_NUGGET;

    static {
        var commonItem = new Item.Settings()
                .rarity(Rarity.COMMON);

        BRONZE_INGOT = register(ItemGroups.INGREDIENTS, Identifiers.of("bronze_ingot"), commonItem);
        BRONZE_NUGGET = register(ItemGroups.INGREDIENTS, Identifiers.of("bronze_nugget"), commonItem);
    }
}
