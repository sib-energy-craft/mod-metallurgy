package com.github.sib_energy_craft.iron_craft_table.load;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import com.github.sib_energy_craft.iron_craft_table.screen.IronCraftingTableScreen;
import com.github.sib_energy_craft.iron_craft_table.screen.handler.IronCraftingTableScreenHandler;
import com.github.sib_energy_craft.sec_utils.utils.ScreenUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraft.screen.ScreenHandlerType;

/**
 * @since 0.0.1
 * @author sibmaks
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Screens {
    public static final ScreenHandlerType<IronCraftingTableScreenHandler> IRON_CRAFTING_TABLE;

    static {
        IRON_CRAFTING_TABLE = ScreenUtils.register(Identifiers.of("iron_crafting_table"),
                IronCraftingTableScreenHandler::new, IronCraftingTableScreen::new);
    }

}
