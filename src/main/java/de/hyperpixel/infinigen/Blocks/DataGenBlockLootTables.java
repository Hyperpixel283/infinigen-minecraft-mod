package de.hyperpixel.infinigen.Blocks;

import de.hyperpixel.infinigen.Items.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class DataGenBlockLootTables extends BlockLootSubProvider {
    public DataGenBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.HAUNTED_STONE_BRICKS.get());
        dropSelf(ModBlocks.CHISELED_HAUNTED_STONE_BRICKS.get());

        this.dropSelf(ModBlocks.HAUNTEDWOOD_LOG.get());
        this.dropSelf(ModBlocks.HAUNTEDWOOD_WOOD.get());
        this.dropSelf(ModBlocks.HAUNTEDWOOD_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_HAUNTEDWOOD_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_HAUNTEDWOOD_LOG.get());
        this.dropSelf(ModBlocks.HAUNTEDTREE_SAPLING.get());
        this.add(ModBlocks.HAUNTEDTREE_LEAVES.get(),
                (block) -> createLeavesDrops(block, ModBlocks.HAUNTEDTREE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.HAUNTEDWOOD_STAIRS.get());
        this.add(ModBlocks.HAUNTEDWOOD_SLAB.get(), block -> createSlabItemTable(ModBlocks.HAUNTEDWOOD_SLAB.get()));
        this.add(ModBlocks.HAUNTEDWOOD_DOOR.get(), block -> createDoorTable(ModBlocks.HAUNTEDWOOD_DOOR.get()));
        this.dropSelf(ModBlocks.HAUNTEDWOOD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.HAUNTEDWOOD_FENCE.get());
        this.dropSelf(ModBlocks.HAUNTEDWOOD_FENCE_GATE.get());
        this.dropSelf(ModBlocks.HAUNTEDWOOD_BUTTON.get());
        this.dropSelf(ModBlocks.HAUNTEDWOOD_PRESSURE_PLATE.get());
        this.add(ModBlocks.HAUNTEDWOOD_SIGN.get(),
                (block) -> createSingleItemTable(ModItems.HAUNTEDWOOD_SIGN.get()));
        this.add(ModBlocks.HAUNTEDWOOD_SIGN_WALL.get(),
                (block) -> createSingleItemTable(ModItems.HAUNTEDWOOD_SIGN.get()));
        this.add(ModBlocks.HAUNTEDWOOD_HANGING_SIGN.get(),
                (block) -> createSingleItemTable(ModItems.HAUNTEDWOOD_HANGING_SIGN.get()));
        this.add(ModBlocks.HAUNTEDWOOD_HANGING_SIGN_WALL.get(),
                (block) -> createSingleItemTable(ModItems.HAUNTEDWOOD_HANGING_SIGN.get()));
        this.dropSelf(ModBlocks.HAUNTED_STONE_BRICKS_STAIRS.get());
        this.add(ModBlocks.HAUNTED_STONE_BRICKS_SLAB.get(), block -> createSlabItemTable(ModBlocks.HAUNTED_STONE_BRICKS_SLAB.get()));
        this.dropSelf(ModBlocks.HAUNTED_STONE_BRICKS_WALL.get());
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
