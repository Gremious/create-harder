package uk.co.gremy.items;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class SharpRockRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
	public static final Identifier TEXTURE = Identifier.of("create-harder", "textures/item/sharp_rock_box_uv.png");

	private final ModelPart sharp_rock;

	public SharpRockRenderer(ModelPart root) {
		this.sharp_rock = root.getChild("sharp_rock");
	}

	// You gotta do "parent": "builtin/entity" for this custom renderer to work
	// Which unforutnatley means you gotta position the item by hand but it shouldn't be too bad the scale's in the json
	// Maybe just read it form there
	// update: nvm entity don't have a blockbench position tab, but maybe we can make a item and steal them anyway
	// Just makes sure not to do that in the render function, that gets called every frame

	@Override
	public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
		matrices.push();
//		matrices.scale(0.5F, 0.5F, 0.5F);

//		matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
//		matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
//		matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90));

//		matrices.translate(1.0, 0.2, 0.9);

		VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(vertexConsumers, RenderLayer.getEntityCutout(TEXTURE), true, false);
		this.sharp_rock.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

		matrices.pop();

//		VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, RenderLayer.getEntityCutout(TEXTURE), false, true);
//		this.bone.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
//
//		matrices.pop();

//		minecraft.getItemRenderer().renderItem(ITEM, ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, light, overlay, matrices, vertexConsumers, minecraft.world, 0);

//		matrices.push();
//		matrices.pop();
	}
}
