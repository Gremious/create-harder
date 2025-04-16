package uk.co.gremy.items;

import net.fabricmc.api.ModInitializer;

public class ItemsInitializer implements ModInitializer {
	@Override
	public void onInitialize() {
		ItemsInitializer.initialize();
	}

	public static void initialize() {
		ChItems.initialize();
	}
}
