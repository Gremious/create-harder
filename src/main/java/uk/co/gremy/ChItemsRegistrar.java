package uk.co.gremy;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Set;

public class ChItemsRegistrar implements ModInitializer {
    static Set<ChItem> ITEMS = Set.of(
        register(new ChItem(new FabricItemSettings(), "sharp_rock"))
    );

    static ChItem register(ChItem item) {
        return Registry.register(Registries.ITEM, new Identifier(CreateHarder.MOD_ID, item.Id), item);
    }

    @Override
    public void onInitialize() { ChItemsRegistrar.initialize();}
    public static void initialize() { }
}

class ChItem extends Item {
    public String Id;
    public String Name;

    public ChItem(Settings settings, String id) {
        super(settings);
        Id = id;
        String name = id.replace('_', ' ');
        Name = org.apache.commons.lang3.text.WordUtils.capitalize(name);
    }

    public ChItem(Settings settings, String id, String name) {
        super(settings);
        Id = id;
        Name = name;
    }
}
