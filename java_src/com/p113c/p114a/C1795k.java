package com.p113c.p114a;

import android.view.animation.Interpolator;
import com.p113c.p114a.AbstractC1791j;
import java.util.ArrayList;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.c.a.k */
/* loaded from: classes.dex */
public class C1795k {

    /* renamed from: a */
    int f6346a;

    /* renamed from: c */
    AbstractC1791j f6348c;

    /* renamed from: d */
    Interpolator f6349d;

    /* renamed from: f */
    AbstractC1818p f6351f;

    /* renamed from: e */
    ArrayList<AbstractC1791j> f6350e = new ArrayList<>();

    /* renamed from: b */
    AbstractC1791j f6347b = this.f6350e.get(0);

    public C1795k(AbstractC1791j... abstractC1791jArr) {
        this.f6346a = abstractC1791jArr.length;
        this.f6350e.addAll(Arrays.asList(abstractC1791jArr));
        this.f6348c = this.f6350e.get(this.f6346a - 1);
        this.f6349d = this.f6348c.m14627d();
    }

    /* renamed from: a */
    public static C1795k m14614a(float... fArr) {
        int length = fArr.length;
        AbstractC1791j.C1792a[] c1792aArr = new AbstractC1791j.C1792a[Math.max(length, 2)];
        if (length == 1) {
            c1792aArr[0] = (AbstractC1791j.C1792a) AbstractC1791j.m14630b(0.0f);
            c1792aArr[1] = (AbstractC1791j.C1792a) AbstractC1791j.m14634a(1.0f, fArr[0]);
        } else {
            c1792aArr[0] = (AbstractC1791j.C1792a) AbstractC1791j.m14634a(0.0f, fArr[0]);
            for (int i = 1; i < length; i++) {
                c1792aArr[i] = (AbstractC1791j.C1792a) AbstractC1791j.m14634a(i / (length - 1), fArr[i]);
            }
        }
        return new C1788g(c1792aArr);
    }

    /* renamed from: a */
    public static C1795k m14613a(int... iArr) {
        int length = iArr.length;
        AbstractC1791j.C1793b[] c1793bArr = new AbstractC1791j.C1793b[Math.max(length, 2)];
        if (length == 1) {
            c1793bArr[0] = (AbstractC1791j.C1793b) AbstractC1791j.m14635a(0.0f);
            c1793bArr[1] = (AbstractC1791j.C1793b) AbstractC1791j.m14633a(1.0f, iArr[0]);
        } else {
            c1793bArr[0] = (AbstractC1791j.C1793b) AbstractC1791j.m14633a(0.0f, iArr[0]);
            for (int i = 1; i < length; i++) {
                c1793bArr[i] = (AbstractC1791j.C1793b) AbstractC1791j.m14633a(i / (length - 1), iArr[i]);
            }
        }
        return new C1790i(c1793bArr);
    }

    /* renamed from: a */
    public static C1795k m14612a(AbstractC1791j... abstractC1791jArr) {
        int length = abstractC1791jArr.length;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < length; i++) {
            if (abstractC1791jArr[i] instanceof AbstractC1791j.C1792a) {
                z3 = true;
            } else if (abstractC1791jArr[i] instanceof AbstractC1791j.C1793b) {
                z2 = true;
            } else {
                z = true;
            }
        }
        if (z3 && !z2 && !z) {
            AbstractC1791j.C1792a[] c1792aArr = new AbstractC1791j.C1792a[length];
            for (int i2 = 0; i2 < length; i2++) {
                c1792aArr[i2] = (AbstractC1791j.C1792a) abstractC1791jArr[i2];
            }
            return new C1788g(c1792aArr);
        } else if (!z2 || z3 || z) {
            return new C1795k(abstractC1791jArr);
        } else {
            AbstractC1791j.C1793b[] c1793bArr = new AbstractC1791j.C1793b[length];
            for (int i3 = 0; i3 < length; i3++) {
                c1793bArr[i3] = (AbstractC1791j.C1793b) abstractC1791jArr[i3];
            }
            return new C1790i(c1793bArr);
        }
    }

    /* renamed from: a */
    public static C1795k m14611a(Object... objArr) {
        int length = objArr.length;
        AbstractC1791j.C1794c[] c1794cArr = new AbstractC1791j.C1794c[Math.max(length, 2)];
        if (length == 1) {
            c1794cArr[0] = (AbstractC1791j.C1794c) AbstractC1791j.m14628c(0.0f);
            c1794cArr[1] = (AbstractC1791j.C1794c) AbstractC1791j.m14632a(1.0f, objArr[0]);
        } else {
            c1794cArr[0] = (AbstractC1791j.C1794c) AbstractC1791j.m14632a(0.0f, objArr[0]);
            for (int i = 1; i < length; i++) {
                c1794cArr[i] = (AbstractC1791j.C1794c) AbstractC1791j.m14632a(i / (length - 1), objArr[i]);
            }
        }
        return new C1795k(c1794cArr);
    }

    /* renamed from: a */
    public Object mo14616a(float f) {
        if (this.f6346a == 2) {
            if (this.f6349d != null) {
                f = this.f6349d.getInterpolation(f);
            }
            return this.f6351f.mo14531a(f, this.f6347b.mo14619b(), this.f6348c.mo14619b());
        } else if (f <= 0.0f) {
            AbstractC1791j abstractC1791j = this.f6350e.get(1);
            Interpolator m14627d = abstractC1791j.m14627d();
            if (m14627d != null) {
                f = m14627d.getInterpolation(f);
            }
            float m14629c = this.f6347b.m14629c();
            return this.f6351f.mo14531a((f - m14629c) / (abstractC1791j.m14629c() - m14629c), this.f6347b.mo14619b(), abstractC1791j.mo14619b());
        } else if (f >= 1.0f) {
            AbstractC1791j abstractC1791j2 = this.f6350e.get(this.f6346a - 2);
            Interpolator m14627d2 = this.f6348c.m14627d();
            if (m14627d2 != null) {
                f = m14627d2.getInterpolation(f);
            }
            float m14629c2 = abstractC1791j2.m14629c();
            return this.f6351f.mo14531a((f - m14629c2) / (this.f6348c.m14629c() - m14629c2), abstractC1791j2.mo14619b(), this.f6348c.mo14619b());
        } else {
            AbstractC1791j abstractC1791j3 = this.f6347b;
            int i = 1;
            while (i < this.f6346a) {
                AbstractC1791j abstractC1791j4 = this.f6350e.get(i);
                if (f < abstractC1791j4.m14629c()) {
                    Interpolator m14627d3 = abstractC1791j4.m14627d();
                    if (m14627d3 != null) {
                        f = m14627d3.getInterpolation(f);
                    }
                    float m14629c3 = abstractC1791j3.m14629c();
                    return this.f6351f.mo14531a((f - m14629c3) / (abstractC1791j4.m14629c() - m14629c3), abstractC1791j3.mo14619b(), abstractC1791j4.mo14619b());
                }
                i++;
                abstractC1791j3 = abstractC1791j4;
            }
            return this.f6348c.mo14619b();
        }
    }

    /* renamed from: a */
    public void m14615a(AbstractC1818p abstractC1818p) {
        this.f6351f = abstractC1818p;
    }

    @Override // 
    /* renamed from: b */
    public C1795k clone() {
        ArrayList<AbstractC1791j> arrayList = this.f6350e;
        int size = this.f6350e.size();
        AbstractC1791j[] abstractC1791jArr = new AbstractC1791j[size];
        for (int i = 0; i < size; i++) {
            abstractC1791jArr[i] = arrayList.get(i).clone();
        }
        return new C1795k(abstractC1791jArr);
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.f6346a) {
            String str2 = str + this.f6350e.get(i).mo14619b() + "  ";
            i++;
            str = str2;
        }
        return str;
    }
}
