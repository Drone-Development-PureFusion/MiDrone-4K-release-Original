package com.fimi.soul.drone.p193d.p194a;

import android.content.Context;
import android.util.Log;
/* renamed from: com.fimi.soul.drone.d.a.e */
/* loaded from: classes.dex */
public class C2772e {

    /* renamed from: a */
    public int f10269a;

    /* renamed from: b */
    public int f10270b;

    /* renamed from: c */
    public int f10271c;

    /* renamed from: d */
    String f10272d;

    /* renamed from: e */
    private int f10273e;

    /* renamed from: f */
    private Context f10274f;

    /* renamed from: c */
    private void m11036c() {
        this.f10273e = (this.f10273e + 1) & 255;
    }

    /* renamed from: a */
    public void m11040a() {
        this.f10270b++;
    }

    /* renamed from: a */
    public void m11039a(Context context) {
        Log.e("fdfdfdfd", this.f10269a + "//////" + this.f10270b);
    }

    /* renamed from: a */
    public void m11038a(C2770c c2770c) {
        this.f10269a++;
    }

    /* renamed from: b */
    public void m11037b() {
        this.f10273e = -1;
        this.f10271c = 0;
        this.f10270b = 0;
        this.f10269a = 0;
    }
}
