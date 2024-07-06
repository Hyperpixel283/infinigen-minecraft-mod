package de.hyperpixel.infinigen.Blocks.Sign;

import de.hyperpixel.infinigen.Blocks.BlockEntities.ModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class HangingSignBlockWall extends WallHangingSignBlock {
    public HangingSignBlockWall(Properties p_251606_, WoodType p_252140_) {
        super(p_251606_, p_252140_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos p_250745_, BlockState p_250905_) {
        return new ModHangingSignBlockEntity(p_250745_, p_250905_);
    }
}
