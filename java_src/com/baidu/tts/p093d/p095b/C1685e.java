package com.baidu.tts.p093d.p095b;

import com.baidu.tts.client.model.DownloadHandler;
import java.util.concurrent.ConcurrentHashMap;
/* renamed from: com.baidu.tts.d.b.e */
/* loaded from: classes.dex */
public class C1685e {

    /* renamed from: a */
    private static volatile C1685e f5915a = null;

    /* renamed from: b */
    private ConcurrentHashMap<String, C1684d> f5916b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private ConcurrentHashMap<String, C1683c> f5917c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private ConcurrentHashMap<String, C1682b> f5918d = new ConcurrentHashMap<>();

    private C1685e() {
    }

    /* renamed from: a */
    public static C1685e m14958a() {
        if (f5915a == null) {
            synchronized (C1685e.class) {
                if (f5915a == null) {
                    f5915a = new C1685e();
                }
            }
        }
        return f5915a;
    }

    /* renamed from: a */
    public C1684d m14956a(String str) {
        try {
            C1684d c1684d = new C1684d(str);
            C1684d putIfAbsent = this.f5916b.putIfAbsent(str, c1684d);
            return putIfAbsent == null ? c1684d : putIfAbsent;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public void m14957a(DownloadHandler downloadHandler) {
        m14956a(downloadHandler.getModelId()).m14969b(downloadHandler);
    }

    /* renamed from: a */
    public void m14955a(String str, String str2) {
        C1682b m14951d = m14951d(str);
        if (m14951d != null) {
            m14951d.m14992b(str2);
        }
    }

    /* renamed from: b */
    public C1683c m14953b(String str) {
        try {
            C1683c c1683c = new C1683c(str);
            C1683c putIfAbsent = this.f5917c.putIfAbsent(str, c1683c);
            return putIfAbsent == null ? c1683c : putIfAbsent;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    public void m14954b() {
        for (C1684d c1684d : this.f5916b.values()) {
            c1684d.m14977a();
        }
    }

    /* renamed from: c */
    public C1682b m14952c(String str) {
        try {
            C1682b c1682b = new C1682b(str);
            C1682b putIfAbsent = this.f5918d.putIfAbsent(str, c1682b);
            return putIfAbsent == null ? c1682b : putIfAbsent;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: d */
    public C1682b m14951d(String str) {
        C1683c m14953b = m14953b(str);
        if (m14953b != null) {
            return m14952c(m14953b.m14982a());
        }
        return null;
    }

    /* renamed from: e */
    public long m14950e(String str) {
        return m14951d(str).m15001a();
    }

    /* renamed from: f */
    public int m14949f(String str) {
        return m14951d(str).m14989d();
    }
}
