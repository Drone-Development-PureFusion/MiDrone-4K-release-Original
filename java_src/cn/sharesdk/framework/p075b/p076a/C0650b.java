package cn.sharesdk.framework.p075b.p076a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.sharesdk.framework.utils.C0683d;
/* renamed from: cn.sharesdk.framework.b.a.b */
/* loaded from: classes.dex */
public class C0650b {

    /* renamed from: c */
    private static C0650b f1485c = null;

    /* renamed from: a */
    private Context f1486a;

    /* renamed from: b */
    private C0649a f1487b;

    private C0650b(Context context) {
        this.f1486a = context.getApplicationContext();
        this.f1487b = new C0649a(this.f1486a);
    }

    /* renamed from: a */
    public static synchronized C0650b m19688a(Context context) {
        C0650b c0650b;
        synchronized (C0650b.class) {
            if (f1485c == null) {
                f1485c = new C0650b(context);
            }
            c0650b = f1485c;
        }
        return c0650b;
    }

    /* renamed from: a */
    public int m19687a(String str) {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = this.f1487b.getWritableDatabase().rawQuery("select count(*) from " + str, null);
            if (cursor.moveToNext()) {
                i = cursor.getInt(0);
            }
        } catch (Exception e) {
            C0683d.m19513a().m5959w(e);
        } finally {
            cursor.close();
        }
        return i;
    }

    /* renamed from: a */
    public int m19685a(String str, String str2, String[] strArr) {
        Exception e;
        int i;
        try {
            i = this.f1487b.getWritableDatabase().delete(str, str2, strArr);
            try {
                C0683d.m19513a().m5972d("Deleted %d rows from table: %s", Integer.valueOf(i), str);
            } catch (Exception e2) {
                e = e2;
                C0683d.m19513a().m5958w(e, "when delete database occur error table:%s,", str);
                return i;
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
        }
        return i;
    }

    /* renamed from: a */
    public long m19686a(String str, ContentValues contentValues) {
        try {
            return this.f1487b.getWritableDatabase().replace(str, null, contentValues);
        } catch (Exception e) {
            C0683d.m19513a().m5958w(e, "when insert database occur error table:%s,", str);
            return -1L;
        }
    }

    /* renamed from: a */
    public Cursor m19684a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        SQLiteDatabase writableDatabase = this.f1487b.getWritableDatabase();
        C0683d.m19513a().m5972d("Query table: %s", str);
        try {
            return writableDatabase.query(str, strArr, str2, strArr2, null, null, str3);
        } catch (Exception e) {
            C0683d.m19513a().m5958w(e, "when query database occur error table:%s,", str);
            return null;
        }
    }
}
