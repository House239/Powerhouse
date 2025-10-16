package com.House239.Powerhouse;

import com.House239.Powerhouse.Blocks.TileEntity.TileEntityAxle;
import com.House239.Powerhouse.Blocks.TileEntity.TileEntityCreativeEngine;
import com.House239.Powerhouse.Blocks.TileEntity.TileEntityGearbox;
import com.House239.Powerhouse.Blocks.TileEntity.TileEntitySpeedometer;
import com.House239.Powerhouse.Capability.Mechanical.IMechanicalCapability;
import com.House239.Powerhouse.Capability.Mechanical.MechanicalFactory;
import com.House239.Powerhouse.Capability.Mechanical.MechanicalStorage;
import com.House239.Powerhouse.Handlers.RegistryHandler;
import com.House239.Powerhouse.Material.MaterialRegistry;
import com.House239.Powerhouse.Tabs.MaterialTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class Powerhouse {

    public static Boolean DEBUG_MODE = true;
    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);
    public static final CreativeTabs MaterialTab = new MaterialTab("materials");

    /**
     * <a href="https://cleanroommc.com/wiki/forge-mod-development/event#overview">
     *     Take a look at how many FMLStateEvents you can listen to via the @Mod.EventHandler annotation here
     * </a>
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Hello From {}!", Tags.MOD_NAME);
        // GameRegistry.registerTileEntity(TileEntityAxle.class, "tileEntityAxle");
        // GameRegistry.registerTileEntity(TileEntityGearbox.class, "tileEntityGearbox");
        // GameRegistry.registerTileEntity(TileEntityCreativeEngine.class, "tileEntityCreativeEngine");
        // GameRegistry.registerTileEntity(TileEntitySpeedometer.class, "tileEntitySpeedometer");
    }

    @SubscribeEvent
    public static void RegisterCapabilities(){
        CapabilityManager.INSTANCE.register(IMechanicalCapability.class, new MechanicalStorage(), new MechanicalFactory());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        // RecipeHandler.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        RegistryHandler.postInitRegistries(event);
    }

    @Mod.EventHandler
    public void serverInit(FMLServerStartingEvent event){

    }
}
