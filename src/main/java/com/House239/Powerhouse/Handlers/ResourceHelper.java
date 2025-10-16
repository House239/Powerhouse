package com.House239.Powerhouse.Handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

@SideOnly(Side.CLIENT)
public class ResourceHelper {
    public static boolean resourceExists(ResourceLocation loc) {
        try {
            Minecraft.getMinecraft().getResourceManager().getResource(loc);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
