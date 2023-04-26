package com.github.sib_energy_craft.iron_craft_table.load;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.fabricmc.api.ModInitializer;

import java.util.Set;

/**
 * @author drobyshev-ma
 * Created at 22-12-2022
 */
@Slf4j
public class Loader implements ModInitializer {
    @Override
    @SneakyThrows
    public void onInitialize() {
        log.info("Load: {}", Loader.class.getName());
        for (Class<?> type : Set.of(Blocks.class, Entities.class, Screens.class, Items.class)) {
            log.info("Loaded: {}", Class.forName(type.getName()));
        }
        log.info("Loaded: {}", Loader.class.getName());
    }
}
