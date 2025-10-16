package com.House239.Powerhouse.Handlers;

import com.House239.Powerhouse.Items.ItemMaterial;
import com.House239.Powerhouse.Material.*;
import com.House239.Powerhouse.Material.Shapes.*;
import com.House239.Powerhouse.ModBlocks;
import com.House239.Powerhouse.ModItems;
import com.House239.Powerhouse.Powerhouse;
import com.House239.Powerhouse.Proxy.ClientProxy;
import com.House239.Powerhouse.Tags;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.function.Function;

@Mod.EventBusSubscriber
public class RegistryHandler {
    public static final ArrayList<OredictHelper> OREDICT = new ArrayList<OredictHelper>();
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
        if(Powerhouse.DEBUG_MODE = true){
            Powerhouse.LOGGER.info("Items registered");
        }
    }
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
        if(Powerhouse.DEBUG_MODE = true){
            Powerhouse.LOGGER.info("Blocks registered");
        }
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEMS) {
            if(!(item instanceof ItemMaterial)){
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
                if(Powerhouse.DEBUG_MODE = true) {
                    Powerhouse.LOGGER.info("Registered model for item " + item.getRegistryName());
                }
            }
        }
        for(MaterialHelper item : ClientProxy.COLOREDITEMS){
            ResourceLocation location = new ResourceLocation(item.getShape().getRegistryName().toString()+"_"+item.getMaterial().getIconset());
            ResourceLocation defaultlocation = new ResourceLocation(item.getShape().getRegistryName().toString()+"_0");
            if(ResourceHelper.resourceExists(location)){
                ModelLoader.setCustomModelResourceLocation(item.getItem(), 0, new ModelResourceLocation(location, "inventory"));
            }else{
                ModelLoader.setCustomModelResourceLocation(item.getItem(), 0, new ModelResourceLocation(defaultlocation, "inventory"));
            }
            if(Powerhouse.DEBUG_MODE = true) {
                Powerhouse.LOGGER.info("Registered model for material item " + item.getItem().getRegistryName());
            }
        }
        for(Block block : ModBlocks.BLOCKS){
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
            if(Powerhouse.DEBUG_MODE = true){
                Powerhouse.LOGGER.info("Registered model for block " + block.getRegistryName());
            }
        }
    }

    public static void preInitRegistries(FMLPreInitializationEvent event){

    }

    public static void postInitRegistries(FMLPostInitializationEvent event){
        for(int i = 0; i < OREDICT.size(); i++){
            OredictHelper oredict = OREDICT.get(i);
            Item item = oredict.getItem();
            String oredictname = oredict.getOredict();
            OreDictionary.registerOre(oredictname, item);
        }
    }
}
