package com.amap.api.services.core;

import android.content.Context;
import com.baidu.tts.loopj.AsyncHttpClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p252c.p258f.C5078j;
/* renamed from: com.amap.api.services.core.r */
/* loaded from: classes.dex */
public abstract class AbstractC1254r<T, V> extends AbstractC1227bt {

    /* renamed from: a */
    protected T f4183a;

    /* renamed from: d */
    protected Context f4186d;

    /* renamed from: b */
    protected int f4184b = 1;

    /* renamed from: c */
    protected String f4185c = "";

    /* renamed from: h */
    private int f4187h = 1;

    public AbstractC1254r(Context context, T t) {
        m16942a(context, t);
    }

    /* renamed from: a */
    private String m16941a(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(m16936d(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    /* renamed from: a */
    private void m16942a(Context context, T t) {
        this.f4186d = context;
        this.f4183a = t;
        this.f4184b = 1;
        d(ServiceSettings.getInstance().getSoTimeOut());
        c(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    /* renamed from: b */
    private V m16939b(byte[] bArr) {
        return m16940a(bArr);
    }

    /* renamed from: f */
    private V m16933f() {
        int i = 0;
        V v = null;
        while (i < this.f4184b) {
            try {
                int protocol = ServiceSettings.getInstance().getProtocol();
                C1224bs m17051a = C1224bs.m17051a(false);
                a(C1165ac.m17269a(this.f4186d));
                v = m16939b(protocol == 1 ? m17051a.m17055a(this) : protocol == 2 ? m17051a.m17049b(this) : null);
                i = this.f4184b;
            } catch (AMapException e) {
                C1233d.m17031a(e, "ProtocalHandler", "getDataMayThrowAMapException");
                i++;
                if (i >= this.f4184b) {
                    throw new AMapException(e.getErrorMessage());
                }
            } catch (C1258v e2) {
                C1233d.m17031a(e2, "ProtocalHandler", "getDataMayThrowAMapCoreException");
                i++;
                if (i >= this.f4184b) {
                    m16931h();
                    throw new AMapException(e2.m16928a());
                }
                try {
                    Thread.sleep(this.f4187h * 1000);
                } catch (InterruptedException e3) {
                    C1233d.m17031a(e2, "ProtocalHandler", "getDataMayThrowInterruptedException");
                    throw new AMapException(e2.getMessage());
                }
            } catch (Throwable th) {
                C1233d.m17031a(th, "ProtocalHandler", "getDataMayThrowAMapCoreException");
                throw new AMapException("未知的错误");
            }
        }
        return v;
    }

    /* renamed from: a */
    protected V m16940a(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            C1233d.m17031a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        C1233d.m17028b(str);
        return mo16811b(str);
    }

    /* renamed from: a_ */
    protected abstract String mo16814a_();

    /* renamed from: b */
    protected abstract V mo16811b(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public String m16938c(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            C1233d.m17031a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return new String();
        } catch (Exception e2) {
            C1233d.m17031a(e2, "ProtocalHandler", "strEncoderException");
            return new String();
        }
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: c_ */
    public Map<String, String> mo16937c_() {
        return null;
    }

    /* renamed from: d */
    protected String m16936d(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            C1233d.m17031a(e, "ProtocalHandler", "strReEncoder");
            return new String();
        } catch (Exception e2) {
            C1233d.m17031a(e2, "ProtocalHandler", "strReEncoderException");
            return new String();
        }
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: d_ */
    public Map<String, String> mo16935d_() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", C5078j.f21618a);
        hashMap.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        hashMap.put(C5083e.f21661Y, "AMAP SDK Android Search 2.5.0");
        hashMap.put("X-INFO", C1261y.m16914a(this.f4186d, C1241l.f4158a, (Map<String, String>) null));
        hashMap.put("ia", "1");
        hashMap.put("ec", "1");
        hashMap.put("key", C1259w.m16920f(this.f4186d));
        return hashMap;
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: e */
    public HttpEntity mo16934e() {
        try {
            String mo16814a_ = mo16814a_();
            String m16941a = m16941a(mo16814a_);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(mo16814a_);
            String m16917a = C1261y.m16917a();
            stringBuffer.append("&ts=" + m16917a);
            stringBuffer.append("&scode=" + C1261y.m16913a(this.f4186d, m16917a, m16941a));
            return new StringEntity(stringBuffer.toString());
        } catch (UnsupportedEncodingException e) {
            C1233d.m17031a(e, "ProtocalHandler", "getEntity");
            return null;
        }
    }

    /* renamed from: g */
    public V m16932g() {
        if (this.f4183a != null) {
            return m16933f();
        }
        return null;
    }

    /* renamed from: h */
    protected V m16931h() {
        return null;
    }
}
