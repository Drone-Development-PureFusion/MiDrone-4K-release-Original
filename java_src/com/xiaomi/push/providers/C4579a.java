package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.mipush.sdk.Constants;
/* renamed from: com.xiaomi.push.providers.a */
/* loaded from: classes2.dex */
public class C4579a extends SQLiteOpenHelper {

    /* renamed from: b */
    private static int f18879b = 1;

    /* renamed from: a */
    public static final Object f18878a = new Object();

    /* renamed from: c */
    private static final String[] f18880c = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public C4579a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f18879b);
    }

    /* renamed from: a */
    private void m4509a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i = 0; i < f18880c.length - 1; i += 2) {
            if (i != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(f18880c[i]).append(" ").append(f18880c[i + 1]);
        }
        sb.append(");");
        sQLiteDatabase.execSQL(sb.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f18878a) {
            try {
                m4509a(sQLiteDatabase);
            } catch (SQLException e) {
                AbstractC4478b.m5039a(e);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
