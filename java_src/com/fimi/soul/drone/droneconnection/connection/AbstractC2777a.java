package com.fimi.soul.drone.droneconnection.connection;

import android.content.Context;
import com.fimi.soul.biz.p168a.C2367d;
/* renamed from: com.fimi.soul.drone.droneconnection.connection.a */
/* loaded from: classes.dex */
public abstract class AbstractC2777a extends AbstractC2799e {

    /* renamed from: i */
    private static final String f10289i = AbstractC2777a.class.getSimpleName();

    /* renamed from: a */
    protected final Context f10290a;

    /* renamed from: j */
    private boolean f10291j = true;

    public AbstractC2777a(Context context) {
        this.f10290a = context;
    }

    /* renamed from: a */
    protected abstract int mo10986a(byte[] bArr);

    /* renamed from: a */
    protected abstract void mo10989a();

    /* renamed from: a */
    public void m11030a(boolean z) {
        this.f10291j = z;
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: b */
    protected int mo10940b(byte[] bArr) {
        if (this.f10291j) {
            return mo10986a(bArr);
        }
        return 0;
    }

    /* renamed from: b */
    protected abstract void mo10985b();

    /* renamed from: b */
    public void m11029b(boolean z) {
        if (z) {
            this.f10375e = true;
        } else {
            this.f10375e = false;
        }
    }

    /* renamed from: c */
    public boolean m11028c() {
        return this.f10291j;
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: d */
    protected final void mo10937d() {
        mo10985b();
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: e */
    public final void mo10934e() {
        mo10989a();
        k();
        C2367d.m12459a().m12451b(false);
    }
}
