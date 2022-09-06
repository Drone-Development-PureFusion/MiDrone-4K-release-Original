package com.p118d.p119a.p127b.p131c;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.p118d.p119a.p127b.p128a.EnumC1894f;
import com.p118d.p119a.p127b.p133e.AbstractC1926a;
/* renamed from: com.d.a.b.c.b */
/* loaded from: classes.dex */
public class C1908b implements AbstractC1907a {

    /* renamed from: a */
    private final int f6754a;

    /* renamed from: b */
    private final boolean f6755b;

    /* renamed from: c */
    private final boolean f6756c;

    /* renamed from: d */
    private final boolean f6757d;

    public C1908b(int i) {
        this(i, true, true, true);
    }

    public C1908b(int i, boolean z, boolean z2, boolean z3) {
        this.f6754a = i;
        this.f6755b = z;
        this.f6756c = z2;
        this.f6757d = z3;
    }

    /* renamed from: a */
    public static void m14038a(View view, int i) {
        if (view != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(i);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(alphaAnimation);
        }
    }

    @Override // com.p118d.p119a.p127b.p131c.AbstractC1907a
    /* renamed from: a */
    public void mo14037a(Bitmap bitmap, AbstractC1926a abstractC1926a, EnumC1894f enumC1894f) {
        abstractC1926a.mo13927a(bitmap);
        if ((!this.f6755b || enumC1894f != EnumC1894f.NETWORK) && ((!this.f6756c || enumC1894f != EnumC1894f.DISC_CACHE) && (!this.f6757d || enumC1894f != EnumC1894f.MEMORY_CACHE))) {
            return;
        }
        m14038a(abstractC1926a.mo13921d(), this.f6754a);
    }
}
