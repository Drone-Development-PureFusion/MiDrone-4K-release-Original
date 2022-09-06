package com.mining.app.zxing.p221a;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mining.app.zxing.a.f */
/* loaded from: classes.dex */
public final class C4106f implements Camera.PreviewCallback {

    /* renamed from: a */
    private static final String f17168a = C4106f.class.getSimpleName();

    /* renamed from: b */
    private final C4102b f17169b;

    /* renamed from: c */
    private final boolean f17170c;

    /* renamed from: d */
    private Handler f17171d;

    /* renamed from: e */
    private int f17172e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4106f(C4102b c4102b, boolean z) {
        this.f17169b = c4102b;
        this.f17170c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m6163a(Handler handler, int i) {
        this.f17171d = handler;
        this.f17172e = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point m6201a = this.f17169b.m6201a();
        if (!this.f17170c) {
            camera.setPreviewCallback(null);
        }
        if (this.f17171d == null) {
            Log.d(f17168a, "Got preview callback, but no handler for it");
            return;
        }
        this.f17171d.obtainMessage(this.f17172e, m6201a.x, m6201a.y, bArr).sendToTarget();
        this.f17171d = null;
    }
}
