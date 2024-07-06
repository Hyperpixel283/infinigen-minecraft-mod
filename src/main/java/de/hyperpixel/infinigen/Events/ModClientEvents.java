package de.hyperpixel.infinigen.Events;

import de.hyperpixel.infinigen.Blocks.ModBlocks;
import de.hyperpixel.infinigen.Entities.ModLayers;
import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Infinigen.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlocks.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlocks.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModLayers.HAUNTEDWOOD_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModLayers.HAUNTEDWOOD_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }
}