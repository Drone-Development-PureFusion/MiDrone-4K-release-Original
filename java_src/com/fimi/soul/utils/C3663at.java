package com.fimi.soul.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.toolbox.C1366k;
@TargetApi(12)
/* renamed from: com.fimi.soul.utils.at */
/* loaded from: classes.dex */
public class C3663at implements C1366k.AbstractC1372b {

    /* renamed from: a */
    private static LruCache<String, Bitmap> f14856a;

    /* renamed from: b */
    private static C3663at f14857b;

    public C3663at() {
        f14856a = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.fimi.soul.utils.at.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a */
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }

    /* renamed from: a */
    public static C3663at m7561a() {
        if (f14857b == null) {
            f14857b = new C3663at();
        }
        return f14857b;
    }

    @Override // com.android.volley.toolbox.C1366k.AbstractC1372b
    /* renamed from: a */
    public Bitmap mo7560a(String str) {
        return f14856a.get(str);
    }

    /* renamed from: a */
    public void m7559a(String str, int i, int i2) {
        f14856a.remove(m7556b(str, i, i2));
    }

    @Override // com.android.volley.toolbox.C1366k.AbstractC1372b
    /* renamed from: a */
    public void mo7558a(String str, Bitmap bitmap) {
        f14856a.put(str, bitmap);
    }

    /* renamed from: b */
    public String m7556b(String str, int i, int i2) {
        return new StringBuilder(str.length() + 12).append("#W").append(i).append("#H").append(i2).append(str).toString();
    }

    /* renamed from: b */
    public void m7557b() {
        f14856a.evictAll();
    }
}
