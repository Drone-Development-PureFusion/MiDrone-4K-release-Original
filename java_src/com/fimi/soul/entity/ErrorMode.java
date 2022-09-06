package com.fimi.soul.entity;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class ErrorMode {
    private boolean isMiddleFault = false;
    private boolean isCompassFault = false;
    ArrayList seriousErrorList = new ArrayList();
    ArrayList lightErrorList = new ArrayList();

    public ArrayList getLightErrorList() {
        return this.lightErrorList;
    }

    public ArrayList getSeriousErrorList() {
        return this.seriousErrorList;
    }

    public boolean isCompassFault() {
        return this.isCompassFault;
    }

    public boolean isMiddleFault() {
        return this.isMiddleFault;
    }

    public void setIsCompassFault(boolean z) {
        this.isCompassFault = z;
    }

    public void setIsMiddleFault(boolean z) {
        this.isMiddleFault = z;
    }

    public void setLightErrorList(ArrayList arrayList) {
        this.lightErrorList = arrayList;
    }

    public void setSeriousErrorList(ArrayList arrayList) {
        this.seriousErrorList = arrayList;
    }
}
