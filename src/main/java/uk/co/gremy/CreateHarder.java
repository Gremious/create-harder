package uk.co.gremy;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.gremy.items.ItemsInitializer;

public class CreateHarder implements ModInitializer {
    public static final String MOD_ID = "create-harder";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        ItemsInitializer.initialize();
        ChEvents.registerEvents();
        LOGGER.info("Hello from harder create! Enjoy!");
    }
}
