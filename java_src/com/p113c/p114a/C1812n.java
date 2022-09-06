package com.p113c.p114a;

import android.util.Log;
import com.p113c.p115b.AbstractC1827a;
import com.p113c.p115b.AbstractC1828b;
import com.p113c.p115b.AbstractC1830d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* renamed from: com.c.a.n */
/* loaded from: classes.dex */
public class C1812n implements Cloneable {

    /* renamed from: i */
    private static final AbstractC1818p f6371i = new C1789h();

    /* renamed from: j */
    private static final AbstractC1818p f6372j = new C1787f();

    /* renamed from: k */
    private static Class[] f6373k = {Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};

    /* renamed from: l */
    private static Class[] f6374l = {Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};

    /* renamed from: m */
    private static Class[] f6375m = {Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};

    /* renamed from: n */
    private static final HashMap<Class, HashMap<String, Method>> f6376n = new HashMap<>();

    /* renamed from: o */
    private static final HashMap<Class, HashMap<String, Method>> f6377o = new HashMap<>();

    /* renamed from: a */
    String f6378a;

    /* renamed from: b */
    protected AbstractC1830d f6379b;

    /* renamed from: c */
    Method f6380c;

    /* renamed from: d */
    Class f6381d;

    /* renamed from: e */
    C1795k f6382e;

    /* renamed from: f */
    final ReentrantReadWriteLock f6383f;

    /* renamed from: g */
    final Object[] f6384g;

    /* renamed from: h */
    private Method f6385h;

    /* renamed from: p */
    private AbstractC1818p f6386p;

    /* renamed from: q */
    private Object f6387q;

    /* renamed from: com.c.a.n$a */
    /* loaded from: classes.dex */
    static class C1814a extends C1812n {

        /* renamed from: h */
        C1788g f6388h;

        /* renamed from: i */
        float f6389i;

        /* renamed from: j */
        private AbstractC1827a f6390j;

        public C1814a(AbstractC1830d abstractC1830d, C1788g c1788g) {
            super(abstractC1830d);
            this.f6381d = Float.TYPE;
            this.f6382e = c1788g;
            this.f6388h = (C1788g) this.f6382e;
            if (abstractC1830d instanceof AbstractC1827a) {
                this.f6390j = (AbstractC1827a) this.f6379b;
            }
        }

        public C1814a(AbstractC1830d abstractC1830d, float... fArr) {
            super(abstractC1830d);
            mo14542a(fArr);
            if (abstractC1830d instanceof AbstractC1827a) {
                this.f6390j = (AbstractC1827a) this.f6379b;
            }
        }

        public C1814a(String str, C1788g c1788g) {
            super(str);
            this.f6381d = Float.TYPE;
            this.f6382e = c1788g;
            this.f6388h = (C1788g) this.f6382e;
        }

        public C1814a(String str, float... fArr) {
            super(str);
            mo14542a(fArr);
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: a */
        void mo14539a(float f) {
            this.f6389i = this.f6388h.m14640b(f);
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: a */
        void mo14538a(Class cls) {
            if (this.f6379b != null) {
                return;
            }
            super.mo14538a(cls);
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: a */
        public void mo14542a(float... fArr) {
            super.mo14542a(fArr);
            this.f6388h = (C1788g) this.f6382e;
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: d */
        Object mo14536d() {
            return Float.valueOf(this.f6389i);
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: d */
        void mo14535d(Object obj) {
            if (this.f6390j != null) {
                this.f6390j.mo14466a((AbstractC1827a) obj, this.f6389i);
            } else if (this.f6379b != null) {
                this.f6379b.mo14456a(obj, Float.valueOf(this.f6389i));
            } else if (this.f6380c == null) {
            } else {
                try {
                    this.f6384g[0] = Float.valueOf(this.f6389i);
                    this.f6380c.invoke(obj, this.f6384g);
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: e */
        public C1814a clone() {
            C1814a c1814a = (C1814a) super.clone();
            c1814a.f6388h = (C1788g) c1814a.f6382e;
            return c1814a;
        }
    }

    /* renamed from: com.c.a.n$b */
    /* loaded from: classes.dex */
    static class C1815b extends C1812n {

        /* renamed from: h */
        C1790i f6391h;

        /* renamed from: i */
        int f6392i;

        /* renamed from: j */
        private AbstractC1828b f6393j;

        public C1815b(AbstractC1830d abstractC1830d, C1790i c1790i) {
            super(abstractC1830d);
            this.f6381d = Integer.TYPE;
            this.f6382e = c1790i;
            this.f6391h = (C1790i) this.f6382e;
            if (abstractC1830d instanceof AbstractC1828b) {
                this.f6393j = (AbstractC1828b) this.f6379b;
            }
        }

        public C1815b(AbstractC1830d abstractC1830d, int... iArr) {
            super(abstractC1830d);
            mo14537a(iArr);
            if (abstractC1830d instanceof AbstractC1828b) {
                this.f6393j = (AbstractC1828b) this.f6379b;
            }
        }

        public C1815b(String str, C1790i c1790i) {
            super(str);
            this.f6381d = Integer.TYPE;
            this.f6382e = c1790i;
            this.f6391h = (C1790i) this.f6382e;
        }

        public C1815b(String str, int... iArr) {
            super(str);
            mo14537a(iArr);
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: a */
        void mo14539a(float f) {
            this.f6392i = this.f6391h.m14637b(f);
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: a */
        void mo14538a(Class cls) {
            if (this.f6379b != null) {
                return;
            }
            super.mo14538a(cls);
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: a */
        public void mo14537a(int... iArr) {
            super.mo14537a(iArr);
            this.f6391h = (C1790i) this.f6382e;
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: d */
        Object mo14536d() {
            return Integer.valueOf(this.f6392i);
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: d */
        void mo14535d(Object obj) {
            if (this.f6393j != null) {
                this.f6393j.mo14464a((AbstractC1828b) obj, this.f6392i);
            } else if (this.f6379b != null) {
                this.f6379b.mo14456a(obj, Integer.valueOf(this.f6392i));
            } else if (this.f6380c == null) {
            } else {
                try {
                    this.f6384g[0] = Integer.valueOf(this.f6392i);
                    this.f6380c.invoke(obj, this.f6384g);
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        @Override // com.p113c.p114a.C1812n
        /* renamed from: e */
        public C1815b clone() {
            C1815b c1815b = (C1815b) super.clone();
            c1815b.f6391h = (C1790i) c1815b.f6382e;
            return c1815b;
        }
    }

    private C1812n(AbstractC1830d abstractC1830d) {
        this.f6380c = null;
        this.f6385h = null;
        this.f6382e = null;
        this.f6383f = new ReentrantReadWriteLock();
        this.f6384g = new Object[1];
        this.f6379b = abstractC1830d;
        if (abstractC1830d != null) {
            this.f6378a = abstractC1830d.m14461b();
        }
    }

    private C1812n(String str) {
        this.f6380c = null;
        this.f6385h = null;
        this.f6382e = null;
        this.f6383f = new ReentrantReadWriteLock();
        this.f6384g = new Object[1];
        this.f6378a = str;
    }

    /* renamed from: a */
    public static <V> C1812n m14563a(AbstractC1830d abstractC1830d, AbstractC1818p<V> abstractC1818p, V... vArr) {
        C1812n c1812n = new C1812n(abstractC1830d);
        c1812n.m14548a((Object[]) vArr);
        c1812n.m14565a((AbstractC1818p) abstractC1818p);
        return c1812n;
    }

    /* renamed from: a */
    public static C1812n m14562a(AbstractC1830d<?, Float> abstractC1830d, float... fArr) {
        return new C1814a(abstractC1830d, fArr);
    }

    /* renamed from: a */
    public static C1812n m14561a(AbstractC1830d<?, Integer> abstractC1830d, int... iArr) {
        return new C1815b(abstractC1830d, iArr);
    }

    /* renamed from: a */
    public static C1812n m14560a(AbstractC1830d abstractC1830d, AbstractC1791j... abstractC1791jArr) {
        C1795k m14612a = C1795k.m14612a(abstractC1791jArr);
        if (m14612a instanceof C1790i) {
            return new C1815b(abstractC1830d, (C1790i) m14612a);
        }
        if (m14612a instanceof C1788g) {
            return new C1814a(abstractC1830d, (C1788g) m14612a);
        }
        C1812n c1812n = new C1812n(abstractC1830d);
        c1812n.f6382e = m14612a;
        c1812n.f6381d = abstractC1791jArr[0].m14625e();
        return c1812n;
    }

    /* renamed from: a */
    public static C1812n m14554a(String str, AbstractC1818p abstractC1818p, Object... objArr) {
        C1812n c1812n = new C1812n(str);
        c1812n.m14548a(objArr);
        c1812n.m14565a(abstractC1818p);
        return c1812n;
    }

    /* renamed from: a */
    public static C1812n m14552a(String str, float... fArr) {
        return new C1814a(str, fArr);
    }

    /* renamed from: a */
    public static C1812n m14551a(String str, int... iArr) {
        return new C1815b(str, iArr);
    }

    /* renamed from: a */
    public static C1812n m14550a(String str, AbstractC1791j... abstractC1791jArr) {
        C1795k m14612a = C1795k.m14612a(abstractC1791jArr);
        if (m14612a instanceof C1790i) {
            return new C1815b(str, (C1790i) m14612a);
        }
        if (m14612a instanceof C1788g) {
            return new C1814a(str, (C1788g) m14612a);
        }
        C1812n c1812n = new C1812n(str);
        c1812n.f6382e = m14612a;
        c1812n.f6381d = abstractC1791jArr[0].m14625e();
        return c1812n;
    }

    /* renamed from: a */
    static String m14553a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        return str + upperCase + str2.substring(1);
    }

    /* renamed from: a */
    private Method m14559a(Class cls, String str, Class cls2) {
        Method method;
        Class<?>[] clsArr;
        Method method2 = null;
        String m14553a = m14553a(str, this.f6378a);
        if (cls2 != null) {
            Class<?>[] clsArr2 = new Class[1];
            for (Class<?> cls3 : this.f6381d.equals(Float.class) ? f6373k : this.f6381d.equals(Integer.class) ? f6374l : this.f6381d.equals(Double.class) ? f6375m : new Class[]{this.f6381d}) {
                clsArr2[0] = cls3;
                try {
                    method2 = cls.getMethod(m14553a, clsArr2);
                    this.f6381d = cls3;
                    return method2;
                } catch (NoSuchMethodException e) {
                    try {
                        method2 = cls.getDeclaredMethod(m14553a, clsArr2);
                        method2.setAccessible(true);
                        this.f6381d = cls3;
                        return method2;
                    } catch (NoSuchMethodException e2) {
                    }
                }
            }
            Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f6378a + " with value type " + this.f6381d);
            return method2;
        }
        try {
            return cls.getMethod(m14553a, null);
        } catch (NoSuchMethodException e3) {
            try {
                method = cls.getDeclaredMethod(m14553a, null);
                try {
                    method.setAccessible(true);
                    return method;
                } catch (NoSuchMethodException e4) {
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f6378a + ": " + e3);
                    return method;
                }
            } catch (NoSuchMethodException e5) {
                method = null;
            }
        }
    }

    /* renamed from: a */
    private Method m14558a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        Method method = null;
        try {
            this.f6383f.writeLock().lock();
            HashMap<String, Method> hashMap2 = hashMap.get(cls);
            if (hashMap2 != null) {
                method = hashMap2.get(this.f6378a);
            }
            if (method == null) {
                method = m14559a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap<>();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f6378a, method);
            }
            Method method2 = method;
            return method2;
        } finally {
            this.f6383f.writeLock().unlock();
        }
    }

    /* renamed from: a */
    private void m14556a(Object obj, AbstractC1791j abstractC1791j) {
        if (this.f6379b != null) {
            abstractC1791j.mo14620a(this.f6379b.mo14457a(obj));
        }
        try {
            if (this.f6385h == null) {
                m14546b((Class) obj.getClass());
            }
            abstractC1791j.mo14620a(this.f6385h.invoke(obj, new Object[0]));
        } catch (IllegalAccessException e) {
            Log.e("PropertyValuesHolder", e.toString());
        } catch (InvocationTargetException e2) {
            Log.e("PropertyValuesHolder", e2.toString());
        }
    }

    /* renamed from: b */
    private void m14546b(Class cls) {
        this.f6385h = m14558a(cls, f6377o, "get", null);
    }

    @Override // 
    /* renamed from: a */
    public C1812n clone() {
        try {
            C1812n c1812n = (C1812n) super.clone();
            c1812n.f6378a = this.f6378a;
            c1812n.f6379b = this.f6379b;
            c1812n.f6382e = this.f6382e.clone();
            c1812n.f6386p = this.f6386p;
            return c1812n;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14539a(float f) {
        this.f6387q = this.f6382e.mo14616a(f);
    }

    /* renamed from: a */
    public void m14565a(AbstractC1818p abstractC1818p) {
        this.f6386p = abstractC1818p;
        this.f6382e.m14615a(abstractC1818p);
    }

    /* renamed from: a */
    public void m14564a(AbstractC1830d abstractC1830d) {
        this.f6379b = abstractC1830d;
    }

    /* renamed from: a */
    void mo14538a(Class cls) {
        this.f6380c = m14558a(cls, f6376n, "set", this.f6381d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14557a(Object obj) {
        if (this.f6379b != null) {
            try {
                this.f6379b.mo14457a(obj);
                Iterator<AbstractC1791j> it2 = this.f6382e.f6350e.iterator();
                while (it2.hasNext()) {
                    AbstractC1791j next = it2.next();
                    if (!next.m14636a()) {
                        next.mo14620a(this.f6379b.mo14457a(obj));
                    }
                }
                return;
            } catch (ClassCastException e) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f6379b.m14461b() + ") on target object " + obj + ". Trying reflection instead");
                this.f6379b = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.f6380c == null) {
            mo14538a((Class) cls);
        }
        Iterator<AbstractC1791j> it3 = this.f6382e.f6350e.iterator();
        while (it3.hasNext()) {
            AbstractC1791j next2 = it3.next();
            if (!next2.m14636a()) {
                if (this.f6385h == null) {
                    m14546b((Class) cls);
                }
                try {
                    next2.mo14620a(this.f6385h.invoke(obj, new Object[0]));
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (InvocationTargetException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public void m14555a(String str) {
        this.f6378a = str;
    }

    /* renamed from: a */
    public void mo14542a(float... fArr) {
        this.f6381d = Float.TYPE;
        this.f6382e = C1795k.m14614a(fArr);
    }

    /* renamed from: a */
    public void mo14537a(int... iArr) {
        this.f6381d = Integer.TYPE;
        this.f6382e = C1795k.m14613a(iArr);
    }

    /* renamed from: a */
    public void m14549a(AbstractC1791j... abstractC1791jArr) {
        int length = abstractC1791jArr.length;
        AbstractC1791j[] abstractC1791jArr2 = new AbstractC1791j[Math.max(length, 2)];
        this.f6381d = abstractC1791jArr[0].m14625e();
        for (int i = 0; i < length; i++) {
            abstractC1791jArr2[i] = abstractC1791jArr[i];
        }
        this.f6382e = new C1795k(abstractC1791jArr2);
    }

    /* renamed from: a */
    public void m14548a(Object... objArr) {
        this.f6381d = objArr[0].getClass();
        this.f6382e = C1795k.m14611a(objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m14547b() {
        if (this.f6386p == null) {
            this.f6386p = this.f6381d == Integer.class ? f6371i : this.f6381d == Float.class ? f6372j : null;
        }
        if (this.f6386p != null) {
            this.f6382e.m14615a(this.f6386p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m14545b(Object obj) {
        m14556a(obj, this.f6382e.f6350e.get(0));
    }

    /* renamed from: c */
    public String m14544c() {
        return this.f6378a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m14543c(Object obj) {
        m14556a(obj, this.f6382e.f6350e.get(this.f6382e.f6350e.size() - 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public Object mo14536d() {
        return this.f6387q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo14535d(Object obj) {
        if (this.f6379b != null) {
            this.f6379b.mo14456a(obj, mo14536d());
        }
        if (this.f6380c != null) {
            try {
                this.f6384g[0] = mo14536d();
                this.f6380c.invoke(obj, this.f6384g);
            } catch (IllegalAccessException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (InvocationTargetException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    public String toString() {
        return this.f6378a + ": " + this.f6382e.toString();
    }
}
