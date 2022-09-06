package org.p290c.p299b;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.List;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.C5629j;
import org.p290c.p309e.p311b.C5605a;
import org.p290c.p309e.p311b.C5606b;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: org.c.b.j */
/* loaded from: classes2.dex */
public class C5560j extends C5606b {

    /* renamed from: a */
    private final PrintStream f22643a;

    public C5560j(PrintStream printStream) {
        this.f22643a = printStream;
    }

    public C5560j(AbstractC5555g abstractC5555g) {
        this(abstractC5555g.mo776a());
    }

    /* renamed from: a */
    private PrintStream m774a() {
        return this.f22643a;
    }

    /* renamed from: a */
    protected void m773a(long j) {
        m774a().println();
        m774a().println("Time: " + m771b(j));
    }

    @Override // org.p290c.p309e.p311b.C5606b
    /* renamed from: a */
    public void mo476a(C5605a c5605a) {
        this.f22643a.append('E');
    }

    /* renamed from: a */
    protected void m772a(C5605a c5605a, String str) {
        m774a().println(str + ") " + c5605a.m575a());
        m774a().print(c5605a.m572d());
    }

    @Override // org.p290c.p309e.p311b.C5606b
    /* renamed from: a */
    public void mo474a(C5629j c5629j) {
        m773a(c5629j.m484c());
        m770b(c5629j);
        m769c(c5629j);
    }

    /* renamed from: b */
    protected String m771b(long j) {
        return NumberFormat.getInstance().format(j / 1000.0d);
    }

    @Override // org.p290c.p309e.p311b.C5606b
    /* renamed from: b */
    public void mo553b(C5619c c5619c) {
        this.f22643a.append(C0359h.f677G);
    }

    /* renamed from: b */
    protected void m770b(C5629j c5629j) {
        List<C5605a> m482d = c5629j.m482d();
        if (m482d.size() == 0) {
            return;
        }
        if (m482d.size() == 1) {
            m774a().println("There was " + m482d.size() + " failure:");
        } else {
            m774a().println("There were " + m482d.size() + " failures:");
        }
        int i = 1;
        for (C5605a c5605a : m482d) {
            m772a(c5605a, "" + i);
            i++;
        }
    }

    @Override // org.p290c.p309e.p311b.C5606b
    /* renamed from: c */
    public void mo472c(C5619c c5619c) {
        this.f22643a.append('I');
    }

    /* renamed from: c */
    protected void m769c(C5629j c5629j) {
        if (c5629j.m478f()) {
            m774a().println();
            m774a().print("OK");
            m774a().println(" (" + c5629j.m488a() + " test" + (c5629j.m488a() == 1 ? "" : "s") + ")");
        } else {
            m774a().println();
            m774a().println("FAILURES!!!");
            m774a().println("Tests run: " + c5629j.m488a() + ",  Failures: " + c5629j.m486b());
        }
        m774a().println();
    }
}
