package com.fimi.soul.module.dronemanage;

import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.PolylineOptions;
import com.fimi.kernel.utils.C2281x;
/* renamed from: com.fimi.soul.module.dronemanage.i */
/* loaded from: classes.dex */
abstract class AbstractC3247i {

    /* renamed from: a */
    private HandlerC3248a f12507a = new HandlerC3248a();

    /* renamed from: b */
    public PolylineOptions f12508b = new PolylineOptions();

    /* renamed from: com.fimi.soul.module.dronemanage.i$a */
    /* loaded from: classes.dex */
    class HandlerC3248a extends Handler {
        HandlerC3248a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AbstractC3247i.this.mo8961a(message);
        }
    }

    public AbstractC3247i() {
        this.f12508b.color(-256).width(5.0f);
    }

    /* renamed from: a */
    protected abstract void mo8961a(Message message);

    /* renamed from: a */
    protected void m8965a(Runnable runnable) {
        C2281x.m12704a(runnable);
    }

    /* renamed from: h */
    public void mo8942h() {
        if (this.f12508b != null) {
            this.f12508b = null;
            this.f12508b = new PolylineOptions();
            this.f12508b.color(-256).width(5.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public Handler m8964i() {
        return this.f12507a;
    }
}
