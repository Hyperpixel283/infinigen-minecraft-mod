package de.hyperpixel.infinigen.Items;

import de.hyperpixel.infinigen.Blocks.ModBlocks;
import de.hyperpixel.infinigen.Infinigen;
import de.hyperpixel.infinigen.StuffIdkwheretoput.ModTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class DataGenRecipes extends RecipeProvider {
    public DataGenRecipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAUNTED_STONE_BRICKS.get(), 2)
                .requires(Blocks.STONE_BRICKS)
                .requires(ModTags.Items.HAUNTED)
                .unlockedBy("has_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.STONE_BRICKS).build()))
                .save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_HAUNTED_STONE_BRICKS.get(),
                ModBlocks.HAUNTED_STONE_BRICKS.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAUNTED_STONE_BRICKS_STAIRS.get(), 4)
                .define('#', ModBlocks.HAUNTED_STONE_BRICKS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_haunted_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTED_STONE_BRICKS.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAUNTED_STONE_BRICKS_SLAB.get(), 6)
                .define('#', ModBlocks.HAUNTED_STONE_BRICKS.get())
                .pattern("###")
                .unlockedBy("has_haunted_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTED_STONE_BRICKS.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAUNTED_STONE_BRICKS_WALL.get(), 6)
                .define('#', ModBlocks.HAUNTED_STONE_BRICKS.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_haunted_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTED_STONE_BRICKS.get()).build()))
                .save(consumer);





        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAUNTEDWOOD_PLANKS.get(), 4)
                .requires(ModTags.Items.HAUNTEDWOOD)
                .unlockedBy("has_hauntedwood_log", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_LOG.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAUNTEDWOOD_STAIRS.get(), 4)
                .define('#', ModBlocks.HAUNTEDWOOD_PLANKS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_hauntedwood_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_PLANKS.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAUNTEDWOOD_SLAB.get(), 6)
                .define('#', ModBlocks.HAUNTEDWOOD_PLANKS.get())
                .pattern("###")
                .unlockedBy("has_hauntedwood_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_PLANKS.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.HAUNTEDWOOD_DOOR.get(), 3)
                .define('#', ModBlocks.HAUNTEDWOOD_PLANKS.get())
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_hauntedwood_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_PLANKS.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.HAUNTEDWOOD_TRAPDOOR.get(), 2)
                .define('#', ModBlocks.HAUNTEDWOOD_PLANKS.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_hauntedwood_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_PLANKS.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HAUNTEDWOOD_FENCE.get(), 3)
                .define('#', ModBlocks.HAUNTEDWOOD_PLANKS.get())
                .define('+', Items.STICK)
                .pattern("#+#")
                .pattern("#+#")
                .unlockedBy("has_hauntedwood_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_PLANKS.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.HAUNTEDWOOD_FENCE_GATE.get())
                .define('#', ModBlocks.HAUNTEDWOOD_PLANKS.get())
                .define('+', Items.STICK)
                .pattern("+#+")
                .pattern("+#+")
                .unlockedBy("has_hauntedwood_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_PLANKS.get()).build()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.HAUNTEDWOOD_BUTTON.get())
                .requires(ModBlocks.HAUNTEDWOOD_PLANKS.get())
                .unlockedBy("has_hauntedwood_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_PLANKS.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.HAUNTEDWOOD_PRESSURE_PLATE.get())
                .define('#', ModBlocks.HAUNTEDWOOD_PLANKS.get())
                .pattern("##")
                .unlockedBy("has_hauntedwood_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_PLANKS.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAUNTEDWOOD_SIGN.get(), 3)
                .define('#', ModBlocks.HAUNTEDWOOD_PLANKS.get())
                .define('+', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" + ")
                .unlockedBy("has_hauntedwood_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_PLANKS.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAUNTEDWOOD_HANGING_SIGN.get(), 6)
                .define('#', ModBlocks.STRIPPED_HAUNTEDWOOD_LOG.get())
                .define('+', Items.CHAIN)
                .pattern("+ +")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_stripped_hauntedwood_log", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.STRIPPED_HAUNTEDWOOD_LOG.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAUNTEDWOOD_BOAT.get())
                .define('#', ModBlocks.HAUNTEDWOOD_PLANKS.get())
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_hauntedwood_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_PLANKS.get()).build()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HAUNTEDWOOD_CHEST_BOAT.get())
                .requires(ModItems.HAUNTEDWOOD_BOAT.get())
                .requires(Blocks.CHEST)
                .unlockedBy("has_hauntedwood_boat", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.HAUNTEDWOOD_BOAT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAUNTEDWOOD_WOOD.get(), 3)
                .define('#', ModBlocks.HAUNTEDWOOD_LOG.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_hauntedwood_log", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.HAUNTEDWOOD_LOG.get()).build()))
                .save(consumer);
    }
    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> p_249145_, RecipeCategory p_250609_, ItemLike p_251254_, ItemLike p_249666_, int p_251462_) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(p_249666_), p_250609_, p_251254_, p_251462_).unlockedBy(getHasName(p_249666_), has(p_249666_)).save(p_249145_, new ResourceLocation(Infinigen.MODID, getItemName(p_251254_) + p_249666_) + "_stonecutting");
    }
}
