package uk.co.gremy.items;

import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.content.equipment.sandPaper.SandPaperItemRenderer;
import com.simibubi.create.foundation.item.CustomUseEffectsItem;
import io.github.fabricators_of_create.porting_lib.util.NBTSerializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BrushableBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.BrushItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import uk.co.gremy.CreateHarder;

import static net.minecraft.util.ActionResult.PASS;
import static net.minecraft.util.ActionResult.SUCCESS;

public class SharpRock extends Item implements CustomUseEffectsItem {
	private static final double MAX_DISTANCE = Math.sqrt(ServerPlayNetworkHandler.MAX_BREAK_SQUARED_DISTANCE) - 1.0;

	public SharpRock() {
		super(new FabricItemSettings());
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 200;
	}
//
//	@Override
//	public UseAction getUseAction(ItemStack stack) {
//		return UseAction.EAT;
//	}

	@Override
	public SoundEvent getEatSound() {
		return SoundEvents.ENTITY_GENERIC_EAT;
	}

	@Override
	public Boolean shouldTriggerUseEffects(ItemStack stack, LivingEntity entity) {
		// Trigger every tick so that we have more fine grain control over the animation
		return true;
	}


	@Override
	public boolean triggerUseEffects(ItemStack stack, LivingEntity entity, int count, Random random) {
		// After 6 ticks play the sound every 7th
		if ((entity.getItemUseTime() - 6) % 7 == 0) {
			entity.playSound(entity.getEatSound(stack), 0.9F + 0.2F * random.nextFloat(), random.nextFloat() * 0.2F + 0.9F);
		}

		return true;
	}


	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemstack = user.getStackInHand(hand);
//
//		if (itemstack.getOrCreateNbt().contains("Rockin")) {
//			user.setCurrentHand(hand);
//			return new TypedActionResult<>(PASS, itemstack);
//		}

//		itemstack.getOrCreateNbt().putBoolean("Rockin", true);
		user.setCurrentHand(hand);
		return new TypedActionResult<>(PASS, itemstack);
//		return new TypedActionResult<>(SUCCESS, itemstack);
	}

//	@Override
//	public ActionResult useOnBlock(ItemUsageContext context) {
//
//		PlayerEntity playerEntity = context.getPlayer();
//		if (playerEntity != null && this.getHitResult(playerEntity).getType() == HitResult.Type.BLOCK) {
//			playerEntity.setCurrentHand(context.getHand());
//		}
//
//		return ActionResult.CONSUME;
//	}

//	public UseAction getUseAction(ItemStack stack) {
//		return UseAction.EAT;
//	}

	public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
		CreateHarder.LOGGER.info("usatge tickk!!");

		if (remainingUseTicks >= 0 && user instanceof PlayerEntity playerEntity) {
			HitResult hitResult = this.getHitResult(user);
			if (hitResult instanceof BlockHitResult blockHitResult) {
				BlockPos blockPos = blockHitResult.getBlockPos();
				BlockState blockState = world.getBlockState(blockPos);
				Arm arm = user.getActiveHand() == Hand.MAIN_HAND ? playerEntity.getMainArm() : playerEntity.getMainArm().getOpposite();

				this.addDustParticles(world, blockHitResult, blockState, user.getRotationVec(0.0F), arm);
			}
		}

	}

	private HitResult getHitResult(LivingEntity user) {
		return ProjectileUtil.getCollision(user, (entity) -> !entity.isSpectator() && entity.canHit(), MAX_DISTANCE);
	}

	public void addDustParticles(World world, BlockHitResult hitResult, BlockState state, Vec3d userRotation, Arm arm) {
		double d = (double)3.0F;
		int i = arm == Arm.RIGHT ? 1 : -1;
		int j = world.getRandom().nextBetweenExclusive(7, 12);
		BlockStateParticleEffect blockStateParticleEffect = new BlockStateParticleEffect(ParticleTypes.BLOCK, state);
		Direction direction = hitResult.getSide();
		SharpRock.DustParticlesOffset dustParticlesOffset = SharpRock.DustParticlesOffset.fromSide(userRotation, direction);
		Vec3d vec3d = hitResult.getPos();

		for(int k = 0; k < j; ++k) {
			world.addParticle(blockStateParticleEffect, vec3d.x - (double)(direction == Direction.WEST ? 1.0E-6F : 0.0F), vec3d.y, vec3d.z - (double)(direction == Direction.NORTH ? 1.0E-6F : 0.0F), dustParticlesOffset.xd() * (double)i * (double)3.0F * world.getRandom().nextDouble(), (double)0.0F, dustParticlesOffset.zd() * (double)i * (double)3.0F * world.getRandom().nextDouble());
		}

	}

	static record DustParticlesOffset(double xd, double yd, double zd) {
		private static final double field_42685 = (double)1.0F;
		private static final double field_42686 = 0.1;

		DustParticlesOffset(double xd, double yd, double zd) {
			this.xd = xd;
			this.yd = yd;
			this.zd = zd;
		}

		public static SharpRock.DustParticlesOffset fromSide(Vec3d userRotation, Direction side) {
			double d = (double)0.0F;
			SharpRock.DustParticlesOffset var10000;
			switch (side) {
				case DOWN:
				case UP:
					var10000 = new SharpRock.DustParticlesOffset(userRotation.getZ(), (double)0.0F, -userRotation.getX());
					break;
				case NORTH:
					var10000 = new SharpRock.DustParticlesOffset((double)1.0F, (double)0.0F, -0.1);
					break;
				case SOUTH:
					var10000 = new SharpRock.DustParticlesOffset((double)-1.0F, (double)0.0F, 0.1);
					break;
				case WEST:
					var10000 = new SharpRock.DustParticlesOffset(-0.1, (double)0.0F, (double)-1.0F);
					break;
				case EAST:
					var10000 = new SharpRock.DustParticlesOffset(0.1, (double)0.0F, (double)1.0F);
					break;
				default:
					throw new IncompatibleClassChangeError();
			}

			return var10000;
		}

		public double xd() {
			return this.xd;
		}

		public double yd() {
			return this.yd;
		}

		public double zd() {
			return this.zd;
		}
	}
}
