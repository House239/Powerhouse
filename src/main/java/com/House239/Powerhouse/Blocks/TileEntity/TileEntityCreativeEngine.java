package com.House239.Powerhouse.Blocks.TileEntity;

import com.House239.Powerhouse.Capability.Mechanical.IMechanicalCapability;
import com.House239.Powerhouse.Capability.Mechanical.MechanicalCapability;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityCreativeEngine extends TileEntity implements ITickable, IMechanicalCapability {
    private float torque;
    private float speed;
    private boolean direction;
    private IMechanicalCapability mechanicalCapability;

    // Tunable constants
    private static final float BASE_TORQUE = 10.0f;
    private static final float BASE_SPEED = 5.0f;

    public TileEntityCreativeEngine(){
        this.mechanicalCapability = new MechanicalCapability();
    }

    @Override
    public void update() {
        if (world.isRemote) return;

        boolean powered = world.isBlockPowered(pos);

        if (powered) {
            torque = BASE_TORQUE;
            speed = BASE_SPEED;
        } else {
            torque = 0;
            speed = 0;
        }

        EnumFacing outputSide = EnumFacing.EAST;
        TileEntity teOut = world.getTileEntity(pos.offset(outputSide));
        if (teOut instanceof IMechanicalCapability) {
            IMechanicalCapability output = (IMechanicalCapability) teOut;
            output.setTorque(torque);
            output.setSpeed(speed);
        }
    }

    @Override
    public float getTorque() { return torque; }

    @Override
    public float getSpeed() { return speed; }

    @Override
    public float getPower() {
        return 0;
    }

    @Override
    public boolean getDirection() {
        return false;
    }

    @Override
    public void setTorque(float torque) {
        this.torque = torque;
    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    @Override
    public void invertDirection() {
        this.direction = !direction;
    }
}
