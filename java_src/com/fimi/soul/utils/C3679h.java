package com.fimi.soul.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.fimi.soul.utils.C3674d;
import com.fimi.soul.utils.C3684m;
import com.fimi.soul.utils.C3707w;
import com.fimi.soul.utils.p211a.C3625a;
import com.fimi.soul.utils.p211a.C3628c;
/* renamed from: com.fimi.soul.utils.h */
/* loaded from: classes.dex */
public class C3679h extends SQLiteOpenHelper {

    /* renamed from: a */
    public static C3679h f14927a = null;

    /* renamed from: b */
    private static final String f14928b = "miplaner";

    /* renamed from: c */
    private static final int f14929c = 15;

    /* renamed from: d */
    private Context f14930d;

    private C3679h(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, f14928b, cursorFactory, 15);
        this.f14930d = context;
    }

    /* renamed from: a */
    public static C3679h m7485a(Context context) {
        if (f14927a == null) {
            f14927a = new C3679h(context, null, null, 0);
        }
        return f14927a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C3670av.m7525a(sQLiteDatabase);
        sQLiteDatabase.execSQL(C3707w.f15124b);
        sQLiteDatabase.execSQL(C3674d.f14897b);
        sQLiteDatabase.execSQL(C3628c.f14763a);
        sQLiteDatabase.execSQL(C3625a.f14754a);
        sQLiteDatabase.execSQL(C3684m.f14937b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                sQLiteDatabase.execSQL("drop table if exists flyRecord_tb");
                sQLiteDatabase.execSQL(C3707w.f15124b);
                sQLiteDatabase.execSQL(C3674d.f14897b);
            case 2:
                sQLiteDatabase.execSQL("drop table if exists battery_over_dischange_tb");
                sQLiteDatabase.execSQL(C3674d.f14897b);
                sQLiteDatabase.execSQL("drop table if exists flyRecord_tb");
                sQLiteDatabase.execSQL(C3707w.f15124b);
            case 3:
                sQLiteDatabase.execSQL("drop table if exists flyRecord_tb");
                sQLiteDatabase.execSQL(C3707w.f15124b);
            case 4:
                sQLiteDatabase.execSQL("drop table if exists history_push_message");
                sQLiteDatabase.execSQL(C3628c.f14763a);
                sQLiteDatabase.execSQL("drop table if exists " + C3625a.C3626a.f14759a);
                sQLiteDatabase.execSQL(C3625a.f14754a);
            case 5:
                sQLiteDatabase.execSQL("drop table if exists history_push_message");
                sQLiteDatabase.execSQL(C3628c.f14763a);
            case 6:
                sQLiteDatabase.execSQL("drop table if exists history_push_message");
                sQLiteDatabase.execSQL(C3628c.f14763a);
            case 7:
                sQLiteDatabase.execSQL("alter table " + C3674d.C3675a.f14901a + " add " + C3674d.C3675a.f14917q + " varchar(20)");
                sQLiteDatabase.execSQL("alter table " + C3674d.C3675a.f14901a + " add " + C3674d.C3675a.f14919s + " varchar(20)");
                sQLiteDatabase.execSQL("alter table " + C3674d.C3675a.f14901a + " add " + C3674d.C3675a.f14918r + " varchar(20)");
            case 8:
                sQLiteDatabase.execSQL(C3684m.f14937b);
            case 9:
                sQLiteDatabase.execSQL("alter table " + C3707w.C3708a.f15128a + " add " + C3707w.C3708a.f15133f + " varchar(10) ");
            case 10:
                sQLiteDatabase.execSQL("alter table " + C3707w.C3708a.f15128a + " add " + C3707w.C3708a.f15134g + " double");
                sQLiteDatabase.execSQL("alter table " + C3707w.C3708a.f15128a + " add " + C3707w.C3708a.f15135h + " double");
            case 11:
                sQLiteDatabase.execSQL("alter table " + C3684m.C3685a.f14941a + " add " + C3684m.C3685a.f14955o + " double");
                sQLiteDatabase.execSQL("alter table " + C3684m.C3685a.f14941a + " add " + C3684m.C3685a.f14956p + " double");
                sQLiteDatabase.execSQL("alter table " + C3684m.C3685a.f14941a + " add " + C3684m.C3685a.f14957q + " double");
                sQLiteDatabase.execSQL("alter table " + C3684m.C3685a.f14941a + " add " + C3684m.C3685a.f14958r + " double");
                sQLiteDatabase.execSQL("alter table " + C3684m.C3685a.f14941a + " add " + C3684m.C3685a.f14959s + " double");
            case 12:
                sQLiteDatabase.execSQL("alter table " + C3684m.C3685a.f14941a + " add " + C3684m.C3685a.f14960t + " double");
            case 13:
                sQLiteDatabase.execSQL("alter table " + C3684m.C3685a.f14941a + " add " + C3684m.C3685a.f14961u + " varchar(200)");
                break;
            case 14:
                break;
            default:
                return;
        }
        sQLiteDatabase.execSQL("alter table " + C3684m.C3685a.f14941a + " add " + C3684m.C3685a.f14962v + " varchar(10)");
    }
}
