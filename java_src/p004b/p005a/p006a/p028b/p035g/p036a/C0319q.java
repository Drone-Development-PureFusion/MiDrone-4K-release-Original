package p004b.p005a.p006a.p028b.p035g.p036a;

import com.xiaomi.mipush.sdk.Constants;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p039d.C0341h;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.a.q */
/* loaded from: classes.dex */
public class C0319q extends AbstractC0301c {

    /* renamed from: a */
    boolean f601a = false;

    /* renamed from: a */
    public void m20949a(C0344k c0344k) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f601a = false;
        String value = attributes.getValue("pattern");
        String value2 = attributes.getValue("actionClass");
        if (C0589u.m20054e(value)) {
            this.f601a = true;
            c("No 'pattern' attribute in <newRule>");
        } else if (C0589u.m20054e(value2)) {
            this.f601a = true;
            c("No 'actionClass' attribute in <newRule>");
        } else {
            try {
                d("About to add new Joran parsing rule [" + value + Constants.ACCEPT_TIME_SEPARATOR_SP + value2 + "].");
                c0344k.m20874c().m20847f().mo20841a(new C0341h(value), value2);
            } catch (Exception e) {
                this.f601a = true;
                c("Could not add new Joran parsing rule [" + value + Constants.ACCEPT_TIME_SEPARATOR_SP + value2 + "]");
            }
        }
    }
}
