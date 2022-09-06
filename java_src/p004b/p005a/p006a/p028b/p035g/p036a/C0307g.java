package p004b.p005a.p006a.p028b.p035g.p036a;

import java.util.HashMap;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.AbstractC0266a;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p054o.AbstractC0523b;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.a.g */
/* loaded from: classes.dex */
public class C0307g<E> extends AbstractC0301c {

    /* renamed from: a */
    boolean f578a = false;

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f578a = false;
        Object m20871f = c0344k.m20871f();
        if (!(m20871f instanceof AbstractC0523b)) {
            this.f578a = true;
            c("Could not find an AppenderAttachable at the top of execution stack. Near [" + str + "] line " + c(c0344k));
            return;
        }
        AbstractC0523b abstractC0523b = (AbstractC0523b) m20871f;
        String m20870f = c0344k.m20870f(attributes.getValue(AbstractC0302d.f558b));
        if (C0589u.m20054e(m20870f)) {
            this.f578a = true;
            c("Missing appender ref attribute in <appender-ref> tag.");
            return;
        }
        AbstractC0266a<E> abstractC0266a = (AbstractC0266a) ((HashMap) c0344k.m20868h().get(AbstractC0302d.f569m)).get(m20870f);
        if (abstractC0266a != null) {
            d("Attaching appender named [" + m20870f + "] to " + abstractC0523b);
            abstractC0523b.mo20251a(abstractC0266a);
            return;
        }
        this.f578a = true;
        c("Could not find an appender named [" + m20870f + "]. Did you define it below instead of above in the configuration file?");
        c("See http://logback.qos.ch/codes.html#appender_order for more details.");
    }
}
