package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.C4464b;
import com.xiaomi.channel.commonutils.android.C4468e;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
/* renamed from: com.xiaomi.mipush.sdk.a */
/* loaded from: classes.dex */
public class C4520a {

    /* renamed from: a */
    private static C4520a f18610a;

    /* renamed from: b */
    private Context f18611b;

    /* renamed from: c */
    private C4521a f18612c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.mipush.sdk.a$a */
    /* loaded from: classes2.dex */
    public class C4521a {

        /* renamed from: a */
        public String f18613a;

        /* renamed from: b */
        public String f18614b;

        /* renamed from: c */
        public String f18615c;

        /* renamed from: d */
        public String f18616d;

        /* renamed from: e */
        public String f18617e;

        /* renamed from: f */
        public String f18618f;

        /* renamed from: g */
        public String f18619g;

        /* renamed from: h */
        public boolean f18620h;

        /* renamed from: i */
        public boolean f18621i;

        /* renamed from: j */
        public int f18622j;

        private C4521a() {
            this.f18620h = true;
            this.f18621i = false;
            this.f18622j = 1;
        }

        /* renamed from: d */
        private String m4880d() {
            return C4464b.m5099a(C4520a.this.f18611b, C4520a.this.f18611b.getPackageName());
        }

        /* renamed from: a */
        public void m4887a(int i) {
            this.f18622j = i;
        }

        /* renamed from: a */
        public void m4886a(String str, String str2) {
            this.f18615c = str;
            this.f18616d = str2;
            this.f18618f = C4468e.m5080e(C4520a.this.f18611b);
            this.f18617e = m4880d();
            this.f18620h = true;
            SharedPreferences.Editor edit = C4520a.this.m4894j().edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f18618f);
            edit.putString("vName", m4880d());
            edit.putBoolean("valid", true);
            edit.commit();
        }

        /* renamed from: a */
        public void m4885a(String str, String str2, String str3) {
            this.f18613a = str;
            this.f18614b = str2;
            this.f18619g = str3;
            SharedPreferences.Editor edit = C4520a.this.m4894j().edit();
            edit.putString("appId", this.f18613a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        /* renamed from: a */
        public void m4884a(boolean z) {
            this.f18621i = z;
        }

        /* renamed from: a */
        public boolean m4888a() {
            return m4882b(this.f18613a, this.f18614b);
        }

        /* renamed from: b */
        public void m4883b() {
            C4520a.this.m4894j().edit().clear().commit();
            this.f18613a = null;
            this.f18614b = null;
            this.f18615c = null;
            this.f18616d = null;
            this.f18618f = null;
            this.f18617e = null;
            this.f18620h = false;
            this.f18621i = false;
            this.f18622j = 1;
        }

        /* renamed from: b */
        public boolean m4882b(String str, String str2) {
            return TextUtils.equals(this.f18613a, str) && TextUtils.equals(this.f18614b, str2) && !TextUtils.isEmpty(this.f18615c) && !TextUtils.isEmpty(this.f18616d) && TextUtils.equals(this.f18618f, C4468e.m5080e(C4520a.this.f18611b));
        }

        /* renamed from: c */
        public void m4881c() {
            this.f18620h = false;
            C4520a.this.m4894j().edit().putBoolean("valid", this.f18620h).commit();
        }
    }

    private C4520a(Context context) {
        this.f18611b = context;
        m4889o();
    }

    /* renamed from: a */
    public static C4520a m4909a(Context context) {
        if (f18610a == null) {
            f18610a = new C4520a(context);
        }
        return f18610a;
    }

    /* renamed from: o */
    private void m4889o() {
        this.f18612c = new C4521a();
        SharedPreferences m4894j = m4894j();
        this.f18612c.f18613a = m4894j.getString("appId", null);
        this.f18612c.f18614b = m4894j.getString("appToken", null);
        this.f18612c.f18615c = m4894j.getString("regId", null);
        this.f18612c.f18616d = m4894j.getString("regSec", null);
        this.f18612c.f18618f = m4894j.getString("devId", null);
        if (!TextUtils.isEmpty(this.f18612c.f18618f) && this.f18612c.f18618f.startsWith("a-")) {
            this.f18612c.f18618f = C4468e.m5080e(this.f18611b);
            m4894j.edit().putString("devId", this.f18612c.f18618f).commit();
        }
        this.f18612c.f18617e = m4894j.getString("vName", null);
        this.f18612c.f18620h = m4894j.getBoolean("valid", true);
        this.f18612c.f18621i = m4894j.getBoolean("paused", false);
        this.f18612c.f18622j = m4894j.getInt("envType", 1);
        this.f18612c.f18619g = m4894j.getString("regResource", null);
    }

    /* renamed from: a */
    public void m4910a(int i) {
        this.f18612c.m4887a(i);
        m4894j().edit().putInt("envType", i).commit();
    }

    /* renamed from: a */
    public void m4907a(String str) {
        SharedPreferences.Editor edit = m4894j().edit();
        edit.putString("vName", str);
        edit.commit();
        this.f18612c.f18617e = str;
    }

    /* renamed from: a */
    public void m4905a(String str, String str2, String str3) {
        this.f18612c.m4885a(str, str2, str3);
    }

    /* renamed from: a */
    public void m4904a(boolean z) {
        this.f18612c.m4884a(z);
        m4894j().edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a */
    public boolean m4911a() {
        return !TextUtils.equals(C4464b.m5099a(this.f18611b, this.f18611b.getPackageName()), this.f18612c.f18617e);
    }

    /* renamed from: a */
    public boolean m4906a(String str, String str2) {
        return this.f18612c.m4882b(str, str2);
    }

    /* renamed from: b */
    public void m4902b(String str, String str2) {
        this.f18612c.m4886a(str, str2);
    }

    /* renamed from: b */
    public boolean m4903b() {
        if (!this.f18612c.m4888a()) {
            AbstractC4478b.m5041a("Don't send message before initialization succeeded!");
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public String m4901c() {
        return this.f18612c.f18613a;
    }

    /* renamed from: d */
    public String m4900d() {
        return this.f18612c.f18614b;
    }

    /* renamed from: e */
    public String m4899e() {
        return this.f18612c.f18615c;
    }

    /* renamed from: f */
    public String m4898f() {
        return this.f18612c.f18616d;
    }

    /* renamed from: g */
    public String m4897g() {
        return this.f18612c.f18619g;
    }

    /* renamed from: h */
    public void m4896h() {
        this.f18612c.m4883b();
    }

    /* renamed from: i */
    public boolean m4895i() {
        return this.f18612c.m4888a();
    }

    /* renamed from: j */
    public SharedPreferences m4894j() {
        return this.f18611b.getSharedPreferences("mipush", 0);
    }

    /* renamed from: k */
    public void m4893k() {
        this.f18612c.m4881c();
    }

    /* renamed from: l */
    public boolean m4892l() {
        return this.f18612c.f18621i;
    }

    /* renamed from: m */
    public int m4891m() {
        return this.f18612c.f18622j;
    }

    /* renamed from: n */
    public boolean m4890n() {
        return !this.f18612c.f18620h;
    }
}
