package net.vex.eteriamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.vex.eteriamod.EteriaMod;
import net.vex.eteriamod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EteriaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.KHARDUNIT_INGOT);
        simpleItem(ModItems.RAW_KHARDUNIT);

        simpleItem(ModItems.BANANA);
        simpleItem(ModItems.STEW_WITH_POTATOES);

        simpleItem(ModItems.OAK_BARK);

        simpleItem(ModItems.KHARDUNIT_INGOT);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EteriaMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
