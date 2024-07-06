package de.hyperpixel.infinigen.WorldGen.NewBiomes;

import de.hyperpixel.infinigen.Infinigen;
import de.hyperpixel.infinigen.StuffIdkwheretoput.ModTags;
import de.hyperpixel.infinigen.WorldGen.ModFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;


public class BiomeModifiers {
    public static final ResourceKey<BiomeModifier> GENERATE_HAUNTEDTREE_KEY = registerKey("generate_hauntedtree_key");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var biomes = context.lookup(Registries.BIOME);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(GENERATE_HAUNTEDTREE_KEY, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.HAUNTEDTREE_SPAWNS),
                HolderSet.direct(placedFeatures.getOrThrow(ModFeatures.HAUNTEDTREE_PLACEDFEATURE_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Infinigen.MODID, name));
    }
}
