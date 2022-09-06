package com.fimi.soul.biz.p180i;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.fimi.soul.drone.p202h.C2854c;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.fimi.soul.biz.i.h */
/* loaded from: classes.dex */
public class C2477h {

    /* renamed from: a */
    public static final int f8544a = 0;

    /* renamed from: b */
    public static final int f8545b = 1;

    /* renamed from: c */
    public static final int f8546c = 2;

    /* renamed from: d */
    public static final int f8547d = 3;

    /* renamed from: e */
    public static final int f8548e = 4;

    /* renamed from: g */
    private static C2477h f8549g;

    /* renamed from: f */
    private AtomicInteger f8550f = new AtomicInteger(0);

    /* renamed from: h */
    private SharedPreferences f8551h;

    public C2477h(Context context) {
        this.f8551h = PreferenceManager.getDefaultSharedPreferences(context);
        m12021a(this.f8551h.getInt(C2854c.f10603bo, 0));
    }

    /* renamed from: a */
    public static C2477h m12020a(Context context) {
        if (f8549g == null) {
            f8549g = new C2477h(context);
        }
        return f8549g;
    }

    /* renamed from: a */
    public AtomicInteger m12022a() {
        return this.f8550f;
    }

    /* renamed from: a */
    public void m12021a(int i) {
        this.f8550f.set(i);
        this.f8551h.edit().putInt(C2854c.f10603bo, i).commit();
    }

    /* renamed from: b */
    public boolean m12019b() {
        return 1 == this.f8550f.get() || 2 == this.f8550f.get() || 3 == this.f8550f.get();
    }
}
