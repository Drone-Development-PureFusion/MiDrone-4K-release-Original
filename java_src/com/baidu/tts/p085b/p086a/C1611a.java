package com.baidu.tts.p085b.p086a;

import com.baidu.tts.p085b.p086a.p087a.AbstractC1618d;
import com.baidu.tts.p085b.p086a.p087a.C1615c;
import com.baidu.tts.p085b.p086a.p088b.AbstractC1625b;
import com.baidu.tts.p085b.p086a.p088b.C1628d;
import com.baidu.tts.p085b.p086a.p088b.C1631e;
import com.baidu.tts.p085b.p086a.p088b.C1634f;
import com.baidu.tts.p096e.EnumC1703f;
/* renamed from: com.baidu.tts.b.a.a */
/* loaded from: classes.dex */
public class C1611a {

    /* renamed from: a */
    private static volatile C1611a f5711a = null;

    private C1611a() {
    }

    /* renamed from: a */
    private AbstractC1618d m15282a(AbstractC1625b abstractC1625b) {
        C1615c c1615c = new C1615c();
        c1615c.mo15249a(abstractC1625b);
        return c1615c;
    }

    /* renamed from: a */
    public static C1611a m15283a() {
        if (f5711a == null) {
            synchronized (C1611a.class) {
                if (f5711a == null) {
                    f5711a = new C1611a();
                }
            }
        }
        return f5711a;
    }

    /* renamed from: b */
    private AbstractC1618d m15280b() {
        return m15282a(new C1634f());
    }

    /* renamed from: c */
    private AbstractC1618d m15279c() {
        return m15282a(new C1631e());
    }

    /* renamed from: d */
    private AbstractC1618d m15278d() {
        return m15282a(new C1628d());
    }

    /* renamed from: a */
    public AbstractC1618d m15281a(EnumC1703f enumC1703f) {
        switch (enumC1703f) {
            case ONLINE:
                return m15280b();
            case OFFLINE:
                return m15279c();
            case MIX:
                return m15278d();
            default:
                return null;
        }
    }
}
