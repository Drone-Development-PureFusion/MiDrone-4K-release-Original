package com.fimi.soul.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fimi.soul.entity.FlyModeLog;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.utils.v */
/* loaded from: classes.dex */
public class C3705v {

    /* renamed from: a */
    public static C3705v f15111a;

    /* renamed from: b */
    private C3679h f15112b;

    /* renamed from: c */
    private SQLiteDatabase f15113c;

    /* renamed from: d */
    private Context f15114d;

    /* renamed from: e */
    private final String f15115e = "create table  if not exists " + C3706a.f15116a + "(" + C3706a.f15117b + " varchar(20) not null ," + C3706a.f15118c + " varchar(20) not null ," + C3706a.f15119d + " varchar(20) not null ," + C3706a.f15120e + " varchar(20) not null ," + C3706a.f15121f + " varchar(20) not null ," + C3706a.f15122g + " varchar(20) not null)";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.utils.v$a */
    /* loaded from: classes.dex */
    public static class C3706a {

        /* renamed from: a */
        public static String f15116a = "fly_mode_log_tb";

        /* renamed from: b */
        public static String f15117b = "userID";

        /* renamed from: c */
        public static String f15118c = "fcVersion";

        /* renamed from: d */
        public static String f15119d = "openType";

        /* renamed from: e */
        public static String f15120e = "applyTime";

        /* renamed from: f */
        public static String f15121f = "x2Version";

        /* renamed from: g */
        public static String f15122g = "appType";

        C3706a() {
        }
    }

    public C3705v(Context context) {
        this.f15114d = context;
        this.f15112b = C3679h.m7485a(context);
        this.f15113c = this.f15112b.getWritableDatabase();
        this.f15113c.execSQL(this.f15115e);
    }

    /* renamed from: a */
    public static C3705v m7415a(Context context) {
        if (f15111a == null) {
            f15111a = new C3705v(context);
        }
        return f15111a;
    }

    /* renamed from: b */
    private ContentValues m7412b(FlyModeLog flyModeLog) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C3706a.f15117b, flyModeLog.getUserID());
        contentValues.put(C3706a.f15118c, flyModeLog.getFcVersion());
        contentValues.put(C3706a.f15119d, flyModeLog.getOpenType());
        contentValues.put(C3706a.f15120e, flyModeLog.getApplyTime());
        contentValues.put(C3706a.f15121f, flyModeLog.getX2Version());
        contentValues.put(C3706a.f15122g, flyModeLog.getAppType());
        return contentValues;
    }

    /* renamed from: a */
    public long m7414a(FlyModeLog flyModeLog) {
        return this.f15113c.insert(C3706a.f15116a, null, m7412b(flyModeLog));
    }

    /* renamed from: a */
    public List<FlyModeLog> m7416a() {
        SQLiteDatabase writableDatabase = this.f15112b.getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("select * from " + C3706a.f15116a, null);
        while (rawQuery.moveToNext()) {
            FlyModeLog flyModeLog = new FlyModeLog();
            flyModeLog.setUserID(rawQuery.getString(rawQuery.getColumnIndex(C3706a.f15117b)));
            flyModeLog.setFcVersion(rawQuery.getString(rawQuery.getColumnIndex(C3706a.f15118c)));
            flyModeLog.setOpenType(rawQuery.getString(rawQuery.getColumnIndex(C3706a.f15119d)));
            flyModeLog.setApplyTime(rawQuery.getString(rawQuery.getColumnIndex(C3706a.f15120e)));
            flyModeLog.setX2Version(rawQuery.getString(rawQuery.getColumnIndex(C3706a.f15121f)));
            flyModeLog.setAppType(rawQuery.getString(rawQuery.getColumnIndex(C3706a.f15122g)));
            arrayList.add(flyModeLog);
        }
        return arrayList;
    }

    /* renamed from: b */
    public boolean m7413b() {
        return this.f15113c.delete(C3706a.f15116a, null, null) > 0;
    }

    /* renamed from: c */
    public long m7411c() {
        this.f15113c = this.f15112b.getReadableDatabase();
        Cursor rawQuery = this.f15113c.rawQuery("select count(*)from" + C3706a.f15116a, null);
        rawQuery.moveToFirst();
        return rawQuery.getLong(0);
    }
}
