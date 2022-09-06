package com.amap.api.mapcore.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* renamed from: com.amap.api.mapcore.util.bl */
/* loaded from: classes.dex */
public class C0841bl implements AbstractC1015ft {

    /* renamed from: a */
    private static volatile C0841bl f2362a;

    private C0841bl() {
    }

    /* renamed from: a */
    public static C0841bl m18822a() {
        if (f2362a == null) {
            synchronized (C0841bl.class) {
                if (f2362a == null) {
                    f2362a = new C0841bl();
                }
            }
        }
        return f2362a;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: a */
    public void mo17860a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");
        } catch (Throwable th) {
            C1007fo.m18012b(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: a */
    public void mo17859a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                sQLiteDatabase.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
                Cursor query = sQLiteDatabase.query("update_item", null, null, null, null, null, null);
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("url"));
                    String substring = string.substring(string.lastIndexOf("/") + 1);
                    sQLiteDatabase.execSQL("update update_item set mPinyin=? where url =?", new String[]{substring.substring(0, substring.lastIndexOf(".")), string});
                }
                query.close();
                return;
            default:
                return;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: b */
    public String mo17858b() {
        return "offlineDbV4.db";
    }

    @Override // com.amap.api.mapcore.util.AbstractC1015ft
    /* renamed from: c */
    public int mo17857c() {
        return 2;
    }
}
