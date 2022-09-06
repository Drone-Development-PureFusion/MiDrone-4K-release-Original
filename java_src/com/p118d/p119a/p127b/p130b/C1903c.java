package com.p118d.p119a.p127b.p130b;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.p118d.p119a.p127b.C1904c;
import com.p118d.p119a.p127b.p128a.C1893e;
import com.p118d.p119a.p127b.p128a.EnumC1892d;
import com.p118d.p119a.p127b.p128a.EnumC1896h;
import com.p118d.p119a.p127b.p132d.AbstractC1919b;
/* renamed from: com.d.a.b.b.c */
/* loaded from: classes.dex */
public class C1903c {

    /* renamed from: a */
    private final String f6706a;

    /* renamed from: b */
    private final String f6707b;

    /* renamed from: c */
    private final String f6708c;

    /* renamed from: d */
    private final C1893e f6709d;

    /* renamed from: e */
    private final EnumC1892d f6710e;

    /* renamed from: f */
    private final EnumC1896h f6711f;

    /* renamed from: g */
    private final AbstractC1919b f6712g;

    /* renamed from: h */
    private final Object f6713h;

    /* renamed from: i */
    private final boolean f6714i;

    /* renamed from: j */
    private final BitmapFactory.Options f6715j = new BitmapFactory.Options();

    public C1903c(String str, String str2, String str3, C1893e c1893e, EnumC1896h enumC1896h, AbstractC1919b abstractC1919b, C1904c c1904c) {
        this.f6706a = str;
        this.f6707b = str2;
        this.f6708c = str3;
        this.f6709d = c1893e;
        this.f6710e = c1904c.m14105j();
        this.f6711f = enumC1896h;
        this.f6712g = abstractC1919b;
        this.f6713h = c1904c.m14097n();
        this.f6714i = c1904c.m14099m();
        m14138a(c1904c.m14103k(), this.f6715j);
    }

    /* renamed from: a */
    private void m14138a(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        if (Build.VERSION.SDK_INT >= 10) {
            m14136b(options, options2);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            m14134c(options, options2);
        }
    }

    @TargetApi(10)
    /* renamed from: b */
    private void m14136b(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    /* renamed from: c */
    private void m14134c(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    /* renamed from: a */
    public String m14139a() {
        return this.f6706a;
    }

    /* renamed from: b */
    public String m14137b() {
        return this.f6707b;
    }

    /* renamed from: c */
    public String m14135c() {
        return this.f6708c;
    }

    /* renamed from: d */
    public C1893e m14133d() {
        return this.f6709d;
    }

    /* renamed from: e */
    public EnumC1892d m14132e() {
        return this.f6710e;
    }

    /* renamed from: f */
    public EnumC1896h m14131f() {
        return this.f6711f;
    }

    /* renamed from: g */
    public AbstractC1919b m14130g() {
        return this.f6712g;
    }

    /* renamed from: h */
    public Object m14129h() {
        return this.f6713h;
    }

    /* renamed from: i */
    public boolean m14128i() {
        return this.f6714i;
    }

    /* renamed from: j */
    public BitmapFactory.Options m14127j() {
        return this.f6715j;
    }
}
