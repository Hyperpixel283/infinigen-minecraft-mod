package de.hyperpixel.infinigen;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Infinigen.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
    }
}
