package net.vex.eteriamod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.registries.RegistryObject;
import net.vex.eteriamod.block.ModBlocks;
import net.vex.eteriamod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.KHARDUNIT_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_KHARDUNIT_BLOCK.get());

        this.add(ModBlocks.KHARDUNIT_ORE.get(),
                block -> createLikeOreDrop(ModBlocks.KHARDUNIT_BLOCK.get(), ModItems.RAW_KHARDUNIT.get()));
        this.add(ModBlocks.DEEPSLATE_KHARDUNIT_ORE.get(),
                block -> createLikeOreDrop(ModBlocks.DEEPSLATE_KHARDUNIT_ORE.get(), ModItems.RAW_KHARDUNIT.get()));
        }

    protected LootTable.Builder createLikeOreDrop(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
