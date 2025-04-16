package uk.co.gremy.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import uk.co.gremy.CreateHarder;

public enum ITEMS {
	SHARP_ROCK(register(new SharpRock("sharp_rock", new FabricItemSettings())));

	static {
		uk.co.gremy.CreateHarder.LOGGER.warn("Static blok");
	}

	private final ChItem item;

	ITEMS(ChItem item) {
		this.item = item;
	}

	public ChItem getItem() {
		return item;
	}

	static ChItem register(ChItem item) {
		uk.co.gremy.CreateHarder.LOGGER.warn("WAWAWAwawawa");
		return Registry.register(Registries.ITEM, new Identifier(CreateHarder.MOD_ID, item.Id), item);
	}
}
