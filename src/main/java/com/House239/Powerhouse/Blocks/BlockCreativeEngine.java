package com.House239.Powerhouse.Blocks;

import com.House239.Powerhouse.Blocks.TileEntity.TileEntityCreativeEngine;
import com.House239.Powerhouse.Blocks.TileEntity.TileEntityGearbox;
import com.House239.Powerhouse.ModBlocks;
import com.House239.Powerhouse.ModItems;
import com.House239.Powerhouse.Proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockCreativeEngine extends Block {
    public static final PropertyEnum<EnumFacing.Axis> axis = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class);
    public BlockCreativeEngine(String name, Material material, CreativeTabs tab){
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(tab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
    // @Override
    public void registerModels(){
        ClientProxy.registerItemRenderer(ItemBlock.getItemFromBlock(this), 0, "inventory");
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, axis);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(axis).ordinal();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing.Axis[] axisSet = EnumFacing.Axis.values();
        return getDefaultState().withProperty(axis, axisSet[meta % axisSet.length]);
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing face, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return getDefaultState().withProperty(axis, face.getAxis());
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityCreativeEngine();
    }
}
