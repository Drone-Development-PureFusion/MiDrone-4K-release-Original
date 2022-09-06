package com.xiaomi.network;

import android.content.Context;
import com.xiaomi.channel.commonutils.network.AbstractC4496c;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class HttpProcessor {

    /* renamed from: a */
    private int f18704a;

    public HttpProcessor(int i) {
        this.f18704a = i;
    }

    /* renamed from: a */
    public int m4749a() {
        return this.f18704a;
    }

    /* renamed from: a */
    public boolean m4748a(Context context, String str, List<AbstractC4496c> list) {
        return true;
    }

    /* renamed from: b */
    public abstract String mo4740b(Context context, String str, List<AbstractC4496c> list);
}
