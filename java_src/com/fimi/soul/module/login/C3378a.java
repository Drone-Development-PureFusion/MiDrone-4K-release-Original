package com.fimi.soul.module.login;

import android.content.Context;
import com.fimi.kernel.p163c.C2241c;
/* renamed from: com.fimi.soul.module.login.a */
/* loaded from: classes.dex */
public class C3378a {

    /* renamed from: a */
    private static String[] f13149a = {"https://paas-beijing6-static-file.fimi.com/h5/", "https://paas-oregon-static-file.fimi.com/h5/", "https://paas-singapore.fimi.com/h5/", "https://paas-moscow.fimi.com/h5/", "https://paas-mumbai.fimi.com/h5/", "https://paas-frankfurt.fimi.com/h5/"};

    /* renamed from: a */
    public static String m8559a(Context context) {
        return "file:///android_asset/privacy.html";
    }

    /* renamed from: a */
    private static String m8558a(Context context, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        String string = context.getResources().getString(i);
        C3391h c3391h = (C3391h) C2241c.m13122a().mo13118a(C3384c.f13195w, C3391h.class);
        stringBuffer.append(String.format(string, C3384c.f13181i.toString().toLowerCase(), (c3391h == null || c3391h.m8514a().equals("")) ? "en" : c3391h.m8514a()));
        return stringBuffer.toString().trim();
    }

    /* renamed from: b */
    public static String m8557b(Context context) {
        return "file:///android_asset/protocol.html";
    }
}
