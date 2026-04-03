package net.vex.eteriamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.vex.eteriamod.EteriaMod;
import net.vex.eteriamod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EteriaMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.KHARDUNIT_BLOCK);
        blockWithItem(ModBlocks.RAW_KHARDUNIT_BLOCK);

        blockWithItem(ModBlocks.KHARDUNIT_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_KHARDUNIT_ORE);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
