package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.tencent.stat.common.C4420k;
import com.tencent.stat.common.StatLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.w */
/* loaded from: classes2.dex */
public class C4445w extends SQLiteOpenHelper {
    public C4445w(Context context) {
        super(context, C4420k.m5165v(context), (SQLiteDatabase.CursorFactory) null, 3);
    }

    /* renamed from: a */
    private void m5108a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        StatLogger statLogger;
        String str = null;
        try {
            cursor = sQLiteDatabase.query("user", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (cursor.moveToNext()) {
                    str = cursor.getString(0);
                    cursor.getInt(1);
                    cursor.getString(2);
                    cursor.getLong(3);
                    contentValues.put(C3947a.f16896g, C4420k.m5191c(str));
                }
                if (str != null) {
                    sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{str});
                }
            } catch (Throwable th) {
                th = th;
                try {
                    statLogger = C4436n.f18489e;
                    statLogger.m5236e(th);
                    if (cursor == null) {
                        return;
                    }
                    cursor.close();
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: b */
    private void m5107b(android.database.sqlite.SQLiteDatabase r11) {
        /*
            r10 = this;
            r8 = 0
            java.lang.String r1 = "events"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r11
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L8c
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L36
            r0.<init>()     // Catch: java.lang.Throwable -> L36
        L13:
            boolean r1 = r7.moveToNext()     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L45
            r1 = 0
            long r2 = r7.getLong(r1)     // Catch: java.lang.Throwable -> L36
            r1 = 1
            java.lang.String r4 = r7.getString(r1)     // Catch: java.lang.Throwable -> L36
            r1 = 2
            int r5 = r7.getInt(r1)     // Catch: java.lang.Throwable -> L36
            r1 = 3
            int r6 = r7.getInt(r1)     // Catch: java.lang.Throwable -> L36
            com.tencent.stat.x r1 = new com.tencent.stat.x     // Catch: java.lang.Throwable -> L36
            r1.<init>(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L36
            r0.add(r1)     // Catch: java.lang.Throwable -> L36
            goto L13
        L36:
            r0 = move-exception
            r1 = r7
        L38:
            com.tencent.stat.common.StatLogger r2 = com.tencent.stat.C4436n.m5113d()     // Catch: java.lang.Throwable -> L89
            r2.m5236e(r0)     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L44
            r1.close()
        L44:
            return
        L45:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L36
            r1.<init>()     // Catch: java.lang.Throwable -> L36
            java.util.Iterator r2 = r0.iterator()     // Catch: java.lang.Throwable -> L36
        L4e:
            boolean r0 = r2.hasNext()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L80
            java.lang.Object r0 = r2.next()     // Catch: java.lang.Throwable -> L36
            com.tencent.stat.x r0 = (com.tencent.stat.C4446x) r0     // Catch: java.lang.Throwable -> L36
            java.lang.String r3 = "content"
            java.lang.String r4 = r0.f18514b     // Catch: java.lang.Throwable -> L36
            java.lang.String r4 = com.tencent.stat.common.C4420k.m5191c(r4)     // Catch: java.lang.Throwable -> L36
            r1.put(r3, r4)     // Catch: java.lang.Throwable -> L36
            java.lang.String r3 = "events"
            java.lang.String r4 = "event_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L36
            r6 = 0
            long r8 = r0.f18513a     // Catch: java.lang.Throwable -> L36
            java.lang.String r0 = java.lang.Long.toString(r8)     // Catch: java.lang.Throwable -> L36
            r5[r6] = r0     // Catch: java.lang.Throwable -> L36
            r11.update(r3, r1, r4, r5)     // Catch: java.lang.Throwable -> L36
            goto L4e
        L79:
            r0 = move-exception
        L7a:
            if (r7 == 0) goto L7f
            r7.close()
        L7f:
            throw r0
        L80:
            if (r7 == 0) goto L44
            r7.close()
            goto L44
        L86:
            r0 = move-exception
            r7 = r8
            goto L7a
        L89:
            r0 = move-exception
            r7 = r1
            goto L7a
        L8c:
            r0 = move-exception
            r1 = r8
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C4445w.m5107b(android.database.sqlite.SQLiteDatabase):void");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        StatLogger statLogger;
        statLogger = C4436n.f18489e;
        statLogger.debug("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            m5108a(sQLiteDatabase);
            m5107b(sQLiteDatabase);
        }
        if (i == 2) {
            m5108a(sQLiteDatabase);
            m5107b(sQLiteDatabase);
        }
    }
}
