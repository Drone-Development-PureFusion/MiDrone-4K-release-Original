package p004b.p005a.p006a.p028b.p035g.p036a;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p054o.C0527f;
/* renamed from: b.a.a.b.g.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC0301c extends C0527f {

    /* renamed from: e */
    public static final String f549e = "name";

    /* renamed from: f */
    public static final String f550f = "key";

    /* renamed from: g */
    public static final String f551g = "value";

    /* renamed from: h */
    public static final String f552h = "file";

    /* renamed from: i */
    public static final String f553i = "class";

    /* renamed from: j */
    public static final String f554j = "pattern";

    /* renamed from: k */
    public static final String f555k = "scope";

    /* renamed from: l */
    public static final String f556l = "actionClass";

    /* renamed from: a */
    public abstract void mo20941a(C0344k c0344k, String str);

    /* renamed from: a */
    public abstract void mo20940a(C0344k c0344k, String str, Attributes attributes);

    /* renamed from: b */
    protected int m20969b(C0344k c0344k) {
        Locator m20848e = c0344k.m20874c().m20848e();
        if (m20848e != null) {
            return m20848e.getColumnNumber();
        }
        return -1;
    }

    /* renamed from: b */
    public void mo20951b(C0344k c0344k, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public int m20968c(C0344k c0344k) {
        Locator m20848e = c0344k.m20874c().m20848e();
        if (m20848e != null) {
            return m20848e.getLineNumber();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public String m20967d(C0344k c0344k) {
        return "line: " + m20968c(c0344k) + ", column: " + m20969b(c0344k);
    }

    public String toString() {
        return getClass().getName();
    }
}
