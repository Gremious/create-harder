package uk.co.gremy;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.util.ActionResult;

public class ChEvents {
    public static void registerEvents() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            BlockState state = world.getBlockState(pos);

            // Manual spectator check is necessary because AttackBlockCallbacks fire before the spectator check
            if (!player.isSpectator() && player.getMainHandStack().isEmpty() && state.isToolRequired()) {
                player.damage(world.getDamageSources().generic(), 1.0F);
            }

            return ActionResult.PASS;
        });
    }
}
