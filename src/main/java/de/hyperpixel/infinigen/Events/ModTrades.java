package de.hyperpixel.infinigen.Events;

import de.hyperpixel.infinigen.Blocks.ModBlocks;
import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Infinigen.MODID)
public class ModTrades {
    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 3),
                new ItemStack(ModBlocks.HAUNTEDTREE_SAPLING.get(), 1),
                5, 5, 0.01f));
    }
}
