package com.House239.Powerhouse;

import com.House239.Powerhouse.Items.ItemBase;
import com.House239.Powerhouse.Items.ItemMaterial;
import com.House239.Powerhouse.Items.ItemMaterialArray;
import com.House239.Powerhouse.Material.MaterialRegistration;
import com.House239.Powerhouse.Material.Shapes.ShapeRegistration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final Item ITEM_TEST = new ItemBase("item_test", CreativeTabs.FOOD);

    // public static final Item DIAMOND = new ItemMaterial("gem_diamond", MaterialRegistration.DIAMOND, "gemDiamond", ShapeRegistration.GEM);
}
