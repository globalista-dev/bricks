package com.globalista;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static com.globalista.Bricks.MODID;

public class BricksBlocks {

    public static void callBlocks(){};

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> content.add(block));
        return item;
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MODID, name), block);
    }

    public static final Block SANDSTONE_BRICKS = registerBlock("sandstone_bricks", new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_BRICK_SLAB = registerBlock("sandstone_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE_STAIRS)));
    public static final Block SANDSTONE_BRICK_STAIRS = registerBlock("sandstone_brick_stairs",
            new StairsBlock(SANDSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SANDSTONE_SLAB)));

}
