package com.House239.Powerhouse.Handlers;

import net.minecraft.item.Item;

public class OredictHelper {
    private Item item;
    private String oredict;
    public OredictHelper(Item item, String oredict){
        this.item = item;
        this.oredict = oredict;
    }

    public Item getItem(){
        return item;
    }

    public String getOredict(){
        return oredict;
    }
}
