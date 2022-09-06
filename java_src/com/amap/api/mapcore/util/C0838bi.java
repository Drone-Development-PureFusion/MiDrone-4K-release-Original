package com.amap.api.mapcore.util;
@AbstractC1017fv(m17950a = "update_item_download_info")
/* renamed from: com.amap.api.mapcore.util.bi */
/* loaded from: classes.dex */
class C0838bi {
    @AbstractC1018fw(m17948a = "mAdcode", m17947b = 6)

    /* renamed from: a */
    private String f2342a;
    @AbstractC1018fw(m17948a = "fileLength", m17947b = 5)

    /* renamed from: b */
    private long f2343b;
    @AbstractC1018fw(m17948a = "splitter", m17947b = 2)

    /* renamed from: c */
    private int f2344c;
    @AbstractC1018fw(m17948a = "startPos", m17947b = 5)

    /* renamed from: d */
    private long f2345d;
    @AbstractC1018fw(m17948a = "endPos", m17947b = 5)

    /* renamed from: e */
    private long f2346e;

    public C0838bi() {
        this.f2342a = "";
        this.f2343b = 0L;
        this.f2344c = 0;
        this.f2345d = 0L;
        this.f2346e = 0L;
    }

    public C0838bi(String str, long j, int i, long j2, long j3) {
        this.f2342a = "";
        this.f2343b = 0L;
        this.f2344c = 0;
        this.f2345d = 0L;
        this.f2346e = 0L;
        this.f2342a = str;
        this.f2343b = j;
        this.f2344c = i;
        this.f2345d = j2;
        this.f2346e = j3;
    }

    /* renamed from: a */
    public static String m18834a(String str) {
        return "mAdcode='" + str + "'";
    }
}
