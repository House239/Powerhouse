package com.House239.Powerhouse.Blocks.TileEntity;

import com.House239.Powerhouse.Capability.Mechanical.IMechanicalCapability;
import com.House239.Powerhouse.Capability.Mechanical.MechanicalCapability;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntitySpeedometer extends TileEntity implements ITickable {
    private float torque;
    private float speed;
    private IMechanicalCapability mechanicalCapability;

    public TileEntitySpeedometer(){
        this.mechanicalCapability = new MechanicalCapability();
    }

    @Override
    public void update() {
        if (world.isRemote) return;

        EnumFacing inputSide = EnumFacing.WEST;
        TileEntity te = world.getTileEntity(pos.offset(inputSide));
        if (te instanceof IMechanicalCapability) {
            IMechanicalCapability input = (IMechanicalCapability) te;
            this.torque = input.getTorque() * 0.95f; // 5% loss
            this.speed = input.getSpeed();
        }

        EnumFacing outputSide = EnumFacing.EAST;
        TileEntity teOut = world.getTileEntity(pos.offset(outputSide));
        if (teOut instanceof IMechanicalCapability) {
            IMechanicalCapability output = (IMechanicalCapability) teOut;
            output.setTorque(this.torque);
            output.setSpeed(this.speed);
        }

        if (world.getTotalWorldTime() % 40 == 0) {
            System.out.println("PowerMeter at " + pos +
                    " | Torque=" + torque +
                    " | Speed=" + speed +
                    " | Power=" + (torque * speed));
        }
    }

    public double getTorque() { return torque; }
    public double getSpeed() { return speed; }
}
