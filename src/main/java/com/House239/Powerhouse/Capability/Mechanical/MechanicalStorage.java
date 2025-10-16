package com.House239.Powerhouse.Capability.Mechanical;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class MechanicalStorage implements Capability.IStorage<IMechanicalCapability> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IMechanicalCapability> capability, IMechanicalCapability instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setFloat("speed", instance.getSpeed());
        nbt.setFloat("torque", instance.getTorque());
        nbt.setFloat("power", instance.getPower());
        nbt.setBoolean("direction", instance.getDirection());

        nbt.setTag("MechanicalPowerData", nbt);

        return null;
    }


    @Override
    public void readNBT(Capability<IMechanicalCapability> capability, IMechanicalCapability instance, EnumFacing side, NBTBase nbt) {
        if(nbt instanceof NBTTagCompound){
            NBTTagCompound nbt2 = ((NBTTagCompound) nbt);
            if (nbt2.hasKey("MechanicalPowerData")) {
                NBTTagCompound data = nbt2.getCompoundTag("MechanicalPowerData");
                instance.setSpeed(data.getFloat("speed"));
                instance.setTorque(data.getFloat("torque"));
                instance.setDirection(data.getBoolean("direction"));
            }
        }
    }
}
