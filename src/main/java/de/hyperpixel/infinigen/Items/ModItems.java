package de.hyperpixel.infinigen.Items;

import de.hyperpixel.infinigen.Blocks.ModBlocks;
import de.hyperpixel.infinigen.Entities.ModBoat;
import de.hyperpixel.infinigen.Entities.ModChestBoat;
import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Infinigen.MODID);

public static final RegistryObject<Item> HAUNTEDWOOD_SIGN = ITEMS.register("hauntedwood_sign",
        () -> new SignItem(
                new Item.Properties().stacksTo(16),
                ModBlocks.HAUNTEDWOOD_SIGN.get(),
                ModBlocks.HAUNTEDWOOD_SIGN_WALL.get()));
public static final RegistryObject<Item> HAUNTEDWOOD_HANGING_SIGN = ITEMS.register("hauntedwood_hanging_sign",
        () -> new HangingSignItem(
                ModBlocks.HAUNTEDWOOD_HANGING_SIGN.get(),
                ModBlocks.HAUNTEDWOOD_HANGING_SIGN_WALL.get(),
                new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> HAUNTEDWOOD_BOAT = ITEMS.register("hauntedwood_boat",
            () -> new ModBoatItem(false, ModBoat.Type.HAUNTED, new Item.Properties()));
    public static final RegistryObject<Item> HAUNTEDWOOD_CHEST_BOAT = ITEMS.register("hauntedwood_chest_boat",
            () -> new ModBoatItem(true, ModBoat.Type.HAUNTED, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
