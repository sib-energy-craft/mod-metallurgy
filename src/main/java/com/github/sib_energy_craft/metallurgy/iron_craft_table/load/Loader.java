package com.github.sib_energy_craft.metallurgy.iron_craft_table.load;

import lombok.extern.slf4j.Slf4j;
import net.fabricmc.api.ModInitializer;

import static com.github.sib_energy_craft.sec_utils.load.LoadUtils.load;

/**
 * @author drobyshev-ma
 * Created at 22-12-2022
 */
@Slf4j
public class Loader implements ModInitializer {
    @Override
    public void onInitialize() {
        var classLoader = getClass().getClassLoader();
        load(classLoader, "mod-metallurgy-iron-craft-table", Loader.class.getPackageName());
    }
}
