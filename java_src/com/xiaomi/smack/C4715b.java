package com.xiaomi.smack;

import com.xiaomi.channel.commonutils.misc.C4479a;
import com.xiaomi.channel.commonutils.misc.C4481c;
import java.util.Map;
/* renamed from: com.xiaomi.smack.b */
/* loaded from: classes.dex */
public class C4715b implements Cloneable {

    /* renamed from: b */
    public static String f19377b = "wcc-ml-test10.bj";

    /* renamed from: c */
    public static final String f19378c = C4481c.f18547b;

    /* renamed from: d */
    public static String f19379d = null;

    /* renamed from: a */
    private String f19380a;

    /* renamed from: e */
    private String f19381e;

    /* renamed from: f */
    private int f19382f;

    /* renamed from: g */
    private boolean f19383g = AbstractC4713a.f19356a;

    /* renamed from: h */
    private boolean f19384h = true;

    /* renamed from: i */
    private String f19385i;

    /* renamed from: j */
    private AbstractC4719e f19386j;

    public C4715b(Map<String, Integer> map, int i, String str, AbstractC4719e abstractC4719e) {
        m3962a(map, i, str, abstractC4719e);
    }

    /* renamed from: a */
    private void m3962a(Map<String, Integer> map, int i, String str, AbstractC4719e abstractC4719e) {
        this.f19381e = m3960b();
        this.f19382f = i;
        this.f19380a = str;
        this.f19386j = abstractC4719e;
    }

    /* renamed from: b */
    public static final String m3960b() {
        return f19379d != null ? f19379d : C4479a.m5034a() ? "sandbox.xmpush.xiaomi.com" : C4479a.m5032b() ? f19378c : "app.chat.xiaomi.net";
    }

    /* renamed from: a */
    public void m3963a(String str) {
        this.f19385i = str;
    }

    /* renamed from: a */
    public void m3961a(boolean z) {
        this.f19383g = z;
    }

    /* renamed from: a */
    public byte[] mo3964a() {
        return null;
    }

    /* renamed from: b */
    public void m3959b(String str) {
        this.f19381e = str;
    }

    /* renamed from: c */
    public String m3958c() {
        return this.f19385i;
    }

    /* renamed from: d */
    public int m3957d() {
        return this.f19382f;
    }

    /* renamed from: e */
    public String m3956e() {
        return this.f19381e;
    }

    /* renamed from: f */
    public boolean m3955f() {
        return this.f19383g;
    }
}
