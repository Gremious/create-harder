package uk.co.gremy;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

public class CreateHarderDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator
				.createPack()
				.addProvider(CreateHarderEnglishLangProvider::new);
	}

	private static class CreateHarderEnglishLangProvider extends FabricLanguageProvider {
		private CreateHarderEnglishLangProvider(FabricDataOutput dataGenerator) {
			// Default it is en_us.
			super(dataGenerator);
		}

		// Why would you not override existing entries on data gen?
		@Override
		public CompletableFuture<?> run(DataWriter writer) {
			TreeMap<String, String> translationEntries = new TreeMap<>();
			this.generateTranslations((key, value) -> {
				Objects.requireNonNull(key);
				Objects.requireNonNull(value);

				if (key.contains("create-harder") && translationEntries.containsKey(key)) {
                    LOGGER.warn("Existing translation key found - {} - overriding.", key);
				}

				translationEntries.put(key, value);
			});

			JsonObject langEntryJson = new JsonObject();
			for(Map.Entry<String, String> entry : translationEntries.entrySet()) {
				langEntryJson.addProperty((String)entry.getKey(), (String)entry.getValue());
			}

			Path filepath = this.dataOutput
					.getResolver(DataOutput.OutputType.RESOURCE_PACK, "lang")
					.resolveJson(new Identifier(this.dataOutput.getModId(), "en_us"));

			return DataProvider.writeToPath(writer, langEntryJson, filepath);
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			// I don't care about the existing file, full generate/override every time please.
			// Feat. let's not do a billion item lines
			for (ChItem item : ChItemsRegistrar.ITEMS) { translationBuilder.add(item, item.Name); }
		}
	}
}
