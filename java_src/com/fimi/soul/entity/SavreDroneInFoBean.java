package com.fimi.soul.entity;

import com.fimi.soul.drone.p193d.p194a.C2770c;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class SavreDroneInFoBean implements Serializable {
    private ConcurrentHashMap<String, C2770c> hashMap = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, C2770c> getHashMap() {
        return this.hashMap;
    }
}
