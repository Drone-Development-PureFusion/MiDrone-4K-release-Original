package org.p290c.p315g;

import java.util.Collections;
import java.util.List;
import org.p290c.p312f.p313a.C5648k;
/* renamed from: org.c.g.d */
/* loaded from: classes.dex */
public class C5681d implements AbstractC5682e {

    /* renamed from: a */
    private static final List<Exception> f22791a = Collections.emptyList();

    @Override // org.p290c.p315g.AbstractC5682e
    /* renamed from: a */
    public List<Exception> mo298a(C5648k c5648k) {
        return c5648k.m406g() ? f22791a : Collections.singletonList(new Exception("The class " + c5648k.m410e() + " is not public."));
    }
}
