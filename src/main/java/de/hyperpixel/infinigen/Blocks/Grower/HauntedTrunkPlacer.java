package de.hyperpixel.infinigen.Blocks.Grower;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class HauntedTrunkPlacer extends TrunkPlacer {
    private boolean branchednorth;
    private boolean branchedsouth;
    private boolean branchedeast;
    private boolean branchedwest;

    public HauntedTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
        super(p_70268_, p_70269_, p_70270_);
    }

    public static final Codec<HauntedTrunkPlacer> HAUNTEDCODEC = RecordCodecBuilder
            .create(hauntedTrunkPlacerInstance -> trunkPlacerParts(hauntedTrunkPlacerInstance)
                    .apply(hauntedTrunkPlacerInstance, HauntedTrunkPlacer::new));

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.HAUNTED_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, int trunkheight, BlockPos blockPos, TreeConfiguration treeConfiguration) {
        setDirtAt(levelSimulatedReader, biConsumer, randomSource, blockPos.below(), treeConfiguration);
        int height = trunkheight + randomSource.nextInt(heightRandA, heightRandA + 1) + randomSource.nextInt(heightRandB, heightRandB + 2);

        branchednorth = false;
        branchedsouth = false;
        branchedeast = false;
        branchedwest = false;

        for (int i = 0; i < height; i++) {
            placeLog(levelSimulatedReader, biConsumer, randomSource, blockPos.above(i), treeConfiguration);

            if (i >= height - 2 && i <= height -1 && randomSource.nextBoolean()) {
                if (randomSource.nextFloat() > 0.4f && branchednorth == false) {
                    for(int k = 0; k < 2; k++) {
                        biConsumer.accept(blockPos.offset(0, i - 1, 0)
                                .relative(Direction.NORTH, 1),
                                ((BlockState) Function.identity().apply(treeConfiguration.trunkProvider.getState(randomSource, blockPos)
                                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)))
                        );
                        biConsumer.accept(blockPos.offset(0, i, -2)
                                        .relative(Direction.UP, k),
                                ((BlockState) Function.identity().apply(treeConfiguration.trunkProvider.getState(randomSource, blockPos)
                                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)))
                        );
                    }
                    branchednorth = true;
                }
                if (randomSource.nextFloat() > 0.4f && branchedsouth == false) {
                    for (int k = 0; k < 2; k++) {
                        biConsumer.accept(blockPos.offset(0, i - 1, 0)
                                        .relative(Direction.SOUTH, 1),
                                ((BlockState) Function.identity().apply(treeConfiguration.trunkProvider.getState(randomSource, blockPos)
                                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)))
                        );
                        biConsumer.accept(blockPos.offset(0, i, 2)
                                        .relative(Direction.UP, k),
                                ((BlockState) Function.identity().apply(treeConfiguration.trunkProvider.getState(randomSource, blockPos)
                                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)))
                        );
                    }
                    branchedsouth = true;
                }
                if (randomSource.nextFloat() > 0.4f && branchedeast == false) {
                    for (int k = 0; k < 2; k++) {
                        biConsumer.accept(blockPos.offset(0, i - 1, 0)
                                        .relative(Direction.EAST, 1),
                                ((BlockState) Function.identity().apply(treeConfiguration.trunkProvider.getState(randomSource, blockPos)
                                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)))
                        );
                        biConsumer.accept(blockPos.offset(2, i, 0)
                                        .relative(Direction.UP, k),
                                ((BlockState) Function.identity().apply(treeConfiguration.trunkProvider.getState(randomSource, blockPos)
                                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)))
                        );
                    }
                    branchedeast = true;
                }
                if (randomSource.nextFloat() > 0.4f && branchedwest == false) {
                    for (int k = 0; k < 2; k++) {
                        biConsumer.accept(blockPos.offset( 0, i - 1, 0)
                                        .relative(Direction.WEST, 1),
                                ((BlockState) Function.identity().apply(treeConfiguration.trunkProvider.getState(randomSource, blockPos)
                                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)))
                        );
                        biConsumer.accept(blockPos.offset(-2, i, 0)
                                        .relative(Direction.UP, k),
                                ((BlockState) Function.identity().apply(treeConfiguration.trunkProvider.getState(randomSource, blockPos)
                                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)))
                        );
                    }
                    branchedwest = true;
                }
            }
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(blockPos.above(height), 0, false));
    }
}
