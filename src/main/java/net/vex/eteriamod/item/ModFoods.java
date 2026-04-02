package net.vex.eteriamod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BANANA = new FoodProperties.Builder().nutrition(1).fast()
            .saturationMod(0.2f).build();
    public static final FoodProperties STEW_WITH_POTATOES = new FoodProperties.Builder().nutrition(7)
            .saturationMod(8).build();
}
