package de.hyperpixel.infinigen.Blocks.Sign;

import de.hyperpixel.infinigen.Blocks.BlockEntities.ModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class HangingSignBlock extends CeilingHangingSignBlock {
    public HangingSignBlock(Properties p_250481_, WoodType p_248716_) {
        super(p_250481_, p_248716_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos p_249338_, BlockState p_250706_) {
        return new ModHangingSignBlockEntity(p_249338_, p_250706_);
    }
}
