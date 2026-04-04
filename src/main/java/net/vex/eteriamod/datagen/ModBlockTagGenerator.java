package net.vex.eteriamod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.vex.eteriamod.EteriaMod;
import net.vex.eteriamod.block.ModBlocks;
import net.vex.eteriamod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EteriaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.BLOCK_TAG_CHECKER_VALUABLES)
                .add(ModBlocks.KHARDUNIT_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.KHARDUNIT_ORE.get(),
                        ModBlocks.DEEPSLATE_KHARDUNIT_ORE.get(),
                        ModBlocks.KHARDUNIT_BLOCK.get(),
                        ModBlocks.RAW_KHARDUNIT_BLOCK.get(),
                        ModBlocks.WEATHERED_SANDSTONE.get(),
                        ModBlocks.WEATHERED_SANDSTONE_BRICKS.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.KHARDUNIT_ORE.get(),
                        ModBlocks.DEEPSLATE_KHARDUNIT_ORE.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.WEATHERED_SANDSTONE_WALL.get());
    }
}
