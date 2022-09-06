package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;
/* renamed from: com.android.volley.e */
/* loaded from: classes.dex */
public class C1322e implements AbstractC1344q {

    /* renamed from: a */
    private final Executor f4552a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.android.volley.e$a */
    /* loaded from: classes.dex */
    public class RunnableC1324a implements Runnable {

        /* renamed from: b */
        private final AbstractC1333n f4556b;

        /* renamed from: c */
        private final C1341p f4557c;

        /* renamed from: d */
        private final Runnable f4558d;

        public RunnableC1324a(AbstractC1333n abstractC1333n, C1341p c1341p, Runnable runnable) {
            this.f4556b = abstractC1333n;
            this.f4557c = c1341p;
            this.f4558d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4556b.mo16661m()) {
                this.f4556b.m16720b("canceled-at-delivery");
                return;
            }
            if (this.f4557c.m16689a()) {
                this.f4556b.mo13154b((AbstractC1333n) this.f4557c.f4618a);
            } else {
                this.f4556b.m16721b(this.f4557c.f4620c);
            }
            if (this.f4557c.f4621d) {
                this.f4556b.m16726a("intermediate-response");
            } else {
                this.f4556b.m16720b("done");
            }
            if (this.f4558d == null) {
                return;
            }
            this.f4558d.run();
        }
    }

    public C1322e(final Handler handler) {
        this.f4552a = new Executor() { // from class: com.android.volley.e.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public C1322e(Executor executor) {
        this.f4552a = executor;
    }

    @Override // com.android.volley.AbstractC1344q
    /* renamed from: a */
    public void mo16686a(AbstractC1333n<?> abstractC1333n, C1341p<?> c1341p) {
        mo16685a(abstractC1333n, c1341p, null);
    }

    @Override // com.android.volley.AbstractC1344q
    /* renamed from: a */
    public void mo16685a(AbstractC1333n<?> abstractC1333n, C1341p<?> c1341p, Runnable runnable) {
        abstractC1333n.m16737A();
        abstractC1333n.m16726a("post-response");
        this.f4552a.execute(new RunnableC1324a(abstractC1333n, c1341p, runnable));
    }

    @Override // com.android.volley.AbstractC1344q
    /* renamed from: a */
    public void mo16684a(AbstractC1333n<?> abstractC1333n, C1384u c1384u) {
        abstractC1333n.m16726a("post-error");
        this.f4552a.execute(new RunnableC1324a(abstractC1333n, C1341p.m16688a(c1384u), null));
    }
}
