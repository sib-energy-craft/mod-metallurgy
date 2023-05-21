package com.github.sib_energy_craft.metallurgy.iron_craft_table.load.client;

import com.github.sib_energy_craft.metallurgy.iron_craft_table.load.ScreenHandlers;
import com.github.sib_energy_craft.metallurgy.iron_craft_table.screen.IronCraftingTableScreen;
import com.github.sib_energy_craft.sec_utils.load.DefaultClientModInitializer;

import static com.github.sib_energy_craft.sec_utils.utils.ScreenUtils.registerScreen;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public final class Screens implements DefaultClientModInitializer {

    static {
        registerScreen(ScreenHandlers.IRON_CRAFTING_TABLE, IronCraftingTableScreen::new);
    }

}
