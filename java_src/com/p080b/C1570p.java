package com.p080b;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.HashMap;
/* renamed from: com.b.p */
/* loaded from: classes.dex */
public class C1570p implements AbstractC1566l<C1571q> {

    /* renamed from: a */
    private static final String f5592a = C1568n.f5581l;

    /* renamed from: b */
    private static final String f5593b = C1568n.f5582m;

    /* renamed from: c */
    private static final String f5594c = C1568n.f5583n;

    /* renamed from: d */
    private static final String f5595d = C1568n.f5575f;

    /* renamed from: e */
    private C1571q f5596e = null;

    /* renamed from: f */
    private int f5597f;

    public C1570p(int i) {
        this.f5597f = i;
    }

    /* renamed from: a */
    public static String m15475a(int i) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(f5593b).append("=").append(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m15473a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(f5592a, str);
        return C1565k.m15494a(hashMap);
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: a */
    public ContentValues mo15451a() {
        ContentValues contentValues = null;
        try {
            if (this.f5596e == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f5592a, this.f5596e.m15468b());
                contentValues2.put(f5593b, Integer.valueOf(this.f5596e.m15471a()));
                contentValues2.put(f5595d, C1577w.m15439a(this.f5596e.m15465c()));
                contentValues2.put(f5594c, Integer.valueOf(this.f5596e.m15464d()));
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
    public void mo15448a(C1571q c1571q) {
        this.f5596e = c1571q;
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: b */
    public C1571q mo15450a(Cursor cursor) {
        String string;
        int i;
        String string2;
        int i2;
        C1571q c1571q;
        C1571q c1571q2 = null;
        if (cursor == null) {
            return null;
        }
        try {
            string = cursor.getString(1);
            i = cursor.getInt(2);
            string2 = cursor.getString(4);
            i2 = cursor.getInt(3);
            c1571q = new C1571q();
        } catch (Throwable th) {
            th = th;
        }
        try {
            c1571q.m15469a(string);
            c1571q.m15470a(i);
            c1571q.m15466b(C1577w.m15438b(string2));
            c1571q.m15467b(i2);
            return c1571q;
        } catch (Throwable th2) {
            c1571q2 = c1571q;
            th = th2;
            th.printStackTrace();
            return c1571q2;
        }
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: b */
    public String mo15447b() {
        return C1557g.m15546a(this.f5597f);
    }
}
