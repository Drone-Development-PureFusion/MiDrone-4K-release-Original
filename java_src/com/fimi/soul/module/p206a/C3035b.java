package com.fimi.soul.module.p206a;

import android.content.Context;
import android.content.res.Resources;
import com.fimi.soul.C2300R;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.module.a.b */
/* loaded from: classes.dex */
public class C3035b {

    /* renamed from: a */
    private List<C3046d> f11306a = new ArrayList();

    /* renamed from: b */
    private Context f11307b;

    /* renamed from: c */
    private String[] f11308c;

    /* renamed from: d */
    private Resources f11309d;

    /* renamed from: e */
    private String[] f11310e;

    /* renamed from: com.fimi.soul.module.a.b$a */
    /* loaded from: classes.dex */
    public enum EnumC3036a {
        AE,
        ME
    }

    public C3035b(Context context) {
        this.f11307b = context;
        this.f11309d = context.getResources();
        m9905a();
    }

    /* renamed from: a */
    public List<C3046d> m9904a(EnumC3036a enumC3036a, boolean z) {
        this.f11306a.clear();
        for (int i = 0; i < this.f11308c.length; i++) {
            C3046d c3046d = new C3046d();
            c3046d.m9869a(this.f11308c[i]);
            if (!z) {
                c3046d.m9868a(true);
            } else if (i != 0) {
                c3046d.m9868a(true);
            }
            c3046d.m9866b(this.f11310e[i]);
            this.f11306a.add(c3046d);
        }
        return this.f11306a;
    }

    /* renamed from: a */
    public void m9905a() {
        this.f11308c = this.f11309d.getStringArray(C2300R.array.camera_menu);
    }

    /* renamed from: a */
    public void m9903a(String[] strArr) {
        this.f11310e = strArr;
    }
}
