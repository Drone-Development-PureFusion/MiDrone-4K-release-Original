package com.mining.app.zxing.p222b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.fimi.soul.C2300R;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.mining.app.zxing.activity.MipcaActivityCapture;
import com.mining.app.zxing.p221a.C4103c;
import com.mining.app.zxing.p221a.C4105e;
import java.util.Hashtable;
/* renamed from: com.mining.app.zxing.b.c */
/* loaded from: classes.dex */
final class HandlerC4112c extends Handler {

    /* renamed from: a */
    private static final String f17197a = HandlerC4112c.class.getSimpleName();

    /* renamed from: b */
    private final MipcaActivityCapture f17198b;

    /* renamed from: c */
    private final MultiFormatReader f17199c = new MultiFormatReader();

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC4112c(MipcaActivityCapture mipcaActivityCapture, Hashtable<DecodeHintType, Object> hashtable) {
        this.f17199c.setHints(hashtable);
        this.f17198b = mipcaActivityCapture;
    }

    /* renamed from: a */
    private void m6152a(byte[] bArr, int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        Result result = null;
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        C4105e m6183a = C4103c.m6188a().m6183a(bArr2, i2, i);
        try {
            result = this.f17199c.decodeWithState(new BinaryBitmap(new HybridBinarizer(m6183a)));
        } catch (ReaderException e) {
        } finally {
            this.f17199c.reset();
        }
        if (result == null) {
            Message.obtain(this.f17198b.m6159b(), (int) C2300R.C2302id.decode_failed).sendToTarget();
            return;
        }
        Log.d(f17197a, "Found barcode (" + (System.currentTimeMillis() - currentTimeMillis) + " ms):\n" + result.toString());
        Message obtain = Message.obtain(this.f17198b.m6159b(), C2300R.C2302id.decode_succeeded, result);
        Bundle bundle = new Bundle();
        bundle.putParcelable(C4113d.f17200a, m6183a.m6164c());
        obtain.setData(bundle);
        obtain.sendToTarget();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case C2300R.C2302id.decode /* 2131492869 */:
                m6152a((byte[]) message.obj, message.arg1, message.arg2);
                return;
            case C2300R.C2302id.quit /* 2131492875 */:
                Looper.myLooper().quit();
                return;
            default:
                return;
        }
    }
}
