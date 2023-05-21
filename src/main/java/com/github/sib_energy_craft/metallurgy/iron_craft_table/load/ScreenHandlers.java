package com.github.sib_energy_craft.metallurgy.iron_craft_table.load;

import com.github.sib_energy_craft.energy_api.utils.Identifiers;
import com.github.sib_energy_craft.metallurgy.iron_craft_table.screen.handler.IronCraftingTableScreenHandler;
import com.github.sib_energy_craft.sec_utils.load.DefaultModInitializer;
import net.minecraft.screen.ScreenHandlerType;

import static com.github.sib_energy_craft.sec_utils.utils.ScreenUtils.registerHandler;

/**
 * @since 0.0.19
 * @author sibmaks
 */
public final class ScreenHandlers implements DefaultModInitializer {
    public static final ScreenHandlerType<IronCraftingTableScreenHandler> IRON_CRAFTING_TABLE;

    static {
        IRON_CRAFTING_TABLE = registerHandler(Identifiers.of("iron_crafting_table"), IronCraftingTableScreenHandler::new);
    }

}
