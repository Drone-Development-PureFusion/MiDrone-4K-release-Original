package cn.sharesdk.framework.p075b.p077b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.C0683d;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;
/* renamed from: cn.sharesdk.framework.b.b.f */
/* loaded from: classes.dex */
public class C0660f extends AbstractC0657c {

    /* renamed from: p */
    private static int f1523p;

    /* renamed from: q */
    private static long f1524q;

    /* renamed from: a */
    public int f1525a;

    /* renamed from: b */
    public String f1526b;

    /* renamed from: c */
    public String f1527c;

    /* renamed from: d */
    public C0661a f1528d = new C0661a();

    /* renamed from: n */
    public String f1529n;

    /* renamed from: o */
    public String[] f1530o;

    /* renamed from: cn.sharesdk.framework.b.b.f$a */
    /* loaded from: classes.dex */
    public static class C0661a {

        /* renamed from: b */
        public String f1532b;

        /* renamed from: g */
        public HashMap<String, Object> f1537g;

        /* renamed from: a */
        public String f1531a = "";

        /* renamed from: c */
        public ArrayList<String> f1533c = new ArrayList<>();

        /* renamed from: d */
        public ArrayList<String> f1534d = new ArrayList<>();

        /* renamed from: e */
        public ArrayList<String> f1535e = new ArrayList<>();

        /* renamed from: f */
        public ArrayList<Bitmap> f1536f = new ArrayList<>();

        public String toString() {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f1532b)) {
                this.f1532b = this.f1532b.trim().replaceAll("\r", "");
                this.f1532b = this.f1532b.trim().replaceAll("\n", "");
                this.f1532b = this.f1532b.trim().replaceAll(C3947a.f16890a, "");
            }
            hashMap.put("text", this.f1532b);
            hashMap.put("url", this.f1533c);
            if (this.f1534d != null && this.f1534d.size() > 0) {
                hashMap.put("imgs", this.f1534d);
            }
            if (this.f1537g != null) {
                hashMap.put("attch", new Hashon().fromHashMap(this.f1537g));
            }
            return new Hashon().fromHashMap(hashMap);
        }
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: a */
    protected String mo19653a() {
        return "[SHR]";
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: a */
    protected void mo19652a(long j) {
        f1524q = j;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: b */
    protected int mo19650b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: c */
    protected int mo19648c() {
        return 30;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: d */
    protected long mo19647d() {
        return f1523p;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: e */
    protected long mo19646e() {
        return f1524q;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    /* renamed from: f */
    protected void mo19645f() {
        f1523p++;
    }

    @Override // cn.sharesdk.framework.p075b.p077b.AbstractC0657c
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|').append(this.f1525a);
        sb.append('|').append(this.f1526b);
        sb.append('|').append(TextUtils.isEmpty(this.f1527c) ? "" : this.f1527c);
        String str = "";
        if (this.f1530o != null && this.f1530o.length > 0) {
            str = "[\"" + TextUtils.join("\",\"", this.f1530o) + "\"]";
        }
        sb.append('|').append(str);
        sb.append('|');
        if (this.f1528d != null) {
            try {
                String encodeToString = Base64.encodeToString(Data.AES128Encode(this.f1507f.substring(0, 16), this.f1528d.toString()), 0);
                if (encodeToString.contains("\n")) {
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
        if (!TextUtils.isEmpty(this.f1529n)) {
            try {
                String encodeToString2 = Base64.encodeToString(Data.AES128Encode(this.f1507f.substring(0, 16), this.f1529n), 0);
                if (!TextUtils.isEmpty(encodeToString2) && encodeToString2.contains("\n")) {
                    encodeToString2 = encodeToString2.replace("\n", "");
                }
                sb.append(encodeToString2);
            } catch (Throwable th2) {
                C0683d.m19513a().m5959w(th2);
            }
        }
        return sb.toString();
    }
}
