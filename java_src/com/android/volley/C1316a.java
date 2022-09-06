package com.android.volley;

import android.content.Intent;
/* renamed from: com.android.volley.a */
/* loaded from: classes.dex */
public class C1316a extends C1384u {

    /* renamed from: b */
    private Intent f4529b;

    public C1316a() {
    }

    public C1316a(Intent intent) {
        this.f4529b = intent;
    }

    public C1316a(C1329j c1329j) {
        super(c1329j);
    }

    public C1316a(String str) {
        super(str);
    }

    public C1316a(String str, Exception exc) {
        super(str, exc);
    }

    /* renamed from: a */
    public Intent m16749a() {
        return this.f4529b;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f4529b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
