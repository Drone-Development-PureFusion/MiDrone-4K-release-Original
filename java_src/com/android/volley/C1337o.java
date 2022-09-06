package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.android.volley.o */
/* loaded from: classes.dex */
public class C1337o {

    /* renamed from: f */
    private static final int f4604f = 4;

    /* renamed from: a */
    private AtomicInteger f4605a;

    /* renamed from: b */
    private final Map<String, Queue<AbstractC1333n<?>>> f4606b;

    /* renamed from: c */
    private final Set<AbstractC1333n<?>> f4607c;

    /* renamed from: d */
    private final PriorityBlockingQueue<AbstractC1333n<?>> f4608d;

    /* renamed from: e */
    private final PriorityBlockingQueue<AbstractC1333n<?>> f4609e;

    /* renamed from: g */
    private final AbstractC1317b f4610g;

    /* renamed from: h */
    private final AbstractC1326g f4611h;

    /* renamed from: i */
    private final AbstractC1344q f4612i;

    /* renamed from: j */
    private C1327h[] f4613j;

    /* renamed from: k */
    private C1319c f4614k;

    /* renamed from: l */
    private List<AbstractC1340b> f4615l;

    /* renamed from: com.android.volley.o$a */
    /* loaded from: classes.dex */
    public interface AbstractC1339a {
        /* renamed from: a */
        boolean mo16691a(AbstractC1333n<?> abstractC1333n);
    }

    /* renamed from: com.android.volley.o$b */
    /* loaded from: classes.dex */
    public interface AbstractC1340b<T> {
        /* renamed from: a */
        void m16690a(AbstractC1333n<T> abstractC1333n);
    }

    public C1337o(AbstractC1317b abstractC1317b, AbstractC1326g abstractC1326g) {
        this(abstractC1317b, abstractC1326g, 4);
    }

    public C1337o(AbstractC1317b abstractC1317b, AbstractC1326g abstractC1326g, int i) {
        this(abstractC1317b, abstractC1326g, i, new C1322e(new Handler(Looper.getMainLooper())));
    }

    public C1337o(AbstractC1317b abstractC1317b, AbstractC1326g abstractC1326g, int i, AbstractC1344q abstractC1344q) {
        this.f4605a = new AtomicInteger();
        this.f4606b = new HashMap();
        this.f4607c = new HashSet();
        this.f4608d = new PriorityBlockingQueue<>();
        this.f4609e = new PriorityBlockingQueue<>();
        this.f4615l = new ArrayList();
        this.f4610g = abstractC1317b;
        this.f4611h = abstractC1326g;
        this.f4613j = new C1327h[i];
        this.f4612i = abstractC1344q;
    }

    /* renamed from: a */
    public <T> AbstractC1333n<T> m16700a(AbstractC1333n<T> abstractC1333n) {
        abstractC1333n.m16730a(this);
        synchronized (this.f4607c) {
            this.f4607c.add(abstractC1333n);
        }
        abstractC1333n.m16734a(m16693c());
        abstractC1333n.m16726a("add-to-queue");
        if (!abstractC1333n.m16704w()) {
            this.f4609e.add(abstractC1333n);
        } else {
            synchronized (this.f4606b) {
                String m16711j = abstractC1333n.m16711j();
                if (this.f4606b.containsKey(m16711j)) {
                    Queue<AbstractC1333n<?>> queue = this.f4606b.get(m16711j);
                    if (queue == null) {
                        queue = new LinkedList<>();
                    }
                    queue.add(abstractC1333n);
                    this.f4606b.put(m16711j, queue);
                    if (C1385v.f4718b) {
                        C1385v.m16567a("Request for cacheKey=%s is in flight, putting on hold.", m16711j);
                    }
                } else {
                    this.f4606b.put(m16711j, null);
                    this.f4608d.add(abstractC1333n);
                }
            }
        }
        return abstractC1333n;
    }

    /* renamed from: a */
    public void m16701a() {
        m16696b();
        this.f4614k = new C1319c(this.f4608d, this.f4609e, this.f4610g, this.f4612i);
        this.f4614k.start();
        for (int i = 0; i < this.f4613j.length; i++) {
            C1327h c1327h = new C1327h(this.f4609e, this.f4611h, this.f4610g, this.f4612i);
            this.f4613j[i] = c1327h;
            c1327h.start();
        }
    }

    /* renamed from: a */
    public void m16699a(AbstractC1339a abstractC1339a) {
        synchronized (this.f4607c) {
            for (AbstractC1333n<?> abstractC1333n : this.f4607c) {
                if (abstractC1339a.mo16691a(abstractC1333n)) {
                    abstractC1333n.m16709l();
                }
            }
        }
    }

    /* renamed from: a */
    public <T> void m16698a(AbstractC1340b<T> abstractC1340b) {
        synchronized (this.f4615l) {
            this.f4615l.add(abstractC1340b);
        }
    }

    /* renamed from: a */
    public void m16697a(final Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        m16699a(new AbstractC1339a() { // from class: com.android.volley.o.1
            @Override // com.android.volley.C1337o.AbstractC1339a
            /* renamed from: a */
            public boolean mo16691a(AbstractC1333n<?> abstractC1333n) {
                return abstractC1333n.m16723b() == obj;
            }
        });
    }

    /* renamed from: b */
    public void m16696b() {
        if (this.f4614k != null) {
            this.f4614k.m16746a();
        }
        for (int i = 0; i < this.f4613j.length; i++) {
            if (this.f4613j[i] != null) {
                this.f4613j[i].m16740a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public <T> void m16695b(AbstractC1333n<T> abstractC1333n) {
        synchronized (this.f4607c) {
            this.f4607c.remove(abstractC1333n);
        }
        synchronized (this.f4615l) {
            for (AbstractC1340b abstractC1340b : this.f4615l) {
                abstractC1340b.m16690a(abstractC1333n);
            }
        }
        if (abstractC1333n.m16704w()) {
            synchronized (this.f4606b) {
                String m16711j = abstractC1333n.m16711j();
                Queue<AbstractC1333n<?>> remove = this.f4606b.remove(m16711j);
                if (remove != null) {
                    if (C1385v.f4718b) {
                        C1385v.m16567a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), m16711j);
                    }
                    this.f4608d.addAll(remove);
                }
            }
        }
    }

    /* renamed from: b */
    public <T> void m16694b(AbstractC1340b<T> abstractC1340b) {
        synchronized (this.f4615l) {
            this.f4615l.remove(abstractC1340b);
        }
    }

    /* renamed from: c */
    public int m16693c() {
        return this.f4605a.incrementAndGet();
    }

    /* renamed from: d */
    public AbstractC1317b m16692d() {
        return this.f4610g;
    }
}
