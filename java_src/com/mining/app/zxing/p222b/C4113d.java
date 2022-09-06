package com.mining.app.zxing.p222b;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.mining.app.zxing.activity.MipcaActivityCapture;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mining.app.zxing.b.d */
/* loaded from: classes.dex */
public final class C4113d extends Thread {

    /* renamed from: a */
    public static final String f17200a = "barcode_bitmap";

    /* renamed from: b */
    private final MipcaActivityCapture f17201b;

    /* renamed from: d */
    private Handler f17203d;

    /* renamed from: e */
    private final CountDownLatch f17204e = new CountDownLatch(1);

    /* renamed from: c */
    private final Hashtable<DecodeHintType, Object> f17202c = new Hashtable<>(3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4113d(MipcaActivityCapture mipcaActivityCapture, Vector<BarcodeFormat> vector, String str, ResultPointCallback resultPointCallback) {
        this.f17201b = mipcaActivityCapture;
        if (vector == null || vector.isEmpty()) {
            vector = new Vector<>();
            vector.addAll(C4111b.f17193b);
        }
        this.f17202c.put(DecodeHintType.POSSIBLE_FORMATS, vector);
        if (str != null) {
            this.f17202c.put(DecodeHintType.CHARACTER_SET, str);
        }
        this.f17202c.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Handler m6151a() {
        try {
            this.f17204e.await();
        } catch (InterruptedException e) {
        }
        return this.f17203d;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f17203d = new HandlerC4112c(this.f17201b, this.f17202c);
        this.f17204e.countDown();
        Looper.loop();
    }
}
