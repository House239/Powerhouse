package com.House239.Powerhouse.Capability.Mechanical;

public interface IMechanicalCapability {
    float getTorque();
    float getSpeed();
    float getPower();
    boolean getDirection();

    void setTorque(float torque);
    void setSpeed(float speed);
    void setDirection(boolean direction);
    void invertDirection();
}
