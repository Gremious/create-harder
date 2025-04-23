package uk.co.gremy.items;

import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import uk.co.gremy.CreateHarder;

public class SharpRockCustomModelRenderer extends CustomRenderedItemModelRenderer {
//
//	private final ModelPart sharp_rock;

	public SharpRockCustomModelRenderer() {
		super();
		CreateHarder.LOGGER.info("initttttt aaaaaaaa oooooooo");

	}

	@Override
	public void render(ItemStack stack, ModelTransformationMode transformType, MatrixStack matrices, VertexConsumerProvider vertexConsumersProvider, int light, int overlay) {

		CreateHarder.LOGGER.info("SharpRockCustomModelRenderer please");

		matrices.push();

//		matrices.scale(2.5F, 0.5F, 0.5F);

		var player = MinecraftClient.getInstance().player;
		var item = new ItemStack(Items.IRON_INGOT);

		ItemRenderer itemRenderer =  MinecraftClient.getInstance().getItemRenderer();
		itemRenderer.renderItem(item, ModelTransformationMode.NONE, light, overlay, matrices, vertexConsumersProvider, player.getWorld(), 0);


//		matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
//		matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
//		matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90));

//		matrices.translate(1.0, 0.2, 0.9);

//		VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(vertexConsumersProvider, RenderLayer.getEntityCutout(TEXTURE), true, false);
//		this.sharp_rock.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

		matrices.pop();
	}

	@Override
	protected void render(
			ItemStack stack,
			CustomRenderedItemModel model,
			PartialItemModelRenderer renderer,
			ModelTransformationMode transformType,
			MatrixStack matrices,
			VertexConsumerProvider vertexConsumersProvider,
			int light,
			int overlay) {
		CreateHarder.LOGGER.info("SharpRockCustomModelRenderer");

		matrices.push();

		matrices.scale(2.5F, 0.5F, 0.5F);

		var player = MinecraftClient.getInstance().player;
		var item = new ItemStack(Items.IRON_INGOT);

		ItemRenderer itemRenderer =  MinecraftClient.getInstance().getItemRenderer();
		itemRenderer.renderItem(item, ModelTransformationMode.NONE, light, overlay, matrices, vertexConsumersProvider, player.getWorld(), 0);


//		matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
//		matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
//		matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90));

//		matrices.translate(1.0, 0.2, 0.9);

//		VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(vertexConsumersProvider, RenderLayer.getEntityCutout(TEXTURE), true, false);
//		this.sharp_rock.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

		matrices.pop();
	}
}
