package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.push.service.C4622ao;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.w */
/* loaded from: classes2.dex */
public class C4548w extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ C4545u f18677a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4548w(C4545u c4545u, Handler handler) {
        super(handler);
        this.f18677a = c4545u;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        C4545u c4545u = this.f18677a;
        context = this.f18677a.f18668c;
        c4545u.f18672h = Integer.valueOf(C4622ao.m4356a(context).m4355b());
        num = this.f18677a.f18672h;
        if (num.intValue() != 0) {
            context2 = this.f18677a.f18668c;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.f18677a.f18668c;
            if (!C4497d.m4985d(context3)) {
                return;
            }
            this.f18677a.m4797d();
        }
    }
}
