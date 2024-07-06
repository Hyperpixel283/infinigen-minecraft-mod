package de.hyperpixel.infinigen;

import com.mojang.logging.LogUtils;
import de.hyperpixel.infinigen.Blocks.Grower.ModTrunkPlacerTypes;
import de.hyperpixel.infinigen.Blocks.ModBlocks;
import de.hyperpixel.infinigen.Blocks.ModWoodType;
import de.hyperpixel.infinigen.Entities.ModBoatRenderer;
import de.hyperpixel.infinigen.Entities.ModEntities;
import de.hyperpixel.infinigen.Items.ModCreativeModeTab;
import de.hyperpixel.infinigen.Items.ModItems;
import de.hyperpixel.infinigen.StuffIdkwheretoput.ModSounds;
import de.hyperpixel.infinigen.WorldGen.NewBiomes.surfaceRules.ModSurfaceRules;
import de.hyperpixel.infinigen.WorldGen.Terrablender;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Infinigen.MODID)
public class Infinigen {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "infinigen";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public Infinigen() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.registerBlock(modEventBus);
        ModBlocks.registerBlockEntitiy(modEventBus);
        ModEntities.register(modEventBus);
        ModTrunkPlacerTypes.register(modEventBus);
        ModCreativeModeTab.register(modEventBus);
        ModSounds.register(modEventBus);

        Terrablender.registerBiomes();

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.makeRules());
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodType.HAUNTED);
            EntityRenderers.register(ModEntities.MOD_BOAT_ENTITY.get(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT_ENTITY.get(), pContext -> new ModBoatRenderer(pContext, true));
        }
    }
}
