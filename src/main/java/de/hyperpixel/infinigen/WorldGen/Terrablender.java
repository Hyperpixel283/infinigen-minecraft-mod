package de.hyperpixel.infinigen.WorldGen;

import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class Terrablender {
    public static void registerBiomes() {
        Regions.register(new OverworldRegions(new ResourceLocation(Infinigen.MODID, "overworld"), 2));
    }
}
