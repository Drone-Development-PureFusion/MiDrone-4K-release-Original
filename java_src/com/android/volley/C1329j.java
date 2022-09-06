package com.android.volley;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
/* renamed from: com.android.volley.j */
/* loaded from: classes.dex */
public class C1329j implements Serializable {
    private static final long serialVersionUID = -20150728102000L;

    /* renamed from: a */
    public final int f4565a;

    /* renamed from: b */
    public final byte[] f4566b;

    /* renamed from: c */
    public final Map<String, String> f4567c;

    /* renamed from: d */
    public final boolean f4568d;

    /* renamed from: e */
    public final long f4569e;

    public C1329j(int i, byte[] bArr, Map<String, String> map, boolean z) {
        this(i, bArr, map, z, 0L);
    }

    public C1329j(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.f4565a = i;
        this.f4566b = bArr;
        this.f4567c = map;
        this.f4568d = z;
        this.f4569e = j;
    }

    public C1329j(byte[] bArr) {
        this(200, bArr, Collections.emptyMap(), false, 0L);
    }

    public C1329j(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }
}
