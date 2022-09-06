package com.p080b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* renamed from: com.b.m */
/* loaded from: classes.dex */
public class C1567m extends SQLiteOpenHelper {

    /* renamed from: a */
    private AbstractC1564j f5569a;

    public C1567m(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, AbstractC1564j abstractC1564j) {
        super(context, str, cursorFactory, i);
        this.f5569a = abstractC1564j;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f5569a.mo15487a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f5569a.mo15486a(sQLiteDatabase, i, i2);
    }
}
