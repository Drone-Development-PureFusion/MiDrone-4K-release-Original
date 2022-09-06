package p004b.p005a.p006a.p007a.p026o;

import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
/* renamed from: b.a.a.a.o.g */
/* loaded from: classes.dex */
public abstract class AbstractC0254g extends AbstractC0257i {

    /* renamed from: c */
    protected EnumC0533l f436c = EnumC0533l.NEUTRAL;

    /* renamed from: d */
    protected EnumC0533l f437d = EnumC0533l.NEUTRAL;

    /* renamed from: h_ */
    public final void m21143h_(String str) {
        if ("NEUTRAL".equals(str)) {
            this.f436c = EnumC0533l.NEUTRAL;
        } else if ("ACCEPT".equals(str)) {
            this.f436c = EnumC0533l.ACCEPT;
        } else if (!"DENY".equals(str)) {
        } else {
            this.f436c = EnumC0533l.DENY;
        }
    }

    /* renamed from: i_ */
    public final void m21142i_(String str) {
        if ("NEUTRAL".equals(str)) {
            this.f437d = EnumC0533l.NEUTRAL;
        } else if ("ACCEPT".equals(str)) {
            this.f437d = EnumC0533l.ACCEPT;
        } else if (!"DENY".equals(str)) {
        } else {
            this.f437d = EnumC0533l.DENY;
        }
    }
}
