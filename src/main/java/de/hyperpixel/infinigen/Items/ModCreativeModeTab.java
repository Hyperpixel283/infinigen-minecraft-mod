package de.hyperpixel.infinigen.Items;

import de.hyperpixel.infinigen.Blocks.ModBlocks;
import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            Infinigen.MODID);

    public static RegistryObject<CreativeModeTab> INFINIGEN_CREATIVE_TAB = CREATIVE_MODE_TABS.register("infinigen_creative_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.HAUNTED_STONE_BRICKS.get()))
                    .title(Component.translatable("creativemodetab.infinigen_creative_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.HAUNTED_STONE_BRICKS.get());
                        pOutput.accept(ModBlocks.CHISELED_HAUNTED_STONE_BRICKS.get());
                        pOutput.accept(ModBlocks.HAUNTED_STONE_BRICKS_STAIRS.get());
                        pOutput.accept(ModBlocks.HAUNTED_STONE_BRICKS_SLAB.get());
                        pOutput.accept(ModBlocks.HAUNTED_STONE_BRICKS_WALL.get());
                        pOutput.accept(ModBlocks.HAUNTEDTREE_SAPLING.get());
                        pOutput.accept(ModBlocks.HAUNTEDTREE_LEAVES.get());
                        pOutput.accept(ModBlocks.HAUNTEDWOOD_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_HAUNTEDWOOD_LOG.get());
                        pOutput.accept(ModBlocks.HAUNTEDWOOD_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_HAUNTEDWOOD_WOOD.get());
                        pOutput.accept(ModBlocks.HAUNTEDWOOD_PLANKS.get());
                        pOutput.accept(ModBlocks.HAUNTEDWOOD_STAIRS.get());
                        pOutput.accept(ModBlocks.HAUNTEDWOOD_SLAB.get());
                        pOutput.accept(ModBlocks.HAUNTEDWOOD_DOOR.get());
                        pOutput.accept(ModBlocks.HAUNTEDWOOD_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.HAUNTEDWOOD_FENCE.get());
                        pOutput.accept(ModBlocks.HAUNTEDWOOD_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.HAUNTEDWOOD_BUTTON.get());
                        pOutput.accept(ModBlocks.HAUNTEDWOOD_PRESSURE_PLATE.get());
                        pOutput.accept(ModItems.HAUNTEDWOOD_SIGN.get());
                        pOutput.accept(ModItems.HAUNTEDWOOD_HANGING_SIGN.get());
                        pOutput.accept(ModItems.HAUNTEDWOOD_BOAT.get());
                        pOutput.accept(ModItems.HAUNTEDWOOD_CHEST_BOAT.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
