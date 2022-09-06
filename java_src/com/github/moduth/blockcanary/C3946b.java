package com.github.moduth.blockcanary;

import android.content.Context;
import java.io.File;
/* renamed from: com.github.moduth.blockcanary.b */
/* loaded from: classes.dex */
public class C3946b implements AbstractC3963h {

    /* renamed from: a */
    private static Context f16885a;

    /* renamed from: b */
    private static C3946b f16886b = null;

    /* renamed from: a */
    public static void m6407a(Context context, C3946b c3946b) {
        f16885a = context;
        f16886b = c3946b;
    }

    /* renamed from: d */
    public static C3946b m6406d() {
        if (f16886b == null) {
            throw new RuntimeException("BlockCanaryContext not init");
        }
        return f16886b;
    }

    @Override // com.github.moduth.blockcanary.AbstractC3963h
    /* renamed from: a */
    public int mo6370a() {
        return 1000;
    }

    @Override // com.github.moduth.blockcanary.AbstractC3963h
    /* renamed from: a */
    public void mo6369a(File file) {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.moduth.blockcanary.AbstractC3963h
    /* renamed from: a */
    public boolean mo6368a(File[] fileArr, File file) {
        return false;
    }

    @Override // com.github.moduth.blockcanary.AbstractC3963h
    /* renamed from: b */
    public boolean mo6367b() {
        return true;
    }

    @Override // com.github.moduth.blockcanary.AbstractC3963h
    /* renamed from: c */
    public String mo6366c() {
        return "/blockcanary/performance";
    }

    @Override // com.github.moduth.blockcanary.AbstractC3963h
    /* renamed from: e */
    public Context mo6365e() {
        return f16885a;
    }

    @Override // com.github.moduth.blockcanary.AbstractC3963h
    /* renamed from: f */
    public String mo6364f() {
        return "Unspecified";
    }

    @Override // com.github.moduth.blockcanary.AbstractC3963h
    /* renamed from: g */
    public String mo6363g() {
        return "0";
    }

    @Override // com.github.moduth.blockcanary.AbstractC3963h
    /* renamed from: h */
    public String mo6362h() {
        return "UNKNOWN";
    }

    /* renamed from: i */
    public int m6405i() {
        return 99999;
    }

    @Override // com.github.moduth.blockcanary.AbstractC3963h
    /* renamed from: j */
    public String mo6361j() {
        return null;
    }

    @Override // com.github.moduth.blockcanary.AbstractC3963h
    /* renamed from: k */
    public int mo6360k() {
        return mo6370a();
    }
}
