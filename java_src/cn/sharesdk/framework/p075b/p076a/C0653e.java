package cn.sharesdk.framework.p075b.p076a;

import android.content.Context;
import android.text.TextUtils;
import com.mob.tools.utils.SharePrefrenceHelper;
/* renamed from: cn.sharesdk.framework.b.a.e */
/* loaded from: classes.dex */
public class C0653e {

    /* renamed from: c */
    private static C0653e f1490c;

    /* renamed from: a */
    private Context f1491a;

    /* renamed from: b */
    private SharePrefrenceHelper f1492b;

    private C0653e(Context context) {
        this.f1491a = context.getApplicationContext();
        this.f1492b = new SharePrefrenceHelper(this.f1491a);
        this.f1492b.open("share_sdk", 1);
    }

    /* renamed from: a */
    public static C0653e m19677a(Context context) {
        if (f1490c == null) {
            f1490c = new C0653e(context.getApplicationContext());
        }
        return f1490c;
    }

    /* renamed from: a */
    public long m19679a() {
        return this.f1492b.getLong("service_time");
    }

    /* renamed from: a */
    public void m19678a(long j) {
        this.f1492b.putLong("device_time", Long.valueOf(j));
    }

    /* renamed from: a */
    public void m19676a(String str) {
        this.f1492b.putString("trans_short_link", str);
    }

    /* renamed from: a */
    public void m19675a(String str, int i) {
        this.f1492b.putInt(str, Integer.valueOf(i));
    }

    /* renamed from: a */
    public void m19674a(String str, Long l) {
        this.f1492b.putLong(str, l);
    }

    /* renamed from: a */
    public void m19673a(String str, Object obj) {
        this.f1492b.put(str, obj);
    }

    /* renamed from: a */
    public void m19672a(String str, String str2) {
        this.f1492b.putString("buffered_snsconf_" + str, str2);
    }

    /* renamed from: a */
    public void m19671a(boolean z) {
        this.f1492b.putBoolean("connect_server", Boolean.valueOf(z));
    }

    /* renamed from: b */
    public void m19669b(long j) {
        this.f1492b.putLong("connect_server_time", Long.valueOf(j));
    }

    /* renamed from: b */
    public void m19668b(String str) {
        this.f1492b.putString("upload_device_info", str);
    }

    /* renamed from: b */
    public void m19667b(boolean z) {
        this.f1492b.putBoolean("sns_info_buffered", Boolean.valueOf(z));
    }

    /* renamed from: b */
    public boolean m19670b() {
        String string = this.f1492b.getString("upload_device_info");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        return Boolean.parseBoolean(string);
    }

    /* renamed from: c */
    public void m19665c(String str) {
        this.f1492b.putString("upload_user_info", str);
    }

    /* renamed from: c */
    public boolean m19666c() {
        String string = this.f1492b.getString("upload_user_info");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        return Boolean.parseBoolean(string);
    }

    /* renamed from: d */
    public void m19663d(String str) {
        this.f1492b.putString("upload_share_content", str);
    }

    /* renamed from: d */
    public boolean m19664d() {
        String string = this.f1492b.getString("trans_short_link");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return Boolean.parseBoolean(string);
    }

    /* renamed from: e */
    public int m19662e() {
        String string = this.f1492b.getString("upload_share_content");
        if ("true".equals(string)) {
            return 1;
        }
        return "false".equals(string) ? -1 : 0;
    }

    /* renamed from: e */
    public String m19661e(String str) {
        return this.f1492b.getString("buffered_snsconf_" + str);
    }

    /* renamed from: f */
    public long m19659f(String str) {
        return this.f1492b.getLong(str);
    }

    /* renamed from: f */
    public Long m19660f() {
        return Long.valueOf(this.f1492b.getLong("device_time"));
    }

    /* renamed from: g */
    public int m19657g(String str) {
        return this.f1492b.getInt(str);
    }

    /* renamed from: g */
    public boolean m19658g() {
        return this.f1492b.getBoolean("connect_server");
    }

    /* renamed from: h */
    public Long m19656h() {
        return Long.valueOf(this.f1492b.getLong("connect_server_time"));
    }

    /* renamed from: h */
    public Object m19655h(String str) {
        return this.f1492b.get(str);
    }

    /* renamed from: i */
    public boolean m19654i() {
        return this.f1492b.getBoolean("sns_info_buffered");
    }
}
