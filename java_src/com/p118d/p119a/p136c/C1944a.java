package com.p118d.p119a.p136c;

import com.p118d.p119a.p120a.p121a.AbstractC1848a;
import java.io.File;
/* renamed from: com.d.a.c.a */
/* loaded from: classes.dex */
public final class C1944a {
    private C1944a() {
    }

    /* renamed from: a */
    public static File m13869a(String str, AbstractC1848a abstractC1848a) {
        File mo14221a = abstractC1848a.mo14221a(str);
        if (mo14221a == null || !mo14221a.exists()) {
            return null;
        }
        return mo14221a;
    }

    /* renamed from: b */
    public static boolean m13868b(String str, AbstractC1848a abstractC1848a) {
        File mo14221a = abstractC1848a.mo14221a(str);
        return mo14221a != null && mo14221a.exists() && mo14221a.delete();
    }
}
