package uk.co.gremy.customItems;

import net.minecraft.item.Item;

public class HcItem extends Item {
    public String Id;
    public String Name;

    public HcItem(Settings settings) {
        super(settings);
    }

    public HcItem(Settings settings, String id) {
        super(settings);
        Id = id;
        String name = id.replace('_', ' ');
        Name = org.apache.commons.lang3.text.WordUtils.capitalize(name);
    }

    public HcItem(Settings settings, String id, String name) {
        super(settings);
        Id = id;
        Name = name;
    }
}

