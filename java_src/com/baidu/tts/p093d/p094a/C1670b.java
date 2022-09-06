package com.baidu.tts.p093d.p094a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.p096e.EnumC1709l;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p097f.p098a.ThreadFactoryC1714a;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p104i.AbstractC1722a;
import com.baidu.tts.p106k.C1728a;
import com.baidu.tts.tools.FileTools;
import com.baidu.tts.tools.StringTool;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;
/* renamed from: com.baidu.tts.d.a.b */
/* loaded from: classes.dex */
public class C1670b extends AbstractC1722a {

    /* renamed from: h */
    private ThreadPoolExecutor f5883h;

    /* renamed from: i */
    private C1728a f5884i;

    /* renamed from: b */
    private C1679i f5879b = new C1679i(this);

    /* renamed from: c */
    private C1676f f5880c = new C1676f(this);

    /* renamed from: f */
    private C1674d f5881f = new C1674d(this);

    /* renamed from: g */
    private C1678h f5882g = new C1678h(this);

    /* renamed from: a */
    private volatile AbstractC1669a f5878a = this.f5879b;

    /* renamed from: com.baidu.tts.d.a.b$a */
    /* loaded from: classes.dex */
    public class CallableC1671a implements Callable<Void> {

        /* renamed from: b */
        private C1673c f5886b;

        /* renamed from: c */
        private SyncHttpClient f5887c;

        public CallableC1671a(C1673c c1673c) {
            this.f5886b = c1673c;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            this.f5886b.m15024d();
            final String m15030a = this.f5886b.m15030a();
            LoggerProxy.m15091d("DownloadEngine", "DownloadWork start fileId=" + m15030a);
            if (StringTool.isEmpty(m15030a)) {
                this.f5886b.m15028a(C1717c.m14880a().m14875a(EnumC1711n.MODEL_REQUEST_ERROR, "fileId is null"));
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(m15030a);
                ModelFileBags modelFileBags = C1670b.this.f5884i.m14823a(hashSet).get();
                if (modelFileBags != null) {
                    String url = modelFileBags.getUrl(0);
                    if (url != null) {
                        this.f5887c = new SyncHttpClient();
                        this.f5887c.setURLEncodingEnabled(false);
                        this.f5887c.setTimeout(EnumC1709l.DEFAULT.m14890b());
                        this.f5887c.setMaxRetriesAndTimeout(5, 1500);
                        C1677g c1677g = new C1677g(FileTools.getFile(this.f5886b.m15026b()), this.f5886b) { // from class: com.baidu.tts.d.a.b.a.1
                            @Override // com.baidu.tts.p093d.p094a.C1677g, com.baidu.tts.loopj.FileAsyncHttpResponseHandler
                            public void onFailure(int i, Header[] headerArr, Throwable th, File file) {
                                LoggerProxy.m15091d("DownloadEngine", "1isInterrupted=" + Thread.currentThread().isInterrupted());
                                if (C1670b.this.A()) {
                                    super.onFailure(i, headerArr, th, file);
                                }
                            }

                            @Override // com.baidu.tts.p093d.p094a.C1677g, com.baidu.tts.loopj.AsyncHttpResponseHandler
                            public void onProgress(long j, long j2) {
                                if (C1670b.this.A()) {
                                    super.onProgress(j, j2);
                                }
                            }

                            @Override // com.baidu.tts.p093d.p094a.C1677g, com.baidu.tts.loopj.FileAsyncHttpResponseHandler
                            public void onSuccess(int i, Header[] headerArr, File file) {
                                LoggerProxy.m15091d("DownloadEngine", "2isInterrupted=" + Thread.currentThread().isInterrupted() + "--fileId=" + m15030a);
                                if (C1670b.this.A()) {
                                    super.onSuccess(i, headerArr, file);
                                }
                            }
                        };
                        c1677g.setUseSynchronousMode(true);
                        LoggerProxy.m15091d("DownloadEngine", "before get fileId=" + m15030a);
                        this.f5887c.get(url, c1677g);
                    } else {
                        this.f5886b.m15028a(C1717c.m14880a().m14875a(EnumC1711n.MODEL_REQUEST_ERROR, "url is null"));
                    }
                } else {
                    this.f5886b.m15028a(C1717c.m14880a().m14875a(EnumC1711n.MODEL_REQUEST_ERROR, "urlbags is null"));
                }
            }
            LoggerProxy.m15091d("DownloadEngine", "DownloadWork end");
            return null;
        }

        /* renamed from: b */
        public void m15032b() {
            if (this.f5887c != null) {
                this.f5887c.stop();
            }
        }

        /* renamed from: c */
        public C1673c m15031c() {
            return this.f5886b;
        }
    }

    public C1670b() {
        b();
    }

    /* renamed from: a */
    public AbstractC1669a m15045a() {
        return this.f5878a;
    }

    /* renamed from: a */
    public C1675e m15042a(C1673c c1673c) {
        return this.f5878a.mo15018a(c1673c);
    }

    /* renamed from: a */
    public void m15044a(AbstractC1669a abstractC1669a) {
        this.f5878a = abstractC1669a;
    }

    /* renamed from: a */
    public void m15041a(C1728a c1728a) {
        this.f5884i = c1728a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public C1675e m15040b(C1673c c1673c) {
        CallableC1671a callableC1671a = new CallableC1671a(c1673c);
        c1673c.m15025c();
        LoggerProxy.m15091d("DownloadEngine", "before submit");
        Future<Void> future = null;
        try {
            future = this.f5883h.submit(callableC1671a);
        } catch (Exception e) {
            LoggerProxy.m15091d("DownloadEngine", "submit exception");
            c1673c.m15028a(C1717c.m14880a().m14874a(EnumC1711n.MODEL_FILE_DOWNLOAD_EXCEPTION, e));
        }
        C1675e c1675e = new C1675e();
        c1675e.m15020a(future);
        c1675e.m15021a(callableC1671a);
        return c1675e;
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: g */
    protected TtsError mo14843g() {
        return this.f5878a.mo14683b();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: h */
    protected void mo14842h() {
        this.f5878a.mo15019a();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: i */
    protected void mo14841i() {
        this.f5878a.mo14682c();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: j */
    protected void mo14840j() {
        this.f5878a.mo14681d();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: k */
    protected void mo14839k() {
        this.f5878a.mo14680e();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: l */
    protected void mo14838l() {
        this.f5878a.mo14679f();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: m */
    public boolean mo14837m() {
        return this.f5878a == this.f5882g;
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: n */
    public boolean mo14836n() {
        return Thread.currentThread().isInterrupted() || this.f5878a == this.f5880c;
    }

    /* renamed from: o */
    public C1679i m15039o() {
        return this.f5879b;
    }

    /* renamed from: p */
    public C1676f m15038p() {
        return this.f5880c;
    }

    /* renamed from: q */
    public C1674d m15037q() {
        return this.f5881f;
    }

    /* renamed from: r */
    public C1678h m15036r() {
        return this.f5882g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public void m15035s() {
        this.f5883h = (ThreadPoolExecutor) Executors.newFixedThreadPool(5, new ThreadFactoryC1714a("downloadPoolThread"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public void m15034t() {
        LoggerProxy.m15091d("DownloadEngine", "enter stop");
        if (this.f5883h != null) {
            if (!this.f5883h.isShutdown()) {
                this.f5883h.shutdownNow();
            }
            try {
                LoggerProxy.m15091d("DownloadEngine", "before awaitTermination");
                LoggerProxy.m15091d("DownloadEngine", "after awaitTermination isTermination=" + this.f5883h.awaitTermination(EnumC1709l.DEFAULT.m14891a(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
            }
            this.f5883h = null;
        }
        LoggerProxy.m15091d("DownloadEngine", "end stop");
    }
}
