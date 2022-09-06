package com.p113c.p114a;

import android.view.animation.Interpolator;
import com.p113c.p114a.AbstractC1791j;
import java.util.ArrayList;
/* renamed from: com.c.a.i */
/* loaded from: classes.dex */
class C1790i extends C1795k {

    /* renamed from: g */
    private int f6335g;

    /* renamed from: h */
    private int f6336h;

    /* renamed from: i */
    private int f6337i;

    /* renamed from: j */
    private boolean f6338j = true;

    public C1790i(AbstractC1791j.C1793b... c1793bArr) {
        super(c1793bArr);
    }

    @Override // com.p113c.p114a.C1795k
    /* renamed from: a */
    public C1790i clone() {
        ArrayList<AbstractC1791j> arrayList = this.f6350e;
        int size = this.f6350e.size();
        AbstractC1791j.C1793b[] c1793bArr = new AbstractC1791j.C1793b[size];
        for (int i = 0; i < size; i++) {
            c1793bArr[i] = (AbstractC1791j.C1793b) arrayList.get(i).clone();
        }
        return new C1790i(c1793bArr);
    }

    @Override // com.p113c.p114a.C1795k
    /* renamed from: a */
    public Object mo14616a(float f) {
        return Integer.valueOf(m14637b(f));
    }

    /* renamed from: b */
    public int m14637b(float f) {
        int i = 1;
        if (this.f6346a == 2) {
            if (this.f6338j) {
                this.f6338j = false;
                this.f6335g = ((AbstractC1791j.C1793b) this.f6350e.get(0)).m14622g();
                this.f6336h = ((AbstractC1791j.C1793b) this.f6350e.get(1)).m14622g();
                this.f6337i = this.f6336h - this.f6335g;
            }
            if (this.f6349d != null) {
                f = this.f6349d.getInterpolation(f);
            }
            return this.f6351f == null ? this.f6335g + ((int) (this.f6337i * f)) : ((Number) this.f6351f.mo14531a(f, Integer.valueOf(this.f6335g), Integer.valueOf(this.f6336h))).intValue();
        } else if (f <= 0.0f) {
            AbstractC1791j.C1793b c1793b = (AbstractC1791j.C1793b) this.f6350e.get(0);
            AbstractC1791j.C1793b c1793b2 = (AbstractC1791j.C1793b) this.f6350e.get(1);
            int m14622g = c1793b.m14622g();
            int m14622g2 = c1793b2.m14622g();
            float c = c1793b.c();
            float c2 = c1793b2.c();
            Interpolator d = c1793b2.d();
            if (d != null) {
                f = d.getInterpolation(f);
            }
            float f2 = (f - c) / (c2 - c);
            return this.f6351f == null ? ((int) (f2 * (m14622g2 - m14622g))) + m14622g : ((Number) this.f6351f.mo14531a(f2, Integer.valueOf(m14622g), Integer.valueOf(m14622g2))).intValue();
        } else if (f >= 1.0f) {
            AbstractC1791j.C1793b c1793b3 = (AbstractC1791j.C1793b) this.f6350e.get(this.f6346a - 2);
            AbstractC1791j.C1793b c1793b4 = (AbstractC1791j.C1793b) this.f6350e.get(this.f6346a - 1);
            int m14622g3 = c1793b3.m14622g();
            int m14622g4 = c1793b4.m14622g();
            float c3 = c1793b3.c();
            float c4 = c1793b4.c();
            Interpolator d2 = c1793b4.d();
            if (d2 != null) {
                f = d2.getInterpolation(f);
            }
            float f3 = (f - c3) / (c4 - c3);
            return this.f6351f == null ? ((int) (f3 * (m14622g4 - m14622g3))) + m14622g3 : ((Number) this.f6351f.mo14531a(f3, Integer.valueOf(m14622g3), Integer.valueOf(m14622g4))).intValue();
        } else {
            AbstractC1791j.C1793b c1793b5 = (AbstractC1791j.C1793b) this.f6350e.get(0);
            while (true) {
                AbstractC1791j.C1793b c1793b6 = c1793b5;
                if (i >= this.f6346a) {
                    return ((Number) this.f6350e.get(this.f6346a - 1).mo14619b()).intValue();
                }
                c1793b5 = (AbstractC1791j.C1793b) this.f6350e.get(i);
                if (f < c1793b5.c()) {
                    Interpolator d3 = c1793b5.d();
                    if (d3 != null) {
                        f = d3.getInterpolation(f);
                    }
                    float c5 = (f - c1793b6.c()) / (c1793b5.c() - c1793b6.c());
                    int m14622g5 = c1793b6.m14622g();
                    int m14622g6 = c1793b5.m14622g();
                    return this.f6351f == null ? ((int) ((m14622g6 - m14622g5) * c5)) + m14622g5 : ((Number) this.f6351f.mo14531a(c5, Integer.valueOf(m14622g5), Integer.valueOf(m14622g6))).intValue();
                }
                i++;
            }
        }
    }
}
