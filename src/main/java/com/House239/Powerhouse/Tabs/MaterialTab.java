package com.House239.Powerhouse.Tabs;

import com.House239.Powerhouse.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MaterialTab extends CreativeTabs {
    public MaterialTab(String label) {super ("materialtab");}

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.ITEM_TEST);
    }
}
