package com.facebook.rebound;
/* loaded from: classes.dex */
public abstract class SpringLooper {
    protected BaseSpringSystem mSpringSystem;

    public void setSpringSystem(BaseSpringSystem baseSpringSystem) {
        this.mSpringSystem = baseSpringSystem;
    }

    public abstract void start();

    public abstract void stop();
}
