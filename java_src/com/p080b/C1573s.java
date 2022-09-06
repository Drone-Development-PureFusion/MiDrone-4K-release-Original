package com.p080b;

import android.content.ContentValues;
import android.database.Cursor;
import com.p080b.C1549dv;
import java.util.HashMap;
/* renamed from: com.b.s */
/* loaded from: classes.dex */
public class C1573s implements AbstractC1566l<C1549dv> {

    /* renamed from: a */
    private static String f5604a = C1568n.f5575f;

    /* renamed from: b */
    private static String f5605b = C1568n.f5576g;

    /* renamed from: c */
    private static String f5606c = C1568n.f5580k;

    /* renamed from: d */
    private static String f5607d = C1568n.f5577h;

    /* renamed from: e */
    private static String f5608e = C1568n.f5578i;

    /* renamed from: f */
    private static String f5609f = C1568n.f5579j;

    /* renamed from: g */
    private C1549dv f5610g = null;

    /* renamed from: a */
    public static String m15459a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(f5604a, C1577w.m15439a(str));
        return C1565k.m15494a(hashMap);
    }

    /* renamed from: a */
    private String m15458a(String[] strArr) {
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
    private String[] m15456b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static String m15455c() {
        return f5606c + "=1";
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: a */
    public ContentValues mo15451a() {
        ContentValues contentValues = null;
        try {
            if (this.f5610g == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f5604a, C1577w.m15439a(this.f5610g.m15580a()));
                contentValues2.put(f5605b, C1577w.m15439a(this.f5610g.m15578b()));
                contentValues2.put(f5606c, Boolean.valueOf(this.f5610g.m15575e()));
                contentValues2.put(f5607d, C1577w.m15439a(this.f5610g.m15577c()));
                contentValues2.put(f5609f, C1577w.m15439a(this.f5610g.m15576d()));
                contentValues2.put(f5608e, C1577w.m15439a(m15458a(this.f5610g.m15574f())));
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
    public void mo15448a(C1549dv c1549dv) {
        this.f5610g = c1549dv;
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: b */
    public C1549dv mo15450a(Cursor cursor) {
        boolean z = true;
        try {
            String m15438b = C1577w.m15438b(cursor.getString(1));
            String m15438b2 = C1577w.m15438b(cursor.getString(2));
            String m15438b3 = C1577w.m15438b(cursor.getString(3));
            String[] m15456b = m15456b(C1577w.m15438b(cursor.getString(4)));
            String m15438b4 = C1577w.m15438b(cursor.getString(5));
            if (cursor.getInt(6) == 0) {
                z = false;
            }
            return new C1549dv.C1550a(m15438b, m15438b2, m15438b3).m15570a(z).m15571a(m15438b4).m15569a(m15456b).m15573a();
        } catch (C1532dl e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: b */
    public String mo15447b() {
        return C1568n.f5570a;
    }
}
