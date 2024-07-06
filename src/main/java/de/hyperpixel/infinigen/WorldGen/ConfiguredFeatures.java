package de.hyperpixel.infinigen.WorldGen;

import de.hyperpixel.infinigen.Blocks.Grower.HauntedTrunkPlacer;
import de.hyperpixel.infinigen.Blocks.ModBlocks;
import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ConfiguredFeatures {
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Infinigen.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static final ResourceKey<ConfiguredFeature<?, ?>> HAUNTEDTREE_KEY = registerKey("hauntedtree_key");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, HAUNTEDTREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.HAUNTEDWOOD_LOG.get()),
                new HauntedTrunkPlacer(3, 2, 2), BlockStateProvider.simple(ModBlocks.HAUNTEDTREE_LEAVES.get()),
                new DarkOakFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1)),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }
}
