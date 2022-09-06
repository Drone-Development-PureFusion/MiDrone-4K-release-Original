package com.baidu.tts.p093d;

import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.p106k.C1728a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* renamed from: com.baidu.tts.d.d */
/* loaded from: classes.dex */
public class C1688d {

    /* renamed from: b */
    private ConcurrentMap<String, DownloadHandler> f5927b = new ConcurrentHashMap();

    /* renamed from: a */
    private C1686c f5926a = C1686c.m14948a();

    /* renamed from: c */
    private void m14934c() {
        for (DownloadHandler downloadHandler : this.f5927b.values()) {
            downloadHandler.stop();
        }
    }

    /* renamed from: a */
    public DownloadHandler m14938a(C1680b c1680b) {
        DownloadHandler m14936a;
        if (c1680b == null || !c1680b.m15014b() || (m14936a = m14936a(c1680b.m15017a())) == null) {
            return null;
        }
        m14936a.reset(c1680b);
        return this.f5926a.m14947a(m14936a);
    }

    /* renamed from: a */
    public synchronized DownloadHandler m14936a(String str) {
        DownloadHandler downloadHandler;
        try {
            downloadHandler = this.f5927b.get(str);
            if (downloadHandler == null) {
                downloadHandler = new DownloadHandler();
                this.f5927b.put(str, downloadHandler);
            }
        } catch (Exception e) {
            downloadHandler = null;
        }
        return downloadHandler;
    }

    /* renamed from: a */
    public void m14939a() {
        this.f5926a.m14942g();
    }

    /* renamed from: a */
    public void m14937a(C1728a c1728a) {
        this.f5926a.m14945a(c1728a);
    }

    /* renamed from: b */
    public void m14935b() {
        m14934c();
        this.f5926a.mo14680e();
    }
}
