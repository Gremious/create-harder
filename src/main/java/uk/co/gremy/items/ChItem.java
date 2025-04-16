package uk.co.gremy.items;

public class ChItem extends net.minecraft.item.Item {
    public String Id;
    public String Name;

    public ChItem(String id, Settings settings) {
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
