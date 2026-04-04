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
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.KHARDUNIT_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_KHARDUNIT_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
        this.dropSelf(ModBlocks.WEATHERED_SANDSTONE.get());
        this.dropSelf(ModBlocks.WEATHERED_SANDSTONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.WEATHERED_SANDSTONE_WALL.get());
        this.dropSelf(ModBlocks.WEATHERED_SANDSTONE_STAIRS.get());
        this.add(ModBlocks.WEATHERED_SANDSTONE_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(ModBlocks.WEATHERED_SANDSTONE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.WEATHERED_SANDSTONE_BUTTON.get());
        this.dropSelf(ModBlocks.WEATHERED_SANDSTONE_BRICKS.get());
        this.dropSelf(ModBlocks.WEATHERED_SANDSTONE_BRICKS_WALL.get());
        this.dropSelf(ModBlocks.WEATHERED_SANDSTONE_BRICKS_STAIRS.get());
        this.add(ModBlocks.WEATHERED_SANDSTONE_BRICKS_SLAB.get(), this::createSlabItemTable);

        this.add(ModBlocks.WEATHERED_SANDSTONE_DOOR.get(),
                block -> createDoorTable(ModBlocks.WEATHERED_SANDSTONE_DOOR.get()));

        this.add(ModBlocks.KHARDUNIT_ORE.get(),
                block -> createLikeOreDrop(ModBlocks.KHARDUNIT_ORE.get(), ModItems.RAW_KHARDUNIT.get()));
        this.add(ModBlocks.DEEPSLATE_KHARDUNIT_ORE.get(),
                block -> createLikeOreDrop(ModBlocks.DEEPSLATE_KHARDUNIT_ORE.get(), ModItems.RAW_KHARDUNIT.get()));

        this.add(ModBlocks.SOUND_BLOCK.get(), block -> LootTable.lootTable());
        }

    protected LootTable.Builder createLikeOreDrop(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return java.util.List.of(
                ModBlocks.KHARDUNIT_BLOCK.get(),
                ModBlocks.RAW_KHARDUNIT_BLOCK.get(),
                ModBlocks.SOUND_BLOCK.get(),
                ModBlocks.WEATHERED_SANDSTONE.get(),
                ModBlocks.WEATHERED_SANDSTONE_PRESSURE_PLATE.get(),
                ModBlocks.WEATHERED_SANDSTONE_WALL.get(),
                ModBlocks.WEATHERED_SANDSTONE_STAIRS.get(),
                ModBlocks.WEATHERED_SANDSTONE_SLAB.get(),
                ModBlocks.WEATHERED_SANDSTONE_TRAPDOOR.get(),
                ModBlocks.WEATHERED_SANDSTONE_BUTTON.get(),
                ModBlocks.WEATHERED_SANDSTONE_BRICKS.get(),
                ModBlocks.WEATHERED_SANDSTONE_BRICKS_WALL.get(),
                ModBlocks.WEATHERED_SANDSTONE_BRICKS_STAIRS.get(),
                ModBlocks.WEATHERED_SANDSTONE_BRICKS_SLAB.get(),
                ModBlocks.WEATHERED_SANDSTONE_DOOR.get(),
                ModBlocks.KHARDUNIT_ORE.get(),
                ModBlocks.DEEPSLATE_KHARDUNIT_ORE.get()
        );
    }
}
