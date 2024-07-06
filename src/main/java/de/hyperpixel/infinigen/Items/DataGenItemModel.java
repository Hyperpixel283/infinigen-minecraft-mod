package de.hyperpixel.infinigen.Items;

import de.hyperpixel.infinigen.Blocks.ModBlocks;
import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DataGenItemModel extends ItemModelProvider {

    public DataGenItemModel(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Infinigen.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        saplingItem(ModBlocks.HAUNTEDTREE_SAPLING);

        simpleBlockItem(ModBlocks.HAUNTEDWOOD_DOOR);
        evenSimplerBlockItem(ModBlocks.HAUNTEDWOOD_STAIRS);
        evenSimplerBlockItem(ModBlocks.HAUNTEDWOOD_SLAB);
        evenSimplerBlockItem(ModBlocks.HAUNTEDWOOD_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.HAUNTEDWOOD_FENCE_GATE);
        fenceItem(ModBlocks.HAUNTEDWOOD_FENCE, ModBlocks.HAUNTEDWOOD_PLANKS);
        buttonItem(ModBlocks.HAUNTEDWOOD_BUTTON, ModBlocks.HAUNTEDWOOD_PLANKS);
        trapdoorItem(ModBlocks.HAUNTEDWOOD_TRAPDOOR);
        simpleItem(ModItems.HAUNTEDWOOD_SIGN);
        simpleItem(ModItems.HAUNTEDWOOD_HANGING_SIGN);
        simpleItem(ModItems.HAUNTEDWOOD_BOAT);
        simpleItem(ModItems.HAUNTEDWOOD_CHEST_BOAT);

        evenSimplerBlockItem(ModBlocks.HAUNTED_STONE_BRICKS_STAIRS);
        evenSimplerBlockItem(ModBlocks.HAUNTED_STONE_BRICKS_SLAB);
        wallItem(ModBlocks.HAUNTED_STONE_BRICKS_WALL, ModBlocks.HAUNTED_STONE_BRICKS);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Infinigen.MODID, "block/" + item.getId().getPath()));
    }

    //Credits for these methods: Kaupenjoe (Git: https://github.com/Tutorials-By-Kaupenjoe/Forge-Tutorial-1.20.X/blob/13-stairsSlabsAndSimilar/src/main/java/net/kaupenjoe/tutorialmod/datagen/ModItemModelProvider.java)

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Infinigen.MODID,"item/" + item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Infinigen.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(Infinigen.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(Infinigen.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Infinigen.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }


    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Infinigen.MODID, "item/" + item.getId().getPath()));
    }
}
