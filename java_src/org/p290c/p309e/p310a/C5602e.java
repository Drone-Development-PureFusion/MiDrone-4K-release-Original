package org.p290c.p309e.p310a;

import java.util.Comparator;
import org.p290c.p309e.C5619c;
/* renamed from: org.c.e.a.e */
/* loaded from: classes.dex */
public class C5602e implements Comparator<C5619c> {

    /* renamed from: a */
    public static final C5602e f22691a = new C5602e(new Comparator<C5619c>() { // from class: org.c.e.a.e.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C5619c c5619c, C5619c c5619c2) {
            return 0;
        }
    });

    /* renamed from: b */
    private final Comparator<C5619c> f22692b;

    public C5602e(Comparator<C5619c> comparator) {
        this.f22692b = comparator;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(C5619c c5619c, C5619c c5619c2) {
        return this.f22692b.compare(c5619c, c5619c2);
    }

    /* renamed from: a */
    public void m578a(Object obj) {
        if (obj instanceof AbstractC5601d) {
            ((AbstractC5601d) obj).mo342a(this);
        }
    }
}
