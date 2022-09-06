package com.tencent.stat.common;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.stat.StatConfig;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;
import org.p318d.AbstractC5756f;
/* renamed from: com.tencent.stat.common.c */
/* loaded from: classes2.dex */
class C4412c {

    /* renamed from: a */
    String f18418a;

    /* renamed from: b */
    String f18419b;

    /* renamed from: c */
    DisplayMetrics f18420c;

    /* renamed from: d */
    int f18421d;

    /* renamed from: e */
    String f18422e;

    /* renamed from: f */
    String f18423f;

    /* renamed from: g */
    String f18424g;

    /* renamed from: h */
    String f18425h;

    /* renamed from: i */
    String f18426i;

    /* renamed from: j */
    String f18427j;

    /* renamed from: k */
    String f18428k;

    /* renamed from: l */
    int f18429l;

    /* renamed from: m */
    String f18430m;

    /* renamed from: n */
    Context f18431n;

    /* renamed from: o */
    private String f18432o;

    /* renamed from: p */
    private String f18433p;

    /* renamed from: q */
    private String f18434q;

    /* renamed from: r */
    private String f18435r;

    private C4412c(Context context) {
        this.f18419b = StatConstants.VERSION;
        this.f18421d = Build.VERSION.SDK_INT;
        this.f18422e = Build.MODEL;
        this.f18423f = Build.MANUFACTURER;
        this.f18424g = Locale.getDefault().getLanguage();
        this.f18429l = 0;
        this.f18430m = null;
        this.f18431n = null;
        this.f18432o = null;
        this.f18433p = null;
        this.f18434q = null;
        this.f18435r = null;
        this.f18431n = context;
        this.f18420c = C4420k.m5189d(context);
        this.f18418a = C4420k.m5173n(context);
        this.f18425h = StatConfig.getInstallChannel(context);
        this.f18426i = C4420k.m5174m(context);
        this.f18427j = TimeZone.getDefault().getID();
        this.f18429l = C4420k.m5168s(context);
        this.f18428k = C4420k.m5167t(context);
        this.f18430m = context.getPackageName();
        if (this.f18421d >= 14) {
            this.f18432o = C4420k.m5212A(context);
        }
        this.f18433p = C4420k.m5161z(context).toString();
        this.f18434q = C4420k.m5163x(context);
        this.f18435r = C4420k.m5187e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5229a(JSONObject jSONObject) {
        jSONObject.put("sr", this.f18420c.widthPixels + AbstractC5756f.f23062a + this.f18420c.heightPixels);
        C4420k.m5199a(jSONObject, "av", this.f18418a);
        C4420k.m5199a(jSONObject, "ch", this.f18425h);
        C4420k.m5199a(jSONObject, "mf", this.f18423f);
        C4420k.m5199a(jSONObject, "sv", this.f18419b);
        C4420k.m5199a(jSONObject, "ov", Integer.toString(this.f18421d));
        jSONObject.put("os", 1);
        C4420k.m5199a(jSONObject, "op", this.f18426i);
        C4420k.m5199a(jSONObject, "lg", this.f18424g);
        C4420k.m5199a(jSONObject, "md", this.f18422e);
        C4420k.m5199a(jSONObject, "tz", this.f18427j);
        if (this.f18429l != 0) {
            jSONObject.put("jb", this.f18429l);
        }
        C4420k.m5199a(jSONObject, "sd", this.f18428k);
        C4420k.m5199a(jSONObject, "apn", this.f18430m);
        if (C4420k.m5180h(this.f18431n)) {
            JSONObject jSONObject2 = new JSONObject();
            C4420k.m5199a(jSONObject2, "bs", C4420k.m5210C(this.f18431n));
            C4420k.m5199a(jSONObject2, "ss", C4420k.m5209D(this.f18431n));
            if (jSONObject2.length() > 0) {
                C4420k.m5199a(jSONObject, "wf", jSONObject2.toString());
            }
        }
        C4420k.m5199a(jSONObject, "sen", this.f18432o);
        C4420k.m5199a(jSONObject, "cpu", this.f18433p);
        C4420k.m5199a(jSONObject, "ram", this.f18434q);
        C4420k.m5199a(jSONObject, "rom", this.f18435r);
    }
}
