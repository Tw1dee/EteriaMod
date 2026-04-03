package net.vex.eteriamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.vex.eteriamod.EteriaMod;
import net.vex.eteriamod.block.ModBlocks;
import net.vex.eteriamod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> KHARDUNIT_SMELTABLES = List.of(ModItems.RAW_KHARDUNIT.get(),
    ModBlocks.KHARDUNIT_ORE.get(),
            ModBlocks.DEEPSLATE_KHARDUNIT_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, KHARDUNIT_SMELTABLES, RecipeCategory.MISC, ModItems.KHARDUNIT_INGOT.get(), 0.25f, 200, "khardunit");
        oreSmelting(pWriter, KHARDUNIT_SMELTABLES, RecipeCategory.MISC, ModItems.KHARDUNIT_INGOT.get(), 0.25f, 100, "khardunit");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.KHARDUNIT_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.KHARDUNIT_INGOT.get())
                .unlockedBy(getHasName(ModItems.KHARDUNIT_INGOT.get()), has(ModItems.KHARDUNIT_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.KHARDUNIT_INGOT.get(), 9)
                .requires(ModBlocks.KHARDUNIT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.KHARDUNIT_BLOCK.get()), has(ModBlocks.KHARDUNIT_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_KHARDUNIT_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RAW_KHARDUNIT.get())
                .unlockedBy(getHasName(ModItems.RAW_KHARDUNIT.get()), has(ModItems.RAW_KHARDUNIT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_KHARDUNIT.get(), 9)
                .requires(ModBlocks.RAW_KHARDUNIT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_KHARDUNIT_BLOCK.get()), has(ModBlocks.RAW_KHARDUNIT_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.STEW_WITH_POTATOES.get())
                .requires(Items.BOWL)
                .requires(Items.POTATO)
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy(getHasName(ModItems.STEW_WITH_POTATOES.get()), has(ModItems.STEW_WITH_POTATOES.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, EteriaMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
