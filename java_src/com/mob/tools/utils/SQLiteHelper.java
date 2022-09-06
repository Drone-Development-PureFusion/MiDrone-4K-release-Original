package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class SQLiteHelper {

    /* loaded from: classes.dex */
    public static class SingleTableDB {

        /* renamed from: db */
        private SQLiteDatabase f17342db;
        private HashMap<String, Boolean> fieldLimits;
        private LinkedHashMap<String, String> fieldTypes;
        private String name;
        private String path;
        private String primary;
        private boolean primaryAutoincrement;

        private SingleTableDB(String str, String str2) {
            this.path = str;
            this.name = str2;
            this.fieldTypes = new LinkedHashMap<>();
            this.fieldLimits = new HashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void close() {
            if (this.f17342db != null) {
                this.f17342db.close();
                this.f17342db = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void open() {
            if (this.f17342db == null) {
                this.f17342db = SQLiteDatabase.openOrCreateDatabase(new File(this.path), (SQLiteDatabase.CursorFactory) null);
                Cursor rawQuery = this.f17342db.rawQuery("select count(*) from sqlite_master where type ='table' and name ='" + this.name + "' ", null);
                boolean z = true;
                if (rawQuery != null) {
                    if (rawQuery.moveToNext() && rawQuery.getInt(0) > 0) {
                        z = false;
                    }
                    rawQuery.close();
                }
                if (!z) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("create table  ").append(this.name).append("(");
                for (Map.Entry<String, String> entry : this.fieldTypes.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    boolean booleanValue = this.fieldLimits.get(key).booleanValue();
                    boolean equals = key.equals(this.primary);
                    boolean z2 = equals ? this.primaryAutoincrement : false;
                    sb.append(key).append(" ").append(value);
                    sb.append(booleanValue ? " not null" : "");
                    sb.append(equals ? " primary key" : "");
                    sb.append(z2 ? " autoincrement," : Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.replace(sb.length() - 1, sb.length(), ");");
                this.f17342db.execSQL(sb.toString());
            }
        }

        public void addField(String str, String str2, boolean z) {
            if (this.f17342db == null) {
                this.fieldTypes.put(str, str2);
                this.fieldLimits.put(str, Boolean.valueOf(z));
            }
        }

        public void setPrimary(String str, boolean z) {
            this.primary = str;
            this.primaryAutoincrement = z;
        }
    }

    public static void close(SingleTableDB singleTableDB) {
        singleTableDB.close();
    }

    public static int delete(SingleTableDB singleTableDB, String str, String[] strArr) {
        singleTableDB.open();
        return singleTableDB.f17342db.delete(singleTableDB.getName(), str, strArr);
    }

    public static void execSQL(SingleTableDB singleTableDB, String str) {
        singleTableDB.open();
        singleTableDB.f17342db.beginTransaction();
        try {
            singleTableDB.f17342db.execSQL(str);
            singleTableDB.f17342db.setTransactionSuccessful();
        } finally {
        }
    }

    public static SingleTableDB getDatabase(Context context, String str) {
        return getDatabase(context.getDatabasePath(str).getPath(), str);
    }

    public static SingleTableDB getDatabase(String str, String str2) {
        return new SingleTableDB(str, str2);
    }

    public static int getSize(SingleTableDB singleTableDB) {
        Cursor cursor = null;
        int i = 0;
        singleTableDB.open();
        try {
            cursor = singleTableDB.f17342db.rawQuery("select count(*) from " + singleTableDB.getName(), null);
            if (cursor.moveToNext()) {
                i = cursor.getInt(0);
            }
            return i;
        } finally {
        }
    }

    public static long insert(SingleTableDB singleTableDB, ContentValues contentValues) {
        singleTableDB.open();
        return singleTableDB.f17342db.replace(singleTableDB.getName(), null, contentValues);
    }

    public static Cursor query(SingleTableDB singleTableDB, String[] strArr, String str, String[] strArr2, String str2) {
        singleTableDB.open();
        return singleTableDB.f17342db.query(singleTableDB.getName(), strArr, str, strArr2, null, null, str2);
    }

    public static Cursor rawQuery(SingleTableDB singleTableDB, String str, String[] strArr) {
        singleTableDB.open();
        return singleTableDB.f17342db.rawQuery(str, strArr);
    }

    public static int update(SingleTableDB singleTableDB, ContentValues contentValues, String str, String[] strArr) {
        singleTableDB.open();
        return singleTableDB.f17342db.update(singleTableDB.getName(), contentValues, str, strArr);
    }
}
