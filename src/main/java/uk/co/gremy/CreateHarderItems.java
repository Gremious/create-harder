package uk.co.gremy;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import uk.co.gremy.customItems.HcItem;

import java.util.Set;

public class CreateHarderItems implements ModInitializer {
    static Set<HcItem> ITEMS = Set.of(
            register(new HcItem(new FabricItemSettings(), "sharp_rock", "new rock")),
            register(new HcItem(new FabricItemSettings(), "sharp_rock2"))
    );

    public static HcItem register(HcItem item) {
        return Registry.register(Registries.ITEM, new Identifier(CreateHarder.MOD_ID, item.Id), item);
    }

    @Override
    public void onInitialize() {
        CreateHarderItems.initialize();
    }

    public static void initialize() {
    }
}