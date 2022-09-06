package org.p290c.p309e;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.p290c.p309e.p311b.C5605a;
import org.p290c.p309e.p311b.C5606b;
/* renamed from: org.c.e.j */
/* loaded from: classes2.dex */
public class C5629j implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = ObjectStreamClass.lookup(C5632b.class).getFields();
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final AtomicInteger f22730a;

    /* renamed from: b */
    private final AtomicInteger f22731b;

    /* renamed from: c */
    private final CopyOnWriteArrayList<C5605a> f22732c;

    /* renamed from: d */
    private final AtomicLong f22733d;

    /* renamed from: e */
    private final AtomicLong f22734e;

    /* renamed from: f */
    private C5632b f22735f;

    @C5606b.AbstractC5607a
    /* renamed from: org.c.e.j$a */
    /* loaded from: classes.dex */
    private class C5631a extends C5606b {
        private C5631a() {
        }

        @Override // org.p290c.p309e.p311b.C5606b
        /* renamed from: a */
        public void mo476a(C5605a c5605a) {
            C5629j.this.f22732c.add(c5605a);
        }

        @Override // org.p290c.p309e.p311b.C5606b
        /* renamed from: a */
        public void mo475a(C5619c c5619c) {
            C5629j.this.f22730a.getAndIncrement();
        }

        @Override // org.p290c.p309e.p311b.C5606b
        /* renamed from: a */
        public void mo474a(C5629j c5629j) {
            C5629j.this.f22733d.addAndGet(System.currentTimeMillis() - C5629j.this.f22734e.get());
        }

        @Override // org.p290c.p309e.p311b.C5606b
        /* renamed from: b */
        public void mo473b(C5605a c5605a) {
        }

        @Override // org.p290c.p309e.p311b.C5606b
        /* renamed from: c */
        public void mo472c(C5619c c5619c) {
            C5629j.this.f22731b.getAndIncrement();
        }

        @Override // org.p290c.p309e.p311b.C5606b
        /* renamed from: d */
        public void mo471d(C5619c c5619c) {
            C5629j.this.f22734e.set(System.currentTimeMillis());
        }
    }

    /* renamed from: org.c.e.j$b */
    /* loaded from: classes2.dex */
    private static class C5632b implements Serializable {
        private static final long serialVersionUID = 1;

        /* renamed from: a */
        private final AtomicInteger f22737a;

        /* renamed from: b */
        private final AtomicInteger f22738b;

        /* renamed from: c */
        private final List<C5605a> f22739c;

        /* renamed from: d */
        private final long f22740d;

        /* renamed from: e */
        private final long f22741e;

        private C5632b(ObjectInputStream.GetField getField) {
            this.f22737a = (AtomicInteger) getField.get("fCount", (Object) null);
            this.f22738b = (AtomicInteger) getField.get("fIgnoreCount", (Object) null);
            this.f22739c = (List) getField.get("fFailures", (Object) null);
            this.f22740d = getField.get("fRunTime", 0L);
            this.f22741e = getField.get("fStartTime", 0L);
        }

        public C5632b(C5629j c5629j) {
            this.f22737a = c5629j.f22730a;
            this.f22738b = c5629j.f22731b;
            this.f22739c = Collections.synchronizedList(new ArrayList(c5629j.f22732c));
            this.f22740d = c5629j.f22733d.longValue();
            this.f22741e = c5629j.f22734e.longValue();
        }

        /* renamed from: a */
        public static C5632b m470a(ObjectInputStream objectInputStream) {
            return new C5632b(objectInputStream.readFields());
        }

        /* renamed from: a */
        public void m469a(ObjectOutputStream objectOutputStream) {
            ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            putFields.put("fCount", this.f22737a);
            putFields.put("fIgnoreCount", this.f22738b);
            putFields.put("fFailures", this.f22739c);
            putFields.put("fRunTime", this.f22740d);
            putFields.put("fStartTime", this.f22741e);
            objectOutputStream.writeFields();
        }
    }

    public C5629j() {
        this.f22730a = new AtomicInteger();
        this.f22731b = new AtomicInteger();
        this.f22732c = new CopyOnWriteArrayList<>();
        this.f22733d = new AtomicLong();
        this.f22734e = new AtomicLong();
    }

    private C5629j(C5632b c5632b) {
        this.f22730a = c5632b.f22737a;
        this.f22731b = c5632b.f22738b;
        this.f22732c = new CopyOnWriteArrayList<>(c5632b.f22739c);
        this.f22733d = new AtomicLong(c5632b.f22740d);
        this.f22734e = new AtomicLong(c5632b.f22741e);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f22735f = C5632b.m470a(objectInputStream);
    }

    private Object readResolve() {
        return new C5629j(this.f22735f);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        new C5632b(this).m469a(objectOutputStream);
    }

    /* renamed from: a */
    public int m488a() {
        return this.f22730a.get();
    }

    /* renamed from: b */
    public int m486b() {
        return this.f22732c.size();
    }

    /* renamed from: c */
    public long m484c() {
        return this.f22733d.get();
    }

    /* renamed from: d */
    public List<C5605a> m482d() {
        return this.f22732c;
    }

    /* renamed from: e */
    public int m480e() {
        return this.f22731b.get();
    }

    /* renamed from: f */
    public boolean m478f() {
        return m486b() == 0;
    }

    /* renamed from: g */
    public C5606b m477g() {
        return new C5631a();
    }
}
