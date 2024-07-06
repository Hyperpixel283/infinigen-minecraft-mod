package de.hyperpixel.infinigen.StuffIdkwheretoput;

import de.hyperpixel.infinigen.Blocks.DataGenBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class DataGenLootTables {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(DataGenBlockLootTables::new, LootContextParamSets.BLOCK)));
    }
}
