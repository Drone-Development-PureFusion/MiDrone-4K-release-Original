package com.amap.api.mapcore.util;

import com.amap.api.maps.model.animation.Animation;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.dj */
/* loaded from: classes.dex */
public class C0903dj extends C0902di {

    /* renamed from: b */
    private boolean f2758b;

    /* renamed from: x */
    private long f2761x;

    /* renamed from: a */
    private int f2757a = 0;

    /* renamed from: c */
    private ArrayList<C0902di> f2759c = new ArrayList<>();

    /* renamed from: w */
    private C0907dn f2760w = new C0907dn();

    public C0903dj(boolean z) {
        m18521a(16, z);
        m18510p();
    }

    /* renamed from: a */
    private void m18521a(int i, boolean z) {
        if (z) {
            this.f2757a |= i;
        } else {
            this.f2757a &= i ^ (-1);
        }
    }

    /* renamed from: p */
    private void m18510p() {
        this.f2741k = 0L;
    }

    @Override // com.amap.api.mapcore.util.C0902di
    /* renamed from: a */
    public void mo18520a(long j) {
        this.f2757a |= 32;
        super.mo18520a(j);
        this.f2761x = this.f2742l + this.f2743m;
    }

    /* renamed from: a */
    public void m18518a(Animation animation) {
        boolean z = false;
        this.f2759c.add(animation.glAnimation);
        if (((this.f2757a & 64) == 0) && animation.glAnimation.mo18515h()) {
            this.f2757a |= 64;
        }
        if ((this.f2757a & 128) == 0) {
            z = true;
        }
        if (z && animation.glAnimation.mo18514i()) {
            this.f2757a |= 128;
        }
        if ((this.f2757a & 32) == 32) {
            this.f2761x = this.f2742l + this.f2743m;
        } else if (this.f2759c.size() == 1) {
            this.f2743m = animation.glAnimation.m18529g() + animation.glAnimation.mo18516f();
            this.f2761x = this.f2742l + this.f2743m;
        } else {
            this.f2761x = Math.max(this.f2761x, animation.glAnimation.m18529g() + animation.glAnimation.mo18516f());
            this.f2743m = this.f2761x - this.f2742l;
        }
        this.f2758b = true;
    }

    @Override // com.amap.api.mapcore.util.C0902di
    /* renamed from: a */
    public boolean mo18519a(long j, C0907dn c0907dn) {
        int size = this.f2759c.size();
        ArrayList<C0902di> arrayList = this.f2759c;
        C0907dn c0907dn2 = this.f2760w;
        c0907dn.m18509a();
        int i = size - 1;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = false;
        while (i >= 0) {
            C0902di c0902di = arrayList.get(i);
            c0907dn2.m18509a();
            z3 = c0902di.m18536a(j, c0907dn, e()) || z3;
            z2 = z2 || c0902di.m18527k();
            i--;
            z = c0902di.m18526l() && z;
        }
        if (z2 && !this.f2735e) {
            if (this.f2748r != null) {
                this.f2748r.onAnimationStart();
            }
            this.f2735e = true;
        }
        if (z != this.f2734d) {
            if (this.f2748r != null) {
                this.f2748r.onAnimationEnd();
            }
            this.f2734d = z;
        }
        return z3;
    }

    @Override // com.amap.api.mapcore.util.C0902di
    /* renamed from: b */
    public void mo18517b(long j) {
        super.mo18517b(j);
        int size = this.f2759c.size();
        ArrayList<C0902di> arrayList = this.f2759c;
        for (int i = 0; i < size; i++) {
            arrayList.get(i).mo18517b(j);
        }
    }

    @Override // com.amap.api.mapcore.util.C0902di
    /* renamed from: f */
    public long mo18516f() {
        ArrayList<C0902di> arrayList = this.f2759c;
        int size = arrayList.size();
        long j = 0;
        if ((this.f2757a & 32) == 32) {
            return this.f2743m;
        }
        for (int i = 0; i < size; i++) {
            j = Math.max(j, arrayList.get(i).mo18516f());
        }
        return j;
    }

    @Override // com.amap.api.mapcore.util.C0902di
    /* renamed from: h */
    public boolean mo18515h() {
        return (this.f2757a & 64) == 64;
    }

    @Override // com.amap.api.mapcore.util.C0902di
    /* renamed from: i */
    public boolean mo18514i() {
        return (this.f2757a & 128) == 128;
    }

    @Override // com.amap.api.mapcore.util.C0902di
    /* renamed from: m */
    public C0903dj clone() {
        C0903dj c0903dj = (C0903dj) super.clone();
        c0903dj.f2760w = new C0907dn();
        c0903dj.f2759c = new ArrayList<>();
        int size = this.f2759c.size();
        ArrayList<C0902di> arrayList = this.f2759c;
        for (int i = 0; i < size; i++) {
            c0903dj.f2759c.add(arrayList.get(i).clone());
        }
        return c0903dj;
    }

    /* renamed from: n */
    public List<C0902di> m18512n() {
        return this.f2759c;
    }

    /* renamed from: o */
    public void m18511o() {
        this.f2759c.clear();
    }
}
