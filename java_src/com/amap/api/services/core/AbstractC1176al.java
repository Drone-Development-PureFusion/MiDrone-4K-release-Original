package com.amap.api.services.core;

import android.content.ContentValues;
import android.database.Cursor;
/* renamed from: com.amap.api.services.core.al */
/* loaded from: classes.dex */
public abstract class AbstractC1176al implements AbstractC1180ap<C1177am> {

    /* renamed from: a */
    private static final String f4015a = C1172ah.f4003l;

    /* renamed from: b */
    private static final String f4016b = C1172ah.f4004m;

    /* renamed from: c */
    private static final String f4017c = C1172ah.f4005n;

    /* renamed from: d */
    private static final String f4018d = C1172ah.f3997f;

    /* renamed from: e */
    private C1177am f4019e = null;

    /* renamed from: a */
    public static String m17225a(int i) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(f4016b).append("=").append(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m17222a(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(f4015a).append("='").append(str).append("'");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1180ap
    /* renamed from: a */
    public C1177am mo17196b(Cursor cursor) {
        String string;
        int i;
        String string2;
        int i2;
        C1177am c1177am;
        C1177am c1177am2 = null;
        if (cursor == null) {
            return null;
        }
        try {
            string = cursor.getString(1);
            i = cursor.getInt(2);
            string2 = cursor.getString(4);
            i2 = cursor.getInt(3);
            c1177am = new C1177am();
        } catch (Throwable th) {
            th = th;
        }
        try {
            c1177am.m17219a(string);
            c1177am.m17220a(i);
            c1177am.m17216b(C1184at.m17188b(string2));
            c1177am.m17217b(i2);
            return c1177am;
        } catch (Throwable th2) {
            c1177am2 = c1177am;
            th = th2;
            th.printStackTrace();
            return c1177am2;
        }
    }

    @Override // com.amap.api.services.core.AbstractC1180ap
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo17198a(C1177am c1177am) {
        this.f4019e = c1177am;
    }

    @Override // com.amap.api.services.core.AbstractC1180ap
    /* renamed from: b */
    public ContentValues mo17197b() {
        ContentValues contentValues = null;
        try {
            if (this.f4019e == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f4015a, this.f4019e.m17218b());
                contentValues2.put(f4016b, Integer.valueOf(this.f4019e.m17221a()));
                contentValues2.put(f4018d, C1184at.m17189a(this.f4019e.m17215c()));
                contentValues2.put(f4017c, Integer.valueOf(this.f4019e.m17214d()));
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
