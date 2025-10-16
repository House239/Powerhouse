package com.House239.Powerhouse.Capability.Mechanical;

import java.util.concurrent.Callable;

public class MechanicalFactory implements Callable<IMechanicalCapability> {
    @Override
    public IMechanicalCapability call() throws Exception {
        return new MechanicalCapability();
    }
}
