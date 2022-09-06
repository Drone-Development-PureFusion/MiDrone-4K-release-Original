package com.fimi.soul.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.fimi.kernel.C2238c;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
/* loaded from: classes.dex */
public class DroneFaultService extends Service implements C2678d.AbstractC2680b {

    /* renamed from: a */
    public C2657a f14687a;

    /* renamed from: b */
    public DroidPlannerApp f14688b;

    /* renamed from: com.fimi.soul.service.DroneFaultService$1 */
    /* loaded from: classes.dex */
    static /* synthetic */ class C36061 {

        /* renamed from: a */
        static final /* synthetic */ int[] f14689a = new int[C2678d.EnumC2679a.values().length];
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f14688b = (DroidPlannerApp) getApplication();
        this.f14687a = this.f14688b.f7895a;
        this.f14687a.mo11219a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        startService(new Intent(this, DroneFaultService.class));
        this.f14687a.mo11214b(this);
        super.onDestroy();
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (C2238c.m13124d() == null) {
            stopSelf();
        } else {
            int i = C36061.f14689a[enumC2679a.ordinal()];
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
