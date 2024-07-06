package de.hyperpixel.infinigen.Blocks.Grower;

import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister
            .create(Registries.TRUNK_PLACER_TYPE, Infinigen.MODID);

    public static final RegistryObject<TrunkPlacerType<HauntedTrunkPlacer>> HAUNTED_TRUNK_PLACER = TRUNK_PLACER
            .register("haunted_trunk_placer", () -> new TrunkPlacerType<>(HauntedTrunkPlacer.HAUNTEDCODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
