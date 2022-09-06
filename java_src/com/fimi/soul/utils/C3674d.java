package com.fimi.soul.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fimi.soul.entity.BatteryOverDischange;
import com.tencent.open.GameAppOperation;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.utils.d */
/* loaded from: classes.dex */
public class C3674d {

    /* renamed from: a */
    public static C3674d f14896a;

    /* renamed from: b */
    public static final String f14897b = "create table  if not exists " + C3675a.f14901a + "(" + C3675a.f14902b + " varchar(20) not null ," + C3675a.f14903c + " varchar(20) not null ," + C3675a.f14904d + " varchar(20) not null ," + C3675a.f14905e + " varchar(20) not null ," + C3675a.f14906f + " varchar(20) not null ," + C3675a.f14907g + " varchar(20) not null ," + C3675a.f14908h + " varchar(20) not null ," + C3675a.f14909i + " varchar(20) not null ," + C3675a.f14910j + " varchar(20) not null ," + C3675a.f14911k + " varchar(20) not null ," + C3675a.f14912l + " varchar(20) not null ," + C3675a.f14913m + " varchar(20) not null ," + C3675a.f14914n + " varchar(20) not null ," + C3675a.f14915o + " varchar(20) not null ," + C3675a.f14917q + " varchar(20) ," + C3675a.f14918r + " varchar(20) ," + C3675a.f14919s + " varchar(20) ," + C3675a.f14916p + " INTEGER)";

    /* renamed from: c */
    private C3679h f14898c;

    /* renamed from: d */
    private SQLiteDatabase f14899d;

    /* renamed from: e */
    private Context f14900e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.utils.d$a */
    /* loaded from: classes.dex */
    public static class C3675a {

        /* renamed from: a */
        public static String f14901a = "battery_over_dischange_tb";

        /* renamed from: b */
        public static String f14902b = "user_id";

        /* renamed from: c */
        public static String f14903c = "battery_id";

        /* renamed from: d */
        public static String f14904d = "battery_level";

        /* renamed from: e */
        public static String f14905e = "voltage";

        /* renamed from: f */
        public static String f14906f = "battery_current";

        /* renamed from: g */
        public static String f14907g = "temperature";

        /* renamed from: h */
        public static String f14908h = "battery_full";

        /* renamed from: i */
        public static String f14909i = "battery_one";

        /* renamed from: j */
        public static String f14910j = "battery_two";

        /* renamed from: k */
        public static String f14911k = "battery_three";

        /* renamed from: l */
        public static String f14912l = "battery_four";

        /* renamed from: m */
        public static String f14913m = "battery_recyle";

        /* renamed from: n */
        public static String f14914n = GameAppOperation.QQFAV_DATALINE_VERSION;

        /* renamed from: o */
        public static String f14915o = "appType";

        /* renamed from: p */
        public static String f14916p = "accidentType";

        /* renamed from: q */
        public static String f14917q = "fc_version";

        /* renamed from: r */
        public static String f14918r = "update_size";

        /* renamed from: s */
        public static String f14919s = "current";

        C3675a() {
        }
    }

    public C3674d(Context context) {
        this.f14900e = context;
        this.f14898c = C3679h.m7485a(context);
        this.f14899d = this.f14898c.getWritableDatabase();
    }

    /* renamed from: a */
    public static C3674d m7498a(Context context) {
        if (f14896a == null) {
            f14896a = new C3674d(context);
        }
        return f14896a;
    }

    /* renamed from: b */
    private ContentValues m7495b(BatteryOverDischange batteryOverDischange) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C3675a.f14902b, batteryOverDischange.getUserId());
        contentValues.put(C3675a.f14903c, batteryOverDischange.getBatteryId());
        contentValues.put(C3675a.f14904d, batteryOverDischange.getBatteryLevel());
        contentValues.put(C3675a.f14905e, batteryOverDischange.getVoltage());
        contentValues.put(C3675a.f14906f, batteryOverDischange.getBatteryCurrent());
        contentValues.put(C3675a.f14907g, batteryOverDischange.getTemperature());
        contentValues.put(C3675a.f14908h, batteryOverDischange.getBatteryFull());
        contentValues.put(C3675a.f14909i, batteryOverDischange.getBatteryOne());
        contentValues.put(C3675a.f14910j, batteryOverDischange.getBatteryTwo());
        contentValues.put(C3675a.f14911k, batteryOverDischange.getBatteryThree());
        contentValues.put(C3675a.f14912l, batteryOverDischange.getBatteryFour());
        contentValues.put(C3675a.f14913m, batteryOverDischange.getBatteryRecyle());
        contentValues.put(C3675a.f14914n, batteryOverDischange.getVersion());
        contentValues.put(C3675a.f14915o, batteryOverDischange.getAppType());
        contentValues.put(C3675a.f14916p, batteryOverDischange.getAppType());
        contentValues.put(C3675a.f14919s, batteryOverDischange.getCurElectric());
        contentValues.put(C3675a.f14917q, batteryOverDischange.getFcVersion());
        contentValues.put(C3675a.f14918r, batteryOverDischange.getUpdateTimes());
        return contentValues;
    }

    /* renamed from: a */
    public long m7497a(BatteryOverDischange batteryOverDischange) {
        return this.f14899d.insert(C3675a.f14901a, null, m7495b(batteryOverDischange));
    }

    /* renamed from: a */
    public List<BatteryOverDischange> m7499a() {
        SQLiteDatabase writableDatabase = this.f14898c.getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("select * from " + C3675a.f14901a, null);
        while (rawQuery.moveToNext()) {
            BatteryOverDischange batteryOverDischange = new BatteryOverDischange();
            batteryOverDischange.setUserId(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14902b)));
            batteryOverDischange.setBatteryId(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14903c)));
            batteryOverDischange.setBatteryLevel(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14904d)));
            batteryOverDischange.setVoltage(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14905e)));
            batteryOverDischange.setBatteryCurrent(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14906f)));
            batteryOverDischange.setTemperature(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14907g)));
            batteryOverDischange.setBatteryFull(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14908h)));
            batteryOverDischange.setBatteryOne(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14909i)));
            batteryOverDischange.setBatteryTwo(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14910j)));
            batteryOverDischange.setBatteryThree(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14911k)));
            batteryOverDischange.setBatteryFour(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14912l)));
            batteryOverDischange.setBatteryRecyle(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14913m)));
            batteryOverDischange.setVersion(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14914n)));
            batteryOverDischange.setAppType(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14915o)));
            batteryOverDischange.setAccidentType(rawQuery.getInt(rawQuery.getColumnIndex(C3675a.f14916p)));
            batteryOverDischange.setCurElectric(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14919s)));
            batteryOverDischange.setFcVersion(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14917q)));
            batteryOverDischange.setUpdateTimes(rawQuery.getString(rawQuery.getColumnIndex(C3675a.f14918r)));
            arrayList.add(batteryOverDischange);
        }
        return arrayList;
    }

    /* renamed from: b */
    public boolean m7496b() {
        return this.f14899d.delete(C3675a.f14901a, null, null) > 0;
    }

    /* renamed from: c */
    public long m7494c() {
        this.f14899d = this.f14898c.getReadableDatabase();
        Cursor rawQuery = this.f14899d.rawQuery("select count(*)from" + C3675a.f14901a, null);
        rawQuery.moveToFirst();
        return rawQuery.getLong(0);
    }
}
