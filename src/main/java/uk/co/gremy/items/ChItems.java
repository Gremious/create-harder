package uk.co.gremy.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.text.WordUtils;
import org.jetbrains.annotations.Nullable;
import uk.co.gremy.CreateHarder;

import java.util.ArrayList;
import java.util.List;

public enum ChItems {
	SHARP_ROCK("sharp_rock", new SharpRock()),
	COOL_ITEM("cool_item", new CoolItem());

	private final String id;
	private final String name;
	private final Item item;

	public String getName() {
		return this.name;
	}

	ChItems(String id, Item item) {
		this(id, item, WordUtils.capitalize(id.replace('_', ' ')));
	}

	ChItems(String id, Item item, String name) {
		this.item = item;
		this.id = id;
		this.name = name;

		Registry.register(Registries.ITEM, new Identifier(CreateHarder.MOD_ID, id), item);
	}

	public Item getItem() { return item; }
	public Identifier getIdent() { return new Identifier(CreateHarder.MOD_ID, id); }

	public static void initialize() {}
}
