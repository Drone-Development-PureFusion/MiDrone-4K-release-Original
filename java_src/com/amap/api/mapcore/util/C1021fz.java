package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* renamed from: com.amap.api.mapcore.util.fz */
/* loaded from: classes.dex */
public class C1021fz extends SQLiteOpenHelper {

    /* renamed from: a */
    private AbstractC1015ft f3198a;

    public C1021fz(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, AbstractC1015ft abstractC1015ft) {
        super(context, str, cursorFactory, i);
        this.f3198a = abstractC1015ft;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f3198a.mo17860a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f3198a.mo17859a(sQLiteDatabase, i, i2);
    }
}
