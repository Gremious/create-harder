package uk.co.gremy.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class CoolItem extends Item {
		public CoolItem() {
			super(new FabricItemSettings().maxDamage(6));
		}
}
