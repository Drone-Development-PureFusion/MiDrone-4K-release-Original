package com.amap.api.services.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.amap.api.services.core.ai */
/* loaded from: classes.dex */
public class C1173ai {

    /* renamed from: a */
    private C1172ah f4012a;

    /* renamed from: b */
    private SQLiteDatabase f4013b;

    public C1173ai(Context context) {
        this.f4012a = new C1172ah(context, "logdb.db", null, 1);
    }

    /* renamed from: a */
    private SQLiteDatabase m17240a() {
        this.f4013b = this.f4012a.getReadableDatabase();
        return this.f4013b;
    }

    /* renamed from: b */
    private SQLiteDatabase m17237b() {
        this.f4013b = this.f4012a.getWritableDatabase();
        return this.f4013b;
    }

    /* renamed from: a */
    public <T> void m17239a(AbstractC1180ap<T> abstractC1180ap) {
        ContentValues mo17197b;
        if (abstractC1180ap == null || (mo17197b = abstractC1180ap.mo17197b()) == null || abstractC1180ap.mo17201a() == null) {
            return;
        }
        if (this.f4013b == null || this.f4013b.isReadOnly()) {
            this.f4013b = m17237b();
        }
        if (this.f4013b == null) {
            return;
        }
        try {
            this.f4013b.insert(abstractC1180ap.mo17201a(), null, mo17197b);
        } catch (Throwable th) {
            try {
                C1190ay.m17177a(th, "DataBase", "insertData");
                th.printStackTrace();
                if (this.f4013b == null) {
                    return;
                }
                this.f4013b.close();
            } catch (Throwable th2) {
                if (this.f4013b != null) {
                    this.f4013b.close();
                    this.f4013b = null;
                }
                throw th2;
            }
        }
        if (this.f4013b == null) {
            return;
        }
        this.f4013b.close();
        this.f4013b = null;
    }

    /* renamed from: a */
    public <T> void m17238a(String str, AbstractC1180ap<T> abstractC1180ap) {
        if (abstractC1180ap.mo17201a() == null || str == null) {
            return;
        }
        if (this.f4013b == null || this.f4013b.isReadOnly()) {
            this.f4013b = m17237b();
        }
        if (this.f4013b == null) {
            return;
        }
        try {
            this.f4013b.delete(abstractC1180ap.mo17201a(), str, null);
        } catch (Throwable th) {
            try {
                C1190ay.m17177a(th, "DataBase", "deleteData");
                th.printStackTrace();
                if (this.f4013b == null) {
                    return;
                }
                this.f4013b.close();
            } catch (Throwable th2) {
                if (this.f4013b != null) {
                    this.f4013b.close();
                    this.f4013b = null;
                }
                throw th2;
            }
        }
        if (this.f4013b == null) {
            return;
        }
        this.f4013b.close();
        this.f4013b = null;
    }

    /* renamed from: b */
    public <T> void m17236b(String str, AbstractC1180ap<T> abstractC1180ap) {
        ContentValues mo17197b;
        if (abstractC1180ap == null || str == null || abstractC1180ap.mo17201a() == null || (mo17197b = abstractC1180ap.mo17197b()) == null) {
            return;
        }
        if (this.f4013b == null || this.f4013b.isReadOnly()) {
            this.f4013b = m17237b();
        }
        if (this.f4013b == null) {
            return;
        }
        try {
            this.f4013b.update(abstractC1180ap.mo17201a(), mo17197b, str, null);
        } catch (Throwable th) {
            try {
                C1190ay.m17177a(th, "DataBase", "updateData");
                th.printStackTrace();
                if (this.f4013b == null) {
                    return;
                }
                this.f4013b.close();
            } catch (Throwable th2) {
                if (this.f4013b != null) {
                    this.f4013b.close();
                    this.f4013b = null;
                }
                throw th2;
            }
        }
        if (this.f4013b == null) {
            return;
        }
        this.f4013b.close();
        this.f4013b = null;
    }

    /* renamed from: c */
    public <T> List<T> m17235c(String str, AbstractC1180ap<T> abstractC1180ap) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        if (this.f4013b == null) {
            this.f4013b = m17240a();
        }
        if (this.f4013b == null || abstractC1180ap.mo17201a() == null || str == null) {
            return arrayList;
        }
        try {
            cursor = this.f4013b.query(abstractC1180ap.mo17201a(), null, str, null, null, null, null);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                C1190ay.m17177a(th, "DataBase", "searchListData");
                th.printStackTrace();
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th3) {
                        C1190ay.m17177a(th3, "DataBase", "searchListData");
                        th3.printStackTrace();
                    }
                }
                try {
                    if (this.f4013b != null) {
                        this.f4013b.close();
                        this.f4013b = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    C1190ay.m17177a(th, "DataBase", "searchListData");
                    th.printStackTrace();
                    return arrayList;
                }
                return arrayList;
            } finally {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th5) {
                        C1190ay.m17177a(th5, "DataBase", "searchListData");
                        th5.printStackTrace();
                    }
                }
                try {
                    if (this.f4013b != null) {
                        this.f4013b.close();
                        this.f4013b = null;
                    }
                } catch (Throwable th6) {
                    C1190ay.m17177a(th6, "DataBase", "searchListData");
                    th6.printStackTrace();
                }
            }
        }
        if (cursor == null) {
            this.f4013b.close();
            this.f4013b = null;
            return arrayList;
        }
        while (cursor.moveToNext()) {
            arrayList.add(abstractC1180ap.mo17196b(cursor));
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th7) {
                C1190ay.m17177a(th7, "DataBase", "searchListData");
                th7.printStackTrace();
            }
        }
        try {
            if (this.f4013b != null) {
                this.f4013b.close();
                this.f4013b = null;
            }
        } catch (Throwable th8) {
            th = th8;
            C1190ay.m17177a(th, "DataBase", "searchListData");
            th.printStackTrace();
            return arrayList;
        }
        return arrayList;
    }
}
