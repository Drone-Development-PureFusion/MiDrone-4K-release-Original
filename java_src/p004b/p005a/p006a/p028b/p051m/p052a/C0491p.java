package p004b.p005a.p006a.p028b.p051m.p052a;

import java.io.File;
import java.util.Date;
/* renamed from: b.a.a.b.m.a.p */
/* loaded from: classes.dex */
public class C0491p extends AbstractC0478g {
    public C0491p(C0483i c0483i, C0489o c0489o) {
        super(c0483i, c0489o);
    }

    @Override // p004b.p005a.p006a.p028b.p051m.p052a.AbstractC0478g
    /* renamed from: a */
    public void mo20360a(Date date, int i) {
        Date m20364a = this.f1064e.m20364a(date, i);
        String m20397a = C0479h.m20397a(this.f1063d.m20385a(m20364a));
        File parentFile = new File(this.f1063d.m20384a(m20364a, 0)).getAbsoluteFile().getAbsoluteFile().getParentFile();
        for (File file : C0479h.m20398a(parentFile, m20397a)) {
            file.delete();
        }
        if (this.f1066g) {
            a(parentFile);
        }
    }
}
