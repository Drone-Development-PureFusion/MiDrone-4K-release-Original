package p004b.p005a.p006a.p028b.p035g.p036a;

import java.util.HashMap;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.AbstractC0266a;
import p004b.p005a.p006a.p028b.p035g.p039d.C0332a;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.a.f */
/* loaded from: classes.dex */
public class C0306f<E> extends AbstractC0301c {

    /* renamed from: a */
    AbstractC0266a<E> f576a;

    /* renamed from: b */
    private boolean f577b = false;

    /* renamed from: a */
    private void m20963a(String str) {
        if (str.equals("ch.qos.logback.core.ConsoleAppender")) {
            e("ConsoleAppender is deprecated for LogcatAppender");
        }
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        if (this.f577b) {
            return;
        }
        if (this.f576a instanceof AbstractC0534m) {
            this.f576a.mo20156j();
        }
        if (c0344k.m20871f() != this.f576a) {
            e("The object at the of the stack is not the appender named [" + this.f576a.mo20159g() + "] pushed earlier.");
        } else {
            c0344k.m20869g();
        }
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f576a = null;
        this.f577b = false;
        String value = attributes.getValue(AbstractC0301c.f553i);
        if (C0589u.m20054e(value)) {
            c("Missing class name for appender. Near [" + str + "] line " + c(c0344k));
            this.f577b = true;
            return;
        }
        try {
            d("About to instantiate appender of type [" + value + "]");
            m20963a(value);
            this.f576a = (AbstractC0266a) C0589u.m20064a(value, AbstractC0266a.class, this.f1190s);
            this.f576a.a(this.f1190s);
            String m20870f = c0344k.m20870f(attributes.getValue("name"));
            if (C0589u.m20054e(m20870f)) {
                e("No appender name given for appender of type " + value + "].");
            } else {
                this.f576a.mo20163b_(m20870f);
                d("Naming appender as [" + m20870f + "]");
            }
            ((HashMap) c0344k.m20868h().get(AbstractC0302d.f569m)).put(m20870f, this.f576a);
            c0344k.m20881a(this.f576a);
        } catch (Exception e) {
            this.f577b = true;
            a("Could not create an Appender of type [" + value + "].", e);
            throw new C0332a(e);
        }
    }
}
