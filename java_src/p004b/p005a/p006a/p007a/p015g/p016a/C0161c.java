package p004b.p005a.p006a.p007a.p015g.p016a;

import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
/* renamed from: b.a.a.a.g.a.c */
/* loaded from: classes.dex */
public class C0161c extends AbstractC0301c {
    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: b */
    public void mo20951b(C0344k c0344k, String str) {
        String m20870f = c0344k.m20870f(str);
        d("Setting logger context name as [" + m20870f + "]");
        try {
            this.f1190s.mo21000b(m20870f);
        } catch (IllegalStateException e) {
            a("Failed to rename context [" + this.f1190s.mo20996p() + "] as [" + m20870f + "]", e);
        }
    }
}
