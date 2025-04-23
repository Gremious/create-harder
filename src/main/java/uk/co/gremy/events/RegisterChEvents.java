package uk.co.gremy.events;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

public class RegisterChEvents {
	public static void registerEvents() {
		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
			ChipStone.event(world, player, pos, state);
		});

//		PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, entity) -> {
//			return BreakDownWood.event(world, player, pos, state, entity);
//		});
	}
}
