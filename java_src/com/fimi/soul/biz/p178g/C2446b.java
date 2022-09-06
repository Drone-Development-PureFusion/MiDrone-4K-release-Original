package com.fimi.soul.biz.p178g;

import java.util.Observable;
/* renamed from: com.fimi.soul.biz.g.b */
/* loaded from: classes.dex */
public class C2446b extends Observable {

    /* renamed from: a */
    private boolean f8427a;

    /* renamed from: a */
    public void m12159a(boolean z) {
        if ((!this.f8427a) == z) {
            setChanged();
            notifyObservers();
        }
        this.f8427a = z;
    }

    /* renamed from: a */
    public boolean m12160a() {
        return this.f8427a;
    }
}
