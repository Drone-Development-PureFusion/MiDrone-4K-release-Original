package com.p118d.p119a.p127b.p133e;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.p118d.p119a.p127b.p128a.C1893e;
import com.p118d.p119a.p127b.p128a.EnumC1896h;
/* renamed from: com.d.a.b.e.c */
/* loaded from: classes.dex */
public class C1928c implements AbstractC1926a {

    /* renamed from: a */
    protected final String f6854a;

    /* renamed from: b */
    protected final C1893e f6855b;

    /* renamed from: c */
    protected final EnumC1896h f6856c;

    public C1928c(C1893e c1893e, EnumC1896h enumC1896h) {
        this(null, c1893e, enumC1896h);
    }

    public C1928c(String str, C1893e c1893e, EnumC1896h enumC1896h) {
        if (c1893e == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        }
        if (enumC1896h == null) {
            throw new IllegalArgumentException("scaleType must not be null");
        }
        this.f6854a = str;
        this.f6855b = c1893e;
        this.f6856c = enumC1896h;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: a */
    public int mo13928a() {
        return this.f6855b.m14153a();
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: a */
    public boolean mo13927a(Bitmap bitmap) {
        return true;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: a */
    public boolean mo13925a(Drawable drawable) {
        return true;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: b */
    public int mo13923b() {
        return this.f6855b.m14150b();
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: c */
    public EnumC1896h mo13922c() {
        return this.f6856c;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: d */
    public View mo13921d() {
        return null;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: e */
    public boolean mo13920e() {
        return false;
    }

    @Override // com.p118d.p119a.p127b.p133e.AbstractC1926a
    /* renamed from: f */
    public int mo13919f() {
        return TextUtils.isEmpty(this.f6854a) ? super.hashCode() : this.f6854a.hashCode();
    }
}
