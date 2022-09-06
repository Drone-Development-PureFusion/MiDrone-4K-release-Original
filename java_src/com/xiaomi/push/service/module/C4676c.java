package com.xiaomi.push.service.module;

import android.content.Context;
import android.text.TextUtils;
/* renamed from: com.xiaomi.push.service.module.c */
/* loaded from: classes2.dex */
public class C4676c {

    /* renamed from: a */
    private String f19138a;

    /* renamed from: b */
    private String f19139b;

    /* renamed from: c */
    private String f19140c;

    /* renamed from: d */
    private int f19141d;

    /* renamed from: e */
    private ClassLoader f19142e;

    /* renamed from: f */
    private Object f19143f;

    public C4676c(String str, String str2, ClassLoader classLoader, String str3, int i) {
        this.f19141d = 0;
        this.f19138a = str;
        this.f19139b = str2;
        this.f19142e = classLoader;
        this.f19141d = i;
        this.f19140c = str3;
        try {
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            this.f19143f = this.f19142e.loadClass(str3).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public ClassLoader m4155a() {
        return this.f19142e;
    }

    /* renamed from: a */
    public void m4154a(Context context) {
        if (this.f19143f != null) {
            try {
                this.f19142e.loadClass(this.f19140c).getMethod("onCreate", Context.class, String.class).invoke(this.f19143f, context, this.f19139b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
