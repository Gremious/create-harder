package uk.co.gremy;

import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.Identifier;
import uk.co.gremy.items.*;

import java.util.Optional;

import static uk.co.gremy.items.SharpRockModel.LAYER_LOCATION;
//import uk.co.gremy.items.SharpRockRenderer;

public class CreateHarderClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
//		EntityModelLayerRegistry.registerModelLayer(LAYER_LOCATION, SharpRockModel::getTexturedModelData);

//		BuiltinItemRendererRegistry.INSTANCE.register(ChItems.COOL_ITEM.getItem(), (stack, mode, matrices, vertexConsumers, light, overlay) -> {
//			CustomRenderedItemModelRenderer renderer = new SharpRockCustomModelRenderer();
//
//			CreateHarder.LOGGER.info("Coiol itemmmmm in register please");
//
//			renderer.render(stack, mode, matrices, vertexConsumers, light, overlay);
//		});

		BuiltinItemRendererRegistry.INSTANCE.register(ChItems.SHARP_ROCK.getItem(), (stack, mode, matrices, vertexConsumers, light, overlay) -> {

			CustomRenderedItemModelRenderer renderer = new SharpRockCustomModelRenderer();

			CreateHarder.LOGGER.info("SharpRockCustomModelRenderer in register please");
//			MinecraftClient.getInstance().getTextureManager().bindTexture(SharpRockRenderer.TEXTURE);

//			ModelPart root = MinecraftClient.getInstance().getEntityModelLoader().getModelPart(LAYER_LOCATION);
//			new SharpRockRenderer(root).render(stack, mode, matrices, vertexConsumers, light, overlay);

			renderer.render(stack, mode, matrices, vertexConsumers, light, overlay);
		});
	}
}
