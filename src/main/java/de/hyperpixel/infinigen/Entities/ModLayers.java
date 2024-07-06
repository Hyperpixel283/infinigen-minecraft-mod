package de.hyperpixel.infinigen.Entities;

import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModLayers {
    public static final ModelLayerLocation HAUNTEDWOOD_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Infinigen.MODID, "boat/haunted"), "main"
    );
    public static final ModelLayerLocation HAUNTEDWOOD_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Infinigen.MODID, "chest_boat/haunted"), "main"
    );
}
