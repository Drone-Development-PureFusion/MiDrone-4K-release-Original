package com.mob.commons.logcollector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.mob.tools.MobLog;
/* renamed from: com.mob.commons.logcollector.b */
/* loaded from: classes.dex */
public class C4153b {

    /* renamed from: c */
    private static C4153b f17322c = null;

    /* renamed from: a */
    private Context f17323a;

    /* renamed from: b */
    private C4152a f17324b;

    private C4153b(Context context) {
        this.f17323a = context.getApplicationContext();
        this.f17324b = new C4152a(this.f17323a);
    }

    /* renamed from: a */
    public static synchronized C4153b m6009a(Context context) {
        C4153b c4153b;
        synchronized (C4153b.class) {
            if (f17322c == null) {
                f17322c = new C4153b(context);
            }
            c4153b = f17322c;
        }
        return c4153b;
    }

    /* renamed from: a */
    public int m6008a(String str) {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = this.f17324b.getWritableDatabase().rawQuery("select count(*) from " + str, null);
            if (cursor.moveToNext()) {
                i = cursor.getInt(0);
            }
        } catch (Exception e) {
            MobLog.getInstance().m5959w(e);
        } finally {
            cursor.close();
        }
        return i;
    }

    /* renamed from: a */
    public int m6006a(String str, String str2, String[] strArr) {
        Exception e;
        int i;
        try {
            i = this.f17324b.getWritableDatabase().delete(str, str2, strArr);
            try {
                MobLog.getInstance().m5972d("Deleted %d rows from table: %s", Integer.valueOf(i), str);
            } catch (Exception e2) {
                e = e2;
                MobLog.getInstance().m5958w(e, "when delete database occur error table:%s,", str);
                return i;
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
        }
        return i;
    }

    /* renamed from: a */
    public long m6007a(String str, ContentValues contentValues) {
        try {
            return this.f17324b.getWritableDatabase().replace(str, null, contentValues);
        } catch (Exception e) {
            MobLog.getInstance().m5958w(e, "when insert database occur error table:%s,", str);
            return -1L;
        }
    }

    /* renamed from: a */
    public Cursor m6005a(String str, String[] strArr) {
        try {
            return this.f17324b.getWritableDatabase().rawQuery(str, strArr);
        } catch (Exception e) {
            MobLog.getInstance().m5959w(e);
            return null;
        }
    }
}
