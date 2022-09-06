package com.fimi.kernel.p157b.p159b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.fimi.kernel.p157b.p159b.C2196b;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.fimi.kernel.b.b.f */
/* loaded from: classes.dex */
public class C2213f {

    /* renamed from: a */
    private static C2213f f7418a = null;

    /* renamed from: b */
    private SQLiteDatabase f7419b;

    /* renamed from: c */
    private Context f7420c;

    /* renamed from: com.fimi.kernel.b.b.f$a */
    /* loaded from: classes.dex */
    public interface AbstractC2215a {
        /* renamed from: a */
        void mo13193a(C2196b c2196b);
    }

    private C2213f(Context context) {
        this.f7419b = null;
        this.f7420c = context;
        try {
            this.f7419b = new C2195a(context).getWritableDatabase();
        } catch (Exception e) {
            Log.d("ljh", e.getMessage());
        }
    }

    /* renamed from: a */
    public static C2213f m13205a(Context context) {
        if (context == null) {
            return null;
        }
        if (f7418a == null) {
            f7418a = new C2213f(context);
            f7418a.f7420c = context;
        }
        return f7418a;
    }

    /* renamed from: d */
    private SQLiteDatabase m13196d() {
        try {
            return new C2195a(this.f7420c).getWritableDatabase();
        } catch (Exception e) {
            Log.d("Good", e + "");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0055 A[Catch: all -> 0x004e, TRY_ENTER, TryCatch #5 {, blocks: (B:12:0x003a, B:29:0x0055, B:30:0x0058, B:24:0x004a), top: B:3:0x0002 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized C2196b m13204a(Context context, String str, final AbstractC2215a abstractC2215a) {
        Cursor cursor;
        Cursor cursor2;
        C2196b c2196b;
        Exception exc;
        try {
            cursor = f7418a.f7419b.rawQuery("select url,local_uri,file_size from download_task where url=?", new String[]{str});
            C2196b c2196b2 = null;
            while (cursor.moveToNext()) {
                try {
                    c2196b2 = C2196b.m13292a(context, cursor.getString(0), cursor.getLong(2), false, cursor.getString(1), new C2196b.AbstractC2203e() { // from class: com.fimi.kernel.b.b.f.1
                        @Override // com.fimi.kernel.p157b.p159b.C2196b.AbstractC2203e
                        /* renamed from: a */
                        public void mo13194a(C2196b c2196b3) {
                            if (abstractC2215a != null) {
                                abstractC2215a.mo13193a(c2196b3);
                            }
                        }
                    });
                } catch (Exception e) {
                    exc = e;
                    cursor2 = cursor;
                    c2196b = c2196b2;
                    try {
                        exc.printStackTrace();
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return c2196b;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
                c2196b = c2196b2;
            } else {
                c2196b = c2196b2;
            }
        } catch (Exception e2) {
            cursor2 = null;
            c2196b = null;
            exc = e2;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        return c2196b;
    }

    /* renamed from: a */
    public List<String> m13207a() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = f7418a.f7419b.rawQuery("select url from download_info group by url", null);
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(0));
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public synchronized void m13206a(int i, long j, String str) {
        try {
            f7418a.f7419b.beginTransaction();
            f7418a.f7419b.execSQL("update download_info set compelete_size=? where thread_id=? and url=?", new Object[]{Long.valueOf(j), Integer.valueOf(i), str});
            f7418a.f7419b.setTransactionSuccessful();
            try {
                f7418a.f7419b.endTransaction();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                f7418a.f7419b.endTransaction();
            } catch (Exception e3) {
            }
        }
    }

    /* renamed from: a */
    public synchronized void m13203a(C2196b c2196b) {
        try {
            f7418a.f7419b.execSQL("insert into download_task(url,local_uri,file_size,dur) values (?,?,?,?)", new Object[]{c2196b.m13250m(), c2196b.m13260h(), Long.valueOf(c2196b.m13258i()), c2196b.m13294a()});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public synchronized void m13201a(List<C2210d> list) {
        try {
            for (C2210d c2210d : list) {
                f7418a.f7419b.execSQL("insert into download_info(thread_id,start_pos, end_pos,compelete_size,url) values (?,?,?,?,?)", new Object[]{Integer.valueOf(c2210d.m13217b()), Long.valueOf(c2210d.m13215c()), Long.valueOf(c2210d.m13213d()), Long.valueOf(c2210d.m13212e()), c2210d.m13221a()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public synchronized boolean m13202a(String str) {
        int i;
        boolean z = true;
        synchronized (this) {
            Cursor cursor = null;
            try {
                cursor = f7418a.f7419b.rawQuery("select count(*)  from download_info where url=?", new String[]{str});
                i = cursor.moveToFirst() ? cursor.getInt(0) : -1;
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                    i = -1;
                } else {
                    i = -1;
                }
            }
            if (i <= 0) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0055 A[Catch: all -> 0x004e, TRY_ENTER, TryCatch #5 {, blocks: (B:30:0x004a, B:34:0x003b, B:39:0x0055, B:40:0x0058), top: B:3:0x0002 }] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized C2196b m13199b(String str) {
        Cursor cursor;
        C2196b c2196b;
        Exception e;
        C2196b c2196b2 = null;
        synchronized (this) {
            try {
                c2196b = "select url,local_uri,dur from download_task where url=?";
                cursor = f7418a.f7419b.rawQuery(c2196b, new String[]{str});
                while (true) {
                    try {
                        try {
                            c2196b = c2196b2;
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            c2196b2 = new C2196b(cursor.getString(0), cursor.getString(1));
                            try {
                                c2196b = cursor.getString(2);
                                if (c2196b != null) {
                                    c2196b = cursor.getString(2);
                                    c2196b2.m13279a(c2196b);
                                }
                            } catch (Exception e2) {
                                c2196b = c2196b2;
                                e = e2;
                                e.printStackTrace();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return c2196b;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e4) {
                cursor = null;
                c2196b = null;
                e = e4;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        }
        return c2196b;
    }

    /* renamed from: b */
    public synchronized List<C2196b> m13200b() {
        ArrayList arrayList;
        Cursor cursor = null;
        synchronized (this) {
            arrayList = new ArrayList();
            try {
                cursor = f7418a.f7419b.rawQuery("select url,local_uri from download_task", null);
                cursor.moveToFirst();
                while (cursor.moveToNext()) {
                    arrayList.add(new C2196b(cursor.getString(0), cursor.getString(1)));
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058 A[Catch: all -> 0x0051, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:16:0x004d, B:23:0x0046, B:28:0x0058, B:29:0x005b), top: B:2:0x0001 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<C2210d> m13197c(String str) {
        ArrayList arrayList;
        Cursor cursor;
        arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            cursor = f7418a.f7419b.rawQuery("select thread_id, start_pos, end_pos,compelete_size,url from download_info where url=?", new String[]{str});
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(new C2210d(cursor.getInt(0), cursor.getLong(1), cursor.getLong(2), cursor.getLong(3), cursor.getString(4)));
                } catch (Exception e) {
                    e = e;
                    cursor2 = cursor;
                    try {
                        e.printStackTrace();
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        return arrayList;
    }

    /* renamed from: c */
    public synchronized void m13198c() {
        try {
            f7418a.f7419b.execSQL("DELETE FROM download_info");
            f7418a.f7419b.execSQL("DELETE FROM download_task");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public synchronized void m13195d(String str) {
        try {
            f7418a.f7419b.delete("download_info", "url=?", new String[]{str});
            f7418a.f7419b.delete("download_task", "url=?", new String[]{str});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void finalize() {
        this.f7419b.close();
        super.finalize();
    }
}
