package com.House239.Powerhouse.Blocks.TileEntity;

import com.House239.Powerhouse.Capability.Mechanical.IMechanicalCapability;
import com.House239.Powerhouse.Capability.Mechanical.MechanicalCapability;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityAxle extends TileEntity implements ITickable {
    private float torque;
    private float speed;
    private static float MAX_SPEED;
    private static float MAX_TORQUE;
    private IMechanicalCapability mechanicalCapability;

    public TileEntityAxle(float maxSpeed, float maxTorque){
        this.mechanicalCapability = new MechanicalCapability();
        MAX_SPEED = maxSpeed;
        MAX_TORQUE = maxTorque;
    }

    @Override
    public void update() {
        if (world.isRemote) return;

        EnumFacing inputSide = EnumFacing.WEST;
        TileEntity te = world.getTileEntity(pos.offset(inputSide));
        if (te instanceof IMechanicalCapability) {
            IMechanicalCapability input = (IMechanicalCapability) te;
            this.torque = input.getTorque() * 0.95f;
            this.speed = input.getSpeed();
        }

        // Send to output tile (opposite side)
        EnumFacing outputSide = EnumFacing.EAST;
        TileEntity teOut = world.getTileEntity(pos.offset(outputSide));
        if (teOut instanceof IMechanicalCapability) {
            IMechanicalCapability output = (IMechanicalCapability) teOut;
            output.setTorque(this.torque);
            output.setSpeed(this.speed);
        }
    }

    // For rendering or debugging
    public double getTorque() { return torque; }
    public double getSpeed() { return speed; }
}
