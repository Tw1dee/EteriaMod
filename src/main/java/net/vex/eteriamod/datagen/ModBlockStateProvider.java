package net.vex.eteriamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
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

        blockWithItem(ModBlocks.WEATHERED_SANDSTONE);
        blockWithItem(ModBlocks.WEATHERED_SANDSTONE_BRICKS);

        stairsBlock(((StairBlock)ModBlocks.WEATHERED_SANDSTONE_STAIRS.get()), blockTexture(ModBlocks.WEATHERED_SANDSTONE.get()));
        slabBlock(((SlabBlock)ModBlocks.WEATHERED_SANDSTONE_SLAB.get()), blockTexture(ModBlocks.WEATHERED_SANDSTONE.get()), blockTexture(ModBlocks.WEATHERED_SANDSTONE.get()));
        stairsBlock(((StairBlock)ModBlocks.WEATHERED_SANDSTONE_BRICKS_STAIRS.get()), blockTexture(ModBlocks.WEATHERED_SANDSTONE_BRICKS.get()));
        slabBlock(((SlabBlock)ModBlocks.WEATHERED_SANDSTONE_BRICKS_SLAB.get()), blockTexture(ModBlocks.WEATHERED_SANDSTONE_BRICKS.get()), blockTexture(ModBlocks.WEATHERED_SANDSTONE_BRICKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.WEATHERED_SANDSTONE_BUTTON.get()), blockTexture(ModBlocks.WEATHERED_SANDSTONE.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.WEATHERED_SANDSTONE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.WEATHERED_SANDSTONE.get()));

        wallBlock(((WallBlock) ModBlocks.WEATHERED_SANDSTONE_WALL.get()), blockTexture(ModBlocks.WEATHERED_SANDSTONE.get()));
        wallBlock(((WallBlock) ModBlocks.WEATHERED_SANDSTONE_BRICKS_WALL.get()), blockTexture(ModBlocks.WEATHERED_SANDSTONE_BRICKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.WEATHERED_SANDSTONE_DOOR.get()), modLoc("block/weathere_sandstone_door_bottom"), modLoc("block/weathere_sandstone_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.WEATHERED_SANDSTONE_TRAPDOOR.get()), modLoc("block/weathere_sandstone_trapdoor"), true, "cutout");
        wallBlock(((WallBlock) ModBlocks.WEATHERED_SANDSTONE_WALL.get()), blockTexture(ModBlocks.WEATHERED_SANDSTONE.get()));


        blockWithItem(ModBlocks.SOUND_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
