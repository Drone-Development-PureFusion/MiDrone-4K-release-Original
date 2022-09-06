package com.p080b;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: com.b.ae */
/* loaded from: classes.dex */
public class C1405ae implements AbstractC1564j {

    /* renamed from: a */
    private static C1405ae f4832a;

    private C1405ae() {
    }

    /* renamed from: c */
    public static synchronized C1405ae m16425c() {
        C1405ae c1405ae;
        synchronized (C1405ae.class) {
            if (f4832a == null) {
                f4832a = new C1405ae();
            }
            c1405ae = f4832a;
        }
        return c1405ae;
    }

    @Override // com.p080b.AbstractC1564j
    /* renamed from: a */
    public String mo15488a() {
        return "dynamicamapfile.db";
    }

    @Override // com.p080b.AbstractC1564j
    /* renamed from: a */
    public void mo15487a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sdkname  varchar(20), filename varchar(100),md5 varchar(20),version varchar(20),dynamicversion varchar(20),status varchar(20),reservedfield varchar(20));");
        } catch (Throwable th) {
            C1450b.m16187a(th, "DynamicFileDBCreator", "onCreate");
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
