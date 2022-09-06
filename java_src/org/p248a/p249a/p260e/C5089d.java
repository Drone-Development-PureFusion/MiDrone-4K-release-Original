package org.p248a.p249a.p260e;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.p248a.p249a.p250a.AbstractC5007d;
@AbstractC5007d
/* renamed from: org.a.a.e.d */
/* loaded from: classes2.dex */
public final class C5089d<I> implements AbstractC5086b<I> {

    /* renamed from: a */
    private final Map<String, I> f21710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5089d(Map<String, I> map) {
        this.f21710a = new ConcurrentHashMap(map);
    }

    @Override // org.p248a.p249a.p260e.AbstractC5086b
    /* renamed from: a */
    public I mo2043a(String str) {
        if (str == null) {
            return null;
        }
        return this.f21710a.get(str.toLowerCase(Locale.US));
    }

    public String toString() {
        return this.f21710a.toString();
    }
}
