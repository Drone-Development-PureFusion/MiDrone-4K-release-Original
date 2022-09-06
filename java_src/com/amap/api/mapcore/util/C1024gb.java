package com.amap.api.mapcore.util;

import android.database.sqlite.SQLiteDatabase;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
/* renamed from: com.amap.api.mapcore.util.gb */
/* loaded from: classes.dex */
public class C1024gb implements AbstractC1015ft {
    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: a */
    public void mo17860a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS a (_id integer primary key autoincrement, a1  varchar(20), a2 varchar(10),a3 varchar(50),a4 varchar(100),a5 varchar(20),a6 integer);");
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", "b"));
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", "c"));
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", C0477f.f1054a));
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS e (_id integer primary key autoincrement,c1 integer,c2 integer,c3 integer);");
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DB", "onCreate");
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: a */
    public void mo17859a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: b */
    public String mo17858b() {
        return "logdb.db";
    }

    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: c */
    public int mo17857c() {
        return 1;
    }
}
