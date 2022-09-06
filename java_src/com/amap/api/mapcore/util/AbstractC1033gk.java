package com.amap.api.mapcore.util;

import android.content.Context;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.amap.api.mapcore.util.gk */
/* loaded from: classes.dex */
abstract class AbstractC1033gk extends ClassLoader {

    /* renamed from: a */
    protected final Context f3232a;

    /* renamed from: b */
    protected final Map<String, Class<?>> f3233b = new HashMap();

    /* renamed from: c */
    protected DexFile f3234c = null;

    /* renamed from: d */
    volatile boolean f3235d = true;

    /* renamed from: e */
    protected C0996fh f3236e;

    /* renamed from: f */
    protected String f3237f;

    public AbstractC1033gk(Context context, C0996fh c0996fh, boolean z) {
        super(context.getClassLoader());
        this.f3232a = context;
        this.f3236e = c0996fh;
    }

    /* renamed from: a */
    public boolean m17899a() {
        return this.f3234c != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m17898b() {
        try {
            synchronized (this.f3233b) {
                this.f3233b.clear();
            }
            if (this.f3234c == null) {
                return;
            }
            this.f3234c.close();
        } catch (Throwable th) {
            C1045gs.m17831a(th, "BaseClassLoader", "releaseDexFile()");
        }
    }
}
