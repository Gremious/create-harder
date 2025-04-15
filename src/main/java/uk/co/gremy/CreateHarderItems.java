package uk.co.gremy;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.item.FoodComponents.POTATO;

public class CreateHarderItems implements ModInitializer {
    public static final Item YUMMY_GREM_ITEM = register(
            new Item(new FabricItemSettings().food(POTATO)),
            "yummy_grem_item"
    );

    public static Item register(Item item, String id) {
        return Registry.register(Registries.ITEM, new Identifier(CreateHarder.MOD_ID, id), item);
    }

    @Override
    public void onInitialize() {
        CreateHarderItems.initialize();
    }

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(CreateHarderItems.YUMMY_GREM_ITEM));
    }
}