package com.p080b;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
/* renamed from: com.b.am */
/* loaded from: classes.dex */
public class C1422am {

    /* renamed from: a */
    private static C1422am f4889a;

    /* renamed from: a */
    public static C1422am m16345a() {
        if (f4889a == null) {
            f4889a = new C1422am();
        }
        return f4889a;
    }

    /* renamed from: a */
    public HttpURLConnection m16343a(AbstractC1428aq abstractC1428aq, boolean z) {
        try {
            m16340c(abstractC1428aq);
            Proxy proxy = abstractC1428aq.f4905c == null ? null : abstractC1428aq.f4905c;
            HttpURLConnection m16335a = (z ? new C1425ao(abstractC1428aq.f4903a, abstractC1428aq.f4904b, proxy, true) : new C1425ao(abstractC1428aq.f4903a, abstractC1428aq.f4904b, proxy, false)).m16335a(abstractC1428aq.m16326e(), abstractC1428aq.mo15505a(), true);
            byte[] m16325f = abstractC1428aq.m16325f();
            if (m16325f != null && m16325f.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(m16335a.getOutputStream());
                dataOutputStream.write(m16325f);
                dataOutputStream.close();
            }
            m16335a.connect();
            return m16335a;
        } catch (C1532dl e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new C1532dl("未知的错误");
        }
    }

    /* renamed from: a */
    public byte[] m16344a(AbstractC1428aq abstractC1428aq) {
        try {
            C1429ar m16341b = m16341b(abstractC1428aq, true);
            if (m16341b == null) {
                return null;
            }
            return m16341b.f4906a;
        } catch (C1532dl e) {
            throw e;
        } catch (Throwable th) {
            throw new C1532dl("未知的错误");
        }
    }

    /* renamed from: b */
    protected C1429ar m16341b(AbstractC1428aq abstractC1428aq, boolean z) {
        try {
            m16340c(abstractC1428aq);
            return new C1425ao(abstractC1428aq.f4903a, abstractC1428aq.f4904b, abstractC1428aq.f4905c == null ? null : abstractC1428aq.f4905c, z).m16334a(abstractC1428aq.m16326e(), abstractC1428aq.mo15505a(), abstractC1428aq.m16325f());
        } catch (C1532dl e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new C1532dl("未知的错误");
        }
    }

    /* renamed from: b */
    public byte[] m16342b(AbstractC1428aq abstractC1428aq) {
        try {
            C1429ar m16341b = m16341b(abstractC1428aq, false);
            if (m16341b == null) {
                return null;
            }
            return m16341b.f4906a;
        } catch (C1532dl e) {
            throw e;
        } catch (Throwable th) {
            C1450b.m16187a(th, "BaseNetManager", "makeSyncPostRequest");
            throw new C1532dl("未知的错误");
        }
    }

    /* renamed from: c */
    protected void m16340c(AbstractC1428aq abstractC1428aq) {
        if (abstractC1428aq == null) {
            throw new C1532dl("requeust is null");
        }
        if (abstractC1428aq.mo15503c() != null && !"".equals(abstractC1428aq.mo15503c())) {
            return;
        }
        throw new C1532dl("request url is empty");
    }
}
