package com.autonavi.amap.mapcore;
/* loaded from: classes.dex */
public abstract class ADGLAnimation {
    public static final int DEFAULT_DURATION = 250;
    public static final int Interpolator_Accelerate = 1;
    public static final int Interpolator_AccelerateDecelerate = 3;
    public static final int Interpolator_Bounce = 4;
    public static final int Interpolator_Decelerate = 2;
    public static final int Interpolator_Double_Raise = 6;
    public static final int Interpolator_Linear = 0;
    public static final int Interpolator_Overshoot = 5;
    protected int _duration = 300;
    protected boolean _isOver = false;
    protected long _startTime = -1;
    protected long _offsetTime = 0;

    public abstract void doAnimation(Object obj);

    public boolean isOver() {
        return this._isOver;
    }

    public boolean isValid() {
        return true;
    }
}
