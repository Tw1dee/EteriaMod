package net.vex.eteriamod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vex.eteriamod.EteriaMod;
import net.vex.eteriamod.item.custom.BlockTagChecker;
import net.vex.eteriamod.item.custom.FuelItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EteriaMod.MOD_ID);

    public static final RegistryObject<Item> KHARDUNIT_INGOT = ITEMS.register("khardunit_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_KHARDUNIT = ITEMS.register("raw_khardunit",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLOCK_TAG_CHECKER = ITEMS.register("block_tag_checker",
            () -> new BlockTagChecker(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoods.BANANA)));
    public static final RegistryObject<Item> STEW_WITH_POTATOES = ITEMS.register("stew_with_potatoes",
            () -> new Item(new Item.Properties().food(ModFoods.STEW_WITH_POTATOES)));

    public static final RegistryObject<Item> OAK_BARK = ITEMS.register("oak_bark",
            () -> new FuelItem(new Item.Properties(), 200));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
