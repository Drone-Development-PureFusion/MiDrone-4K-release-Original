package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.string.C4505b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.protobuf.C4567b;
import com.xiaomi.push.service.C4612ak;
import com.xiaomi.smack.AbstractC4713a;
import java.util.HashMap;
/* renamed from: com.xiaomi.slim.a */
/* loaded from: classes2.dex */
class C4706a {
    /* renamed from: a */
    public static void m4037a(C4612ak.C4614b c4614b, String str, AbstractC4713a abstractC4713a) {
        String m4953a;
        C4567b.C4570c c4570c = new C4567b.C4570c();
        if (!TextUtils.isEmpty(c4614b.f18956c)) {
            c4570c.m4640a(c4614b.f18956c);
        }
        if (!TextUtils.isEmpty(c4614b.f18959f)) {
            c4570c.m4635d(c4614b.f18959f);
        }
        if (!TextUtils.isEmpty(c4614b.f18960g)) {
            c4570c.m4633e(c4614b.f18960g);
        }
        c4570c.m4638b(c4614b.f18958e ? "1" : "0");
        if (!TextUtils.isEmpty(c4614b.f18957d)) {
            c4570c.m4637c(c4614b.f18957d);
        } else {
            c4570c.m4637c("XIAOMI-SASL");
        }
        C4707b c4707b = new C4707b();
        c4707b.m4022c(c4614b.f18955b);
        c4707b.m4034a(Integer.parseInt(c4614b.f18961h));
        c4707b.m4025b(c4614b.f18954a);
        c4707b.m4030a("BIND", (String) null);
        c4707b.m4031a(c4707b.m4015h());
        AbstractC4478b.m5041a("[Slim]: bind id=" + c4707b.m4015h());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put(Constants.EXTRA_KEY_TOKEN, c4614b.f18956c);
        hashMap.put("chid", c4614b.f18961h);
        hashMap.put("from", c4614b.f18955b);
        hashMap.put("id", c4707b.m4015h());
        hashMap.put("to", "xiaomi.com");
        if (c4614b.f18958e) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (!TextUtils.isEmpty(c4614b.f18959f)) {
            hashMap.put("client_attrs", c4614b.f18959f);
        } else {
            hashMap.put("client_attrs", "");
        }
        if (!TextUtils.isEmpty(c4614b.f18960g)) {
            hashMap.put("cloud_attrs", c4614b.f18960g);
        } else {
            hashMap.put("cloud_attrs", "");
        }
        if (c4614b.f18957d.equals("XIAOMI-PASS") || c4614b.f18957d.equals("XMPUSH-PASS")) {
            m4953a = C4505b.m4953a(c4614b.f18957d, null, hashMap, c4614b.f18962i);
        } else {
            if (c4614b.f18957d.equals("XIAOMI-SASL")) {
            }
            m4953a = null;
        }
        c4570c.m4631f(m4953a);
        c4707b.m4027a(c4570c.c(), (String) null);
        abstractC4713a.mo3982b(c4707b);
    }

    /* renamed from: a */
    public static void m4036a(String str, String str2, AbstractC4713a abstractC4713a) {
        C4707b c4707b = new C4707b();
        c4707b.m4022c(str2);
        c4707b.m4034a(Integer.parseInt(str));
        c4707b.m4030a("UBND", (String) null);
        abstractC4713a.mo3982b(c4707b);
    }
}
