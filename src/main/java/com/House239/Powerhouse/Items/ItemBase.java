package com.House239.Powerhouse.Items;

import com.House239.Powerhouse.Handlers.OredictHelper;
import com.House239.Powerhouse.Handlers.RegistryHandler;
import com.House239.Powerhouse.ModItems;
import com.House239.Powerhouse.Proxy.ClientProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase(String name, CreativeTabs tab){
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(tab);

        ModItems.ITEMS.add(this);
    }

    public ItemBase(String name, CreativeTabs tab, String oredict){
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(tab);

        ModItems.ITEMS.add(this);
        RegistryHandler.OREDICT.add(new OredictHelper(this, oredict));
    }

    // @Override
    public void registerModels(){
        ClientProxy.registerItemRenderer(this, 0, "inventory");
    }
}
