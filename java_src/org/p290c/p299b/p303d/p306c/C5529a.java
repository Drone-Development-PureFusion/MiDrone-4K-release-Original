package org.p290c.p299b.p303d.p306c;

import org.p290c.p299b.C5500b;
import org.p290c.p312f.p313a.AbstractC5647j;
/* renamed from: org.c.b.d.c.a */
/* loaded from: classes2.dex */
public class C5529a extends AbstractC5647j {

    /* renamed from: a */
    private final AbstractC5647j f22597a;

    /* renamed from: b */
    private final Class<? extends Throwable> f22598b;

    public C5529a(AbstractC5647j abstractC5647j, Class<? extends Throwable> cls) {
        this.f22597a = abstractC5647j;
        this.f22598b = cls;
    }

    @Override // org.p290c.p312f.p313a.AbstractC5647j
    /* renamed from: a */
    public void mo318a() {
        boolean z;
        try {
            this.f22597a.mo318a();
            z = true;
        } catch (C5500b e) {
            throw e;
        } catch (Throwable th) {
            if (!this.f22598b.isAssignableFrom(th.getClass())) {
                throw new Exception("Unexpected exception, expected<" + this.f22598b.getName() + "> but was<" + th.getClass().getName() + ">", th);
            }
            z = false;
        }
        if (z) {
            throw new AssertionError("Expected exception: " + this.f22598b.getName());
        }
    }
}
