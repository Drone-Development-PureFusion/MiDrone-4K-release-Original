package com.fimi.soul.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fimi.soul.entity.DynamicDYZ_Entity;
import com.tencent.open.GameAppOperation;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.utils.m */
/* loaded from: classes.dex */
public class C3684m {

    /* renamed from: a */
    public static C3684m f14936a;

    /* renamed from: b */
    public static final String f14937b = "create table  if not exists " + C3685a.f14941a + "(" + C3685a.f14944d + "  integer PRIMARY KEY autoincrement," + C3685a.f14943c + " double default 0 ," + C3685a.f14942b + " double default 0," + C3685a.f14945e + " integer ," + C3685a.f14946f + " text," + C3685a.f14947g + " text," + C3685a.f14948h + " integer ," + C3685a.f14949i + " long," + C3685a.f14950j + " long," + C3685a.f14951k + " long," + C3685a.f14952l + " integer," + C3685a.f14953m + " text," + C3685a.f14954n + " integer default 0 ," + C3685a.f14955o + " double default 0 ," + C3685a.f14956p + " double default 0 ," + C3685a.f14957q + " double default 0 , " + C3685a.f14958r + " double default 0 ," + C3685a.f14959s + " double default 0 ," + C3685a.f14960t + " double default 0 ," + C3685a.f14961u + " varchar(200)," + C3685a.f14962v + " varcher(10))";

    /* renamed from: c */
    private C3679h f14938c;

    /* renamed from: d */
    private SQLiteDatabase f14939d;

    /* renamed from: e */
    private Context f14940e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.utils.m$a */
    /* loaded from: classes.dex */
    public static class C3685a {

        /* renamed from: a */
        public static String f14941a = "dynData_tb";

        /* renamed from: b */
        public static String f14942b = "logitude";

        /* renamed from: c */
        public static String f14943c = "latitude";

        /* renamed from: d */
        public static String f14944d = "id";

        /* renamed from: e */
        public static String f14945e = "radius";

        /* renamed from: f */
        public static String f14946f = "encryptKey";

        /* renamed from: g */
        public static String f14947g = "encryptValue";

        /* renamed from: h */
        public static String f14948h = "type";

        /* renamed from: i */
        public static String f14949i = "startDate";

        /* renamed from: j */
        public static String f14950j = "endDate";

        /* renamed from: k */
        public static String f14951k = "insertDate";

        /* renamed from: l */
        public static String f14952l = "status";

        /* renamed from: m */
        public static String f14953m = "remarks";

        /* renamed from: n */
        public static String f14954n = "deviceType";

        /* renamed from: o */
        public static String f14955o = "warinRadius";

        /* renamed from: p */
        public static String f14956p = "limitRadius";

        /* renamed from: q */
        public static String f14957q = "limitHeight";

        /* renamed from: r */
        public static String f14958r = "noFlyType";

        /* renamed from: s */
        public static String f14959s = GameAppOperation.QQFAV_DATALINE_VERSION;

        /* renamed from: t */
        public static String f14960t = "pushType";

        /* renamed from: u */
        public static String f14961u = "fcIds";

        /* renamed from: v */
        public static String f14962v = "whileRange";

        C3685a() {
        }
    }

    public C3684m(Context context) {
        this.f14940e = context;
        this.f14938c = C3679h.m7485a(context);
        this.f14939d = this.f14938c.getWritableDatabase();
    }

    /* renamed from: a */
    private ContentValues m7448a(DynamicDYZ_Entity dynamicDYZ_Entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C3685a.f14943c, Double.valueOf(dynamicDYZ_Entity.getLatitude()));
        contentValues.put(C3685a.f14942b, Double.valueOf(dynamicDYZ_Entity.getLogitude()));
        contentValues.put(C3685a.f14945e, Integer.valueOf(dynamicDYZ_Entity.getRadius()));
        contentValues.put(C3685a.f14946f, dynamicDYZ_Entity.getEncryptKey());
        contentValues.put(C3685a.f14947g, dynamicDYZ_Entity.getEncryptValue());
        contentValues.put(C3685a.f14948h, Integer.valueOf(dynamicDYZ_Entity.getType()));
        contentValues.put(C3685a.f14949i, Long.valueOf(dynamicDYZ_Entity.getStartDate()));
        contentValues.put(C3685a.f14950j, Long.valueOf(dynamicDYZ_Entity.getEndDate()));
        contentValues.put(C3685a.f14951k, Long.valueOf(dynamicDYZ_Entity.getInsertDate()));
        contentValues.put(C3685a.f14952l, Integer.valueOf(dynamicDYZ_Entity.getStatus()));
        contentValues.put(C3685a.f14953m, dynamicDYZ_Entity.getRemarks());
        contentValues.put(C3685a.f14954n, Integer.valueOf(dynamicDYZ_Entity.getDeviceType()));
        contentValues.put(C3685a.f14955o, Double.valueOf(dynamicDYZ_Entity.getWarinRadius()));
        contentValues.put(C3685a.f14956p, Double.valueOf(dynamicDYZ_Entity.getLimitRadius()));
        contentValues.put(C3685a.f14957q, Double.valueOf(dynamicDYZ_Entity.getLimitHeight()));
        contentValues.put(C3685a.f14958r, Double.valueOf(dynamicDYZ_Entity.getNoFlyType()));
        contentValues.put(C3685a.f14959s, Double.valueOf(dynamicDYZ_Entity.getCurrentVersion()));
        contentValues.put(C3685a.f14960t, Double.valueOf(dynamicDYZ_Entity.getPushType()));
        contentValues.put(C3685a.f14961u, dynamicDYZ_Entity.getFcIds());
        contentValues.put(C3685a.f14962v, dynamicDYZ_Entity.getWhileRange());
        return contentValues;
    }

    /* renamed from: a */
    public static C3684m m7449a(Context context) {
        if (f14936a == null) {
            f14936a = new C3684m(context);
        }
        return f14936a;
    }

    /* renamed from: a */
    public List<DynamicDYZ_Entity> m7450a(int i, long j) {
        Cursor rawQuery = this.f14939d.rawQuery("select * from " + C3685a.f14941a + " where " + C3685a.f14954n + " = ? ", new String[]{String.valueOf(i)});
        if (rawQuery == null || rawQuery.getCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        rawQuery.moveToFirst();
        do {
            DynamicDYZ_Entity dynamicDYZ_Entity = new DynamicDYZ_Entity();
            dynamicDYZ_Entity.setLatitude(rawQuery.getDouble(rawQuery.getColumnIndex(C3685a.f14943c)));
            dynamicDYZ_Entity.setLogitude(rawQuery.getDouble(rawQuery.getColumnIndex(C3685a.f14942b)));
            dynamicDYZ_Entity.setRadius(rawQuery.getInt(rawQuery.getColumnIndex(C3685a.f14945e)));
            dynamicDYZ_Entity.setEncryptKey(rawQuery.getString(rawQuery.getColumnIndex(C3685a.f14946f)));
            dynamicDYZ_Entity.setEncryptValue(rawQuery.getString(rawQuery.getColumnIndex(C3685a.f14947g)));
            dynamicDYZ_Entity.setType(rawQuery.getInt(rawQuery.getColumnIndex(C3685a.f14948h)));
            dynamicDYZ_Entity.setStartDate(rawQuery.getLong(rawQuery.getColumnIndex(C3685a.f14949i)));
            dynamicDYZ_Entity.setEndDate(rawQuery.getLong(rawQuery.getColumnIndex(C3685a.f14950j)));
            dynamicDYZ_Entity.setInsertDate(rawQuery.getLong(rawQuery.getColumnIndex(C3685a.f14951k)));
            dynamicDYZ_Entity.setStatus(rawQuery.getInt(rawQuery.getColumnIndex(C3685a.f14952l)));
            dynamicDYZ_Entity.setRemarks(rawQuery.getString(rawQuery.getColumnIndex(C3685a.f14953m)));
            dynamicDYZ_Entity.setDeviceType(rawQuery.getInt(rawQuery.getColumnIndex(C3685a.f14954n)));
            dynamicDYZ_Entity.setWarinRadius(rawQuery.getDouble(rawQuery.getColumnIndex(C3685a.f14955o)));
            dynamicDYZ_Entity.setLimitHeight(rawQuery.getDouble(rawQuery.getColumnIndex(C3685a.f14957q)));
            dynamicDYZ_Entity.setLimitRadius(rawQuery.getDouble(rawQuery.getColumnIndex(C3685a.f14956p)));
            dynamicDYZ_Entity.setNoFlyType(rawQuery.getDouble(rawQuery.getColumnIndex(C3685a.f14958r)));
            dynamicDYZ_Entity.setCurrentVersion(rawQuery.getDouble(rawQuery.getColumnIndex(C3685a.f14959s)));
            dynamicDYZ_Entity.setPushType(rawQuery.getDouble(rawQuery.getColumnIndex(C3685a.f14960t)));
            dynamicDYZ_Entity.setFcIds(rawQuery.getString(rawQuery.getColumnIndex(C3685a.f14961u)));
            dynamicDYZ_Entity.setWhileRange(rawQuery.getString(rawQuery.getColumnIndex(C3685a.f14962v)));
            arrayList.add(dynamicDYZ_Entity);
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return arrayList;
    }

    /* renamed from: a */
    public void m7447a(List<DynamicDYZ_Entity> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        m7451a();
        for (DynamicDYZ_Entity dynamicDYZ_Entity : list) {
            this.f14939d.insert(C3685a.f14941a, null, m7448a(dynamicDYZ_Entity));
        }
    }

    /* renamed from: a */
    public boolean m7451a() {
        return this.f14939d.delete(C3685a.f14941a, null, null) > 0;
    }
}
