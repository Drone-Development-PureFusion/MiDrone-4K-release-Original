package com.baidu.tts.chainofresponsibility.logger;

import android.util.Log;
import com.baidu.tts.p097f.p098a.ThreadFactoryC1714a;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* renamed from: com.baidu.tts.chainofresponsibility.logger.d */
/* loaded from: classes.dex */
public class C1662d {

    /* renamed from: a */
    private static volatile C1662d f5812a = null;

    /* renamed from: e */
    private C1666e f5816e = new C1666e();

    /* renamed from: f */
    private EnumC1664a f5817f = EnumC1664a.RELEASE;

    /* renamed from: g */
    private boolean f5818g = false;

    /* renamed from: b */
    private List<AbstractC1660b> f5813b = m15064g();

    /* renamed from: d */
    private C1667f f5815d = new C1667f();

    /* renamed from: c */
    private ExecutorService f5814c = Executors.newSingleThreadExecutor(new ThreadFactoryC1714a("LoggerChainPoolThread"));

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tts.chainofresponsibility.logger.d$a */
    /* loaded from: classes.dex */
    public enum EnumC1664a {
        DEVELOP,
        RELEASE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tts.chainofresponsibility.logger.d$b */
    /* loaded from: classes.dex */
    public class RunnableC1665b implements Runnable {

        /* renamed from: b */
        private C1661c f5824b;

        public RunnableC1665b(C1661c c1661c) {
            this.f5824b = c1661c;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (AbstractC1660b abstractC1660b : C1662d.this.f5813b) {
                abstractC1660b.a(this.f5824b, null, C1662d.f5812a);
            }
        }
    }

    private C1662d() {
        this.f5813b.add(this.f5815d);
    }

    /* renamed from: a */
    public static C1662d m15079a() {
        if (f5812a == null) {
            synchronized (C1662d.class) {
                if (f5812a == null) {
                    f5812a = new C1662d();
                }
            }
        }
        return f5812a;
    }

    /* renamed from: a */
    private void m15076a(C1661c c1661c, int i, String str, String str2) {
        if (c1661c == null) {
            c1661c = new C1661c();
        }
        c1661c.m15085a(i);
        c1661c.m15084a(str);
        c1661c.m15082b(str2);
        m15077a(c1661c);
    }

    /* renamed from: b */
    private void m15070b(C1661c c1661c) {
        try {
            if (this.f5814c == null || this.f5814c.isShutdown()) {
                return;
            }
            this.f5814c.execute(new RunnableC1665b(c1661c));
        } catch (Exception e) {
            Log.e("LoggerChain", "executeWork exception=" + e.toString());
        }
    }

    /* renamed from: g */
    private List<AbstractC1660b> m15064g() {
        return this.f5813b == null ? new CopyOnWriteArrayList() : this.f5813b;
    }

    /* renamed from: a */
    public void m15078a(int i, String str, String str2) {
        m15076a(new C1661c(), i, str, str2);
    }

    /* renamed from: a */
    public void m15077a(C1661c c1661c) {
        if (c1661c != null) {
            switch (this.f5817f) {
                case DEVELOP:
                    c1661c.m15085a(6);
                    this.f5816e.m15062a(c1661c, null, f5812a);
                    break;
                case RELEASE:
                    if (this.f5818g) {
                        this.f5816e.m15062a(c1661c, null, f5812a);
                        break;
                    }
                    break;
            }
            m15070b(c1661c);
        }
    }

    /* renamed from: a */
    public void m15074a(String str) {
        if (this.f5816e != null) {
            this.f5816e.m15061a(str);
        }
    }

    /* renamed from: a */
    public void m15073a(List<String> list) {
        if (this.f5816e != null) {
            this.f5816e.m15060a(list);
        }
    }

    /* renamed from: a */
    public void m15072a(boolean z) {
        this.f5818g = z;
    }

    /* renamed from: b */
    public void m15071b() {
        if (this.f5813b != null) {
            this.f5813b.clear();
        }
    }

    /* renamed from: b */
    public void m15069b(String str) {
        if (this.f5816e != null) {
            this.f5816e.m15059b(str);
        }
    }

    /* renamed from: c */
    public void m15068c() {
        if (this.f5816e != null) {
            this.f5816e.m15063a();
        }
    }

    /* renamed from: d */
    public void m15067d() {
        this.f5817f = EnumC1664a.RELEASE;
    }

    /* renamed from: e */
    public boolean m15066e() {
        return this.f5817f == null || this.f5817f == EnumC1664a.RELEASE;
    }
}
