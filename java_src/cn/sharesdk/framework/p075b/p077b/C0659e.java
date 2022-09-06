package cn.sharesdk.framework.p075b.p077b;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.p075b.p076a.C0653e;
/* renamed from: cn.sharesdk.framework.b.b.e */
/* loaded from: classes.dex */
public class C0659e extends AbstractC0657c {

    /* renamed from: b */
    private static int f1520b;

    /* renamed from: c */
    private static long f1521c;

    /* renamed from: a */
    public long f1522a;

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: a */
    protected String mo19653a() {
        return "[EXT]";
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: a */
    protected void mo19652a(long j) {
        f1521c = j;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: a */
    public boolean mo19651a(Context context) {
        C0653e m19677a = C0653e.m19677a(context);
        f1520b = m19677a.m19657g("insertExitEventCount");
        f1521c = m19677a.m19659f("lastInsertExitEventTime");
        return super.mo19651a(context);
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: b */
    protected int mo19650b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: b */
    public void mo19649b(Context context) {
        super.mo19649b(context);
        C0653e m19677a = C0653e.m19677a(context);
        m19677a.m19674a("lastInsertExitEventTime", Long.valueOf(f1521c));
        m19677a.m19675a("insertExitEventCount", f1520b);
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: c */
    protected int mo19648c() {
        return 5;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: d */
    protected long mo19647d() {
        return f1520b;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: e */
    protected long mo19646e() {
        return f1521c;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: f */
    protected void mo19645f() {
        f1520b++;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        if (!TextUtils.isEmpty(this.f1514m)) {
            sb.append(this.f1514m);
        }
        sb.append('|').append(Math.round(((float) this.f1522a) / 1000.0f));
        return sb.toString();
    }
}
