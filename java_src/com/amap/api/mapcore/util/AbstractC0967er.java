package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Map;
/* renamed from: com.amap.api.mapcore.util.er */
/* loaded from: classes.dex */
public abstract class AbstractC0967er<T, V> extends AbstractC1075hd {

    /* renamed from: a */
    protected T f3023a;

    /* renamed from: d */
    protected Context f3026d;

    /* renamed from: e */
    protected String f3027e;

    /* renamed from: b */
    protected int f3024b = 1;

    /* renamed from: c */
    protected String f3025c = "";

    /* renamed from: i */
    private int f3028i = 1;

    public AbstractC0967er(Context context, T t) {
        m18196a(context, t);
    }

    /* renamed from: a */
    private void m18196a(Context context, T t) {
        this.f3026d = context;
        this.f3023a = t;
        this.f3024b = 1;
        b(30000);
        a(30000);
    }

    /* renamed from: b */
    private V m18194b(byte[] bArr) {
        return m18195a(bArr);
    }

    /* renamed from: f */
    private V m18192f() {
        int i = 0;
        V v = null;
        while (i < this.f3024b) {
            try {
                C1072hc m17707a = C1072hc.m17707a(false);
                a(C0993ff.m18085a(this.f3026d));
                v = m18194b(m18197a(1, m17707a, this));
                i = this.f3024b;
            } catch (C0966eq e) {
                i++;
                if (i >= this.f3024b) {
                    throw new C0966eq(e.m18199a());
                }
            } catch (C0975ex e2) {
                i++;
                if (i >= this.f3024b) {
                    mo18191e();
                    if (!"http连接失败 - ConnectionException".equals(e2.getMessage()) && !"socket 连接异常 - SocketException".equals(e2.getMessage()) && !"未知的错误".equals(e2.m18175a()) && !"服务器连接失败 - UnknownServiceException".equals(e2.getMessage())) {
                        throw new C0966eq(e2.m18175a());
                    }
                    throw new C0966eq("http或socket连接失败 - ConnectionException");
                }
                try {
                    Thread.sleep(this.f3028i * 1000);
                } catch (InterruptedException e3) {
                    if (!"http连接失败 - ConnectionException".equals(e2.getMessage()) && !"socket 连接异常 - SocketException".equals(e2.getMessage()) && !"服务器连接失败 - UnknownServiceException".equals(e2.getMessage())) {
                        throw new C0966eq(e2.m18175a());
                    }
                    throw new C0966eq("http或socket连接失败 - ConnectionException");
                }
            } catch (Throwable th) {
                throw new C0966eq("未知错误");
            }
        }
        return v;
    }

    /* renamed from: a */
    protected abstract V mo18188a(String str);

    /* renamed from: a */
    protected V m18195a(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        C0969et.m18190a(str, this.f3027e);
        return mo18188a(str);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: a */
    public Map<String, String> mo17702a() {
        return null;
    }

    /* renamed from: a */
    protected byte[] m18197a(int i, C1072hc c1072hc, AbstractC1075hd abstractC1075hd) {
        if (i == 1) {
            return c1072hc.mo17705b(abstractC1075hd);
        }
        if (i != 2) {
            return null;
        }
        return c1072hc.a(abstractC1075hd);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: b */
    public Map<String, String> mo17699b() {
        return null;
    }

    /* renamed from: d */
    public V m18193d() {
        if (this.f3023a != null) {
            return m18192f();
        }
        return null;
    }

    /* renamed from: e */
    protected V mo18191e() {
        return null;
    }
}
