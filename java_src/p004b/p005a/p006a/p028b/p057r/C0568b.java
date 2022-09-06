package p004b.p005a.p006a.p028b.p057r;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* renamed from: b.a.a.b.r.b */
/* loaded from: classes.dex */
public class C0568b {

    /* renamed from: a */
    long f1268a = -1;

    /* renamed from: b */
    String f1269b = null;

    /* renamed from: c */
    final SimpleDateFormat f1270c;

    public C0568b(String str) {
        this.f1270c = new SimpleDateFormat(str);
    }

    /* renamed from: a */
    public final String m20122a(long j) {
        String str;
        synchronized (this) {
            if (j != this.f1268a) {
                this.f1268a = j;
                this.f1269b = this.f1270c.format(new Date(j));
            }
            str = this.f1269b;
        }
        return str;
    }

    /* renamed from: a */
    public void m20121a(TimeZone timeZone) {
        this.f1270c.setTimeZone(timeZone);
    }
}
