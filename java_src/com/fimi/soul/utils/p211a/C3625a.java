package com.fimi.soul.utils.p211a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fimi.soul.entity.BatteryUpdateSize;
import com.fimi.soul.utils.C3679h;
/* renamed from: com.fimi.soul.utils.a.a */
/* loaded from: classes.dex */
public class C3625a {

    /* renamed from: a */
    public static final String f14754a = "create table  if not exists " + C3626a.f14759a + "(" + C3626a.f14760b + " INTEGER ," + C3626a.f14761c + " varchar(20) not null ," + C3626a.f14762d + " INTEGER)";

    /* renamed from: e */
    private static C3625a f14755e;

    /* renamed from: b */
    private Context f14756b;

    /* renamed from: c */
    private C3679h f14757c;

    /* renamed from: d */
    private SQLiteDatabase f14758d;

    /* renamed from: com.fimi.soul.utils.a.a$a */
    /* loaded from: classes.dex */
    public static class C3626a {

        /* renamed from: a */
        public static String f14759a = "battery_update_size";

        /* renamed from: b */
        public static String f14760b = "battery_id";

        /* renamed from: c */
        public static String f14761c = "battery_update_size";

        /* renamed from: d */
        public static String f14762d = "message_hint_size";
    }

    private C3625a(Context context) {
        this.f14756b = context;
        this.f14757c = C3679h.m7485a(context);
    }

    /* renamed from: a */
    public static C3625a m7756a(Context context) {
        if (f14755e == null) {
            f14755e = new C3625a(context.getApplicationContext());
        }
        return f14755e;
    }

    /* renamed from: a */
    public long m7755a(BatteryUpdateSize batteryUpdateSize) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C3626a.f14760b, batteryUpdateSize.getBatteryId());
        contentValues.put(C3626a.f14761c, Integer.valueOf(batteryUpdateSize.getBatteryUpdateSize()));
        contentValues.put(C3626a.f14762d, Integer.valueOf(batteryUpdateSize.getMessageHintSize()));
        this.f14758d = this.f14757c.getWritableDatabase();
        return this.f14758d.insert(C3626a.f14759a, null, contentValues);
    }

    /* renamed from: b */
    public BatteryUpdateSize m7754b(BatteryUpdateSize batteryUpdateSize) {
        this.f14758d = this.f14757c.getWritableDatabase();
        Cursor rawQuery = this.f14758d.rawQuery("select * from " + C3626a.f14759a + " where " + C3626a.f14760b + "=? and " + C3626a.f14761c + "=?", new String[]{batteryUpdateSize.getBatteryId(), String.valueOf(batteryUpdateSize.getBatteryUpdateSize())});
        BatteryUpdateSize batteryUpdateSize2 = null;
        if (rawQuery.moveToFirst()) {
            do {
                batteryUpdateSize2 = new BatteryUpdateSize();
                batteryUpdateSize2.setBatteryId(rawQuery.getString(rawQuery.getColumnIndex(C3626a.f14760b)));
                batteryUpdateSize2.setBatteryUpdateSize(rawQuery.getInt(rawQuery.getColumnIndex(C3626a.f14761c)));
                batteryUpdateSize2.setMessageHintSize(rawQuery.getInt(rawQuery.getColumnIndex(C3626a.f14762d)));
            } while (rawQuery.moveToNext());
            return batteryUpdateSize2;
        }
        return batteryUpdateSize2;
    }

    /* renamed from: c */
    public int m7753c(BatteryUpdateSize batteryUpdateSize) {
        this.f14758d = this.f14757c.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(C3626a.f14762d, Integer.valueOf(batteryUpdateSize.getMessageHintSize()));
        try {
            return this.f14758d.update(C3626a.f14759a, contentValues, C3626a.f14760b + "=? and " + C3626a.f14761c + "=?", new String[]{batteryUpdateSize.getBatteryId(), String.valueOf(batteryUpdateSize.getBatteryUpdateSize())});
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: d */
    public int m7752d(BatteryUpdateSize batteryUpdateSize) {
        this.f14758d = this.f14757c.getWritableDatabase();
        return this.f14758d.delete(C3626a.f14759a, C3626a.f14760b + "=?", new String[]{batteryUpdateSize.getBatteryId()});
    }
}
