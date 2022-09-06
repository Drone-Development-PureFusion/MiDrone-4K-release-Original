package org.p290c.p299b.p303d.p306c;

import java.util.ArrayList;
import java.util.List;
import org.p290c.p312f.p313a.AbstractC5647j;
import org.p290c.p312f.p313a.C5640d;
import org.p290c.p312f.p313a.C5643f;
/* renamed from: org.c.b.d.c.e */
/* loaded from: classes.dex */
public class C5536e extends AbstractC5647j {

    /* renamed from: a */
    private final AbstractC5647j f22612a;

    /* renamed from: b */
    private final Object f22613b;

    /* renamed from: c */
    private final List<C5640d> f22614c;

    public C5536e(AbstractC5647j abstractC5647j, List<C5640d> list, Object obj) {
        this.f22612a = abstractC5647j;
        this.f22614c = list;
        this.f22613b = obj;
    }

    @Override // org.p290c.p312f.p313a.AbstractC5647j
    /* renamed from: a */
    public void mo318a() {
        ArrayList arrayList = new ArrayList();
        try {
            this.f22612a.mo318a();
            for (C5640d c5640d : this.f22614c) {
                try {
                    c5640d.m455a(this.f22613b, new Object[0]);
                } catch (Throwable th) {
                    arrayList.add(th);
                }
            }
        } catch (Throwable th2) {
            try {
                arrayList.add(th2);
                for (C5640d c5640d2 : this.f22614c) {
                    try {
                        c5640d2.m455a(this.f22613b, new Object[0]);
                    } catch (Throwable th3) {
                        arrayList.add(th3);
                    }
                }
            } catch (Throwable th4) {
                for (C5640d c5640d3 : this.f22614c) {
                    try {
                        c5640d3.m455a(this.f22613b, new Object[0]);
                    } catch (Throwable th5) {
                        arrayList.add(th5);
                    }
                }
                throw th4;
            }
        }
        C5643f.m438a(arrayList);
    }
}
