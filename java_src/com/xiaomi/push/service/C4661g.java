package com.xiaomi.push.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.tauth.AuthActivity;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4493k;
import com.xiaomi.push.service.module.C4675b;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.xiaomi.push.service.g */
/* loaded from: classes2.dex */
public class C4661g {

    /* renamed from: a */
    private static volatile C4661g f19092a;

    /* renamed from: b */
    private C4660f f19093b;

    private C4661g(Context context) {
        this.f19093b = new C4660f(context);
    }

    /* renamed from: a */
    private synchronized Cursor m4256a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        synchronized (this) {
            C4493k.m5004a(false);
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT * FROM geoMessage", null);
            } catch (Exception e) {
                AbstractC4478b.m5036d(e.toString());
            }
        }
        return cursor;
    }

    /* renamed from: a */
    public static C4661g m4257a(Context context) {
        if (f19092a == null) {
            synchronized (C4661g.class) {
                if (f19092a == null) {
                    f19092a = new C4661g(context);
                }
            }
        }
        return f19092a;
    }

    /* renamed from: a */
    public synchronized int m4255a(String str) {
        int i = 0;
        synchronized (this) {
            C4493k.m5004a(false);
            if (!TextUtils.isEmpty(str)) {
                try {
                    SQLiteDatabase writableDatabase = this.f19093b.getWritableDatabase();
                    int delete = writableDatabase.delete("geoMessage", "message_id = ?", new String[]{str});
                    writableDatabase.close();
                    i = delete;
                } catch (Exception e) {
                    AbstractC4478b.m5036d(e.toString());
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    public synchronized ArrayList<C4675b> m4258a() {
        ArrayList<C4675b> arrayList;
        C4493k.m5004a(false);
        try {
            SQLiteDatabase writableDatabase = this.f19093b.getWritableDatabase();
            Cursor m4256a = m4256a(writableDatabase);
            arrayList = new ArrayList<>();
            if (m4256a != null) {
                while (m4256a.moveToNext()) {
                    C4675b c4675b = new C4675b();
                    c4675b.m4162a(m4256a.getString(m4256a.getColumnIndex("message_id")));
                    c4675b.m4159b(m4256a.getString(m4256a.getColumnIndex("geo_id")));
                    c4675b.m4161a(m4256a.getBlob(m4256a.getColumnIndex("content")));
                    c4675b.m4164a(m4256a.getInt(m4256a.getColumnIndex(AuthActivity.ACTION_KEY)));
                    c4675b.m4163a(m4256a.getLong(m4256a.getColumnIndex("deadline")));
                    arrayList.add(c4675b);
                }
                m4256a.close();
            }
            writableDatabase.close();
        } catch (Exception e) {
            AbstractC4478b.m5036d(e.toString());
            arrayList = null;
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized boolean m4254a(ArrayList<ContentValues> arrayList) {
        boolean z;
        C4493k.m5004a(false);
        if (arrayList == null || arrayList.size() <= 0) {
            z = false;
        } else {
            try {
                SQLiteDatabase writableDatabase = this.f19093b.getWritableDatabase();
                writableDatabase.beginTransaction();
                Iterator<ContentValues> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    } else if (-1 == writableDatabase.insert("geoMessage", null, it2.next())) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    writableDatabase.setTransactionSuccessful();
                }
                writableDatabase.endTransaction();
                writableDatabase.close();
            } catch (Exception e) {
                AbstractC4478b.m5036d(e.toString());
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public synchronized int m4253b(String str) {
        int i = 0;
        synchronized (this) {
            C4493k.m5004a(false);
            if (!TextUtils.isEmpty(str)) {
                try {
                    SQLiteDatabase writableDatabase = this.f19093b.getWritableDatabase();
                    int delete = writableDatabase.delete("geoMessage", "geo_id = ?", new String[]{str});
                    writableDatabase.close();
                    i = delete;
                } catch (Exception e) {
                    AbstractC4478b.m5036d(e.toString());
                }
            }
        }
        return i;
    }

    /* renamed from: c */
    public synchronized ArrayList<C4675b> m4252c(String str) {
        ArrayList<C4675b> arrayList;
        C4493k.m5004a(false);
        if (TextUtils.isEmpty(str)) {
            arrayList = null;
        } else {
            try {
                ArrayList<C4675b> m4258a = m4258a();
                ArrayList<C4675b> arrayList2 = new ArrayList<>();
                Iterator<C4675b> it2 = m4258a.iterator();
                while (it2.hasNext()) {
                    C4675b next = it2.next();
                    if (TextUtils.equals(next.m4158c(), str)) {
                        arrayList2.add(next);
                    }
                }
                arrayList = arrayList2;
            } catch (Exception e) {
                AbstractC4478b.m5036d(e.toString());
                arrayList = null;
            }
        }
        return arrayList;
    }
}
