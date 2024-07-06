package de.hyperpixel.infinigen.Blocks;

import de.hyperpixel.infinigen.Blocks.Sign.HangingSignBlock;
import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DataGenBlockModels extends BlockStateProvider {
    public DataGenBlockModels(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Infinigen.MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.HAUNTED_STONE_BRICKS);
        blockWithItem(ModBlocks.CHISELED_HAUNTED_STONE_BRICKS);

        logBlock(((RotatedPillarBlock) ModBlocks.HAUNTEDWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.HAUNTEDWOOD_WOOD.get()), new ResourceLocation(Infinigen.MODID, "block/hauntedwood_log"),
                new ResourceLocation(Infinigen.MODID, "block/hauntedwood_log"));

        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_HAUNTEDWOOD_LOG.get(), new ResourceLocation(Infinigen.MODID, "block/stripped_hauntedwood_log"),
                new ResourceLocation(Infinigen.MODID, "block/stripped_hauntedwood_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_HAUNTEDWOOD_WOOD.get(), new ResourceLocation(Infinigen.MODID, "block/stripped_hauntedwood_log"),
                new ResourceLocation(Infinigen.MODID, "block/stripped_hauntedwood_log"));

        blockWithItem(ModBlocks.HAUNTEDTREE_LEAVES);
        blockWithItem(ModBlocks.HAUNTEDWOOD_PLANKS);
        saplingBlock(ModBlocks.HAUNTEDTREE_SAPLING);

        simpleBlockItem(ModBlocks.HAUNTEDWOOD_LOG.get(), models().withExistingParent("infinigen:hauntedwood_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.HAUNTEDWOOD_WOOD.get(), models().withExistingParent("infinigen:hauntedwood_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_HAUNTEDWOOD_LOG.get(), models().withExistingParent("infinigen:stripped_hauntedwood_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_HAUNTEDWOOD_WOOD.get(), models().withExistingParent("infinigen:stripped_hauntedwood_wood", "minecraft:block/cube_column"));

        stairsBlock(((StairBlock) ModBlocks.HAUNTEDWOOD_STAIRS.get()), blockTexture(ModBlocks.HAUNTEDWOOD_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.HAUNTEDWOOD_SLAB.get()), blockTexture(ModBlocks.HAUNTEDWOOD_PLANKS.get()), blockTexture(ModBlocks.HAUNTEDWOOD_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.HAUNTEDWOOD_DOOR.get()), modLoc("block/hauntedwood_door_bottom"), modLoc("block/hauntedwood_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.HAUNTEDWOOD_TRAPDOOR.get()), modLoc("block/hauntedwood_trapdoor"), true, "cutout");
        fenceBlock(((FenceBlock) ModBlocks.HAUNTEDWOOD_FENCE.get()), blockTexture(ModBlocks.HAUNTEDWOOD_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.HAUNTEDWOOD_FENCE_GATE.get()), blockTexture(ModBlocks.HAUNTEDWOOD_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.HAUNTEDWOOD_BUTTON.get()), blockTexture(ModBlocks.HAUNTEDWOOD_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.HAUNTEDWOOD_PRESSURE_PLATE.get()), blockTexture(ModBlocks.HAUNTEDWOOD_PLANKS.get()));
        signBlock(((StandingSignBlock) ModBlocks.HAUNTEDWOOD_SIGN.get()),
                ((WallSignBlock) ModBlocks.HAUNTEDWOOD_SIGN_WALL.get()),
                blockTexture(ModBlocks.HAUNTEDWOOD_PLANKS.get()));
        hangingsignBlock(((HangingSignBlock) ModBlocks.HAUNTEDWOOD_HANGING_SIGN.get()),
                ((WallHangingSignBlock) ModBlocks.HAUNTEDWOOD_HANGING_SIGN_WALL.get()),
                blockTexture(ModBlocks.HAUNTEDWOOD_PLANKS.get()));
        stairsBlock(((StairBlock) ModBlocks.HAUNTED_STONE_BRICKS_STAIRS.get()), blockTexture(ModBlocks.HAUNTED_STONE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.HAUNTED_STONE_BRICKS_SLAB.get()), blockTexture(ModBlocks.HAUNTED_STONE_BRICKS.get()), blockTexture(ModBlocks.HAUNTED_STONE_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.HAUNTED_STONE_BRICKS_WALL.get()), blockTexture(ModBlocks.HAUNTED_STONE_BRICKS.get()));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    public void hangingsignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingsignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingsignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
}
