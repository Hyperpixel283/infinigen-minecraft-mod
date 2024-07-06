package de.hyperpixel.infinigen.Entities;

import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Infinigen.MODID);

    public static final RegistryObject<EntityType<ModBoat>> MOD_BOAT_ENTITY =
            ENTITY_TYPES.register("mod_boat_entity", () ->
                    EntityType.Builder.<ModBoat>of(ModBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f)
                            .build("mod_boat_entity"));
    public static final RegistryObject<EntityType<ModChestBoat>> MOD_CHEST_BOAT_ENTITY =
            ENTITY_TYPES.register("mod_chest_boat_entity", () ->
                    EntityType.Builder.<ModChestBoat>of(ModChestBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f)
                            .build("mod_chest_boat_entity"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
