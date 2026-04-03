package net.vex.eteriamod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.vex.eteriamod.EteriaMod;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> BLOCK_TAG_CHECKER_VALUABLES = tag("block_tag_checker_valuables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(EteriaMod.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(EteriaMod.MOD_ID, name));
        }
    }

}
