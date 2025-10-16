package com.House239.Powerhouse.Items;

import com.House239.Powerhouse.Handlers.MaterialHelper;
import com.House239.Powerhouse.Handlers.OredictHelper;
import com.House239.Powerhouse.Handlers.RegistryHandler;
import com.House239.Powerhouse.Material.Material;
import com.House239.Powerhouse.Material.Shapes.Shape;
import com.House239.Powerhouse.Material.Shapes.ShapeRegistration;
import com.House239.Powerhouse.ModItems;
import com.House239.Powerhouse.Powerhouse;
import com.House239.Powerhouse.Proxy.ClientProxy;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;

public class ItemMaterial extends Item {
    private String resourceLocation;
    private Material material;
    private Shape shape;
    public ItemMaterial(String name, Material material, String oredict, Shape shape){
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Powerhouse.MaterialTab);

        this.material = material;
        this.shape = shape;

        RegistryHandler.OREDICT.add(new OredictHelper(this, oredict));
        // ModItems.ITEMS.add(this);
        ClientProxy.COLOREDITEMS.add(new MaterialHelper(this, material, shape));
        ItemStack itemstack = new ItemStack(this);
        itemstack.setTagInfo("Material", new NBTTagString(material.getModid() + ":" + material.getName()));
        this.resourceLocation = (name + "_" + material.getIconset());
    }

    public String getResourceLocation(){
        return this.resourceLocation;
    }

    // @Override
    public void registerModels(){
        ClientProxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (material == null) return I18n.format("item.powerhouse.unknown.name");

        String matKey   = "material." + material.getRegistryName().toString() + ".name";
        String shapeKey = "shape.powerhouse." + shape + ".name";
        String formatKey = "format.powerhouse.material_shape";

        String matName = I18n.hasKey(matKey) ? I18n.format(matKey) : material.getName();
        String shapeName = I18n.hasKey(shapeKey) ? I18n.format(shapeKey) : shape.getTranslationKey();

        if (shape == ShapeRegistration.GEM && (shapeName.isEmpty() || shapeName.equalsIgnoreCase("Gem"))) {
            return matName; // this is to not show the gem part of most gems for consistency with vanilla
        }

        Powerhouse.LOGGER.info("Has format key? " + I18n.hasKey("format.powerhouse.material_shape"));

        if (I18n.hasKey(formatKey)) {
            return I18n.format(formatKey, matName, shapeName);
        } else {
            return matName + " " + shapeName;
        }
    }
}
