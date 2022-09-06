package com.fimi.soul.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.utils.w */
/* loaded from: classes.dex */
public class C3707w {

    /* renamed from: a */
    public static C3707w f15123a;

    /* renamed from: b */
    public static final String f15124b = "create table  if not exists " + C3708a.f15128a + "(" + C3708a.f15129b + " varchar(20) not null ," + C3708a.f15130c + " long default 0 ," + C3708a.f15131d + " double default 0," + C3708a.f15133f + " varchar(10) ," + C3708a.f15134g + " double," + C3708a.f15135h + " double," + C3708a.f15132e + " varchar(20) not null)";

    /* renamed from: c */
    private C3679h f15125c;

    /* renamed from: d */
    private SQLiteDatabase f15126d;

    /* renamed from: e */
    private Context f15127e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.utils.w$a */
    /* loaded from: classes.dex */
    public static class C3708a {

        /* renamed from: a */
        public static String f15128a = "flyRecords_tb";

        /* renamed from: b */
        public static String f15129b = "drone_id";

        /* renamed from: c */
        public static String f15130c = "fly_time";

        /* renamed from: d */
        public static String f15131d = "fly_distance";

        /* renamed from: e */
        public static String f15132e = "user_id";

        /* renamed from: f */
        public static String f15133f = "deviceType";

        /* renamed from: g */
        public static String f15134g = "latitude";

        /* renamed from: h */
        public static String f15135h = "longitude";

        C3708a() {
        }
    }

    public C3707w(Context context) {
        this.f15127e = context;
        this.f15125c = C3679h.m7485a(context);
        this.f15126d = this.f15125c.getWritableDatabase();
    }

    /* renamed from: a */
    public static C3707w m7410a(Context context) {
        if (f15123a == null) {
            f15123a = new C3707w(context);
        }
        return f15123a;
    }

    /* renamed from: b */
    private ContentValues m7407b(C3709x c3709x) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C3708a.f15130c, Long.valueOf(c3709x.m7395d()));
        contentValues.put(C3708a.f15131d, Double.valueOf(c3709x.m7394e()));
        contentValues.put(C3708a.f15129b, c3709x.m7398c());
        contentValues.put(C3708a.f15132e, c3709x.m7401b());
        contentValues.put(C3708a.f15133f, c3709x.m7405a());
        contentValues.put(C3708a.f15134g, Double.valueOf(c3709x.m7393f()));
        contentValues.put(C3708a.f15135h, Double.valueOf(c3709x.m7392g()));
        return contentValues;
    }

    /* renamed from: a */
    public List<C3709x> m7408a(String str) {
        Cursor query;
        ArrayList arrayList = null;
        if (str == null || "".equals(str) || (query = this.f15126d.query(C3708a.f15128a, new String[]{C3708a.f15132e, C3708a.f15129b, C3708a.f15130c, C3708a.f15131d, C3708a.f15133f, C3708a.f15134g, C3708a.f15135h}, C3708a.f15132e + " = ? ", new String[]{str}, null, null, null)) == null || query.getCount() <= 0) {
            return arrayList;
        }
        arrayList = new ArrayList();
        query.moveToFirst();
        do {
            C3709x c3709x = new C3709x();
            c3709x.m7399b(str);
            c3709x.m7403a(query.getLong(query.getColumnIndex(C3708a.f15130c)));
            c3709x.m7404a(query.getDouble(query.getColumnIndex(C3708a.f15131d)));
            c3709x.m7402a(query.getString(query.getColumnIndex(C3708a.f15133f)));
            c3709x.m7400b(query.getDouble(query.getColumnIndex(C3708a.f15134g)));
            c3709x.m7397c(query.getDouble(query.getColumnIndex(C3708a.f15135h)));
            arrayList.add(c3709x);
        } while (query.moveToNext());
        return arrayList;
    }

    /* renamed from: a */
    public void m7409a(C3709x c3709x) {
        this.f15126d.insert(C3708a.f15128a, null, m7407b(c3709x));
    }

    /* renamed from: b */
    public boolean m7406b(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return this.f15126d.delete(C3708a.f15128a, new StringBuilder().append(C3708a.f15132e).append(" = ? ").toString(), new String[]{str}) > 0;
    }
}
