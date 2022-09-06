package org.p248a.p283b.p284a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.p248a.p283b.AbstractC5358a;
/* renamed from: org.a.b.a.b */
/* loaded from: classes2.dex */
public class C5360b implements Serializable {

    /* renamed from: d */
    private static Map<Class<? extends AbstractC5358a>, Map<?, C5360b>> f22407d = new HashMap();

    /* renamed from: a */
    public final String f22408a;

    /* renamed from: b */
    public final byte f22409b;

    /* renamed from: c */
    public final C5361c f22410c;

    public C5360b(String str, byte b, C5361c c5361c) {
        this.f22408a = str;
        this.f22409b = b;
        this.f22410c = c5361c;
    }

    /* renamed from: a */
    public static void m1284a(Class<? extends AbstractC5358a> cls, Map<?, C5360b> map) {
        f22407d.put(cls, map);
    }
}
