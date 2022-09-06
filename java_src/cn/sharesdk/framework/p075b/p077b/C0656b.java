package cn.sharesdk.framework.p075b.p077b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.C0683d;
import com.mob.tools.utils.Data;
/* renamed from: cn.sharesdk.framework.b.b.b */
/* loaded from: classes.dex */
public class C0656b extends AbstractC0657c {

    /* renamed from: n */
    private static int f1500n;

    /* renamed from: o */
    private static long f1501o;

    /* renamed from: a */
    public int f1502a;

    /* renamed from: b */
    public String f1503b;

    /* renamed from: c */
    public String f1504c;

    /* renamed from: d */
    public String f1505d;

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: a */
    protected String mo19653a() {
        return "[AUT]";
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: a */
    protected void mo19652a(long j) {
        f1501o = j;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: b */
    protected int mo19650b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: c */
    protected int mo19648c() {
        return 5;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: d */
    protected long mo19647d() {
        return f1500n;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: e */
    protected long mo19646e() {
        return f1501o;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: f */
    protected void mo19645f() {
        f1500n++;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|').append(this.f1502a);
        sb.append('|').append(this.f1503b);
        sb.append('|');
        if (!TextUtils.isEmpty(this.f1505d)) {
            try {
                String encodeToString = Base64.encodeToString(Data.AES128Encode(this.f1507f.substring(0, 16), this.f1505d), 0);
                if (!TextUtils.isEmpty(encodeToString) && encodeToString.contains("\n")) {
                    encodeToString = encodeToString.replace("\n", "");
                }
                sb.append(encodeToString);
            } catch (Throwable th) {
                C0683d.m19513a().m5971d(th);
            }
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.f1514m)) {
            sb.append(this.f1514m);
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.f1504c)) {
            sb.append(this.f1504c);
        }
        return sb.toString();
    }
}
