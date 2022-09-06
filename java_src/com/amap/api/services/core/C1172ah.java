package com.amap.api.services.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
/* renamed from: com.amap.api.services.core.ah */
/* loaded from: classes.dex */
public class C1172ah extends SQLiteOpenHelper {

    /* renamed from: a */
    static final String f3992a = "a";

    /* renamed from: b */
    static final String f3993b = "b";

    /* renamed from: c */
    static final String f3994c = "c";

    /* renamed from: d */
    static final String f3995d = C0477f.f1054a;

    /* renamed from: e */
    static final String f3996e = "e";

    /* renamed from: f */
    static final String f3997f = "a1";

    /* renamed from: g */
    static final String f3998g = "a2";

    /* renamed from: h */
    static final String f3999h = "a3";

    /* renamed from: i */
    static final String f4000i = "a4";

    /* renamed from: j */
    static final String f4001j = "a5";

    /* renamed from: k */
    static final String f4002k = "a6";

    /* renamed from: l */
    static final String f4003l = "b1";

    /* renamed from: m */
    static final String f4004m = "b2";

    /* renamed from: n */
    static final String f4005n = "b3";

    /* renamed from: o */
    static final String f4006o = "c1";

    /* renamed from: p */
    static final String f4007p = "c2";

    /* renamed from: q */
    static final String f4008q = "c3";

    /* renamed from: r */
    private static final String f4009r = "CREATE TABLE IF NOT EXISTS " + f3992a + " (_id integer primary key autoincrement, " + f3997f + "  varchar(20), " + f3998g + " varchar(10)," + f3999h + " varchar(50)," + f4000i + " varchar(100)," + f4001j + " varchar(20)," + f4002k + " integer);";

    /* renamed from: s */
    private static final String f4010s = "CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement," + f4003l + " varchar(40), " + f4004m + " integer," + f4005n + "  integer," + f3997f + "  varchar(20));";

    /* renamed from: t */
    private static final String f4011t = "CREATE TABLE IF NOT EXISTS " + f3996e + " (_id integer primary key autoincrement," + f4006o + " integer," + f4007p + " integer," + f4008q + " integer);";

    public C1172ah(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f4009r);
            sQLiteDatabase.execSQL(String.format(f4010s, f3993b));
            sQLiteDatabase.execSQL(String.format(f4010s, f3994c));
            sQLiteDatabase.execSQL(String.format(f4010s, f3995d));
            sQLiteDatabase.execSQL(f4011t);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
