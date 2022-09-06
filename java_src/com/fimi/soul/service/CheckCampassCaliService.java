package com.fimi.soul.service;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.model.LatLng;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p185n.C2571k;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.entity.CheckCampssBeann;
import com.fimi.soul.module.update.p210a.C3582d;
import com.fimi.soul.utils.C3632ab;
/* loaded from: classes.dex */
public class CheckCampassCaliService extends IntentService {

    /* renamed from: a */
    DroidPlannerApp f14670a;

    /* renamed from: b */
    private AMapLocation f14671b;

    public CheckCampassCaliService() {
        super("CheckCampassCaliService");
    }

    public CheckCampassCaliService(String str) {
        super(str);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f14670a = (DroidPlannerApp) getApplication();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        C3582d.m7928a(this.f14670a.f7895a);
        this.f14670a.f7895a.mo11220a(C2678d.EnumC2679a.XIAOMI_INSURENCE);
        CheckCampssBeann checkCampssBeann = (CheckCampssBeann) C2241c.m13122a().mo13118a(C2854c.f10520Z, CheckCampssBeann.class);
        if (checkCampssBeann == null) {
            this.f14670a.f7895a.mo11220a(C2678d.EnumC2679a.SHOWCAMPASSCALI);
            return;
        }
        Location m11639d = C2571k.m11651a(this).m11639d();
        if (m11639d == null) {
            this.f14670a.f7895a.mo11220a(C2678d.EnumC2679a.SHOWCAMPASSCALI);
            return;
        }
        LatLng latLng = new LatLng(m11639d.getLatitude(), m11639d.getLongitude());
        double d = 0.0d;
        for (LatLng latLng2 : checkCampssBeann.getListLatlng()) {
            d = C3632ab.m7729c(latLng, latLng2).m7698a();
            if (d <= 3000.0d) {
                break;
            }
        }
        if (d <= 3000.0d) {
            return;
        }
        this.f14670a.f7895a.mo11220a(C2678d.EnumC2679a.SHOWCAMPASSCALI);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }
}
