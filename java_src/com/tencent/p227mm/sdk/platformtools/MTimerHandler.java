package com.tencent.p227mm.sdk.platformtools;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* renamed from: com.tencent.mm.sdk.platformtools.MTimerHandler */
/* loaded from: classes.dex */
public class MTimerHandler extends Handler {

    /* renamed from: av */
    private static int f17835av;

    /* renamed from: aG */
    private final boolean f17836aG;

    /* renamed from: aI */
    private final CallBack f17838aI;

    /* renamed from: aH */
    private long f17837aH = 0;

    /* renamed from: aw */
    private final int f17839aw = m5637d();

    /* renamed from: com.tencent.mm.sdk.platformtools.MTimerHandler$CallBack */
    /* loaded from: classes.dex */
    public interface CallBack {
        boolean onTimerExpired();
    }

    public MTimerHandler(Looper looper, CallBack callBack, boolean z) {
        super(looper);
        this.f17838aI = callBack;
        this.f17836aG = z;
    }

    public MTimerHandler(CallBack callBack, boolean z) {
        this.f17838aI = callBack;
        this.f17836aG = z;
    }

    /* renamed from: d */
    private static int m5637d() {
        if (f17835av >= 8192) {
            f17835av = 0;
        }
        int i = f17835av + 1;
        f17835av = i;
        return i;
    }

    protected void finalize() {
        stopTimer();
        super.finalize();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != this.f17839aw || this.f17838aI == null || !this.f17838aI.onTimerExpired() || !this.f17836aG) {
            return;
        }
        sendEmptyMessageDelayed(this.f17839aw, this.f17837aH);
    }

    public void startTimer(long j) {
        this.f17837aH = j;
        stopTimer();
        sendEmptyMessageDelayed(this.f17839aw, j);
    }

    public void stopTimer() {
        removeMessages(this.f17839aw);
    }

    public boolean stopped() {
        return !hasMessages(this.f17839aw);
    }
}
