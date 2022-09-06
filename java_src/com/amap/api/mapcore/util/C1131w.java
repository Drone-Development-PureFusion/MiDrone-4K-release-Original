package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Message;
/* renamed from: com.amap.api.mapcore.util.w */
/* loaded from: classes.dex */
class C1131w implements AbstractC1118o {

    /* renamed from: b */
    private AbstractC1115l f3541b;

    /* renamed from: c */
    private boolean f3542c = true;

    /* renamed from: d */
    private boolean f3543d = true;

    /* renamed from: e */
    private boolean f3544e = true;

    /* renamed from: f */
    private boolean f3545f = false;

    /* renamed from: g */
    private boolean f3546g = true;

    /* renamed from: h */
    private boolean f3547h = true;

    /* renamed from: i */
    private boolean f3548i = true;

    /* renamed from: j */
    private boolean f3549j = false;

    /* renamed from: k */
    private int f3550k = 0;

    /* renamed from: l */
    private int f3551l = 1;

    /* renamed from: m */
    private boolean f3552m = true;

    /* renamed from: n */
    private boolean f3553n = false;

    /* renamed from: a */
    final Handler f3540a = new Handler() { // from class: com.amap.api.mapcore.util.w.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || C1131w.this.f3541b == null) {
                return;
            }
            try {
                switch (message.what) {
                    case 0:
                        C1131w.this.f3541b.mo17539a(C1131w.this.f3547h);
                        break;
                    case 1:
                        C1131w.this.f3541b.mo17520e(C1131w.this.f3549j);
                        break;
                    case 2:
                        C1131w.this.f3541b.mo17523d(C1131w.this.f3548i);
                        break;
                    case 3:
                        C1131w.this.f3541b.mo17527c(C1131w.this.f3545f);
                        break;
                    case 4:
                        C1131w.this.f3541b.mo17531b(C1131w.this.f3552m);
                        break;
                }
            } catch (Throwable th) {
                C1007fo.m18012b(th, "UiSettingsDelegateImp", "handleMessage");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1131w(AbstractC1115l abstractC1115l) {
        this.f3541b = abstractC1115l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public float getLogoMarginRate(int i) {
        return this.f3541b.mo17521e(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public int getLogoPosition() {
        return this.f3550k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public int getZoomPosition() {
        return this.f3551l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isCompassEnabled() {
        return this.f3548i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isIndoorSwitchEnabled() {
        return this.f3552m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isMyLocationButtonEnabled() {
        return this.f3545f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isRotateGesturesEnabled() {
        return this.f3542c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isScaleControlsEnabled() {
        return this.f3549j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isScrollGesturesEnabled() {
        return this.f3543d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isTiltGesturesEnabled() {
        return this.f3544e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomControlsEnabled() {
        return this.f3547h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomGesturesEnabled() {
        return this.f3546g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomInByScreenCenter() {
        return this.f3553n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setTiltGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setScrollGesturesEnabled(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setCompassEnabled(boolean z) {
        this.f3548i = z;
        this.f3540a.obtainMessage(2).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setIndoorSwitchEnabled(boolean z) {
        this.f3552m = z;
        this.f3540a.obtainMessage(4).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoBottomMargin(int i) {
        this.f3541b.mo17529c(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoLeftMargin(int i) {
        this.f3541b.mo17525d(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoMarginRate(int i, float f) {
        this.f3541b.mo17552a(i, f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoPosition(int i) {
        this.f3550k = i;
        this.f3541b.mo17536b(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setMyLocationButtonEnabled(boolean z) {
        this.f3545f = z;
        this.f3540a.obtainMessage(3).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setRotateGesturesEnabled(boolean z) {
        this.f3542c = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setScaleControlsEnabled(boolean z) {
        this.f3549j = z;
        this.f3540a.obtainMessage(1).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setScrollGesturesEnabled(boolean z) {
        this.f3543d = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setTiltGesturesEnabled(boolean z) {
        this.f3544e = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomControlsEnabled(boolean z) {
        this.f3547h = z;
        this.f3540a.obtainMessage(0).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomGesturesEnabled(boolean z) {
        this.f3546g = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomInByScreenCenter(boolean z) {
        this.f3553n = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomPosition(int i) {
        this.f3551l = i;
        this.f3541b.mo17518f(i);
    }
}
