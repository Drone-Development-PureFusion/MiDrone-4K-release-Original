package com.fimi.kernel.p157b.p159b;

import android.content.Context;
import com.fimi.kernel.p157b.p159b.C2196b;
import com.fimi.kernel.p157b.p159b.C2213f;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.kernel.b.b.c */
/* loaded from: classes.dex */
public class C2205c implements C2196b.AbstractC2202d {

    /* renamed from: c */
    private static int f7398c = 3;

    /* renamed from: d */
    private static C2205c f7399d;

    /* renamed from: e */
    private static List<C2196b> f7400e;

    /* renamed from: a */
    List<String> f7401a;

    /* renamed from: b */
    private AbstractC2208a f7402b;

    /* renamed from: f */
    private AbstractC2209b f7403f;

    /* renamed from: g */
    private Context f7404g;

    /* renamed from: h */
    private String f7405h;

    /* renamed from: com.fimi.kernel.b.b.c$a */
    /* loaded from: classes.dex */
    public interface AbstractC2208a {
        /* renamed from: a */
        void mo8725a(C2196b c2196b, int i);
    }

    /* renamed from: com.fimi.kernel.b.b.c$b */
    /* loaded from: classes.dex */
    public interface AbstractC2209b {
        /* renamed from: a */
        void mo8716a(List<C2196b> list, boolean z, C2196b c2196b);
    }

    private C2205c() {
    }

    /* renamed from: a */
    public static synchronized C2205c m13235a(Context context) {
        C2205c c2205c;
        synchronized (C2205c.class) {
            if (f7399d == null) {
                f7399d = new C2205c();
                f7399d.f7404g = context;
            }
            f7399d.f7404g = context;
            c2205c = f7399d;
        }
        return c2205c;
    }

    /* renamed from: b */
    private boolean m13227b(C2196b c2196b) {
        c2196b.m13288a(c2196b);
        String m13250m = c2196b.m13250m();
        for (C2196b c2196b2 : f7400e) {
            if (c2196b2.m13250m().equals(m13250m)) {
                f7400e.remove(c2196b);
                if (this.f7403f != null) {
                    this.f7403f.mo8716a(f7400e, false, c2196b);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0072 A[Catch: all -> 0x00a9, TryCatch #0 {, blocks: (B:9:0x0007, B:12:0x000d, B:14:0x0015, B:16:0x0027, B:20:0x0039, B:23:0x0044, B:25:0x0048, B:27:0x005a, B:29:0x005e, B:31:0x0066, B:32:0x006c, B:34:0x0072, B:36:0x007e, B:39:0x0084, B:41:0x0093, B:43:0x009f, B:48:0x0050, B:52:0x00b1), top: B:8:0x0007 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized C2196b m13234a(Context context, String str) {
        C2196b c2196b;
        int i;
        C2196b c2196b2 = null;
        synchronized (this) {
            if (str == null) {
                c2196b = null;
            } else {
                if (f7400e != null) {
                    int i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= f7400e.size()) {
                            c2196b = null;
                            break;
                        } else if (f7400e.get(i).m13278b().equals(str) || f7400e.get(i).m13250m().equals(str)) {
                            break;
                        } else {
                            i2 = i + 1;
                        }
                    }
                    c2196b = f7400e.get(i);
                    if (c2196b == null) {
                        c2196b2 = c2196b;
                    }
                } else {
                    f7400e = new ArrayList();
                }
                if (this.f7401a == null || this.f7401a.size() > 0) {
                    this.f7401a = C2213f.m13205a(context).m13207a();
                }
                if (this.f7401a != null && this.f7401a.size() > 0) {
                    for (String str2 : this.f7401a) {
                        if (str2.endsWith(str) || str2.equals(str)) {
                            c2196b = C2213f.m13205a(context).m13204a(context, str2, new C2213f.AbstractC2215a() { // from class: com.fimi.kernel.b.b.c.1
                                @Override // com.fimi.kernel.p157b.p159b.C2213f.AbstractC2215a
                                /* renamed from: a */
                                public void mo13193a(C2196b c2196b3) {
                                    if (c2196b3 == null || C2205c.this.m13228b() >= C2205c.f7398c) {
                                        return;
                                    }
                                    c2196b3.m13273c();
                                }
                            });
                            break;
                        }
                        while (r2.hasNext()) {
                        }
                    }
                }
                c2196b = c2196b2;
                if (c2196b != null) {
                    f7400e.add(c2196b);
                    c2196b.m13276b(this);
                    if (this.f7403f != null) {
                        this.f7403f.mo8716a(f7400e, true, c2196b);
                    }
                }
            }
        }
        return c2196b;
    }

    /* renamed from: a */
    public void m13236a() {
        if (f7400e == null || f7400e.size() != 0) {
            return;
        }
        C2213f.m13205a(this.f7404g).m13198c();
    }

    @Override // com.fimi.kernel.p157b.p159b.C2196b.AbstractC2202d
    /* renamed from: a */
    public void mo10038a(C2196b.EnumC2198a enumC2198a, C2196b c2196b) {
        if (enumC2198a != C2196b.EnumC2198a.Completed || c2196b.m13250m().equals(this.f7405h)) {
            return;
        }
        this.f7405h = c2196b.m13250m();
        int m13228b = m13228b();
        if (this.f7402b != null) {
            this.f7402b.mo8725a(c2196b, m13228b);
        }
        m13226c();
    }

    /* renamed from: a */
    public void m13232a(AbstractC2208a abstractC2208a) {
        this.f7402b = abstractC2208a;
    }

    /* renamed from: a */
    public void m13231a(AbstractC2209b abstractC2209b) {
        this.f7403f = abstractC2209b;
    }

    /* renamed from: a */
    public synchronized void m13229a(String str, String str2, long j, Boolean bool, String str3) {
        if (f7400e == null) {
            f7400e = new ArrayList();
        }
        int size = f7400e.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (f7400e.get(size).m13250m().equals(str)) {
                f7400e.get(size).m13288a(f7400e.get(size));
                f7400e.remove(size);
                C2213f.m13205a(this.f7404g).m13195d(str);
                break;
            } else {
                size--;
            }
        }
        C2196b m13291a = C2196b.m13291a(this.f7404g, str, str2, j, bool, str3, new C2196b.AbstractC2203e() { // from class: com.fimi.kernel.b.b.c.2
            @Override // com.fimi.kernel.p157b.p159b.C2196b.AbstractC2203e
            /* renamed from: a */
            public void mo13194a(C2196b c2196b) {
                if (c2196b != null) {
                    c2196b.m13276b(C2205c.this);
                    if (C2205c.this.m13228b() < C2205c.f7398c) {
                        c2196b.m13273c();
                    }
                    if (C2205c.this.f7403f == null) {
                        return;
                    }
                    C2205c.this.f7403f.mo8716a(C2205c.f7400e, true, c2196b);
                }
            }
        });
        if (m13291a != null) {
            f7400e.add(m13291a);
        }
    }

    /* renamed from: a */
    public boolean m13233a(C2196b c2196b) {
        if (c2196b != null) {
            C2213f.m13205a(this.f7404g).m13195d(c2196b.m13250m());
            return m13227b(c2196b);
        }
        return false;
    }

    /* renamed from: b */
    public synchronized int m13228b() {
        int i;
        i = 0;
        for (C2196b c2196b : f7400e) {
            i = c2196b.m13262g() == C2196b.EnumC2198a.Downloading ? i + 1 : i;
        }
        return i;
    }

    /* renamed from: c */
    public void m13226c() {
        if (m13228b() < f7398c) {
            for (C2196b c2196b : f7400e) {
                if (c2196b.m13262g() == C2196b.EnumC2198a.Wait) {
                    c2196b.m13273c();
                    return;
                }
            }
        }
    }

    /* renamed from: d */
    public void m13225d() {
        if (f7400e == null || f7400e.size() <= 0) {
            return;
        }
        for (C2196b c2196b : f7400e) {
            if (c2196b.m13262g() == C2196b.EnumC2198a.Downloading || c2196b.m13262g() == C2196b.EnumC2198a.Wait) {
                c2196b.m13267e();
            }
        }
    }

    /* renamed from: e */
    public void m13224e() {
        if (f7400e == null || f7400e.size() <= 0) {
            return;
        }
        for (C2196b c2196b : f7400e) {
            if (c2196b.m13262g() == C2196b.EnumC2198a.Pause) {
                if (m13228b() < f7398c) {
                    c2196b.m13273c();
                } else {
                    c2196b.m13270d();
                }
            }
        }
    }
}
