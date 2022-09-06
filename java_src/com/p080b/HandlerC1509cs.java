package com.p080b;

import android.os.Handler;
import android.os.Message;
/* renamed from: com.b.cs */
/* loaded from: classes.dex */
final class HandlerC1509cs extends Handler {

    /* renamed from: a */
    private /* synthetic */ C1508cr f5379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1509cs(C1508cr c1508cr) {
        this.f5379a = c1508cr;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        C1510ct c1510ct;
        C1510ct c1510ct2;
        try {
            switch (message.what) {
                case 0:
                default:
                    return;
                case 1:
                    c1510ct = this.f5379a.f5378a.f5261A;
                    if (c1510ct == null) {
                        return;
                    }
                    c1510ct2 = this.f5379a.f5378a.f5261A;
                    c1510ct2.m15757a((String) message.obj);
                    return;
            }
        } catch (Throwable th) {
        }
    }
}
