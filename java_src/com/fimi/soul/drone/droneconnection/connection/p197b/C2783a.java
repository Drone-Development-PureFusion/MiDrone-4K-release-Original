package com.fimi.soul.drone.droneconnection.connection.p197b;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.fimi.soul.drone.droneconnection.connection.AbstractC2777a;
import com.fimi.soul.drone.p202h.C2854c;
/* renamed from: com.fimi.soul.drone.droneconnection.connection.b.a */
/* loaded from: classes.dex */
public class C2783a extends AbstractC2777a {

    /* renamed from: i */
    private final AbstractC2785b f10313i;

    public C2783a(Context context) {
        super(context);
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.f10313i = new AbstractC2785b() { // from class: com.fimi.soul.drone.droneconnection.connection.b.a.1
            @Override // com.fimi.soul.drone.droneconnection.connection.p197b.AbstractC2785b
            /* renamed from: a */
            protected int mo11006a() {
                return Integer.parseInt(defaultSharedPreferences.getString(C2854c.f10621i, C2854c.f10623k));
            }

            @Override // com.fimi.soul.drone.droneconnection.connection.p197b.AbstractC2785b
            /* renamed from: b */
            protected String mo11001b() {
                return defaultSharedPreferences.getString(C2854c.f10622j, C2854c.m10763b());
            }
        };
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2777a
    /* renamed from: a */
    protected int mo10986a(byte[] bArr) {
        return this.f10313i.mo10940b(bArr);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2777a
    /* renamed from: a */
    protected void mo10989a() {
        this.f10313i.mo10934e();
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2777a
    /* renamed from: b */
    protected void mo10985b() {
        this.f10313i.mo10937d();
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: d */
    protected void mo10935d(byte[] bArr) {
        this.f10313i.mo10935d(bArr);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: j */
    public int mo10926j() {
        return this.f10313i.mo10926j();
    }
}
