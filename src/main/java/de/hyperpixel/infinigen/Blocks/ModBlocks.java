package de.hyperpixel.infinigen.Blocks;

import de.hyperpixel.infinigen.Blocks.BlockEntities.ModHangingSignBlockEntity;
import de.hyperpixel.infinigen.Blocks.BlockEntities.ModSignBlockEntity;
import de.hyperpixel.infinigen.Blocks.Grower.HauntedTreeGrower;
import de.hyperpixel.infinigen.Blocks.Sign.HangingSignBlock;
import de.hyperpixel.infinigen.Blocks.Sign.HangingSignBlockWall;
import de.hyperpixel.infinigen.Blocks.Sign.SignBlockStanding;
import de.hyperpixel.infinigen.Blocks.Sign.SignBlockWall;
import de.hyperpixel.infinigen.Infinigen;
import de.hyperpixel.infinigen.Items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Infinigen.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Infinigen.MODID);

    public static final RegistryObject<Block> HAUNTED_STONE_BRICKS = registerBlock("haunted_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(7f).requiresCorrectToolForDrops().explosionResistance(15)));
    public static final RegistryObject<Block> CHISELED_HAUNTED_STONE_BRICKS = registerBlock("chiseled_haunted_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6f).requiresCorrectToolForDrops().explosionResistance(15)));
    public static final RegistryObject<Block> HAUNTED_STONE_BRICKS_STAIRS = registerBlock("haunted_stone_bricks_stairs",
            () -> new StairBlock(() -> ModBlocks.HAUNTED_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> HAUNTED_STONE_BRICKS_SLAB = registerBlock("haunted_stone_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> HAUNTED_STONE_BRICKS_WALL = registerBlock("haunted_stone_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    //Trees

    public static final RegistryObject<Block> HAUNTEDTREE_LEAVES = registerBlock("hauntedtree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;}
            });
    public static final RegistryObject<Block> HAUNTEDTREE_SAPLING = registerBlock("hauntedtree_sapling",
            () -> new SaplingBlock(new HauntedTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> HAUNTEDWOOD_LOG = registerBlock("hauntedwood_log",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(5f)));
    public static final RegistryObject<Block> STRIPPED_HAUNTEDWOOD_LOG = registerBlock("stripped_hauntedwood_log",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(5f)));
    public static final RegistryObject<Block> HAUNTEDWOOD_WOOD = registerBlock("hauntedwood_wood",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(5f)));
    public static final RegistryObject<Block> STRIPPED_HAUNTEDWOOD_WOOD = registerBlock("stripped_hauntedwood_wood",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(5f)));
    public static final RegistryObject<Block> HAUNTEDWOOD_PLANKS = registerBlock("hauntedwood_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(5)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_STAIRS = registerBlock("hauntedwood_stairs",
            () -> new StairBlock(() -> ModBlocks.HAUNTEDWOOD_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_SLAB = registerBlock("hauntedwood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_DOOR = registerBlock("hauntedwood_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.OAK) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_TRAPDOOR = registerBlock("hauntedwood_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.OAK) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_FENCE = registerBlock("hauntedwood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_FENCE_GATE = registerBlock("hauntedwood_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_BUTTON = registerBlock("hauntedwood_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), BlockSetType.OAK, 20, true) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_PRESSURE_PLATE = registerBlock("hauntedwood_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), BlockSetType.OAK) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_SIGN = BLOCKS.register("hauntedwood_sign",
            () -> new SignBlockStanding(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodType.HAUNTED) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_SIGN_WALL = BLOCKS.register("hauntedwood_sign_wall",
            () -> new SignBlockWall(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodType.HAUNTED) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_HANGING_SIGN = BLOCKS.register("hauntedwood_hanging_sign",
            () -> new HangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodType.HAUNTED) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<Block> HAUNTEDWOOD_HANGING_SIGN_WALL = BLOCKS.register("hauntedwood_hanging_sign_wall",
            () -> new HangingSignBlockWall(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodType.HAUNTED) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;}
            });
    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN = BLOCK_ENTITIES.register("mod_sign",
            () -> BlockEntityType.Builder.of(ModSignBlockEntity::new,
                    ModBlocks.HAUNTEDWOOD_SIGN.get(),
                    ModBlocks.HAUNTEDWOOD_SIGN_WALL.get()).build(null));
    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN = BLOCK_ENTITIES.register("mod_hanging_sign",
            () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                    ModBlocks.HAUNTEDWOOD_HANGING_SIGN.get(),
                    ModBlocks.HAUNTEDWOOD_HANGING_SIGN_WALL.get()).build(null));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }
    public static void registerBlock(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static void registerBlockEntitiy(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
