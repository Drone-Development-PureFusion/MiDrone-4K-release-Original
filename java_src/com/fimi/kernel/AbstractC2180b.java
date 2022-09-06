package com.fimi.kernel;

import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
/* renamed from: com.fimi.kernel.b */
/* loaded from: classes.dex */
public abstract class AbstractC2180b {

    /* renamed from: a */
    private HandlerC2181a f7326a = new HandlerC2181a();

    /* renamed from: com.fimi.kernel.b$a */
    /* loaded from: classes.dex */
    class HandlerC2181a extends Handler {
        HandlerC2181a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AbstractC2180b.this.mo9399a(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Handler m13332a() {
        return this.f7326a;
    }

    /* renamed from: a */
    protected abstract void mo9399a(Message message);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m13331a(Runnable runnable) {
        C2281x.m12704a(runnable);
    }
}
