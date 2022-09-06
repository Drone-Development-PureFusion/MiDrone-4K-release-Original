package com.fimi.kernel;

import android.app.Activity;
import android.content.Context;
import com.fimi.kernel.p157b.C2216c;
import com.fimi.kernel.p157b.EnumC2222d;
import com.fimi.kernel.p163c.AbstractC2239a;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.view.AbstractC2288b;
import com.fimi.kernel.view.C2292c;
/* renamed from: com.fimi.kernel.c */
/* loaded from: classes.dex */
public final class C2238c {

    /* renamed from: a */
    private static Context f7466a = null;

    /* renamed from: b */
    private static Activity f7467b = null;

    /* renamed from: c */
    private static String f7468c = null;

    private C2238c() {
    }

    /* renamed from: a */
    public static Context m13131a() {
        return f7466a;
    }

    /* renamed from: a */
    public static <T> T m13128a(EnumC2222d enumC2222d) {
        return (T) C2216c.m13192a(enumC2222d);
    }

    /* renamed from: a */
    public static void m13130a(Activity activity) {
        f7467b = null;
        f7467b = activity;
        f7468c = f7467b.getClass().getName();
    }

    /* renamed from: a */
    public static void m13129a(Context context) {
        f7466a = context;
    }

    /* renamed from: b */
    public static AbstractC2288b m13127b() {
        return C2292c.m12665a();
    }

    /* renamed from: b */
    public static void m13126b(Activity activity) {
        if (activity.getClass().getName().equals(f7468c)) {
            f7467b = null;
            f7468c = null;
        }
    }

    /* renamed from: c */
    public static AbstractC2239a m13125c() {
        return C2241c.m13122a();
    }

    /* renamed from: d */
    public static Activity m13124d() {
        return f7467b;
    }

    /* renamed from: e */
    public static C2277v m13123e() {
        return C2277v.m12784a(m13131a());
    }
}
