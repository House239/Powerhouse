package com.House239.Powerhouse.Capability.Mechanical;

public class MechanicalCapability implements IMechanicalCapability {
    private float speed;
    private float torque;
    private float power;
    private boolean direction;

    public void MechanicalPowerCapability() {
        this.speed = 0;
        this.torque = 0;
        this.power = 0;
        this.direction = false;
    }

    /**
     * Retrieves the torque of the component.
     */
    @Override
    public float getTorque() {
        if(this.speed == 0f){
            return 0f;
        }else{
            return this.torque;
        }
    }

    /**
     * Retrieves the speed of the component.
     */
    @Override
    public float getSpeed() {
        return this.speed;
    }

    /**
     * Retrieves the power of the component. Power is equal to speed * torque.
     */
    @Override
    public float getPower() {
        return this.speed * this.torque;
    }

    /**
     * Retrieves the direction of the component.
     */
    @Override
    public boolean getDirection() {
        return this.direction;
    }

    /**
     * Sets the torque of the component.
     */
    @Override
    public void setTorque(float torque) {
        this.torque = torque;
    }

    /**
     * Sets the speed of the component. Make sure to set this back to 0 when mechanical power runs out, so that you don't get infinite power.
     */
    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * Sets the direction of the component.
     */
    @Override
    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    /**
     * Inverts the direction of the component.
     */
    @Override
    public void invertDirection() {
        this.direction = !this.direction;
    }
}
