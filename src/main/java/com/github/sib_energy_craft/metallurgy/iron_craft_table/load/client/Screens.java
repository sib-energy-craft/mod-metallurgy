package com.github.sib_energy_craft.metallurgy.iron_craft_table.load.client;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import com.github.sib_energy_craft.metallurgy.iron_craft_table.screen.IronCraftingTableScreen;
import com.github.sib_energy_craft.metallurgy.iron_craft_table.screen.handler.IronCraftingTableScreenHandler;
import com.github.sib_energy_craft.sec_utils.load.DefaultClientModInitializer;
import com.github.sib_energy_craft.sec_utils.utils.ScreenUtils;
import net.minecraft.screen.ScreenHandlerType;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public final class Screens implements DefaultClientModInitializer {
    public static final ScreenHandlerType<IronCraftingTableScreenHandler> IRON_CRAFTING_TABLE;

    static {
        IRON_CRAFTING_TABLE = ScreenUtils.register(Identifiers.of("iron_crafting_table"),
                IronCraftingTableScreenHandler::new, IronCraftingTableScreen::new);
    }

}
