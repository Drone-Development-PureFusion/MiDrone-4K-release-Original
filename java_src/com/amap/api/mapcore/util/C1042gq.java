package com.amap.api.mapcore.util;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: com.amap.api.mapcore.util.gq */
/* loaded from: classes.dex */
public class C1042gq implements AbstractC1015ft {

    /* renamed from: a */
    private static C1042gq f3253a;

    private C1042gq() {
    }

    /* renamed from: a */
    public static synchronized C1042gq m17861a() {
        C1042gq c1042gq;
        synchronized (C1042gq.class) {
            if (f3253a == null) {
                f3253a = new C1042gq();
            }
            c1042gq = f3253a;
        }
        return c1042gq;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: a */
    public void mo17860a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
        } catch (Throwable th) {
            C1045gs.m17831a(th, "DynamicFileDBCreator", "onCreate");
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: a */
    public void mo17859a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: b */
    public String mo17858b() {
        return "dafile.db";
    }

    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: c */
    public int mo17857c() {
        return 1;
    }
}
