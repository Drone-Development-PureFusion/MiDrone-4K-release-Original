package p004b.p005a.p006a.p028b.p051m.p052a;

import java.io.File;
import java.util.Date;
/* renamed from: b.a.a.b.m.a.q */
/* loaded from: classes.dex */
public class C0492q extends AbstractC0478g {
    public C0492q(C0483i c0483i, C0489o c0489o) {
        super(c0483i, c0489o);
    }

    @Override // p004b.p005a.p006a.p028b.p051m.p052a.AbstractC0478g
    /* renamed from: a */
    protected void mo20360a(Date date, int i) {
        File file = new File(this.f1063d.m20387a((Object) this.f1064e.m20364a(date, i)));
        if (!file.exists() || !file.isFile()) {
            return;
        }
        file.delete();
        d("deleting " + file);
        if (!this.f1066g) {
            return;
        }
        a(file.getParentFile());
    }

    public String toString() {
        return "c.q.l.core.rolling.helper.TimeBasedArchiveRemover";
    }
}
