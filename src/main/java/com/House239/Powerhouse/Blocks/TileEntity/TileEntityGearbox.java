package com.House239.Powerhouse.Blocks.TileEntity;

import com.House239.Powerhouse.Capability.Mechanical.IMechanicalCapability;
import com.House239.Powerhouse.Capability.Mechanical.MechanicalCapability;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityGearbox extends TileEntity implements ITickable {
    private float torque;
    private float speed;
    private float ratio = 4.0f;
    private static float MAX_SPEED;
    private static float MAX_TORQUE;
    private IMechanicalCapability mechanicalCapability;

    public TileEntityGearbox(float maxSpeed, float maxTorque, float ratio){
        this.mechanicalCapability = new MechanicalCapability();
        MAX_SPEED = maxSpeed;
        MAX_TORQUE = maxTorque;
        this.ratio = ratio;
    }

    @Override
    public void update() {
        if (world.isRemote) return;

        EnumFacing inputSide = EnumFacing.WEST;
        TileEntity te = world.getTileEntity(pos.offset(inputSide));
        if (te instanceof IMechanicalCapability) {
            IMechanicalCapability input = (IMechanicalCapability) te;

            this.torque = input.getTorque() * ratio;
            this.speed = input.getSpeed() / ratio;

            float efficiency = 0.9f;
            float inputPower = input.getPower() * efficiency;
            if (this.torque * this.speed > inputPower) {
                this.speed = inputPower / this.torque;
            }
        }

        EnumFacing outputSide = EnumFacing.EAST;
        TileEntity teOut = world.getTileEntity(pos.offset(outputSide));
        if (teOut instanceof IMechanicalCapability) {
            IMechanicalCapability output = (IMechanicalCapability) teOut;
            output.setTorque(this.torque);
            output.setSpeed(this.speed);
        }
    }
}
