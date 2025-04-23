package uk.co.gremy.items;
// Made with Blockbench 4.12.4

// Translate to yarn by me (Gremious):
// PoseStack = MatrixStack
//
// renderToBuffer = render
// setupAnim = setAngles

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class SharpRockModel extends EntityModel<Entity> {
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of("create-harder", "sharp_rock"), "main");

	private final ModelPart sharp_rock;
	public SharpRockModel(ModelPart root) {
		this.sharp_rock = root.getChild("sharp_rock");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("sharp_rock", ModelPartBuilder.create().uv(0, 0).cuboid(3.0F, -5.0F, -8.0F, 5.0F, 6.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(8.0F, -4.0F, -8.0F, 3.0F, 9.0F, 1.0F, new Dilation(0.0F))
				.uv(8, 7).cuboid(11.0F, -2.0F, -8.0F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F))
				.uv(12, 0).cuboid(12.0F, -1.0F, -8.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(12, 5).cuboid(5.0F, 1.0F, -8.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(12, 10).cuboid(4.0F, 1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(12, 12).cuboid(12.0F, 3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(12, 8).cuboid(6.0F, 3.0F, -8.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(12, 14).cuboid(7.0F, 4.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, 16.0F, 8.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		sharp_rock.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
