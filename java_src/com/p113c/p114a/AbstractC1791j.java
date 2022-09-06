package com.p113c.p114a;

import android.view.animation.Interpolator;
/* renamed from: com.c.a.j */
/* loaded from: classes.dex */
public abstract class AbstractC1791j implements Cloneable {

    /* renamed from: a */
    float f6339a;

    /* renamed from: b */
    Class f6340b;

    /* renamed from: d */
    private Interpolator f6342d = null;

    /* renamed from: c */
    boolean f6341c = false;

    /* renamed from: com.c.a.j$a */
    /* loaded from: classes.dex */
    static class C1792a extends AbstractC1791j {

        /* renamed from: d */
        float f6343d;

        C1792a(float f) {
            this.f6339a = f;
            this.f6340b = Float.TYPE;
        }

        C1792a(float f, float f2) {
            this.f6339a = f;
            this.f6343d = f2;
            this.f6340b = Float.TYPE;
            this.f6341c = true;
        }

        @Override // com.p113c.p114a.AbstractC1791j
        /* renamed from: a */
        public void mo14620a(Object obj) {
            if (obj == null || obj.getClass() != Float.class) {
                return;
            }
            this.f6343d = ((Float) obj).floatValue();
            this.f6341c = true;
        }

        @Override // com.p113c.p114a.AbstractC1791j
        /* renamed from: b */
        public Object mo14619b() {
            return Float.valueOf(this.f6343d);
        }

        /* renamed from: g */
        public float m14624g() {
            return this.f6343d;
        }

        @Override // com.p113c.p114a.AbstractC1791j
        /* renamed from: h */
        public C1792a mo14618f() {
            C1792a c1792a = new C1792a(c(), this.f6343d);
            c1792a.a(d());
            return c1792a;
        }
    }

    /* renamed from: com.c.a.j$b */
    /* loaded from: classes.dex */
    static class C1793b extends AbstractC1791j {

        /* renamed from: d */
        int f6344d;

        C1793b(float f) {
            this.f6339a = f;
            this.f6340b = Integer.TYPE;
        }

        C1793b(float f, int i) {
            this.f6339a = f;
            this.f6344d = i;
            this.f6340b = Integer.TYPE;
            this.f6341c = true;
        }

        @Override // com.p113c.p114a.AbstractC1791j
        /* renamed from: a */
        public void mo14620a(Object obj) {
            if (obj == null || obj.getClass() != Integer.class) {
                return;
            }
            this.f6344d = ((Integer) obj).intValue();
            this.f6341c = true;
        }

        @Override // com.p113c.p114a.AbstractC1791j
        /* renamed from: b */
        public Object mo14619b() {
            return Integer.valueOf(this.f6344d);
        }

        /* renamed from: g */
        public int m14622g() {
            return this.f6344d;
        }

        @Override // com.p113c.p114a.AbstractC1791j
        /* renamed from: h */
        public C1793b mo14618f() {
            C1793b c1793b = new C1793b(c(), this.f6344d);
            c1793b.a(d());
            return c1793b;
        }
    }

    /* renamed from: com.c.a.j$c */
    /* loaded from: classes.dex */
    static class C1794c extends AbstractC1791j {

        /* renamed from: d */
        Object f6345d;

        C1794c(float f, Object obj) {
            this.f6339a = f;
            this.f6345d = obj;
            this.f6341c = obj != null;
            this.f6340b = this.f6341c ? obj.getClass() : Object.class;
        }

        @Override // com.p113c.p114a.AbstractC1791j
        /* renamed from: a */
        public void mo14620a(Object obj) {
            this.f6345d = obj;
            this.f6341c = obj != null;
        }

        @Override // com.p113c.p114a.AbstractC1791j
        /* renamed from: b */
        public Object mo14619b() {
            return this.f6345d;
        }

        @Override // com.p113c.p114a.AbstractC1791j
        /* renamed from: g */
        public C1794c mo14618f() {
            C1794c c1794c = new C1794c(c(), this.f6345d);
            c1794c.a(d());
            return c1794c;
        }
    }

    /* renamed from: a */
    public static AbstractC1791j m14635a(float f) {
        return new C1793b(f);
    }

    /* renamed from: a */
    public static AbstractC1791j m14634a(float f, float f2) {
        return new C1792a(f, f2);
    }

    /* renamed from: a */
    public static AbstractC1791j m14633a(float f, int i) {
        return new C1793b(f, i);
    }

    /* renamed from: a */
    public static AbstractC1791j m14632a(float f, Object obj) {
        return new C1794c(f, obj);
    }

    /* renamed from: b */
    public static AbstractC1791j m14630b(float f) {
        return new C1792a(f);
    }

    /* renamed from: c */
    public static AbstractC1791j m14628c(float f) {
        return new C1794c(f, null);
    }

    /* renamed from: a */
    public void m14631a(Interpolator interpolator) {
        this.f6342d = interpolator;
    }

    /* renamed from: a */
    public abstract void mo14620a(Object obj);

    /* renamed from: a */
    public boolean m14636a() {
        return this.f6341c;
    }

    /* renamed from: b */
    public abstract Object mo14619b();

    /* renamed from: c */
    public float m14629c() {
        return this.f6339a;
    }

    /* renamed from: d */
    public Interpolator m14627d() {
        return this.f6342d;
    }

    /* renamed from: d */
    public void m14626d(float f) {
        this.f6339a = f;
    }

    /* renamed from: e */
    public Class m14625e() {
        return this.f6340b;
    }

    @Override // 
    /* renamed from: f */
    public abstract AbstractC1791j clone();
}
