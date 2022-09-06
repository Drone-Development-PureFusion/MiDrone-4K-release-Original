package p004b.p005a.p006a.p028b.p051m;

import java.io.File;
import java.io.IOException;
import p004b.p005a.p006a.p028b.C0411i;
import p004b.p005a.p006a.p028b.p051m.p052a.C0483i;
import p004b.p005a.p006a.p028b.p051m.p052a.EnumC0473c;
/* renamed from: b.a.a.b.m.c */
/* loaded from: classes.dex */
public class C0496c<E> extends C0411i<E> {

    /* renamed from: h */
    private static String f1105h = "http://logback.qos.ch/codes.html#rfa_no_tp";

    /* renamed from: i */
    private static String f1106i = "http://logback.qos.ch/codes.html#rfa_no_rp";

    /* renamed from: m */
    private static String f1107m = "http://logback.qos.ch/codes.html#rfa_collision";

    /* renamed from: e */
    File f1108e;

    /* renamed from: f */
    AbstractC0505l<E> f1109f;

    /* renamed from: g */
    AbstractC0497d f1110g;

    /* renamed from: t */
    private boolean m20342t() {
        C0483i c0483i;
        if (!(this.f1109f instanceof AbstractC0498e) || (c0483i = ((AbstractC0498e) this.f1109f).f1114j) == null || this.f916b == null) {
            return false;
        }
        return this.f916b.matches(c0483i.m20379e());
    }

    /* renamed from: a */
    public void m20349a(AbstractC0497d abstractC0497d) {
        this.f1110g = abstractC0497d;
        if (this.f1110g instanceof AbstractC0505l) {
            this.f1109f = (AbstractC0505l) abstractC0497d;
        }
    }

    /* renamed from: a */
    public void m20348a(AbstractC0505l<E> abstractC0505l) {
        this.f1109f = abstractC0505l;
        if (abstractC0505l instanceof AbstractC0497d) {
            this.f1110g = (AbstractC0497d) abstractC0505l;
        }
    }

    @Override // p004b.p005a.p006a.p028b.C0411i
    /* renamed from: a */
    public void mo20347a(String str) {
        if (str != null && (this.f1109f != null || this.f1110g != null)) {
            c("File property must be set before any triggeringPolicy or rollingPolicy properties");
            c("Visit http://logback.qos.ch/codes.html#rfa_file_after for more information");
        }
        super.mo20347a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.C0411i, p004b.p005a.p006a.p028b.C0516o
    /* renamed from: c */
    public void mo20273c(E e) {
        synchronized (this.f1109f) {
            if (this.f1109f.mo20305a(this.f1108e, e)) {
                m20345q();
            }
        }
        super.mo20273c((C0496c<E>) e);
    }

    @Override // p004b.p005a.p006a.p028b.C0411i
    /* renamed from: d */
    public String mo20346d() {
        return this.f1110g.mo20309d();
    }

    @Override // p004b.p005a.p006a.p028b.C0411i, p004b.p005a.p006a.p028b.C0516o, p004b.p005a.p006a.p028b.AbstractC0554q, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f1109f == null) {
            e("No TriggeringPolicy was set for the RollingFileAppender named " + g());
            e("For more information, please visit " + f1105h);
            return;
        }
        if (!this.f915a) {
            e("Append mode is mandatory for RollingFileAppender");
            this.f915a = true;
        }
        if (this.f1110g == null) {
            c("No RollingPolicy was set for the RollingFileAppender named " + g());
            c("For more information, please visit " + f1106i);
        } else if (m20342t()) {
            c("File property collides with fileNamePattern. Aborting.");
            c("For more information, please visit " + f1107m);
        } else {
            if (e()) {
                if (b() != null) {
                    e("Setting \"File\" property to null on account of prudent mode");
                    mo20347a((String) null);
                }
                if (this.f1110g.mo20339g() != EnumC0473c.NONE) {
                    c("Compression is not supported in prudent mode. Aborting");
                    return;
                }
            }
            this.f1108e = new File(mo20346d());
            d("Active log file name: " + mo20346d());
            super.mo20156j();
        }
    }

    @Override // p004b.p005a.p006a.p028b.C0516o, p004b.p005a.p006a.p028b.AbstractC0554q, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        if (this.f1110g != null) {
            this.f1110g.k();
        }
        if (this.f1109f != null) {
            this.f1109f.k();
        }
        super.k();
    }

    /* renamed from: q */
    public void m20345q() {
        synchronized (this.f1167d) {
            m();
            try {
                this.f1110g.mo20311b();
            } catch (C0499f e) {
                e("RolloverFailure occurred. Deferring rollover");
                this.f915a = true;
            }
            String mo20309d = this.f1110g.mo20309d();
            try {
                this.f1108e = new File(mo20309d);
                b(mo20309d);
            } catch (IOException e2) {
                a("openFile(" + mo20309d + ") failed", e2);
            }
        }
    }

    /* renamed from: r */
    public AbstractC0497d m20344r() {
        return this.f1110g;
    }

    /* renamed from: s */
    public AbstractC0505l<E> m20343s() {
        return this.f1109f;
    }
}
