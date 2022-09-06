package com.amap.api.mapcore.util;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
/* renamed from: com.amap.api.mapcore.util.gx */
/* loaded from: classes.dex */
public class C1057gx {

    /* renamed from: a */
    private static C1057gx f3309a;

    /* renamed from: com.amap.api.mapcore.util.gx$a */
    /* loaded from: classes.dex */
    public interface AbstractC1058a {
        /* renamed from: a */
        URLConnection m17767a(Proxy proxy, URL url);
    }

    /* renamed from: a */
    public static C1057gx m17771a() {
        if (f3309a == null) {
            f3309a = new C1057gx();
        }
        return f3309a;
    }

    /* renamed from: a */
    public C1077hf m17769a(AbstractC1075hd abstractC1075hd, boolean z) {
        try {
            m17768c(abstractC1075hd);
            return new C1069ha(abstractC1075hd.f3367f, abstractC1075hd.f3368g, abstractC1075hd.f3369h == null ? null : abstractC1075hd.f3369h, z).m17718a(abstractC1075hd.m17695k(), abstractC1075hd.mo17702a(), abstractC1075hd.m17694l());
        } catch (C0975ex e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new C0975ex("未知的错误");
        }
    }

    /* renamed from: a */
    public byte[] m17770a(AbstractC1075hd abstractC1075hd) {
        try {
            C1077hf m17769a = m17769a(abstractC1075hd, true);
            if (m17769a == null) {
                return null;
            }
            return m17769a.f3370a;
        } catch (C0975ex e) {
            throw e;
        } catch (Throwable th) {
            throw new C0975ex("未知的错误");
        }
    }

    /* renamed from: b */
    public byte[] mo17705b(AbstractC1075hd abstractC1075hd) {
        try {
            C1077hf m17769a = m17769a(abstractC1075hd, false);
            if (m17769a == null) {
                return null;
            }
            return m17769a.f3370a;
        } catch (C0975ex e) {
            throw e;
        } catch (Throwable th) {
            C1002fl.m18028a(th, "BaseNetManager", "makeSyncPostRequest");
            throw new C0975ex("未知的错误");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m17768c(AbstractC1075hd abstractC1075hd) {
        if (abstractC1075hd == null) {
            throw new C0975ex("requeust is null");
        }
        if (abstractC1075hd.mo17697c() != null && !"".equals(abstractC1075hd.mo17697c())) {
            return;
        }
        throw new C0975ex("request url is empty");
    }
}
