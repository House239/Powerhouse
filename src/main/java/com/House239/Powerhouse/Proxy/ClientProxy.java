package com.House239.Powerhouse.Proxy;

import com.House239.Powerhouse.Handlers.MaterialHelper;
import com.House239.Powerhouse.Items.ItemMaterial;
import com.House239.Powerhouse.Material.*;
import com.House239.Powerhouse.Material.Shapes.*;
import com.House239.Powerhouse.Material.Shapes.Shape;
import com.House239.Powerhouse.ModItems;
import com.House239.Powerhouse.ModBlocks;
import com.House239.Powerhouse.Powerhouse;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy {
    public static final List<MaterialHelper> COLOREDITEMS = new ArrayList<MaterialHelper>();
    public static void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
    public static void registerVariantRenderer(Item item, int meta, String filename, String id){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(filename), id));
    }

    @SubscribeEvent
    public static void onRegisterItemColors(ColorHandlerEvent.Item event) {
        ItemColors itemColors = event.getItemColors();

        for (MaterialHelper item : ClientProxy.COLOREDITEMS) {
            itemColors.registerItemColorHandler((stack, tintIndex) -> item.getMaterial().getColor().getRGB(), item.getItem());
        }
    }
}
