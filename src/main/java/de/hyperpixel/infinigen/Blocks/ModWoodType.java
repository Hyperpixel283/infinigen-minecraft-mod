package de.hyperpixel.infinigen.Blocks;

import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodType {
    public static final WoodType HAUNTED = WoodType.register(new WoodType(Infinigen.MODID + ":haunted", BlockSetType.OAK));
}
