package com.p080b;

import android.database.sqlite.SQLiteDatabase;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
/* renamed from: com.b.n */
/* loaded from: classes.dex */
public class C1568n implements AbstractC1564j {

    /* renamed from: a */
    static final String f5570a = "a";

    /* renamed from: b */
    public static final String f5571b = "b";

    /* renamed from: c */
    public static final String f5572c = "c";

    /* renamed from: d */
    public static final String f5573d = C0477f.f1054a;

    /* renamed from: e */
    static final String f5574e = "e";

    /* renamed from: f */
    static final String f5575f = "a1";

    /* renamed from: g */
    static final String f5576g = "a2";

    /* renamed from: h */
    static final String f5577h = "a3";

    /* renamed from: i */
    static final String f5578i = "a4";

    /* renamed from: j */
    static final String f5579j = "a5";

    /* renamed from: k */
    static final String f5580k = "a6";

    /* renamed from: l */
    static final String f5581l = "b1";

    /* renamed from: m */
    static final String f5582m = "b2";

    /* renamed from: n */
    static final String f5583n = "b3";

    /* renamed from: o */
    static final String f5584o = "c1";

    /* renamed from: p */
    static final String f5585p = "c2";

    /* renamed from: q */
    static final String f5586q = "c3";

    /* renamed from: r */
    private static final String f5587r = "CREATE TABLE IF NOT EXISTS " + f5570a + " (_id integer primary key autoincrement, " + f5575f + "  varchar(20), " + f5576g + " varchar(10)," + f5577h + " varchar(50)," + f5578i + " varchar(100)," + f5579j + " varchar(20)," + f5580k + " integer);";

    /* renamed from: s */
    private static final String f5588s = "CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement," + f5581l + " varchar(40), " + f5582m + " integer," + f5583n + "  integer," + f5575f + "  varchar(20));";

    /* renamed from: t */
    private static final String f5589t = "CREATE TABLE IF NOT EXISTS " + f5574e + " (_id integer primary key autoincrement," + f5584o + " integer," + f5585p + " integer," + f5586q + " integer);";

    /* renamed from: u */
    private static C1568n f5590u;

    private C1568n() {
    }

    /* renamed from: c */
    public static synchronized C1568n m15484c() {
        C1568n c1568n;
        synchronized (C1568n.class) {
            if (f5590u == null) {
                f5590u = new C1568n();
            }
            c1568n = f5590u;
        }
        return c1568n;
    }

    @Override // com.p080b.AbstractC1564j
    /* renamed from: a */
    public String mo15488a() {
        return "logdb.db";
    }

    @Override // com.p080b.AbstractC1564j
    /* renamed from: a */
    public void mo15487a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f5587r);
            sQLiteDatabase.execSQL(String.format(f5588s, f5571b));
            sQLiteDatabase.execSQL(String.format(f5588s, f5572c));
            sQLiteDatabase.execSQL(String.format(f5588s, f5573d));
            sQLiteDatabase.execSQL(f5589t);
        } catch (Throwable th) {
            C1450b.m16187a(th, "DB", "onCreate");
        }
    }

    @Override // com.p080b.AbstractC1564j
    /* renamed from: a */
    public void mo15486a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // com.p080b.AbstractC1564j
    /* renamed from: b */
    public int mo15485b() {
        return 1;
    }
}
