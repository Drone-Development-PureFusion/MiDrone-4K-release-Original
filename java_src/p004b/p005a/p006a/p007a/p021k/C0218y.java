package p004b.p005a.p006a.p007a.p021k;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p007a.p027p.C0262e;
import p004b.p005a.p006a.p028b.p041h.AbstractC0408i;
/* renamed from: b.a.a.a.k.y */
/* loaded from: classes.dex */
public class C0218y extends AbstractC0198e {

    /* renamed from: c */
    SimpleDateFormat f341c;

    /* renamed from: e */
    int f343e;

    /* renamed from: a */
    long f339a = -1;

    /* renamed from: b */
    String f340b = null;

    /* renamed from: d */
    final String f342d = "localhost";

    /* renamed from: a */
    String m21282a(long j) {
        String str;
        synchronized (this) {
            if (j != this.f339a) {
                this.f339a = j;
                this.f340b = this.f341c.format(new Date(j));
            }
            str = this.f340b;
        }
        return str;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: a */
    public String mo20376a(AbstractC0231d abstractC0231d) {
        return "<" + (this.f343e + C0262e.m21111a(abstractC0231d)) + ">" + m21282a(abstractC0231d.mo21208n()) + C5122l.f21763c + "localhost" + C5122l.f21763c;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0449d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        boolean z = false;
        String d = d();
        if (d == null) {
            c("was expecting a facility string as an option");
            return;
        }
        this.f343e = AbstractC0408i.m20569b(d);
        try {
            this.f341c = new SimpleDateFormat("MMM dd HH:mm:ss", new DateFormatSymbols(Locale.US));
        } catch (IllegalArgumentException e) {
            a("Could not instantiate SimpleDateFormat", e);
            z = true;
        }
        if (z) {
            return;
        }
        super.j();
    }
}
