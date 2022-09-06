package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;
/* renamed from: com.amap.api.mapcore.util.gd */
/* loaded from: classes.dex */
public abstract class AbstractC1026gd {
    @AbstractC1018fw(m17948a = "b1", m17947b = 6)

    /* renamed from: b */
    protected String f3207b;
    @AbstractC1018fw(m17948a = "a1", m17947b = 6)

    /* renamed from: d */
    private String f3209d;
    @AbstractC1018fw(m17948a = "b2", m17947b = 2)

    /* renamed from: a */
    protected int f3206a = -1;
    @AbstractC1018fw(m17948a = "b3", m17947b = 2)

    /* renamed from: c */
    protected int f3208c = 1;

    /* renamed from: c */
    public static String m17933c(int i) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("b2").append("=").append(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static String m17932c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("b1", str);
        return C1016fu.m17955a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public int m17940a() {
        return this.f3206a;
    }

    /* renamed from: a */
    public void m17939a(int i) {
        this.f3206a = i;
    }

    /* renamed from: a */
    public void m17938a(String str) {
        this.f3207b = str;
    }

    /* renamed from: b */
    public String m17937b() {
        return this.f3207b;
    }

    /* renamed from: b */
    public void m17936b(int i) {
        this.f3208c = i;
    }

    /* renamed from: b */
    public void m17935b(String str) {
        this.f3209d = C0999fi.m18042b(str);
    }

    /* renamed from: c */
    public int m17934c() {
        return this.f3208c;
    }
}
