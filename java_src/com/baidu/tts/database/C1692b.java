package com.baidu.tts.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* renamed from: com.baidu.tts.database.b */
/* loaded from: classes.dex */
public class C1692b extends SQLiteOpenHelper {
    public C1692b(Context context) {
        this(context, "ttsModel.db", null, 1);
    }

    public C1692b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SpeechModelTable.m14927a());
        sQLiteDatabase.execSQL(ModelFileTable.m14931a());
        sQLiteDatabase.execSQL(FsFileInfoTable.m14933a());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(SpeechModelTable.m14924b());
        sQLiteDatabase.execSQL(ModelFileTable.m14928b());
        sQLiteDatabase.execSQL(FsFileInfoTable.m14932b());
        onCreate(sQLiteDatabase);
    }
}
