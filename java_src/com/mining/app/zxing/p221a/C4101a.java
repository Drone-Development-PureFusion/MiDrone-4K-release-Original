package com.mining.app.zxing.p221a;

import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
/* renamed from: com.mining.app.zxing.a.a */
/* loaded from: classes.dex */
final class C4101a implements Camera.AutoFocusCallback {

    /* renamed from: a */
    private static final String f17128a = C4101a.class.getSimpleName();

    /* renamed from: b */
    private static final long f17129b = 1500;

    /* renamed from: c */
    private Handler f17130c;

    /* renamed from: d */
    private int f17131d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m6202a(Handler handler, int i) {
        this.f17130c = handler;
        this.f17131d = i;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, Camera camera) {
        if (this.f17130c == null) {
            Log.d(f17128a, "Got auto-focus callback, but no handler for it");
            return;
        }
        this.f17130c.sendMessageDelayed(this.f17130c.obtainMessage(this.f17131d, Boolean.valueOf(z)), f17129b);
        this.f17130c = null;
    }
}
