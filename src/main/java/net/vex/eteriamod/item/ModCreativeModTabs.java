package net.vex.eteriamod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.vex.eteriamod.EteriaMod;
import net.vex.eteriamod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EteriaMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> INGREDIENTS = CREATIVE_MODE_TABS.register("ingredients",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_KHARDUNIT.get()))
                    .title(Component.translatable("creativetab.ingredients"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.KHARDUNIT_INGOT.get());
                        pOutput.accept(ModItems.RAW_KHARDUNIT.get());
                        pOutput.accept(ModItems.OAK_BARK.get());


                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> BLOCKS = CREATIVE_MODE_TABS.register("blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.KHARDUNIT_BLOCK.get()))
                    .title(Component.translatable("creativetab.blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.KHARDUNIT_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_KHARDUNIT_BLOCK.get());
                        pOutput.accept(ModBlocks.KHARDUNIT_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_KHARDUNIT_ORE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> FOODS = CREATIVE_MODE_TABS.register("foods",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEW_WITH_POTATOES.get()))
                    .title(Component.translatable("creativetab.foods"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BANANA.get());
                        pOutput.accept(ModItems.STEW_WITH_POTATOES.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
