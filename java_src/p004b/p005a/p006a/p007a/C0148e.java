package p004b.p005a.p006a.p007a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.p318d.AbstractC5744c;
import org.p318d.AbstractC5756f;
import org.p318d.C5748d;
import org.p318d.p322d.AbstractC5749a;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p007a.p025n.C0239l;
import p004b.p005a.p006a.p007a.p027p.C0264g;
import p004b.p005a.p006a.p028b.AbstractC0266a;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p054o.AbstractC0523b;
import p004b.p005a.p006a.p028b.p054o.C0524c;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
/* renamed from: b.a.a.a.e */
/* loaded from: classes.dex */
public final class C0148e implements AbstractC0523b<AbstractC0231d>, Serializable, AbstractC5744c, AbstractC5749a {

    /* renamed from: a */
    public static final String f210a = C0148e.class.getName();

    /* renamed from: p */
    private static final int f211p = 5;
    private static final long serialVersionUID = 5454405123156820674L;

    /* renamed from: b */
    final transient C0151f f212b;

    /* renamed from: i */
    private String f213i;

    /* renamed from: j */
    private transient C0146d f214j;

    /* renamed from: k */
    private transient int f215k;

    /* renamed from: l */
    private transient C0148e f216l;

    /* renamed from: m */
    private transient List<C0148e> f217m;

    /* renamed from: n */
    private transient C0524c<AbstractC0231d> f218n;

    /* renamed from: o */
    private transient boolean f219o = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0148e(String str, C0148e c0148e, C0151f c0151f) {
        this.f213i = str;
        this.f216l = c0148e;
        this.f212b = c0151f;
    }

    /* renamed from: a */
    private synchronized void m21475a(int i) {
        if (this.f214j == null) {
            this.f215k = i;
            if (this.f217m != null) {
                int size = this.f217m.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f217m.get(i2).m21475a(i);
                }
            }
        }
    }

    /* renamed from: a */
    private void m21471a(String str, AbstractC5756f abstractC5756f, C0146d c0146d, String str2, Object obj, Object obj2, Throwable th) {
        EnumC0533l m21440a = this.f212b.m21440a(abstractC5756f, this, c0146d, str2, obj, obj2, th);
        if (m21440a == EnumC0533l.NEUTRAL) {
            if (this.f215k > c0146d.f208v) {
                return;
            }
        } else if (m21440a == EnumC0533l.DENY) {
            return;
        }
        m21463b(str, abstractC5756f, c0146d, str2, new Object[]{obj, obj2}, th);
    }

    /* renamed from: a */
    private void m21470a(String str, AbstractC5756f abstractC5756f, C0146d c0146d, String str2, Object obj, Throwable th) {
        EnumC0533l m21439a = this.f212b.m21439a(abstractC5756f, this, c0146d, str2, obj, th);
        if (m21439a == EnumC0533l.NEUTRAL) {
            if (this.f215k > c0146d.f208v) {
                return;
            }
        } else if (m21439a == EnumC0533l.DENY) {
            return;
        }
        m21463b(str, abstractC5756f, c0146d, str2, new Object[]{obj}, th);
    }

    /* renamed from: a */
    private void m21469a(String str, AbstractC5756f abstractC5756f, C0146d c0146d, String str2, Object[] objArr, Throwable th) {
        EnumC0533l m21438a = this.f212b.m21438a(abstractC5756f, this, c0146d, str2, objArr, th);
        if (m21438a == EnumC0533l.NEUTRAL) {
            if (this.f215k > c0146d.f208v) {
                return;
            }
        } else if (m21438a == EnumC0533l.DENY) {
            return;
        }
        m21463b(str, abstractC5756f, c0146d, str2, objArr, th);
    }

    /* renamed from: b */
    private int m21464b(AbstractC0231d abstractC0231d) {
        if (this.f218n != null) {
            return this.f218n.m20250a((C0524c<AbstractC0231d>) abstractC0231d);
        }
        return 0;
    }

    /* renamed from: b */
    private EnumC0533l m21462b(AbstractC5756f abstractC5756f, C0146d c0146d) {
        return this.f212b.m21438a(abstractC5756f, this, c0146d, (String) null, (Object[]) null, (Throwable) null);
    }

    /* renamed from: b */
    private void m21463b(String str, AbstractC5756f abstractC5756f, C0146d c0146d, String str2, Object[] objArr, Throwable th) {
        C0239l c0239l = new C0239l(str, this, c0146d, str2, th, objArr);
        c0239l.m21229a(abstractC5756f);
        m21473a(c0239l);
    }

    /* renamed from: o */
    private boolean m21455o() {
        return this.f216l == null;
    }

    /* renamed from: p */
    private void m21454p() {
        this.f215k = 10000;
        if (m21455o()) {
            this.f214j = C0146d.f205s;
        } else {
            this.f214j = null;
        }
    }

    /* renamed from: a */
    public C0146d m21476a() {
        return C0146d.m21485a(this.f215k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C0148e m21472a(String str) {
        if (this.f217m == null) {
            return null;
        }
        int size = this.f217m.size();
        for (int i = 0; i < size; i++) {
            C0148e c0148e = this.f217m.get(i);
            if (str.equals(c0148e.mo88d())) {
                return c0148e;
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized void m21474a(C0146d c0146d) {
        if (this.f214j != c0146d) {
            if (c0146d == null && m21455o()) {
                throw new IllegalArgumentException("The level of the root logger cannot be set to null");
            }
            this.f214j = c0146d;
            if (c0146d == null) {
                this.f215k = this.f216l.f215k;
                c0146d = this.f216l.m21476a();
            } else {
                this.f215k = c0146d.f208v;
            }
            if (this.f217m != null) {
                int size = this.f217m.size();
                for (int i = 0; i < size; i++) {
                    this.f217m.get(i).m21475a(this.f215k);
                }
            }
            this.f212b.m21444a(this, c0146d);
        }
    }

    /* renamed from: a */
    public void m21473a(AbstractC0231d abstractC0231d) {
        int i = 0;
        for (C0148e c0148e = this; c0148e != null; c0148e = c0148e.f216l) {
            i += c0148e.m21464b(abstractC0231d);
            if (!c0148e.f219o) {
                break;
            }
        }
        if (i == 0) {
            this.f212b.m21445a(this);
        }
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: a */
    public synchronized void mo20251a(AbstractC0266a<AbstractC0231d> abstractC0266a) {
        if (this.f218n == null) {
            this.f218n = new C0524c<>();
        }
        this.f218n.mo20251a(abstractC0266a);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo118a(String str, Object obj) {
        m21470a(f210a, (AbstractC5756f) null, C0146d.f206t, str, obj, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo117a(String str, Object obj, Object obj2) {
        m21471a(f210a, null, C0146d.f206t, str, obj, obj2, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo116a(String str, Throwable th) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f206t, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo115a(String str, Object[] objArr) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f206t, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo113a(AbstractC5756f abstractC5756f, String str) {
        m21469a(f210a, abstractC5756f, C0146d.f206t, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.p322d.AbstractC5749a
    /* renamed from: a */
    public void mo31a(AbstractC5756f abstractC5756f, String str, int i, String str2, Object[] objArr, Throwable th) {
        m21469a(str, abstractC5756f, C0146d.m21479b(i), str2, objArr, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo112a(AbstractC5756f abstractC5756f, String str, Object obj) {
        m21470a(f210a, abstractC5756f, C0146d.f206t, str, obj, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo111a(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m21471a(f210a, abstractC5756f, C0146d.f206t, str, obj, obj2, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo110a(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m21469a(f210a, abstractC5756f, C0146d.f206t, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo109a(AbstractC5756f abstractC5756f, String str, Object[] objArr) {
        m21469a(f210a, abstractC5756f, C0146d.f206t, str, objArr, (Throwable) null);
    }

    /* renamed from: a */
    public void m21467a(boolean z) {
        this.f219o = z;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public boolean mo114a(AbstractC5756f abstractC5756f) {
        EnumC0533l m21462b = m21462b(abstractC5756f, C0146d.f205s);
        if (m21462b == EnumC0533l.NEUTRAL) {
            return this.f215k <= 10000;
        } else if (m21462b == EnumC0533l.DENY) {
            return false;
        } else {
            if (m21462b == EnumC0533l.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + m21462b);
        }
    }

    /* renamed from: a */
    public boolean m21468a(AbstractC5756f abstractC5756f, C0146d c0146d) {
        EnumC0533l m21462b = m21462b(abstractC5756f, c0146d);
        if (m21462b == EnumC0533l.NEUTRAL) {
            return this.f215k <= c0146d.f208v;
        } else if (m21462b == EnumC0533l.DENY) {
            return false;
        } else {
            if (m21462b == EnumC0533l.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + m21462b);
        }
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: a_ */
    public AbstractC0266a<AbstractC0231d> mo20249a_(String str) {
        if (this.f218n == null) {
            return null;
        }
        return this.f218n.mo20249a_(str);
    }

    /* renamed from: b */
    int m21466b() {
        return this.f215k;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo108b(String str, Object obj) {
        m21470a(f210a, (AbstractC5756f) null, C0146d.f205s, str, obj, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo107b(String str, Object obj, Object obj2) {
        m21471a(f210a, null, C0146d.f205s, str, obj, obj2, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo106b(String str, Throwable th) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f205s, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo105b(String str, Object[] objArr) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f205s, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo103b(AbstractC5756f abstractC5756f, String str) {
        m21469a(f210a, abstractC5756f, C0146d.f205s, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo102b(AbstractC5756f abstractC5756f, String str, Object obj) {
        m21470a(f210a, abstractC5756f, C0146d.f205s, str, obj, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo101b(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m21471a(f210a, abstractC5756f, C0146d.f205s, str, obj, obj2, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo100b(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m21469a(f210a, abstractC5756f, C0146d.f205s, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo99b(AbstractC5756f abstractC5756f, String str, Object[] objArr) {
        m21469a(f210a, abstractC5756f, C0146d.f205s, str, objArr, (Throwable) null);
    }

    /* renamed from: b */
    public boolean m21465b(C0146d c0146d) {
        return m21468a((AbstractC5756f) null, c0146d);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: b */
    public boolean mo20248b(AbstractC0266a<AbstractC0231d> abstractC0266a) {
        if (this.f218n == null) {
            return false;
        }
        return this.f218n.mo20248b(abstractC0266a);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: b */
    public boolean mo20247b(String str) {
        if (this.f218n == null) {
            return false;
        }
        return this.f218n.mo20247b(str);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public boolean mo104b(AbstractC5756f abstractC5756f) {
        EnumC0533l m21462b = m21462b(abstractC5756f, C0146d.f204r);
        if (m21462b == EnumC0533l.NEUTRAL) {
            return this.f215k <= 20000;
        } else if (m21462b == EnumC0533l.DENY) {
            return false;
        } else {
            if (m21462b == EnumC0533l.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + m21462b);
        }
    }

    /* renamed from: c */
    public C0146d m21461c() {
        return this.f214j;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo98c(String str, Object obj) {
        m21470a(f210a, (AbstractC5756f) null, C0146d.f202p, str, obj, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo97c(String str, Object obj, Object obj2) {
        m21471a(f210a, null, C0146d.f202p, str, obj, obj2, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo96c(String str, Throwable th) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f202p, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo95c(String str, Object[] objArr) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f202p, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo93c(AbstractC5756f abstractC5756f, String str) {
        m21469a(f210a, abstractC5756f, C0146d.f202p, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo92c(AbstractC5756f abstractC5756f, String str, Object obj) {
        m21470a(f210a, abstractC5756f, C0146d.f202p, str, obj, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo91c(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m21471a(f210a, abstractC5756f, C0146d.f202p, str, obj, obj2, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo90c(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m21469a(f210a, abstractC5756f, C0146d.f202p, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo89c(AbstractC5756f abstractC5756f, String str, Object[] objArr) {
        m21469a(f210a, abstractC5756f, C0146d.f202p, str, objArr, (Throwable) null);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: c */
    public boolean mo20246c(AbstractC0266a<AbstractC0231d> abstractC0266a) {
        if (this.f218n == null) {
            return false;
        }
        return this.f218n.mo20246c(abstractC0266a);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public boolean mo94c(AbstractC5756f abstractC5756f) {
        EnumC0533l m21462b = m21462b(abstractC5756f, C0146d.f206t);
        if (m21462b == EnumC0533l.NEUTRAL) {
            return this.f215k <= 5000;
        } else if (m21462b == EnumC0533l.DENY) {
            return false;
        } else {
            if (m21462b == EnumC0533l.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + m21462b);
        }
    }

    /* renamed from: d */
    C0148e m21460d(String str) {
        if (C0264g.m21105a(str) != -1) {
            throw new IllegalArgumentException("Child name [" + str + " passed as parameter, may not include [" + C0359h.f677G + "]");
        }
        if (this.f217m == null) {
            this.f217m = new ArrayList();
        }
        C0148e c0148e = m21455o() ? new C0148e(str, this, this.f212b) : new C0148e(this.f213i + C0359h.f677G + str, this, this.f212b);
        this.f217m.add(c0148e);
        c0148e.f215k = this.f215k;
        return c0148e;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public String mo88d() {
        return this.f213i;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo87d(String str, Object obj) {
        m21470a(f210a, (AbstractC5756f) null, C0146d.f204r, str, obj, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo86d(String str, Object obj, Object obj2) {
        m21471a(f210a, null, C0146d.f204r, str, obj, obj2, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo85d(String str, Throwable th) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f204r, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo84d(String str, Object[] objArr) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f204r, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo82d(AbstractC5756f abstractC5756f, String str) {
        m21469a(f210a, abstractC5756f, C0146d.f204r, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo81d(AbstractC5756f abstractC5756f, String str, Object obj) {
        m21470a(f210a, abstractC5756f, C0146d.f204r, str, obj, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo80d(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m21471a(f210a, abstractC5756f, C0146d.f204r, str, obj, obj2, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo79d(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m21469a(f210a, abstractC5756f, C0146d.f204r, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo78d(AbstractC5756f abstractC5756f, String str, Object[] objArr) {
        m21469a(f210a, abstractC5756f, C0146d.f204r, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public boolean mo83d(AbstractC5756f abstractC5756f) {
        EnumC0533l m21462b = m21462b(abstractC5756f, C0146d.f202p);
        if (m21462b == EnumC0533l.NEUTRAL) {
            return this.f215k <= 40000;
        } else if (m21462b == EnumC0533l.DENY) {
            return false;
        } else {
            if (m21462b == EnumC0533l.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + m21462b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public C0148e m21459e(String str) {
        if (C0264g.m21104a(str, this.f213i.length() + 1) != -1) {
            throw new IllegalArgumentException("For logger [" + this.f213i + "] child name [" + str + " passed as parameter, may not include '.' after index" + (this.f213i.length() + 1));
        }
        if (this.f217m == null) {
            this.f217m = new ArrayList(5);
        }
        C0148e c0148e = new C0148e(str, this, this.f212b);
        this.f217m.add(c0148e);
        c0148e.f215k = this.f215k;
        return c0148e;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: e */
    public void mo20245e() {
        if (this.f218n != null) {
            this.f218n.mo20245e();
        }
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo77e(String str, Object obj) {
        m21470a(f210a, (AbstractC5756f) null, C0146d.f203q, str, obj, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo76e(String str, Object obj, Object obj2) {
        m21471a(f210a, null, C0146d.f203q, str, obj, obj2, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo75e(String str, Throwable th) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f203q, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo74e(String str, Object[] objArr) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f203q, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo72e(AbstractC5756f abstractC5756f, String str) {
        m21469a(f210a, abstractC5756f, C0146d.f203q, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo71e(AbstractC5756f abstractC5756f, String str, Object obj) {
        m21470a(f210a, abstractC5756f, C0146d.f203q, str, obj, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo70e(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m21471a(f210a, abstractC5756f, C0146d.f203q, str, obj, obj2, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo69e(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m21469a(f210a, abstractC5756f, C0146d.f203q, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo68e(AbstractC5756f abstractC5756f, String str, Object[] objArr) {
        m21469a(f210a, abstractC5756f, C0146d.f203q, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public boolean mo73e(AbstractC5756f abstractC5756f) {
        EnumC0533l m21462b = m21462b(abstractC5756f, C0146d.f203q);
        if (m21462b == EnumC0533l.NEUTRAL) {
            return this.f215k <= 30000;
        } else if (m21462b == EnumC0533l.DENY) {
            return false;
        } else {
            if (m21462b == EnumC0533l.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + m21462b);
        }
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0523b
    /* renamed from: f */
    public Iterator<AbstractC0266a<AbstractC0231d>> mo20244f() {
        return this.f218n == null ? Collections.EMPTY_LIST.iterator() : this.f218n.mo20244f();
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: f */
    public void mo67f(String str) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f206t, str, (Object[]) null, (Throwable) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m21458g() {
        mo20245e();
        m21454p();
        this.f219o = true;
        if (this.f217m == null) {
            return;
        }
        for (C0148e c0148e : this.f217m) {
            c0148e.m21458g();
        }
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: g */
    public void mo66g(String str) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f205s, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: h */
    public void mo64h(String str) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f202p, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: h */
    public boolean mo65h() {
        return mo114a((AbstractC5756f) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: i */
    public void mo62i(String str) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f204r, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: i */
    public boolean mo63i() {
        return mo104b((AbstractC5756f) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: j */
    public void mo60j(String str) {
        m21469a(f210a, (AbstractC5756f) null, C0146d.f203q, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: j */
    public boolean mo61j() {
        return mo94c((AbstractC5756f) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: k */
    public boolean mo59k() {
        return mo83d((AbstractC5756f) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: l */
    public boolean mo58l() {
        return mo73e((AbstractC5756f) null);
    }

    /* renamed from: m */
    public boolean m21457m() {
        return this.f219o;
    }

    /* renamed from: n */
    public C0151f m21456n() {
        return this.f212b;
    }

    protected Object readResolve() {
        return C5748d.m48a(mo88d());
    }

    public String toString() {
        return "Logger[" + this.f213i + "]";
    }
}
