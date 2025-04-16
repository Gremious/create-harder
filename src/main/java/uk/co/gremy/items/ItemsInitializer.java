package uk.co.gremy.items;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import uk.co.gremy.CreateHarder;

public class ItemsInitializer implements ModInitializer {
	public static enum ITEMS {
		SHARP_ROCK(register(new SharpRock("sharp_rock", new FabricItemSettings())));

		private final ChItem item;

		ITEMS(ChItem item) {
			this.item = item;
		}

		public ChItem getItem() {
			return item;
		}
	}

	static ChItem register(ChItem item) {
		return Registry.register(Registries.ITEM, new Identifier(CreateHarder.MOD_ID, item.Id), item);
	}

	@Override
	public void onInitialize() {
		ItemsInitializer.initialize();
	}

	public static void initialize() {
	}
}
