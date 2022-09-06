package com.p113c.p114a;

import android.view.animation.Interpolator;
import com.p113c.p114a.AbstractC1791j;
import java.util.ArrayList;
/* renamed from: com.c.a.g */
/* loaded from: classes.dex */
class C1788g extends C1795k {

    /* renamed from: g */
    private float f6331g;

    /* renamed from: h */
    private float f6332h;

    /* renamed from: i */
    private float f6333i;

    /* renamed from: j */
    private boolean f6334j = true;

    public C1788g(AbstractC1791j.C1792a... c1792aArr) {
        super(c1792aArr);
    }

    @Override // com.p113c.p114a.C1795k
    /* renamed from: a */
    public C1788g clone() {
        ArrayList<AbstractC1791j> arrayList = this.f6350e;
        int size = this.f6350e.size();
        AbstractC1791j.C1792a[] c1792aArr = new AbstractC1791j.C1792a[size];
        for (int i = 0; i < size; i++) {
            c1792aArr[i] = (AbstractC1791j.C1792a) arrayList.get(i).clone();
        }
        return new C1788g(c1792aArr);
    }

    @Override // com.p113c.p114a.C1795k
    /* renamed from: a */
    public Object mo14616a(float f) {
        return Float.valueOf(m14640b(f));
    }

    /* renamed from: b */
    public float m14640b(float f) {
        int i = 1;
        if (this.f6346a == 2) {
            if (this.f6334j) {
                this.f6334j = false;
                this.f6331g = ((AbstractC1791j.C1792a) this.f6350e.get(0)).m14624g();
                this.f6332h = ((AbstractC1791j.C1792a) this.f6350e.get(1)).m14624g();
                this.f6333i = this.f6332h - this.f6331g;
            }
            if (this.f6349d != null) {
                f = this.f6349d.getInterpolation(f);
            }
            return this.f6351f == null ? this.f6331g + (this.f6333i * f) : ((Number) this.f6351f.mo14531a(f, Float.valueOf(this.f6331g), Float.valueOf(this.f6332h))).floatValue();
        } else if (f <= 0.0f) {
            AbstractC1791j.C1792a c1792a = (AbstractC1791j.C1792a) this.f6350e.get(0);
            AbstractC1791j.C1792a c1792a2 = (AbstractC1791j.C1792a) this.f6350e.get(1);
            float m14624g = c1792a.m14624g();
            float m14624g2 = c1792a2.m14624g();
            float c = c1792a.c();
            float c2 = c1792a2.c();
            Interpolator d = c1792a2.d();
            if (d != null) {
                f = d.getInterpolation(f);
            }
            float f2 = (f - c) / (c2 - c);
            return this.f6351f == null ? (f2 * (m14624g2 - m14624g)) + m14624g : ((Number) this.f6351f.mo14531a(f2, Float.valueOf(m14624g), Float.valueOf(m14624g2))).floatValue();
        } else if (f >= 1.0f) {
            AbstractC1791j.C1792a c1792a3 = (AbstractC1791j.C1792a) this.f6350e.get(this.f6346a - 2);
            AbstractC1791j.C1792a c1792a4 = (AbstractC1791j.C1792a) this.f6350e.get(this.f6346a - 1);
            float m14624g3 = c1792a3.m14624g();
            float m14624g4 = c1792a4.m14624g();
            float c3 = c1792a3.c();
            float c4 = c1792a4.c();
            Interpolator d2 = c1792a4.d();
            if (d2 != null) {
                f = d2.getInterpolation(f);
            }
            float f3 = (f - c3) / (c4 - c3);
            return this.f6351f == null ? (f3 * (m14624g4 - m14624g3)) + m14624g3 : ((Number) this.f6351f.mo14531a(f3, Float.valueOf(m14624g3), Float.valueOf(m14624g4))).floatValue();
        } else {
            AbstractC1791j.C1792a c1792a5 = (AbstractC1791j.C1792a) this.f6350e.get(0);
            while (true) {
                AbstractC1791j.C1792a c1792a6 = c1792a5;
                if (i >= this.f6346a) {
                    return ((Number) this.f6350e.get(this.f6346a - 1).mo14619b()).floatValue();
                }
                c1792a5 = (AbstractC1791j.C1792a) this.f6350e.get(i);
                if (f < c1792a5.c()) {
                    Interpolator d3 = c1792a5.d();
                    if (d3 != null) {
                        f = d3.getInterpolation(f);
                    }
                    float c5 = (f - c1792a6.c()) / (c1792a5.c() - c1792a6.c());
                    float m14624g5 = c1792a6.m14624g();
                    float m14624g6 = c1792a5.m14624g();
                    return this.f6351f == null ? ((m14624g6 - m14624g5) * c5) + m14624g5 : ((Number) this.f6351f.mo14531a(c5, Float.valueOf(m14624g5), Float.valueOf(m14624g6))).floatValue();
                }
                i++;
            }
        }
    }
}
