package com.House239.Powerhouse;

import com.House239.Powerhouse.Blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final List<com.House239.Powerhouse.Material.Material> MECHMATS = new ArrayList<com.House239.Powerhouse.Material.Material>();
    public static final List<com.House239.Powerhouse.Material.Material> HEATMATS = new ArrayList<com.House239.Powerhouse.Material.Material>();

    public static final Block BLOCK_TEST = new BlockBase("block_test", Material.IRON, CreativeTabs.FOOD);

    // public static final Block AXLE_WOOD = new BlockAxle("axle_wood", Material.WOOD, CreativeTabs.REDSTONE, 20f, 25f);
    // public static final Block GEARBOX_WOOD_2_1 = new BlockGearbox("gearbox_wood", Material.WOOD, CreativeTabs.REDSTONE, 20f, 25f, 2f);
    // public static final Block CREATIVE_ENGINE = new BlockCreativeEngine("gearbox_wood", Material.WOOD, CreativeTabs.REDSTONE);
    // public static final Block SPEEDOMETER = new BlockSpeedometer("gearbox_wood", Material.WOOD, CreativeTabs.REDSTONE);
}
