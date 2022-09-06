package com.fimi.soul.entity;
/* loaded from: classes.dex */
public class DroneFilghtState {
    private byte state = -1;

    public boolean isFilghtPhaseFinish(byte b) {
        if (this.state != b) {
            this.state = b;
            if (b == 5) {
                return true;
            }
        }
        return false;
    }
}
