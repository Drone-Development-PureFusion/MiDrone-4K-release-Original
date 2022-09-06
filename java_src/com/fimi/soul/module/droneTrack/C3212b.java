package com.fimi.soul.module.droneTrack;

import java.io.Serializable;
/* renamed from: com.fimi.soul.module.droneTrack.b */
/* loaded from: classes.dex */
public class C3212b implements Serializable {

    /* renamed from: a */
    private int f12338a;

    /* renamed from: b */
    private int f12339b;

    /* renamed from: a */
    public int m9100a() {
        return this.f12338a;
    }

    /* renamed from: a */
    public void m9099a(int i) {
        this.f12338a = i;
    }

    /* renamed from: a */
    public void m9098a(int i, int i2) {
        this.f12338a = i;
        this.f12339b = i2;
    }

    /* renamed from: b */
    public int m9097b() {
        return this.f12339b;
    }

    /* renamed from: b */
    public void m9096b(int i) {
        this.f12339b = i;
    }

    public String toString() {
        return this.f12338a + ",           " + this.f12339b + ",           ";
    }
}
