package com.House239.Powerhouse.Handlers;

import com.House239.Powerhouse.Material.Material;
import com.House239.Powerhouse.Material.Shapes.Shape;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class MaterialHelper {
    private Item item;
    private Block block;
    private Material material;
    private Shape shape;
    public MaterialHelper(Item item, Material material, Shape shape){
        this.item = item;
        this.material = material;
        this.shape = shape;
    }

    public MaterialHelper(Block block, Material material, Shape shape){
        this.block = block;
        this.material = material;
        this.shape = shape;
    }

    public Item getItem(){
        return this.item;
    }

    public Block getBlock(){
        return this.block;
    }

    public Material getMaterial(){
        return this.material;
    }

    public Shape getShape(){
        return this.shape;
    }
}
