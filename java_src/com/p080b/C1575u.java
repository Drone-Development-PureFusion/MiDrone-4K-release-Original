package com.p080b;

import android.content.ContentValues;
import android.database.Cursor;
/* renamed from: com.b.u */
/* loaded from: classes.dex */
public class C1575u implements AbstractC1566l<C1576v> {

    /* renamed from: b */
    private static final String f5613b = C1568n.f5584o;

    /* renamed from: c */
    private static final String f5614c = C1568n.f5585p;

    /* renamed from: d */
    private static final String f5615d = C1568n.f5586q;

    /* renamed from: a */
    private C1576v f5616a = null;

    @Override // com.p080b.AbstractC1566l
    /* renamed from: a */
    public ContentValues mo15451a() {
        ContentValues contentValues = null;
        try {
            if (this.f5616a == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f5613b, Boolean.valueOf(this.f5616a.m15445a()));
                contentValues2.put(f5614c, Boolean.valueOf(this.f5616a.m15443b()));
                contentValues2.put(f5615d, Boolean.valueOf(this.f5616a.m15441c()));
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

    @Override // com.p080b.AbstractC1566l
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo15448a(C1576v c1576v) {
        this.f5616a = c1576v;
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: b */
    public C1576v mo15450a(Cursor cursor) {
        C1576v c1576v;
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
            c1576v = new C1576v();
        } catch (Throwable th2) {
            c1576v = null;
            th = th2;
        }
        try {
            c1576v.m15444a(z);
            c1576v.m15440c(z3);
            c1576v.m15442b(z2);
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            return c1576v;
        }
        return c1576v;
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: b */
    public String mo15447b() {
        return C1568n.f5574e;
    }
}
