package com.fimi.soul.biz.p170c;

import android.content.Context;
import com.fimi.kernel.utils.C2277v;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
/* renamed from: com.fimi.soul.biz.c.a */
/* loaded from: classes.dex */
public class C2374a {
    /* renamed from: a */
    public static String m12426a(Context context, int i) {
        return m12420d(context, i).m12758g("macAlgorithm");
    }

    /* renamed from: a */
    public static void m12425a(Context context, int i, String str) {
        m12420d(context, i).m12781a("macAlgorithm", str);
    }

    /* renamed from: b */
    public static String m12424b(Context context, int i) {
        return m12420d(context, i).m12758g("mackey");
    }

    /* renamed from: b */
    public static void m12423b(Context context, int i, String str) {
        m12420d(context, i).m12781a("mackey", str);
    }

    /* renamed from: c */
    public static String m12422c(Context context, int i) {
        return m12420d(context, i).m12758g(MMPluginProviderConstants.OAuth.ACCESS_TOKEN);
    }

    /* renamed from: c */
    public static void m12421c(Context context, int i, String str) {
        m12420d(context, i).m12781a(MMPluginProviderConstants.OAuth.ACCESS_TOKEN, str);
    }

    /* renamed from: d */
    private static C2277v m12420d(Context context, int i) {
        return C2277v.m12784a(context);
    }
}
