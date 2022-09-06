package org.p290c.p291a.p296e.p297a;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/* renamed from: org.c.a.e.a.e */
/* loaded from: classes2.dex */
public class C5472e extends AssertionError {
    private static final long serialVersionUID = 1;

    public C5472e(Throwable th, String str, Object... objArr) {
        super(String.format("%s(%s)", str, m969a(", ", objArr)));
        initCause(th);
    }

    /* renamed from: a */
    private static String m971a(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Throwable th) {
            return "[toString failed]";
        }
    }

    /* renamed from: a */
    public static String m970a(String str, Collection<Object> collection) {
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it2 = collection.iterator();
        while (it2.hasNext()) {
            sb.append(m971a(it2.next()));
            if (it2.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m969a(String str, Object... objArr) {
        return m970a(str, Arrays.asList(objArr));
    }

    public boolean equals(Object obj) {
        return (obj instanceof C5472e) && toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
