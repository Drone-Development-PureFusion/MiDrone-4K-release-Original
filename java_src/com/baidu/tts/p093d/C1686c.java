package com.baidu.tts.p093d;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.C1691a;
import com.baidu.tts.p093d.p094a.C1670b;
import com.baidu.tts.p093d.p094a.C1673c;
import com.baidu.tts.p093d.p095b.C1681a;
import com.baidu.tts.p093d.p095b.C1682b;
import com.baidu.tts.p093d.p095b.C1683c;
import com.baidu.tts.p093d.p095b.C1684d;
import com.baidu.tts.p096e.EnumC1709l;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p104i.AbstractC1724b;
import com.baidu.tts.p106k.C1728a;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* renamed from: com.baidu.tts.d.c */
/* loaded from: classes.dex */
public class C1686c implements AbstractC1724b {

    /* renamed from: a */
    private static volatile C1686c f5919a = null;

    /* renamed from: b */
    private C1728a f5920b;

    /* renamed from: c */
    private C1681a f5921c = C1681a.m15012a();

    /* renamed from: d */
    private C1670b f5922d = new C1670b();

    /* renamed from: e */
    private ExecutorService f5923e;

    /* renamed from: com.baidu.tts.d.c$a */
    /* loaded from: classes.dex */
    public class CallableC1687a implements Callable<C1668a> {

        /* renamed from: b */
        private DownloadHandler f5925b;

        public CallableC1687a(DownloadHandler downloadHandler) {
            this.f5925b = downloadHandler;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public C1668a call() {
            C1668a c1668a = new C1668a();
            C1691a m14816e = C1686c.this.f5920b.m14816e();
            String modelId = this.f5925b.getModelId();
            C1684d m15006b = C1686c.this.f5921c.m15006b(modelId);
            try {
                m15006b.m14966c(this.f5925b);
                if (!m15006b.m14971a(m14816e)) {
                    Conditions conditions = new Conditions();
                    conditions.appendId(modelId);
                    ModelBags modelBags = C1686c.this.f5920b.m14827a(conditions).get();
                    if (modelBags == null || modelBags.isEmpty()) {
                        m15006b.m14975a(this.f5925b, C1717c.m14880a().m14875a(EnumC1711n.MODEL_BAGS_EMPTY, "modelId=" + modelId));
                        return c1668a;
                    }
                    m15006b.m14974a(modelBags, m14816e);
                }
                Set<String> m14963f = m15006b.m14963f();
                if (DataTool.isSetEmpty(m14963f)) {
                    m15006b.m14975a(this.f5925b, C1717c.m14880a().m14875a(EnumC1711n.MODEL_DB_MODEL_INVALID, "modelId=" + modelId));
                    return c1668a;
                }
                for (String str : m14963f) {
                    C1683c m15004c = C1686c.this.f5921c.m15004c(str);
                    if (!m15004c.m14980a(m14816e)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(str);
                        ModelFileBags modelFileBags = C1686c.this.f5920b.m14823a(hashSet).get();
                        if (modelFileBags == null || modelFileBags.isEmpty()) {
                            m15006b.m14975a(this.f5925b, C1717c.m14880a().m14875a(EnumC1711n.MODEL_FILE_BAG_EMPTY, "fileId=" + str));
                            return c1668a;
                        }
                        modelFileBags.generateAbsPath(C1686c.this.f5920b.m14817d());
                        m15004c.m14981a(modelFileBags, m14816e);
                    }
                }
                m15006b.m14965d();
                Set<String> m14970b = m15006b.m14970b();
                if (DataTool.isSetEmpty(m14970b)) {
                    m15006b.m14975a(this.f5925b, C1717c.m14880a().m14875a(EnumC1711n.MODEL_DB_MODEL_FILE_PATHS_INVALID, "modelId=" + modelId));
                    return c1668a;
                }
                for (String str2 : m14970b) {
                    if (!StringTool.isEmpty(str2)) {
                        C1682b m15009a = C1686c.this.f5921c.m15009a(str2);
                        m15009a.m14995a(modelId);
                        boolean m14996a = m15009a.m14996a(m14816e);
                        String m14991c = m15009a.m14991c();
                        LoggerProxy.m15091d("Downloader", "isNeedDownload=" + m14996a + "--fileId=" + m14991c);
                        if (m14996a) {
                            if (m15009a.m14988e()) {
                                m15009a.m14987f();
                            }
                            C1673c c1673c = new C1673c();
                            c1673c.m15027a(m15009a);
                            if (Thread.currentThread().isInterrupted()) {
                                return null;
                            }
                            LoggerProxy.m15091d("Downloader", "before download fileId=" + m14991c);
                            m15009a.m14998a(C1686c.this.f5922d.m15042a(c1673c));
                            c1668a.m15048a(true);
                        } else {
                            c1668a.m15049a(str2, m15009a.m14989d());
                        }
                    }
                }
                if (!c1668a.m15050a() && c1668a.m15047b()) {
                    this.f5925b.updateProgress(m15006b);
                    m15006b.m14975a(this.f5925b, C1717c.m14880a().m14875a(EnumC1711n.MODEL_EXISTS, "modelId=" + modelId));
                }
                return c1668a;
            } catch (Exception e) {
                LoggerProxy.m15091d("Downloader", "exception=" + e.toString());
                m15006b.m14975a(this.f5925b, C1717c.m14880a().m14875a(EnumC1711n.MODEL_CHECK_EXCEPTION, "modelId=" + modelId));
                return c1668a;
            }
        }
    }

    private C1686c() {
    }

    /* renamed from: a */
    public static C1686c m14948a() {
        if (f5919a == null) {
            synchronized (C1686c.class) {
                if (f5919a == null) {
                    f5919a = new C1686c();
                }
            }
        }
        return f5919a;
    }

    /* renamed from: h */
    private synchronized ExecutorService m14941h() {
        if (this.f5923e == null) {
            this.f5923e = Executors.newSingleThreadExecutor();
        }
        return this.f5923e;
    }

    /* renamed from: a */
    public synchronized DownloadHandler m14947a(DownloadHandler downloadHandler) {
        LoggerProxy.m15091d("Downloader", "download handler=" + downloadHandler);
        downloadHandler.setCheckFuture(m14941h().submit(new CallableC1687a(downloadHandler)));
        return downloadHandler;
    }

    /* renamed from: a */
    public void m14945a(C1728a c1728a) {
        this.f5920b = c1728a;
        this.f5921c.m15010a(this.f5920b.m14816e());
        this.f5922d.m15041a(this.f5920b);
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: b */
    public synchronized TtsError mo14683b() {
        return null;
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: c */
    public synchronized void mo14682c() {
        this.f5922d.c();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: d */
    public synchronized void mo14681d() {
        this.f5922d.d();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: e */
    public synchronized void mo14680e() {
        LoggerProxy.m15091d("Downloader", "enter stop");
        this.f5921c.m15005c();
        if (this.f5923e != null) {
            if (!this.f5923e.isShutdown()) {
                this.f5923e.shutdownNow();
                this.f5922d.e();
                LoggerProxy.m15091d("Downloader", "after engine stop");
            }
            try {
                LoggerProxy.m15091d("Downloader", "before awaitTermination");
                LoggerProxy.m15091d("Downloader", "after awaitTermination isTermination=" + this.f5923e.awaitTermination(EnumC1709l.DEFAULT.m14891a(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
            }
            this.f5923e = null;
        }
        LoggerProxy.m15091d("Downloader", "end stop");
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: f */
    public synchronized void mo14679f() {
    }

    /* renamed from: g */
    public synchronized void m14942g() {
        m14941h();
        this.f5922d.y();
    }
}
