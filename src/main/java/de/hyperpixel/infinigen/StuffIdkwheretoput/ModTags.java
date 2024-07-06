package de.hyperpixel.infinigen.StuffIdkwheretoput;

import de.hyperpixel.infinigen.Infinigen;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;

public class ModTags {
    public static class Items {
        private static TagKey<Item> tags(String name) {
            return ItemTags.create(new ResourceLocation(Infinigen.MODID, name));
        }
        public static final TagKey<Item> HAUNTED = tags("haunted");
        public static final TagKey<Item> HAUNTEDWOOD = tags("hauntedwood");
    }
    public static class Biomes {
        private static TagKey<Biome> tags(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(Infinigen.MODID, name));
        }
        public static final TagKey<Biome> HAUNTEDTREE_SPAWNS = tags("hauntedtree_spawns");
    }
}
