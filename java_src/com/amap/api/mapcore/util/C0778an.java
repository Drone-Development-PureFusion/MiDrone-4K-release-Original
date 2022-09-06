package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.C0776am;
/* renamed from: com.amap.api.mapcore.util.an */
/* loaded from: classes.dex */
public class C0778an extends C0776am {

    /* renamed from: com.amap.api.mapcore.util.an$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0779a implements C0776am.AbstractC0777a {
        @Override // com.amap.api.mapcore.util.C0776am.AbstractC0777a
        /* renamed from: a */
        public boolean mo19055a(C0776am c0776am) {
            return mo17728a((C0778an) c0776am);
        }

        /* renamed from: a */
        public abstract boolean mo17728a(C0778an c0778an);

        @Override // com.amap.api.mapcore.util.C0776am.AbstractC0777a
        /* renamed from: b */
        public boolean mo19054b(C0776am c0776am) {
            return mo17727b((C0778an) c0776am);
        }

        /* renamed from: b */
        public abstract boolean mo17727b(C0778an c0778an);

        @Override // com.amap.api.mapcore.util.C0776am.AbstractC0777a
        /* renamed from: c */
        public void mo19053c(C0776am c0776am) {
            mo17726c((C0778an) c0776am);
        }

        /* renamed from: c */
        public abstract void mo17726c(C0778an c0778an);
    }

    public C0778an(Context context, AbstractC0779a abstractC0779a) {
        super(context, abstractC0779a);
    }

    /* renamed from: j */
    public float m19056j() {
        return (float) (((Math.atan2(h(), g()) - Math.atan2(e(), d())) * 180.0d) / 3.141592653589793d);
    }
}
