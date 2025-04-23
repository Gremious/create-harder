package uk.co.gremy.events;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import uk.co.gremy.items.ChItems;

// Keep punching empty handed for cobble -> gravel -> sand?
// Easier with a tag like "punchable" cause there's redsand and sandstone would make sense too.
public class ChipStone {
	public static void event(World world, PlayerEntity player, BlockPos pos, BlockState state) {
		if (!player.isSpectator() && player.getMainHandStack().isEmpty() && state.getBlock() == Blocks.STONE && !world.isClient) {
			world.setBlockState(pos, Blocks.COBBLESTONE.getDefaultState());

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
				new ItemStack(ChItems.SHARP_ROCK.getItem())
			);
			itemEntity.setToDefaultPickupDelay();
			world.spawnEntity(itemEntity);
		}
	}
}
