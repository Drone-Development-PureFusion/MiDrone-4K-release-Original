package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.channel.commonutils.misc.C4488h;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.channel.commonutils.misc.i */
/* loaded from: classes2.dex */
public class HandlerC4491i extends Handler {

    /* renamed from: a */
    final /* synthetic */ C4488h f18565a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC4491i(C4488h c4488h, Looper looper) {
        super(looper);
        this.f18565a = c4488h;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C4488h.AbstractC4490b abstractC4490b = (C4488h.AbstractC4490b) message.obj;
        if (message.what == 0) {
            abstractC4490b.m5006a();
        } else if (message.what == 1) {
            abstractC4490b.mo4323c();
        }
        super.handleMessage(message);
    }
}
