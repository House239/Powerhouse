package com.House239.Powerhouse.Material;

import com.House239.Powerhouse.Tags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.awt.*;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class MaterialRegistration {

    public static Material IRON = new MaterialMetal("Iron", new Color(255, 255, 255), 0, "powerhouse", 1538, "iron", "Fe", 2, 20f, 20f).withMechStats(64, 4, 0).withHeatStats(1);
    public static Material DIAMOND = new MaterialGem("Diamond", new Color(152, 152, 255), 0, "powerhouse", 3550, "diamond", "C", 2, 20f, 20f);
    public static Material REDSTONE = new MaterialDust("Redstone", new Color(255, 0, 0), 0, "powerhouse", 1538, "redstone", "idk", 2, 20f, 20f);
    @SubscribeEvent
    public static void onRegisterMaterials(RegistryEvent.Register<Material> event) {
        IForgeRegistry<Material> registry = MaterialRegistry.getRegistry();
        createMaterial(registry, IRON, "IRON");
        createMaterial(registry, DIAMOND, "DIAMOND");
        createMaterial(registry, REDSTONE, "REDSTONE");
    }

    public static Material createMaterial(IForgeRegistry<Material> registry, Material material, String name)
    {
        registry.register(material.setRegistryName(Tags.MOD_ID, name));

        return material;
    }
}
