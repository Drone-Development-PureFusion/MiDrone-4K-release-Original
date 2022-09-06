package org.p290c.p309e;

import org.p290c.p299b.C5505c;
import org.p290c.p309e.AbstractC5621e;
import org.p290c.p309e.p310a.AbstractC5595a;
/* renamed from: org.c.e.d */
/* loaded from: classes2.dex */
class C5620d {
    C5620d() {
    }

    /* renamed from: a */
    public static AbstractC5595a m529a(Class<? extends AbstractC5621e> cls, C5623f c5623f) {
        return m530a(cls).mo525a(c5623f);
    }

    /* renamed from: a */
    public static AbstractC5595a m527a(String str, C5623f c5623f) {
        return m528a(str).mo525a(c5623f);
    }

    /* renamed from: a */
    public static AbstractC5595a m526a(AbstractC5627i abstractC5627i, String str) {
        C5619c mo327d = abstractC5627i.mo489a().mo327d();
        String[] split = str.contains("=") ? str.split("=", 2) : new String[]{str, ""};
        return m527a(split[0], new C5623f(mo327d, split[1]));
    }

    /* renamed from: a */
    static AbstractC5621e m530a(Class<? extends AbstractC5621e> cls) {
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new AbstractC5621e.C5622a(e);
        }
    }

    /* renamed from: a */
    static AbstractC5621e m528a(String str) {
        try {
            return m530a((Class<? extends AbstractC5621e>) C5505c.m897a(str).asSubclass(AbstractC5621e.class));
        } catch (Exception e) {
            throw new AbstractC5621e.C5622a(e);
        }
    }
}
