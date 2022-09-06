package com.amap.api.mapcore.util;

import com.tencent.open.GameAppOperation;
@AbstractC1017fv(m17950a = "update_item")
/* renamed from: com.amap.api.mapcore.util.bk */
/* loaded from: classes.dex */
public class C0840bk {
    @AbstractC1018fw(m17948a = "localPath", m17947b = 6)

    /* renamed from: h */
    protected String f2356h;
    @AbstractC1018fw(m17948a = "mCompleteCode", m17947b = 2)

    /* renamed from: j */
    protected int f2358j;
    @AbstractC1018fw(m17948a = "mState", m17947b = 2)

    /* renamed from: l */
    public int f2360l;
    @AbstractC1018fw(m17948a = "title", m17947b = 6)

    /* renamed from: a */
    protected String f2349a = null;
    @AbstractC1018fw(m17948a = "url", m17947b = 6)

    /* renamed from: b */
    protected String f2350b = null;
    @AbstractC1018fw(m17948a = "mAdcode", m17947b = 6)

    /* renamed from: c */
    protected String f2351c = null;
    @AbstractC1018fw(m17948a = "fileName", m17947b = 6)

    /* renamed from: d */
    protected String f2352d = null;
    @AbstractC1018fw(m17948a = GameAppOperation.QQFAV_DATALINE_VERSION, m17947b = 6)

    /* renamed from: e */
    protected String f2353e = "";
    @AbstractC1018fw(m17948a = "lLocalLength", m17947b = 5)

    /* renamed from: f */
    protected long f2354f = 0;
    @AbstractC1018fw(m17948a = "lRemoteLength", m17947b = 5)

    /* renamed from: g */
    protected long f2355g = 0;
    @AbstractC1018fw(m17948a = "isProvince", m17947b = 2)

    /* renamed from: i */
    protected int f2357i = 0;
    @AbstractC1018fw(m17948a = "mCityCode", m17947b = 6)

    /* renamed from: k */
    protected String f2359k = "";
    @AbstractC1018fw(m17948a = "mPinyin", m17947b = 6)

    /* renamed from: m */
    public String f2361m = "";

    /* renamed from: e */
    public static String m18827e(String str) {
        return "mAdcode='" + str + "'";
    }

    /* renamed from: f */
    public static String m18825f(String str) {
        return "mPinyin='" + str + "'";
    }

    /* renamed from: c */
    public void m18831c(String str) {
        this.f2351c = str;
    }

    /* renamed from: d */
    public String m18830d() {
        return this.f2349a;
    }

    /* renamed from: d */
    public void m18829d(String str) {
        this.f2359k = str;
    }

    /* renamed from: e */
    public String m18828e() {
        return this.f2353e;
    }

    /* renamed from: f */
    public String m18826f() {
        return this.f2351c;
    }

    /* renamed from: g */
    public int m18824g() {
        return this.f2358j;
    }

    /* renamed from: h */
    public String m18823h() {
        return this.f2361m;
    }
}
