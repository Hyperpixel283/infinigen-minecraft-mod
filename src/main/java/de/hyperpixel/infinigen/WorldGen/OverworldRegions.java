package de.hyperpixel.infinigen.WorldGen;

import com.mojang.datafixers.util.Pair;
import de.hyperpixel.infinigen.WorldGen.NewBiomes.HauntedWoods;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.*;

import java.util.function.Consumer;

public class OverworldRegions extends Region {

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.WARM, ParameterUtils.Temperature.WARM)
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.FULL_RANGE))
                .continentalness(ParameterUtils.Continentalness.FAR_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_3, ParameterUtils.Erosion.EROSION_5)
                .depth(ParameterUtils.Depth.SURFACE ,ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING)
                .build().forEach(point -> builder.add(point, HauntedWoods.HAUNTED_WOODS_BIOME));

        builder.build().forEach(mapper::accept);
    }

    public OverworldRegions(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }
}
