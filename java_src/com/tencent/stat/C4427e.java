package com.tencent.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;
/* renamed from: com.tencent.stat.e */
/* loaded from: classes2.dex */
class C4427e extends DefaultConnectionKeepAliveStrategy {

    /* renamed from: a */
    final /* synthetic */ C4426d f18475a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4427e(C4426d c4426d) {
        this.f18475a = c4426d;
    }

    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
        if (keepAliveDuration == -1) {
            return 20000L;
        }
        return keepAliveDuration;
    }
}
