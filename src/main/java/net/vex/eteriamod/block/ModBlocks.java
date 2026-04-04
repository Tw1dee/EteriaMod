package net.vex.eteriamod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vex.eteriamod.EteriaMod;
import net.vex.eteriamod.item.ModItems;
import net.vex.eteriamod.block.custom.SoundBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EteriaMod.MOD_ID);

    public static final RegistryObject<Block> KHARDUNIT_BLOCK = registerBlock("khardunit_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_KHARDUNIT_BLOCK = registerBlock("raw_khardunit_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> KHARDUNIT_ORE = registerBlock("khardunit_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_KHARDUNIT_ORE = registerBlock("deepslate_khardunit_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noLootTable()));

    public static final RegistryObject<Block> WEATHERED_SANDSTONE = registerBlock("weathered_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
    public static final RegistryObject<Block> WEATHERED_SANDSTONE_STAIRS = registerBlock("weathered_sandstone_stairs",
            () -> new StairBlock(() -> ModBlocks.WEATHERED_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
    public static final RegistryObject<Block> WEATHERED_SANDSTONE_SLAB = registerBlock("weathered_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
    public static final RegistryObject<Block> WEATHERED_SANDSTONE_WALL = registerBlock("weathered_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> WEATHERED_SANDSTONE_BRICKS = registerBlock("weathered_sandstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
    public static final RegistryObject<Block> WEATHERED_SANDSTONE_BRICKS_STAIRS = registerBlock("weathered_sandstone_bricks_stairs",
            () -> new StairBlock(() -> ModBlocks.WEATHERED_SANDSTONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
    public static final RegistryObject<Block> WEATHERED_SANDSTONE_BRICKS_SLAB = registerBlock("weathered_sandstone_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
    public static final RegistryObject<Block> WEATHERED_SANDSTONE_BRICKS_WALL = registerBlock("weathered_sandstone_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> WEATHERED_SANDSTONE_BUTTON = registerBlock("weathered_sandstone_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON), BlockSetType.STONE, 10, true));
    public static final RegistryObject<Block> WEATHERED_SANDSTONE_PRESSURE_PLATE = registerBlock("weathered_sandstone_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.STONE));
    public static final RegistryObject<Block> WEATHERED_SANDSTONE_DOOR = registerBlock("weathered_sandstone_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noLootTable(), BlockSetType.STONE));
    public static final RegistryObject<Block> WEATHERED_SANDSTONE_TRAPDOOR = registerBlock("weathered_sandstone_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noLootTable(), BlockSetType.STONE));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
