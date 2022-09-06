package org.p290c.p308d;

import java.util.concurrent.TimeUnit;
import org.p290c.p299b.p303d.p306c.C5531c;
import org.p290c.p309e.C5619c;
import org.p290c.p312f.p313a.AbstractC5647j;
/* renamed from: org.c.d.o */
/* loaded from: classes.dex */
public class C5587o implements AbstractC5582l {

    /* renamed from: a */
    private final long f22674a;

    /* renamed from: b */
    private final TimeUnit f22675b;

    /* renamed from: c */
    private final boolean f22676c;

    /* renamed from: org.c.d.o$a */
    /* loaded from: classes2.dex */
    public static class C5589a {

        /* renamed from: a */
        private boolean f22679a = false;

        /* renamed from: b */
        private long f22680b = 0;

        /* renamed from: c */
        private TimeUnit f22681c = TimeUnit.SECONDS;

        protected C5589a() {
        }

        /* renamed from: a */
        protected long m594a() {
            return this.f22680b;
        }

        /* renamed from: a */
        public C5589a m593a(long j, TimeUnit timeUnit) {
            this.f22680b = j;
            this.f22681c = timeUnit;
            return this;
        }

        /* renamed from: a */
        public C5589a m592a(boolean z) {
            this.f22679a = z;
            return this;
        }

        /* renamed from: b */
        protected TimeUnit m591b() {
            return this.f22681c;
        }

        /* renamed from: c */
        protected boolean m590c() {
            return this.f22679a;
        }

        /* renamed from: d */
        public C5587o m589d() {
            return new C5587o(this);
        }
    }

    @Deprecated
    public C5587o(int i) {
        this(i, TimeUnit.MILLISECONDS);
    }

    public C5587o(long j, TimeUnit timeUnit) {
        this.f22674a = j;
        this.f22675b = timeUnit;
        this.f22676c = false;
    }

    protected C5587o(C5589a c5589a) {
        this.f22674a = c5589a.m594a();
        this.f22675b = c5589a.m591b();
        this.f22676c = c5589a.m590c();
    }

    /* renamed from: a */
    public static C5589a m600a() {
        return new C5589a();
    }

    /* renamed from: a */
    public static C5587o m599a(long j) {
        return new C5587o(j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: b */
    public static C5587o m595b(long j) {
        return new C5587o(j, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    protected final long m598a(TimeUnit timeUnit) {
        return timeUnit.convert(this.f22674a, this.f22675b);
    }

    /* renamed from: a */
    protected AbstractC5647j m597a(AbstractC5647j abstractC5647j) {
        return C5531c.m855b().m851a(this.f22674a, this.f22675b).m848a(this.f22676c).m849a(abstractC5647j);
    }

    @Override // org.p290c.p308d.AbstractC5582l
    /* renamed from: a */
    public AbstractC5647j mo587a(AbstractC5647j abstractC5647j, C5619c c5619c) {
        try {
            return m597a(abstractC5647j);
        } catch (Exception e) {
            return new AbstractC5647j() { // from class: org.c.d.o.1
                @Override // org.p290c.p312f.p313a.AbstractC5647j
                /* renamed from: a */
                public void mo318a() {
                    throw new RuntimeException("Invalid parameters for Timeout", e);
                }
            };
        }
    }

    /* renamed from: b */
    protected final boolean m596b() {
        return this.f22676c;
    }
}
