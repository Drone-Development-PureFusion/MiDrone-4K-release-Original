package org.p287b;

import java.util.Arrays;
import java.util.Iterator;
import org.p287b.p289b.C5413a;
import org.p287b.p289b.C5416d;
/* renamed from: org.b.a */
/* loaded from: classes2.dex */
public abstract class AbstractC5391a implements AbstractC5425g {
    /* renamed from: a */
    private <T> AbstractC5425g m1206a(String str, String str2, String str3, Iterator<T> it2) {
        return m1203b(str, str2, str3, new C5416d(it2));
    }

    /* renamed from: b */
    private String m1204b(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e) {
            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
        }
    }

    /* renamed from: b */
    private AbstractC5425g m1203b(String str, String str2, String str3, Iterator<? extends AbstractC5432m> it2) {
        boolean z = false;
        mo1074b(str);
        while (it2.hasNext()) {
            if (z) {
                mo1074b(str2);
            }
            mo1083a(it2.next());
            z = true;
        }
        mo1074b(str3);
        return this;
    }

    /* renamed from: b */
    private void m1205b(char c) {
        switch (c) {
            case '\t':
                mo1074b("\\t");
                return;
            case '\n':
                mo1074b("\\n");
                return;
            case '\r':
                mo1074b("\\r");
                return;
            case '\"':
                mo1074b("\\\"");
                return;
            default:
                mo1075a(c);
                return;
        }
    }

    /* renamed from: c */
    private void m1202c(String str) {
        mo1075a('\"');
        for (int i = 0; i < str.length(); i++) {
            m1205b(str.charAt(i));
        }
        mo1075a('\"');
    }

    @Override // org.p287b.AbstractC5425g
    /* renamed from: a */
    public AbstractC5425g mo1087a(Object obj) {
        if (obj == null) {
            mo1074b("null");
        } else if (obj instanceof String) {
            m1202c((String) obj);
        } else if (obj instanceof Character) {
            mo1075a('\"');
            m1205b(((Character) obj).charValue());
            mo1075a('\"');
        } else if (obj instanceof Short) {
            mo1075a('<');
            mo1074b(m1204b(obj));
            mo1074b("s>");
        } else if (obj instanceof Long) {
            mo1075a('<');
            mo1074b(m1204b(obj));
            mo1074b("L>");
        } else if (obj instanceof Float) {
            mo1075a('<');
            mo1074b(m1204b(obj));
            mo1074b("F>");
        } else if (obj.getClass().isArray()) {
            m1206a("[", ", ", "]", new C5413a(obj));
        } else {
            mo1075a('<');
            mo1074b(m1204b(obj));
            mo1075a('>');
        }
        return this;
    }

    @Override // org.p287b.AbstractC5425g
    /* renamed from: a */
    public AbstractC5425g mo1086a(String str) {
        mo1074b(str);
        return this;
    }

    @Override // org.p287b.AbstractC5425g
    /* renamed from: a */
    public <T> AbstractC5425g mo1085a(String str, String str2, String str3, Iterable<T> iterable) {
        return m1206a(str, str2, str3, iterable.iterator());
    }

    @Override // org.p287b.AbstractC5425g
    /* renamed from: a */
    public <T> AbstractC5425g mo1084a(String str, String str2, String str3, T... tArr) {
        return mo1085a(str, str2, str3, Arrays.asList(tArr));
    }

    @Override // org.p287b.AbstractC5425g
    /* renamed from: a */
    public AbstractC5425g mo1083a(AbstractC5432m abstractC5432m) {
        abstractC5432m.mo905a(this);
        return this;
    }

    /* renamed from: a */
    protected abstract void mo1075a(char c);

    @Override // org.p287b.AbstractC5425g
    /* renamed from: b */
    public AbstractC5425g mo1082b(String str, String str2, String str3, Iterable<? extends AbstractC5432m> iterable) {
        return m1203b(str, str2, str3, iterable.iterator());
    }

    /* renamed from: b */
    protected void mo1074b(String str) {
        for (int i = 0; i < str.length(); i++) {
            mo1075a(str.charAt(i));
        }
    }
}
