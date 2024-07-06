package de.hyperpixel.infinigen;

import de.hyperpixel.infinigen.Blocks.DataGenBlockModels;
import de.hyperpixel.infinigen.Items.DataGenItemModel;
import de.hyperpixel.infinigen.Items.DataGenRecipes;
import de.hyperpixel.infinigen.StuffIdkwheretoput.DataGenLootTables;
import de.hyperpixel.infinigen.WorldGen.WorldGenDataGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Infinigen.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenHandler {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new DataGenBlockModels(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new DataGenItemModel(packOutput, existingFileHelper));
        generator.addProvider(true, new DataGenRecipes(packOutput));
        generator.addProvider(event.includeServer(), new WorldGenDataGenerator(packOutput, lookupProvider));
        generator.addProvider(true, DataGenLootTables.create(packOutput));
    }
}
