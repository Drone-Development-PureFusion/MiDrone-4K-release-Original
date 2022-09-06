package com.baidu.tts.p093d.p095b;

import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.database.C1691a;
/* renamed from: com.baidu.tts.d.b.a */
/* loaded from: classes.dex */
public class C1681a {

    /* renamed from: a */
    private static volatile C1681a f5896a = null;

    /* renamed from: b */
    private C1685e f5897b = C1685e.m14958a();

    /* renamed from: c */
    private C1691a f5898c;

    private C1681a() {
    }

    /* renamed from: a */
    public static C1681a m15012a() {
        if (f5896a == null) {
            synchronized (C1681a.class) {
                if (f5896a == null) {
                    f5896a = new C1681a();
                }
            }
        }
        return f5896a;
    }

    /* renamed from: a */
    public C1682b m15009a(String str) {
        return this.f5897b.m14952c(str);
    }

    /* renamed from: a */
    public void m15011a(DownloadHandler downloadHandler) {
        this.f5897b.m14957a(downloadHandler);
    }

    /* renamed from: a */
    public void m15010a(C1691a c1691a) {
        this.f5898c = c1691a;
    }

    /* renamed from: a */
    public void m15008a(String str, String str2) {
        this.f5897b.m14955a(str, str2);
    }

    /* renamed from: b */
    public C1684d m15006b(String str) {
        return this.f5897b.m14956a(str);
    }

    /* renamed from: b */
    public C1691a m15007b() {
        return this.f5898c;
    }

    /* renamed from: c */
    public C1683c m15004c(String str) {
        return this.f5897b.m14953b(str);
    }

    /* renamed from: c */
    public void m15005c() {
        this.f5897b.m14954b();
    }

    /* renamed from: d */
    public long m15003d(String str) {
        return this.f5897b.m14950e(str);
    }

    /* renamed from: e */
    public int m15002e(String str) {
        return this.f5897b.m14949f(str);
    }
}
