package de.hyperpixel.infinigen.Blocks.BlockEntities;

import de.hyperpixel.infinigen.Blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModHangingSignBlockEntity extends SignBlockEntity {
    public ModHangingSignBlockEntity(BlockPos p_Pos, BlockState p_State) {
        super(ModBlocks.MOD_HANGING_SIGN.get(), p_Pos, p_State);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlocks.MOD_HANGING_SIGN.get();
    }
}
