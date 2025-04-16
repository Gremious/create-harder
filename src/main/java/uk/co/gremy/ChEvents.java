package uk.co.gremy;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import uk.co.gremy.items.ITEMS;

// Keep punching empty handed for cobble -> gravel -> sand?
// Easier with a tag like "punchable" cause there's redsand and sandstone would make sense too.

public class ChEvents {
	public static void registerEvents() {
		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
			Block curr = state.getBlock();
			if (!player.isSpectator() && player.getMainHandStack().isEmpty() /*&& state.getBlock() == Blocks.STONE*/ && !world.isClient) {
				world.setBlockState(pos, Blocks.COBBLESTONE.getDefaultState());

				ItemStack sharp_rock = new ItemStack(ITEMS.SHARP_ROCK.getItem());

				Vec3d blockPos = pos.toCenterPos();
				Vec3d playerPosition = new Vec3d(player.getX(), player.getY(), player.getZ());
				Vec3d positionDiff = playerPosition.subtract(blockPos);
				Vec3d positionSpawn = Vec3d.add(pos,
					(positionDiff.getX() / 2.0) + 0.5,
					(positionDiff.getY() / 2.0) + 0.5,
					(positionDiff.getZ() / 2.0) + 0.5
				).addRandom(world.random, 0.2F);

				ItemEntity itemEntity = new ItemEntity(
						world,
						positionSpawn.getX(),
						positionSpawn.getY(),
						positionSpawn.getZ(),
						sharp_rock
				);
				itemEntity.setToDefaultPickupDelay();
				world.spawnEntity(itemEntity);
			}
		});
	}
}
