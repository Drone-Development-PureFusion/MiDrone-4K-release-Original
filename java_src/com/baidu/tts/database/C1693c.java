package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: com.baidu.tts.database.c */
/* loaded from: classes.dex */
public class C1693c {

    /* renamed from: a */
    private SQLiteDatabase f5962a;

    /* renamed from: b */
    private AbstractC1694a f5963b;

    /* renamed from: com.baidu.tts.database.c$a */
    /* loaded from: classes.dex */
    public interface AbstractC1694a {
        /* renamed from: a */
        boolean mo14907a(SQLiteDatabase sQLiteDatabase);
    }

    public C1693c(SQLiteDatabase sQLiteDatabase, AbstractC1694a abstractC1694a) {
        this.f5962a = sQLiteDatabase;
        this.f5963b = abstractC1694a;
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: a */
    public boolean m14908a() {
        boolean z = false;
        if (this.f5963b != null && this.f5962a != null) {
            try {
                try {
                    this.f5962a.beginTransaction();
                    z = this.f5963b.mo14907a(this.f5962a);
                    if (z) {
                        this.f5962a.setTransactionSuccessful();
                    }
                    if (this.f5962a != null) {
                        this.f5962a.endTransaction();
                        this.f5962a.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.f5962a != null) {
                        this.f5962a.endTransaction();
                        this.f5962a.close();
                    }
                }
            } catch (Throwable th) {
                if (this.f5962a != null) {
                    this.f5962a.endTransaction();
                    this.f5962a.close();
                }
                throw th;
            }
        }
        return z;
    }
}
