package com.House239.Powerhouse.Material;

import com.House239.Powerhouse.ModBlocks;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.awt.*;

public class Material extends IForgeRegistryEntry.Impl<Material>{

    private String Name;
    private int iconset;
    private Color color;
    private String modid;
    private String translationKey;
    private int meltingpoint;
    private int maxpower;
    private int friction;
    private int maxlength;
    private float conductivity;

    public Material(String name, Color color, int iconset, String modid, int meltingPoint, String translationKey) {
        this.Name = name;
        this.color = color;
        this.iconset = iconset;
        this.modid = modid;
        this.meltingpoint = meltingpoint;
        this.translationKey = translationKey;
    }

    @Override
    public String toString() {
        return "Material{name='" + Name + "', color=" + color + "}";
    }

    public String getName(){
        return this.Name;
    }

    public int getIconset(){
        return this.iconset;
    }

    public Color getColor(){
        return this.color;
    }

    public String getModid(){
        return this.modid;
    }

    public String getTranslationKey(){
        return this.translationKey;
    }

    public int getMeltingPoint(){
        return meltingpoint;
    }

    public int getMaxPower(){
        return this.maxpower;
    }

    public int getFriction(){
        return this.friction;
    }

    public int getMaxLength(){
        return this.maxlength;
    }

    public float getConductivity(){
        return this.conductivity;
    }

    public Material withMechStats(int maxpower, int friction, int maxlength){
        this.maxpower = maxpower;
        this.friction = friction;
        this.maxlength = maxlength;
        ModBlocks.MECHMATS.add(this);
        return this;
    }

    public Material withHeatStats(float conductivity){
        this.conductivity = conductivity;
        ModBlocks.HEATMATS.add(this);
        return this;
    }
}
