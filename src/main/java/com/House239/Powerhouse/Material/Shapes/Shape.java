package com.House239.Powerhouse.Material.Shapes;

import net.minecraftforge.registries.IForgeRegistryEntry;

public class Shape extends IForgeRegistryEntry.Impl<Shape>{

    private String Name;
    private String oredict;
    private String modid;

    public Shape(String name, String oredict, String modid) {
        this.Name = name;
        this.oredict = oredict;
        this.modid = modid;
    }

    @Override
    public String toString() {
        return "Material{name='" + Name + "'}";
    }

    public String getTranslationKey(){
        return this.Name;
    }

    public String getOredict(){
        return this.oredict;
    }

    public String getModid(){
        return this.modid;
    }
}
