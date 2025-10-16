package com.House239.Powerhouse.Items;

import com.House239.Powerhouse.Material.*;
import com.House239.Powerhouse.Material.Shapes.*;
import com.House239.Powerhouse.Powerhouse;
import com.House239.Powerhouse.Tags;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class ItemMaterialArray {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> itemregistry = event.getRegistry();
        if(MaterialRegistry.getRegistry().getValuesCollection().isEmpty()){
            Powerhouse.LOGGER.warn("it still can't be accessed what is going on");
        }else{
            Powerhouse.LOGGER.info("The material registry can FINALLY be accessed, i'm free ");
        }
        Powerhouse.LOGGER.info("Static registry size: " + MaterialRegistry.getRegistry().getValuesCollection().size());
        Powerhouse.LOGGER.info("Lookup registry size: " + GameRegistry.findRegistry(Material.class).getValuesCollection().size());
        for (Material m : MaterialRegistry.getRegistry().getValuesCollection()) {
            for (Shape s : ShapeRegistry.SHAPE_REGISTRY.getValuesCollection()) {
                String name = s.getOredict() + "_" + m.getTranslationKey();
                String oredict = s.getOredict() + m.getName();
                if (m instanceof MaterialGem) {
                    if(s instanceof ShapeGem){
                        //ItemMaterial materialGem = new ItemMaterial(name, m, oredict, s);
                        event.getRegistry().register(new ItemMaterial(name, m, oredict, s));
                    }
                } else if (m instanceof MaterialMetal) {
                    if(s instanceof ShapeMetal){
                        // ItemMaterial materialMetal = new ItemMaterial(name, m, oredict, s);
                        event.getRegistry().register(new ItemMaterial(name, m, oredict, s));
                    }
                } else if (m instanceof MaterialDust) {
                    if(s instanceof ShapeDust){
                        // ItemMaterial materialDust = new ItemMaterial(name, m, oredict, s);
                        event.getRegistry().register(new ItemMaterial(name, m, oredict, s));
                    }
                }
            }
        }
    }
}
