package com.House239.Powerhouse.Material;

import com.House239.Powerhouse.Tags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class MaterialRegistry {
    public static IForgeRegistry<Material> MATERIAL_REGISTRY;

    @SubscribeEvent
    public static void onCreateRegistry(RegistryEvent.NewRegistry event)
    {
        MATERIAL_REGISTRY = new RegistryBuilder<Material>()
                .setType(Material.class)
                .setName(new ResourceLocation(Tags.MOD_ID, "materials")).allowModification()
                .create();
    }

    public static IForgeRegistry<Material> getRegistry() {
        return MATERIAL_REGISTRY != null ? MATERIAL_REGISTRY :
                net.minecraftforge.fml.common.registry.GameRegistry.findRegistry(Material.class);
    }
}
