package com.fimi.soul.entity;

import java.io.Serializable;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
public class HistoryFileInfo implements Serializable {
    String deviceType;
    String fcId;

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getFcId() {
        return this.fcId;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setFcId(String str) {
        this.fcId = str;
    }

    public String toString() {
        return "HistoryFileInfo{fcId='" + this.fcId + C0359h.f729z + ", deviceType='" + this.deviceType + C0359h.f729z + C0359h.f726w;
    }
}
