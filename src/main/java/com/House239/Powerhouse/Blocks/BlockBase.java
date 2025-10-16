package com.House239.Powerhouse.Blocks;

import com.House239.Powerhouse.Handlers.OredictHelper;
import com.House239.Powerhouse.Handlers.RegistryHandler;
import com.House239.Powerhouse.ModBlocks;
import com.House239.Powerhouse.ModItems;
import com.House239.Powerhouse.Proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {
    public BlockBase(String name, Material material, CreativeTabs tab){
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setResistance(0);
        setHardness(0);
        setHarvestLevel("none", 0);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockBase(String name, Material material, CreativeTabs tab, float blastres, float hardness, int harvestLevel, String harvestType){
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setResistance(blastres);
        setHardness(hardness);
        setHarvestLevel(harvestType, harvestLevel);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockBase(String name, Material material, CreativeTabs tab, float blastres, float hardness, int harvestLevel, String harvestType, String oredict){
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setResistance(blastres);
        setHardness(hardness);
        setHarvestLevel(harvestType, harvestLevel);
        ItemBlock itemblock = new ItemBlock(this);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(itemblock.setRegistryName(this.getRegistryName()));
        RegistryHandler.OREDICT.add(new OredictHelper(itemblock, oredict));
    }

    // @Override
    public void registerModels(){
        ClientProxy.registerItemRenderer(ItemBlock.getItemFromBlock(this), 0, "inventory");
    }
}
