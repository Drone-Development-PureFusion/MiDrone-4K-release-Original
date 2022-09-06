package p004b.p005a.p006a.p007a.p014f;

import p004b.p005a.p006a.p028b.p034f.AbstractC0293a;
/* renamed from: b.a.a.a.f.d */
/* loaded from: classes.dex */
public class C0155d implements AbstractC0293a {

    /* renamed from: a */
    String f237a = "http://logback.qos.ch/css/classic.css";

    /* renamed from: a */
    public String m21410a() {
        return this.f237a;
    }

    /* renamed from: a */
    public void m21409a(String str) {
        this.f237a = str;
    }

    @Override // p004b.p005a.p006a.p028b.p034f.AbstractC0293a
    /* renamed from: a */
    public void mo21018a(StringBuilder sb) {
        sb.append("<link REL=StyleSheet HREF=\"");
        sb.append(this.f237a);
        sb.append("\" TITLE=\"Basic\" />");
    }
}
