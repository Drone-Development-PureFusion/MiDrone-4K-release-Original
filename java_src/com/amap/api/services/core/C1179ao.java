package com.amap.api.services.core;

import android.content.ContentValues;
import android.database.Cursor;
import com.amap.api.services.core.C1166ad;
/* renamed from: com.amap.api.services.core.ao */
/* loaded from: classes.dex */
public class C1179ao implements AbstractC1180ap<C1166ad> {

    /* renamed from: a */
    private static String f4026a = C1172ah.f3997f;

    /* renamed from: b */
    private static String f4027b = C1172ah.f3998g;

    /* renamed from: c */
    private static String f4028c = C1172ah.f4002k;

    /* renamed from: d */
    private static String f4029d = C1172ah.f3999h;

    /* renamed from: e */
    private static String f4030e = C1172ah.f4000i;

    /* renamed from: f */
    private static String f4031f = C1172ah.f4001j;

    /* renamed from: g */
    private C1166ad f4032g = null;

    /* renamed from: a */
    public static String m17208a(String str) {
        return f4026a + "='" + C1184at.m17189a(str) + "'";
    }

    /* renamed from: a */
    private String m17207a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str).append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private String[] m17206b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static String m17205c() {
        return f4028c + "=1";
    }

    @Override // com.amap.api.services.core.AbstractC1180ap
    /* renamed from: a */
    public C1166ad mo17196b(Cursor cursor) {
        boolean z = true;
        try {
            String m17188b = C1184at.m17188b(cursor.getString(1));
            String m17188b2 = C1184at.m17188b(cursor.getString(2));
            String m17188b3 = C1184at.m17188b(cursor.getString(3));
            String[] m17206b = m17206b(C1184at.m17188b(cursor.getString(4)));
            String m17188b4 = C1184at.m17188b(cursor.getString(5));
            if (cursor.getInt(6) == 0) {
                z = false;
            }
            return new C1166ad.C1168a(m17188b, m17188b2, m17188b3).m17255a(z).m17256a(m17188b4).m17254a(m17206b).m17258a();
        } catch (C1258v e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.services.core.AbstractC1180ap
    /* renamed from: a */
    public String mo17201a() {
        return C1172ah.f3992a;
    }

    @Override // com.amap.api.services.core.AbstractC1180ap
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo17198a(C1166ad c1166ad) {
        this.f4032g = c1166ad;
    }

    @Override // com.amap.api.services.core.AbstractC1180ap
    /* renamed from: b */
    public ContentValues mo17197b() {
        ContentValues contentValues = null;
        try {
            if (this.f4032g == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f4026a, C1184at.m17189a(this.f4032g.m17264a()));
                contentValues2.put(f4027b, C1184at.m17189a(this.f4032g.m17263b()));
                contentValues2.put(f4028c, Boolean.valueOf(this.f4032g.m17260e()));
                contentValues2.put(f4029d, C1184at.m17189a(this.f4032g.m17262c()));
                contentValues2.put(f4031f, C1184at.m17189a(this.f4032g.m17261d()));
                contentValues2.put(f4030e, C1184at.m17189a(m17207a(this.f4032g.m17259f())));
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
