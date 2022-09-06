package org.p290c.p291a.p292a;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.p290c.p299b.C5505c;
import org.p290c.p309e.AbstractC5621e;
import org.p290c.p309e.C5623f;
import org.p290c.p309e.p310a.AbstractC5595a;
/* renamed from: org.c.a.a.c */
/* loaded from: classes2.dex */
abstract class AbstractC5444c implements AbstractC5621e {
    /* renamed from: a */
    private List<Class<?>> m1035a(String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            arrayList.add(C5505c.m897a(str2));
        }
        return arrayList;
    }

    /* renamed from: a */
    protected abstract AbstractC5595a mo1033a(List<Class<?>> list);

    @Override // org.p290c.p309e.AbstractC5621e
    /* renamed from: a */
    public AbstractC5595a mo525a(C5623f c5623f) {
        try {
            return mo1033a(m1035a(c5623f.m524a()));
        } catch (ClassNotFoundException e) {
            throw new AbstractC5621e.C5622a(e);
        }
    }
}
