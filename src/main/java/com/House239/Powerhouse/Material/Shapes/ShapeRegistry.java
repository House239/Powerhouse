package com.House239.Powerhouse.Material.Shapes;

import com.House239.Powerhouse.Material.Material;
import com.House239.Powerhouse.Tags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class ShapeRegistry {
    public static IForgeRegistry<Shape> SHAPE_REGISTRY;

    @SubscribeEvent
    public static void onCreateRegistry(RegistryEvent.NewRegistry event)
    {
        SHAPE_REGISTRY = new RegistryBuilder<Shape>()
                .setType(Shape.class)
                .setName(new ResourceLocation(Tags.MOD_ID, "shapes")).allowModification()
                .create();
    }
}
