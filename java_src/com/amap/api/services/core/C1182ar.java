package com.amap.api.services.core;

import android.content.ContentValues;
import android.database.Cursor;
/* renamed from: com.amap.api.services.core.ar */
/* loaded from: classes.dex */
public class C1182ar implements AbstractC1180ap<C1183as> {

    /* renamed from: b */
    private static final String f4035b = C1172ah.f4006o;

    /* renamed from: c */
    private static final String f4036c = C1172ah.f4007p;

    /* renamed from: d */
    private static final String f4037d = C1172ah.f4008q;

    /* renamed from: a */
    private C1183as f4038a = null;

    @Override // com.amap.api.services.core.AbstractC1180ap
    /* renamed from: a */
    public C1183as mo17196b(Cursor cursor) {
        C1183as c1183as;
        Throwable th;
        boolean z;
        boolean z2;
        boolean z3 = true;
        try {
            int i = cursor.getInt(1);
            int i2 = cursor.getInt(2);
            int i3 = cursor.getInt(3);
            z = i != 0;
            z2 = i2 != 0;
            if (i3 == 0) {
                z3 = false;
            }
            c1183as = new C1183as();
        } catch (Throwable th2) {
            c1183as = null;
            th = th2;
        }
        try {
            c1183as.m17194a(z);
            c1183as.m17190c(z3);
            c1183as.m17192b(z2);
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            return c1183as;
        }
        return c1183as;
    }

    @Override // com.amap.api.services.core.AbstractC1180ap
    /* renamed from: a */
    public String mo17201a() {
        return C1172ah.f3996e;
    }

    @Override // com.amap.api.services.core.AbstractC1180ap
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo17198a(C1183as c1183as) {
        this.f4038a = c1183as;
    }

    @Override // com.amap.api.services.core.AbstractC1180ap
    /* renamed from: b */
    public ContentValues mo17197b() {
        ContentValues contentValues = null;
        try {
            if (this.f4038a == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f4035b, Boolean.valueOf(this.f4038a.m17195a()));
                contentValues2.put(f4036c, Boolean.valueOf(this.f4038a.m17193b()));
                contentValues2.put(f4037d, Boolean.valueOf(this.f4038a.m17191c()));
                return contentValues2;
            } catch (Throwable th) {
                contentValues = contentValues2;
                th = th;
                th.printStackTrace();
                return contentValues;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
