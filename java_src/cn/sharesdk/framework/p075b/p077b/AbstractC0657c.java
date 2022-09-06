package cn.sharesdk.framework.p075b.p077b;

import android.content.Context;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: cn.sharesdk.framework.b.b.c */
/* loaded from: classes.dex */
public abstract class AbstractC0657c {

    /* renamed from: e */
    public long f1506e;

    /* renamed from: f */
    public String f1507f;

    /* renamed from: g */
    public String f1508g;

    /* renamed from: h */
    public String f1509h;

    /* renamed from: i */
    public int f1510i;

    /* renamed from: j */
    public String f1511j;

    /* renamed from: k */
    public int f1512k;

    /* renamed from: l */
    public String f1513l;

    /* renamed from: m */
    public String f1514m;

    /* renamed from: a */
    protected abstract String mo19653a();

    /* renamed from: a */
    protected abstract void mo19652a(long j);

    /* renamed from: a */
    public boolean mo19651a(Context context) {
        int mo19650b = mo19650b();
        int mo19648c = mo19648c();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - mo19646e() < mo19650b) {
            return mo19647d() < ((long) mo19648c);
        }
        mo19652a(currentTimeMillis);
        return true;
    }

    /* renamed from: b */
    protected abstract int mo19650b();

    /* renamed from: b */
    public void mo19649b(Context context) {
        mo19645f();
    }

    /* renamed from: c */
    protected abstract int mo19648c();

    /* renamed from: d */
    protected abstract long mo19647d();

    /* renamed from: e */
    protected abstract long mo19646e();

    /* renamed from: f */
    protected abstract void mo19645f();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo19653a()).append(C0359h.f671A);
        sb.append(this.f1506e).append('|');
        sb.append(this.f1507f).append('|');
        sb.append(this.f1508g).append('|');
        sb.append(this.f1509h).append('|');
        sb.append(this.f1510i).append('|');
        sb.append(this.f1511j).append('|');
        sb.append(this.f1512k).append('|');
        sb.append(this.f1513l);
        return sb.toString();
    }
}
