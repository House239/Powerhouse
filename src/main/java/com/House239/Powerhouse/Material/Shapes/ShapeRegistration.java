package com.House239.Powerhouse.Material.Shapes;

import com.House239.Powerhouse.Powerhouse;
import com.House239.Powerhouse.Tags;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class ShapeRegistration {
    public static Shape INGOT = new ShapeMetal("Ingot", "ingot", "powerhouse");
    public static Shape GEM = new ShapeGem("Gem", "gem", "powerhouse");
    public static Shape DUST = new ShapeDust("Dust", "dust", "powerhouse");
    @SubscribeEvent
    public static void onRegisterMaterials(RegistryEvent.Register<Shape> event) {
        createShape(event.getRegistry(), INGOT, "INGOT");
        createShape(event.getRegistry(), GEM, "GEM");
        createShape(event.getRegistry(), DUST, "DUST");
    }

    public static Shape createShape(IForgeRegistry<Shape> registry, Shape shape, String name)
    {
        registry.register(shape.setRegistryName(Tags.MOD_ID, name));

        return shape;
    }
}
