package uk.co.gremy.events;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.gremy.items.ChItems;

public class BreakDownWood {
	public static boolean event(World world, PlayerEntity player, BlockPos blockPos, BlockState blockState, BlockEntity entity) {
		if (!player.isSpectator() && player.getMainHandStack().getItem() == ChItems.SHARP_ROCK.getItem() && !world.isClient) {
//			net.mehvahdjukaar.every_compat.EveryCompat.getChildKeys(blockState.getBlock());

//			BlockSetAPI.getRegistries().forEach(x -> LOGGER.info("registry: {}", x.toString()));
//			BlockSetAPI.getBlockTypeOf(blockState.getBlock());
//			net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry.getTypes().forEach(x -> LOGGER.info("type: {}", x.toString()));
//			LOGGER.info("type: {}", type.toString());


		}

		return true;
	}

}
