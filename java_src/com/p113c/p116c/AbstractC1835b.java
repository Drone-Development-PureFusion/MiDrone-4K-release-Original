package com.p113c.p116c;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import com.p113c.p114a.AbstractC1775a;
import java.util.WeakHashMap;
/* renamed from: com.c.c.b */
/* loaded from: classes.dex */
public abstract class AbstractC1835b {

    /* renamed from: a */
    private static final WeakHashMap<View, AbstractC1835b> f6460a = new WeakHashMap<>(0);

    /* renamed from: a */
    public static AbstractC1835b m14366a(View view) {
        AbstractC1835b abstractC1835b = f6460a.get(view);
        if (abstractC1835b == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            abstractC1835b = intValue >= 14 ? new C1841d(view) : intValue >= 11 ? new C1836c(view) : new C1843e(view);
            f6460a.put(view, abstractC1835b);
        }
        return abstractC1835b;
    }

    /* renamed from: a */
    public abstract long mo14352a();

    /* renamed from: a */
    public abstract AbstractC1835b mo14351a(float f);

    /* renamed from: a */
    public abstract AbstractC1835b mo14347a(long j);

    /* renamed from: a */
    public abstract AbstractC1835b mo14346a(Interpolator interpolator);

    /* renamed from: a */
    public abstract AbstractC1835b mo14345a(AbstractC1775a.AbstractC1776a abstractC1776a);

    /* renamed from: b */
    public abstract long mo14341b();

    /* renamed from: b */
    public abstract AbstractC1835b mo14340b(float f);

    /* renamed from: b */
    public abstract AbstractC1835b mo14338b(long j);

    /* renamed from: c */
    public abstract AbstractC1835b mo14335c(float f);

    /* renamed from: c */
    public abstract void mo14336c();

    /* renamed from: d */
    public abstract AbstractC1835b mo14331d(float f);

    /* renamed from: d */
    public abstract void mo14332d();

    /* renamed from: e */
    public abstract AbstractC1835b mo14328e(float f);

    /* renamed from: f */
    public abstract AbstractC1835b mo14327f(float f);

    /* renamed from: g */
    public abstract AbstractC1835b mo14326g(float f);

    /* renamed from: h */
    public abstract AbstractC1835b mo14325h(float f);

    /* renamed from: i */
    public abstract AbstractC1835b mo14324i(float f);

    /* renamed from: j */
    public abstract AbstractC1835b mo14323j(float f);

    /* renamed from: k */
    public abstract AbstractC1835b mo14322k(float f);

    /* renamed from: l */
    public abstract AbstractC1835b mo14321l(float f);

    /* renamed from: m */
    public abstract AbstractC1835b mo14320m(float f);

    /* renamed from: n */
    public abstract AbstractC1835b mo14319n(float f);

    /* renamed from: o */
    public abstract AbstractC1835b mo14318o(float f);

    /* renamed from: p */
    public abstract AbstractC1835b mo14317p(float f);

    /* renamed from: q */
    public abstract AbstractC1835b mo14316q(float f);

    /* renamed from: r */
    public abstract AbstractC1835b mo14315r(float f);

    /* renamed from: s */
    public abstract AbstractC1835b mo14314s(float f);

    /* renamed from: t */
    public abstract AbstractC1835b mo14313t(float f);
}
