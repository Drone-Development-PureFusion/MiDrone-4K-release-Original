package com.p113c.p114a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.p113c.p114a.AbstractC1775a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: com.c.a.q */
/* loaded from: classes.dex */
public class C1819q extends AbstractC1775a {

    /* renamed from: b */
    static final int f6397b = 0;

    /* renamed from: c */
    static final int f6398c = 1;

    /* renamed from: d */
    static final int f6399d = 0;

    /* renamed from: e */
    static final int f6400e = 1;

    /* renamed from: f */
    static final int f6401f = 2;

    /* renamed from: m */
    public static final int f6402m = 1;

    /* renamed from: n */
    public static final int f6403n = 2;

    /* renamed from: o */
    public static final int f6404o = -1;

    /* renamed from: D */
    private long f6418D;

    /* renamed from: g */
    long f6427g;

    /* renamed from: k */
    C1812n[] f6431k;

    /* renamed from: l */
    HashMap<String, C1812n> f6432l;

    /* renamed from: q */
    private static ThreadLocal<HandlerC1825a> f6406q = new ThreadLocal<>();

    /* renamed from: r */
    private static final ThreadLocal<ArrayList<C1819q>> f6407r = new ThreadLocal<ArrayList<C1819q>>() { // from class: com.c.a.q.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<C1819q> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: s */
    private static final ThreadLocal<ArrayList<C1819q>> f6408s = new ThreadLocal<ArrayList<C1819q>>() { // from class: com.c.a.q.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<C1819q> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: t */
    private static final ThreadLocal<ArrayList<C1819q>> f6409t = new ThreadLocal<ArrayList<C1819q>>() { // from class: com.c.a.q.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<C1819q> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: u */
    private static final ThreadLocal<ArrayList<C1819q>> f6410u = new ThreadLocal<ArrayList<C1819q>>() { // from class: com.c.a.q.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<C1819q> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: v */
    private static final ThreadLocal<ArrayList<C1819q>> f6411v = new ThreadLocal<ArrayList<C1819q>>() { // from class: com.c.a.q.5
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<C1819q> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: w */
    private static final Interpolator f6412w = new AccelerateDecelerateInterpolator();

    /* renamed from: x */
    private static final AbstractC1818p f6413x = new C1789h();

    /* renamed from: y */
    private static final AbstractC1818p f6414y = new C1787f();

    /* renamed from: p */
    private static final long f6405p = 10;

    /* renamed from: I */
    private static long f6396I = f6405p;

    /* renamed from: h */
    long f6428h = -1;

    /* renamed from: z */
    private boolean f6433z = false;

    /* renamed from: A */
    private int f6415A = 0;

    /* renamed from: B */
    private float f6416B = 0.0f;

    /* renamed from: C */
    private boolean f6417C = false;

    /* renamed from: i */
    int f6429i = 0;

    /* renamed from: E */
    private boolean f6419E = false;

    /* renamed from: F */
    private boolean f6420F = false;

    /* renamed from: j */
    boolean f6430j = false;

    /* renamed from: G */
    private long f6421G = 300;

    /* renamed from: H */
    private long f6422H = 0;

    /* renamed from: J */
    private int f6423J = 0;

    /* renamed from: K */
    private int f6424K = 1;

    /* renamed from: L */
    private Interpolator f6425L = f6412w;

    /* renamed from: M */
    private ArrayList<AbstractC1826b> f6426M = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.c.a.q$a */
    /* loaded from: classes.dex */
    public static class HandlerC1825a extends Handler {
        private HandlerC1825a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            int i;
            ArrayList arrayList = (ArrayList) C1819q.f6407r.get();
            ArrayList arrayList2 = (ArrayList) C1819q.f6409t.get();
            switch (message.what) {
                case 0:
                    ArrayList arrayList3 = (ArrayList) C1819q.f6408s.get();
                    z = arrayList.size() <= 0 && arrayList2.size() <= 0;
                    while (arrayList3.size() > 0) {
                        ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                        arrayList3.clear();
                        int size = arrayList4.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            C1819q c1819q = (C1819q) arrayList4.get(i2);
                            if (c1819q.f6422H == 0) {
                                c1819q.m14482o();
                            } else {
                                arrayList2.add(c1819q);
                            }
                        }
                    }
                    break;
                case 1:
                    z = true;
                    break;
                default:
                    return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) C1819q.f6411v.get();
            ArrayList arrayList6 = (ArrayList) C1819q.f6410u.get();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                C1819q c1819q2 = (C1819q) arrayList2.get(i3);
                if (c1819q2.m14486g(currentAnimationTimeMillis)) {
                    arrayList5.add(c1819q2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i4 = 0; i4 < size3; i4++) {
                    C1819q c1819q3 = (C1819q) arrayList5.get(i4);
                    c1819q3.m14482o();
                    c1819q3.f6419E = true;
                    arrayList2.remove(c1819q3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i5 = 0;
            while (i5 < size4) {
                C1819q c1819q4 = (C1819q) arrayList.get(i5);
                if (c1819q4.mo14495c(currentAnimationTimeMillis)) {
                    arrayList6.add(c1819q4);
                }
                if (arrayList.size() == size4) {
                    i = i5 + 1;
                } else {
                    size4--;
                    arrayList6.remove(c1819q4);
                    i = i5;
                }
                size4 = size4;
                i5 = i;
            }
            if (arrayList6.size() > 0) {
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 < arrayList6.size()) {
                        ((C1819q) arrayList6.get(i7)).m14484m();
                        i6 = i7 + 1;
                    } else {
                        arrayList6.clear();
                    }
                }
            }
            if (z) {
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    return;
                }
                sendEmptyMessageDelayed(1, Math.max(0L, C1819q.f6396I - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    /* renamed from: com.c.a.q$b */
    /* loaded from: classes.dex */
    public interface AbstractC1826b {
        void onAnimationUpdate(C1819q c1819q);
    }

    /* renamed from: B */
    public static int m14529B() {
        return f6407r.get().size();
    }

    /* renamed from: C */
    public static void m14528C() {
        f6407r.get().clear();
        f6408s.get().clear();
        f6409t.get().clear();
    }

    /* renamed from: a */
    public static C1819q m14515a(AbstractC1818p abstractC1818p, Object... objArr) {
        C1819q c1819q = new C1819q();
        c1819q.mo14506a(objArr);
        c1819q.m14516a(abstractC1818p);
        return c1819q;
    }

    /* renamed from: a */
    public static C1819q m14507a(C1812n... c1812nArr) {
        C1819q c1819q = new C1819q();
        c1819q.m14497b(c1812nArr);
        return c1819q;
    }

    /* renamed from: a */
    private void m14510a(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f6433z = z;
        this.f6415A = 0;
        this.f6429i = 0;
        this.f6420F = true;
        this.f6417C = false;
        f6408s.get().add(this);
        if (this.f6422H == 0) {
            m14490e(m14479s());
            this.f6429i = 0;
            this.f6419E = true;
            if (this.f6284a != null) {
                ArrayList arrayList = (ArrayList) this.f6284a.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((AbstractC1775a.AbstractC1776a) arrayList.get(i)).mo14312a(this);
                }
            }
        }
        HandlerC1825a handlerC1825a = f6406q.get();
        if (handlerC1825a == null) {
            handlerC1825a = new HandlerC1825a();
            f6406q.set(handlerC1825a);
        }
        handlerC1825a.sendEmptyMessage(0);
    }

    /* renamed from: b */
    public static C1819q m14499b(float... fArr) {
        C1819q c1819q = new C1819q();
        c1819q.mo14509a(fArr);
        return c1819q;
    }

    /* renamed from: b */
    public static C1819q m14498b(int... iArr) {
        C1819q c1819q = new C1819q();
        c1819q.mo14508a(iArr);
        return c1819q;
    }

    /* renamed from: f */
    public static void m14488f(long j) {
        f6396I = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public boolean m14486g(long j) {
        if (!this.f6417C) {
            this.f6417C = true;
            this.f6418D = j;
        } else {
            long j2 = j - this.f6418D;
            if (j2 > this.f6422H) {
                this.f6427g = j - (j2 - this.f6422H);
                this.f6429i = 1;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m14484m() {
        f6407r.get().remove(this);
        f6408s.get().remove(this);
        f6409t.get().remove(this);
        this.f6429i = 0;
        if (this.f6419E && this.f6284a != null) {
            ArrayList arrayList = (ArrayList) this.f6284a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((AbstractC1775a.AbstractC1776a) arrayList.get(i)).mo14311b(this);
            }
        }
        this.f6419E = false;
        this.f6420F = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m14482o() {
        mo14483n();
        f6407r.get().add(this);
        if (this.f6422H <= 0 || this.f6284a == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.f6284a.clone();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC1775a.AbstractC1776a) arrayList.get(i)).mo14312a(this);
        }
    }

    /* renamed from: t */
    public static long m14478t() {
        return f6396I;
    }

    /* renamed from: A */
    public float m14530A() {
        return this.f6416B;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: a */
    public void mo14521a() {
        m14510a(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14520a(float f) {
        float interpolation = this.f6425L.getInterpolation(f);
        this.f6416B = interpolation;
        int length = this.f6431k.length;
        for (int i = 0; i < length; i++) {
            this.f6431k[i].mo14539a(interpolation);
        }
        if (this.f6426M != null) {
            int size = this.f6426M.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f6426M.get(i2).onAnimationUpdate(this);
            }
        }
    }

    /* renamed from: a */
    public void m14519a(int i) {
        this.f6423J = i;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: a */
    public void mo14518a(long j) {
        this.f6422H = j;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: a */
    public void mo14517a(Interpolator interpolator) {
        if (interpolator != null) {
            this.f6425L = interpolator;
        } else {
            this.f6425L = new LinearInterpolator();
        }
    }

    /* renamed from: a */
    public void m14516a(AbstractC1818p abstractC1818p) {
        if (abstractC1818p == null || this.f6431k == null || this.f6431k.length <= 0) {
            return;
        }
        this.f6431k[0].m14565a(abstractC1818p);
    }

    /* renamed from: a */
    public void m14514a(AbstractC1826b abstractC1826b) {
        if (this.f6426M == null) {
            this.f6426M = new ArrayList<>();
        }
        this.f6426M.add(abstractC1826b);
    }

    /* renamed from: a */
    public void mo14509a(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        if (this.f6431k == null || this.f6431k.length == 0) {
            m14497b(C1812n.m14552a("", fArr));
        } else {
            this.f6431k[0].mo14542a(fArr);
        }
        this.f6430j = false;
    }

    /* renamed from: a */
    public void mo14508a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        if (this.f6431k == null || this.f6431k.length == 0) {
            m14497b(C1812n.m14551a("", iArr));
        } else {
            this.f6431k[0].mo14537a(iArr);
        }
        this.f6430j = false;
    }

    /* renamed from: a */
    public void mo14506a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        if (this.f6431k == null || this.f6431k.length == 0) {
            m14497b(C1812n.m14554a("", (AbstractC1818p) null, objArr));
        } else {
            this.f6431k[0].m14548a(objArr);
        }
        this.f6430j = false;
    }

    /* renamed from: b */
    public Object m14500b(String str) {
        C1812n c1812n = this.f6432l.get(str);
        if (c1812n != null) {
            return c1812n.mo14536d();
        }
        return null;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: b */
    public void mo14505b() {
        if (this.f6429i != 0 || f6408s.get().contains(this) || f6409t.get().contains(this)) {
            if (this.f6419E && this.f6284a != null) {
                Iterator it2 = ((ArrayList) this.f6284a.clone()).iterator();
                while (it2.hasNext()) {
                    ((AbstractC1775a.AbstractC1776a) it2.next()).mo14310c(this);
                }
            }
            m14484m();
        }
    }

    /* renamed from: b */
    public void m14504b(int i) {
        this.f6424K = i;
    }

    /* renamed from: b */
    public void m14502b(AbstractC1826b abstractC1826b) {
        if (this.f6426M == null) {
            return;
        }
        this.f6426M.remove(abstractC1826b);
        if (this.f6426M.size() != 0) {
            return;
        }
        this.f6426M = null;
    }

    /* renamed from: b */
    public void m14497b(C1812n... c1812nArr) {
        int length = c1812nArr.length;
        this.f6431k = c1812nArr;
        this.f6432l = new HashMap<>(length);
        for (C1812n c1812n : c1812nArr) {
            this.f6432l.put(c1812n.m14544c(), c1812n);
        }
        this.f6430j = false;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: c */
    public void mo14496c() {
        if (!f6407r.get().contains(this) && !f6408s.get().contains(this)) {
            this.f6417C = false;
            m14482o();
        } else if (!this.f6430j) {
            mo14483n();
        }
        if (this.f6423J <= 0 || (this.f6423J & 1) != 1) {
            mo14520a(1.0f);
        } else {
            mo14520a(0.0f);
        }
        m14484m();
    }

    /* renamed from: c */
    boolean mo14495c(long j) {
        float f;
        boolean z = false;
        if (this.f6429i == 0) {
            this.f6429i = 1;
            if (this.f6428h < 0) {
                this.f6427g = j;
            } else {
                this.f6427g = j - this.f6428h;
                this.f6428h = -1L;
            }
        }
        switch (this.f6429i) {
            case 1:
            case 2:
                float f2 = this.f6421G > 0 ? ((float) (j - this.f6427g)) / ((float) this.f6421G) : 1.0f;
                if (f2 < 1.0f) {
                    f = f2;
                } else if (this.f6415A < this.f6423J || this.f6423J == -1) {
                    if (this.f6284a != null) {
                        int size = this.f6284a.size();
                        for (int i = 0; i < size; i++) {
                            this.f6284a.get(i).mo14309d(this);
                        }
                    }
                    if (this.f6424K == 2) {
                        this.f6433z = !this.f6433z;
                    }
                    this.f6415A += (int) f2;
                    f = f2 % 1.0f;
                    this.f6427g += this.f6421G;
                } else {
                    f = Math.min(f2, 1.0f);
                    z = true;
                }
                if (this.f6433z) {
                    f = 1.0f - f;
                }
                mo14520a(f);
                break;
        }
        return z;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: d */
    public long mo14493d() {
        return this.f6422H;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: d */
    public C1819q mo14503b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f6421G = j;
        return this;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: e */
    public long mo14491e() {
        return this.f6421G;
    }

    /* renamed from: e */
    public void m14490e(long j) {
        mo14483n();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f6429i != 1) {
            this.f6428h = j;
            this.f6429i = 2;
        }
        this.f6427g = currentAnimationTimeMillis - j;
        mo14495c(currentAnimationTimeMillis);
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: f */
    public boolean mo14489f() {
        return this.f6429i == 1 || this.f6419E;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: g */
    public boolean mo14487g() {
        return this.f6420F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo14483n() {
        if (!this.f6430j) {
            int length = this.f6431k.length;
            for (int i = 0; i < length; i++) {
                this.f6431k[i].m14547b();
            }
            this.f6430j = true;
        }
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: q */
    public C1819q mo14485j() {
        C1819q c1819q = (C1819q) super.clone();
        if (this.f6426M != null) {
            ArrayList<AbstractC1826b> arrayList = this.f6426M;
            c1819q.f6426M = new ArrayList<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                c1819q.f6426M.add(arrayList.get(i));
            }
        }
        c1819q.f6428h = -1L;
        c1819q.f6433z = false;
        c1819q.f6415A = 0;
        c1819q.f6430j = false;
        c1819q.f6429i = 0;
        c1819q.f6417C = false;
        C1812n[] c1812nArr = this.f6431k;
        if (c1812nArr != null) {
            int length = c1812nArr.length;
            c1819q.f6431k = new C1812n[length];
            c1819q.f6432l = new HashMap<>(length);
            for (int i2 = 0; i2 < length; i2++) {
                C1812n clone = c1812nArr[i2].clone();
                c1819q.f6431k[i2] = clone;
                c1819q.f6432l.put(clone.m14544c(), clone);
            }
        }
        return c1819q;
    }

    /* renamed from: r */
    public C1812n[] m14480r() {
        return this.f6431k;
    }

    /* renamed from: s */
    public long m14479s() {
        if (!this.f6430j || this.f6429i == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f6427g;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f6431k != null) {
            for (int i = 0; i < this.f6431k.length; i++) {
                str = str + "\n    " + this.f6431k[i].toString();
            }
        }
        return str;
    }

    /* renamed from: u */
    public Object m14477u() {
        if (this.f6431k == null || this.f6431k.length <= 0) {
            return null;
        }
        return this.f6431k[0].mo14536d();
    }

    /* renamed from: v */
    public int m14476v() {
        return this.f6423J;
    }

    /* renamed from: w */
    public int m14475w() {
        return this.f6424K;
    }

    /* renamed from: x */
    public void m14474x() {
        if (this.f6426M == null) {
            return;
        }
        this.f6426M.clear();
        this.f6426M = null;
    }

    /* renamed from: y */
    public Interpolator m14473y() {
        return this.f6425L;
    }

    /* renamed from: z */
    public void m14472z() {
        this.f6433z = !this.f6433z;
        if (this.f6429i != 1) {
            m14510a(true);
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f6427g = currentAnimationTimeMillis - (this.f6421G - (currentAnimationTimeMillis - this.f6427g));
    }
}
