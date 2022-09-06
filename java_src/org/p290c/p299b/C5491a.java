package org.p290c.p299b;

import java.util.ArrayList;
import java.util.List;
/* renamed from: org.c.b.a */
/* loaded from: classes2.dex */
public class C5491a extends AssertionError {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final List<Integer> f22557a = new ArrayList();

    /* renamed from: b */
    private final String f22558b;

    public C5491a(String str, AssertionError assertionError, int i) {
        this.f22558b = str;
        initCause(assertionError);
        m925a(i);
    }

    /* renamed from: a */
    public void m925a(int i) {
        this.f22557a.add(0, Integer.valueOf(i));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        if (this.f22558b != null) {
            sb.append(this.f22558b);
        }
        sb.append("arrays first differed at element ");
        for (Integer num : this.f22557a) {
            int intValue = num.intValue();
            sb.append("[");
            sb.append(intValue);
            sb.append("]");
        }
        sb.append("; ");
        sb.append(getCause().getMessage());
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage();
    }
}
