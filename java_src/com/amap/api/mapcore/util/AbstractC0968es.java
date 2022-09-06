package com.amap.api.mapcore.util;

import android.content.Context;
import com.baidu.tts.loopj.AsyncHttpClient;
import java.util.HashMap;
import java.util.Map;
import org.p248a.p249a.C5083e;
/* renamed from: com.amap.api.mapcore.util.es */
/* loaded from: classes.dex */
public abstract class AbstractC0968es<T, V> extends AbstractC0967er<T, V> {
    public AbstractC0968es(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0967er, com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: a */
    public Map<String, String> mo17702a() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        hashMap.put(C5083e.f21661Y, "AMAP SDK Android Trace 4.1.2");
        hashMap.put("X-INFO", C0986fb.m18142b(this.f3026d));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.1.2", "trace"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0967er, com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: b */
    public Map<String, String> mo17699b() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: c */
    public String mo17697c() {
        String str;
        String m18151a;
        return "http://restapi.amap.com/v3/grasproad?" + ("key=" + C0976ey.m18166f(this.f3026d)) + ("&ts=" + C0986fb.m18151a()) + ("&scode=" + C0986fb.m18146a(this.f3026d, m18151a, str));
    }

    @Override // com.amap.api.mapcore.util.AbstractC0967er
    /* renamed from: e */
    protected V mo18191e() {
        return null;
    }

    /* renamed from: f */
    protected abstract String mo18186f();

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: g */
    public byte[] mo17696g() {
        try {
            return mo18186f().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
