package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.v */
/* loaded from: classes2.dex */
public class HandlerC4547v extends Handler {

    /* renamed from: a */
    final /* synthetic */ C4545u f18676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC4547v(C4545u c4545u, Looper looper) {
        super(looper);
        this.f18676a = c4545u;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        String str = (String) message.obj;
        int i = message.arg1;
        synchronized (C4540p.class) {
            context = this.f18676a.f18668c;
            if (C4540p.m4845a(context).m4840e(str)) {
                context2 = this.f18676a.f18668c;
                if (C4540p.m4845a(context2).m4842c(str) < 10) {
                    if (1 == i) {
                        context6 = this.f18676a.f18668c;
                        if ("disable_syncing".equals(C4540p.m4845a(context6).m4846a())) {
                            this.f18676a.m4810a(str, true);
                            context5 = this.f18676a.f18668c;
                            C4540p.m4845a(context5).m4843b(str);
                        }
                    }
                    if (i == 0) {
                        context4 = this.f18676a.f18668c;
                        if ("enable_syncing".equals(C4540p.m4845a(context4).m4846a())) {
                            this.f18676a.m4810a(str, false);
                        }
                    }
                    context5 = this.f18676a.f18668c;
                    C4540p.m4845a(context5).m4843b(str);
                } else {
                    context3 = this.f18676a.f18668c;
                    C4540p.m4845a(context3).m4841d(str);
                }
            }
        }
    }
}
