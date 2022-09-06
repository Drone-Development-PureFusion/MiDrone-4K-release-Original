package com.p080b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* renamed from: com.b.k */
/* loaded from: classes.dex */
public class C1565k {

    /* renamed from: a */
    private C1567m f5566a;

    /* renamed from: b */
    private SQLiteDatabase f5567b;

    /* renamed from: c */
    private AbstractC1564j f5568c;

    public C1565k(Context context, AbstractC1564j abstractC1564j) {
        try {
            this.f5566a = new C1567m(context, abstractC1564j.mo15488a(), null, abstractC1564j.mo15485b(), abstractC1564j);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f5568c = abstractC1564j;
    }

    /* renamed from: a */
    private SQLiteDatabase m15493a(boolean z) {
        try {
            this.f5567b = this.f5566a.getReadableDatabase();
        } catch (Throwable th) {
            if (!z) {
                C1450b.m16187a(th, "DBOperation", "getReadAbleDataBase");
            } else {
                th.printStackTrace();
            }
        }
        return this.f5567b;
    }

    /* renamed from: a */
    public static String m15494a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        Iterator<String> it2 = map.keySet().iterator();
        while (true) {
            boolean z2 = z;
            if (!it2.hasNext()) {
                return sb.toString();
            }
            String next = it2.next();
            if (z2) {
                sb.append(next).append(" = '").append(map.get(next)).append("'");
                z = false;
            } else {
                sb.append(" and ").append(next).append(" = '").append(map.get(next)).append("'");
                z = z2;
            }
        }
    }

    /* renamed from: a */
    private <T> void m15500a(SQLiteDatabase sQLiteDatabase, AbstractC1566l<T> abstractC1566l) {
        ContentValues mo15451a;
        if (abstractC1566l == null || sQLiteDatabase == null || (mo15451a = abstractC1566l.mo15451a()) == null || abstractC1566l.mo15447b() == null) {
            return;
        }
        sQLiteDatabase.insert(abstractC1566l.mo15447b(), null, mo15451a);
    }

    /* renamed from: b */
    private SQLiteDatabase m15490b(boolean z) {
        try {
            this.f5567b = this.f5566a.getWritableDatabase();
        } catch (Throwable th) {
            C1450b.m16187a(th, "DBOperation", "getReadAbleDataBase");
        }
        return this.f5567b;
    }

    /* renamed from: a */
    public <T> void m15499a(AbstractC1566l<T> abstractC1566l) {
        m15497a((AbstractC1566l) abstractC1566l, false);
    }

    /* renamed from: a */
    public <T> void m15498a(AbstractC1566l<T> abstractC1566l, String str) {
        synchronized (this.f5568c) {
            List<T> m15489c = m15489c(str, abstractC1566l);
            if (m15489c == null || m15489c.size() == 0) {
                m15499a(abstractC1566l);
            } else {
                m15492b(str, abstractC1566l);
            }
        }
    }

    /* renamed from: a */
    public <T> void m15497a(AbstractC1566l<T> abstractC1566l, boolean z) {
        synchronized (this.f5568c) {
            if (this.f5567b == null || this.f5567b.isReadOnly()) {
                this.f5567b = m15490b(z);
            }
            if (this.f5567b == null) {
                return;
            }
            m15500a(this.f5567b, abstractC1566l);
            if (this.f5567b != null) {
                this.f5567b.close();
                this.f5567b = null;
            }
        }
    }

    /* renamed from: a */
    public <T> void m15496a(String str, AbstractC1566l<T> abstractC1566l) {
        synchronized (this.f5568c) {
            if (abstractC1566l.mo15447b() == null || str == null) {
                return;
            }
            if (this.f5567b == null || this.f5567b.isReadOnly()) {
                this.f5567b = m15490b(false);
            }
            if (this.f5567b == null) {
                return;
            }
            this.f5567b.delete(abstractC1566l.mo15447b(), str, null);
            if (this.f5567b != null) {
                this.f5567b.close();
                this.f5567b = null;
            }
        }
    }

    /* renamed from: a */
    public <T> void m15495a(String str, AbstractC1566l<T> abstractC1566l, boolean z) {
        synchronized (this.f5568c) {
            if (abstractC1566l != null && str != null) {
                if (abstractC1566l.mo15447b() != null) {
                    ContentValues mo15451a = abstractC1566l.mo15451a();
                    if (mo15451a == null) {
                        return;
                    }
                    if (this.f5567b == null || this.f5567b.isReadOnly()) {
                        this.f5567b = m15490b(z);
                    }
                    if (this.f5567b == null) {
                        return;
                    }
                    this.f5567b.update(abstractC1566l.mo15447b(), mo15451a, str, null);
                    if (this.f5567b != null) {
                        this.f5567b.close();
                        this.f5567b = null;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public <T> List<T> m15491b(String str, AbstractC1566l<T> abstractC1566l, boolean z) {
        Cursor cursor;
        synchronized (this.f5568c) {
            ArrayList arrayList = new ArrayList();
            if (this.f5567b == null) {
                this.f5567b = m15493a(z);
            }
            if (this.f5567b == null || abstractC1566l.mo15447b() == null || str == null) {
                return arrayList;
            }
            try {
                cursor = this.f5567b.query(abstractC1566l.mo15447b(), null, str, null, null, null, null);
                try {
                } catch (Throwable th) {
                    th = th;
                    if (!z) {
                        C1450b.m16187a(th, "DataBase", "searchListData");
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (this.f5567b != null) {
                        this.f5567b.close();
                        this.f5567b = null;
                    }
                    return arrayList;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            if (cursor == null) {
                this.f5567b.close();
                this.f5567b = null;
                if (cursor != null) {
                    cursor.close();
                }
                if (this.f5567b != null) {
                    this.f5567b.close();
                    this.f5567b = null;
                }
                return arrayList;
            }
            while (cursor.moveToNext()) {
                arrayList.add(abstractC1566l.mo15450a(cursor));
            }
            if (cursor != null) {
                cursor.close();
            }
            if (this.f5567b != null) {
                this.f5567b.close();
                this.f5567b = null;
            }
            return arrayList;
        }
    }

    /* renamed from: b */
    public <T> void m15492b(String str, AbstractC1566l<T> abstractC1566l) {
        m15495a(str, abstractC1566l, false);
    }

    /* renamed from: c */
    public <T> List<T> m15489c(String str, AbstractC1566l<T> abstractC1566l) {
        return m15491b(str, abstractC1566l, false);
    }
}
