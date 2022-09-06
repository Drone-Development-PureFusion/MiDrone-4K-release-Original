package p004b.p005a.p006a.p007a.p015g.p016a;

import java.io.InputStream;
import java.net.URL;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p007a.p008a.C0129a;
import p004b.p005a.p006a.p007a.p015g.p016a.C0158a;
import p004b.p005a.p006a.p028b.p035g.p036a.C0313m;
import p004b.p005a.p006a.p028b.p035g.p037b.C0329e;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p035g.p039d.C0346m;
/* renamed from: b.a.a.a.g.a.d */
/* loaded from: classes.dex */
public class C0162d extends C0313m {

    /* renamed from: a */
    private static final int f245a = 1;

    public C0162d() {
        a(1);
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.C0313m
    /* renamed from: a */
    protected C0329e mo20953a(InputStream inputStream, URL url) {
        if (url.toString().endsWith("AndroidManifest.xml")) {
            C0129a c0129a = new C0129a();
            c0129a.m21539a("logback");
            return c0129a;
        }
        return new C0329e(h_());
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0300b, p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        if (c0344k.m20872e() || !(c0344k.m20871f() instanceof C0158a.C0159a)) {
            return;
        }
        URL m21405a = ((C0158a.C0159a) c0344k.m20869g()).m21405a();
        if (m21405a == null) {
            d("No paths found from includes");
            return;
        }
        d("Path found [" + m21405a.toString() + "]");
        try {
            a(c0344k, m21405a);
        } catch (C0346m e) {
            a("Failed to process include [" + m21405a.toString() + "]", (Throwable) e);
        }
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0300b, p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
    }
}
