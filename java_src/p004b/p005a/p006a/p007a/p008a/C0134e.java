package p004b.p005a.p006a.p007a.p008a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import p004b.p005a.p006a.p007a.p010c.C0140a;
import p004b.p005a.p006a.p007a.p010c.p011a.AbstractC0142b;
import p004b.p005a.p006a.p007a.p010c.p011a.C0143c;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p007a.p025n.AbstractC0232e;
import p004b.p005a.p006a.p007a.p025n.C0243p;
import p004b.p005a.p006a.p007a.p025n.C0245r;
import p004b.p005a.p006a.p028b.AbstractC0554q;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p029a.AbstractC0267a;
/* renamed from: b.a.a.a.a.e */
/* loaded from: classes.dex */
public class C0134e extends AbstractC0554q<AbstractC0231d> {

    /* renamed from: f */
    private static final int f134f = 1;

    /* renamed from: g */
    private static final int f135g = 2;

    /* renamed from: h */
    private static final int f136h = 3;

    /* renamed from: i */
    private static final int f137i = 4;

    /* renamed from: m */
    private static final int f138m = 5;

    /* renamed from: n */
    private static final int f139n = 6;

    /* renamed from: o */
    private static final int f140o = 7;

    /* renamed from: p */
    private static final int f141p = 11;

    /* renamed from: q */
    private static final int f142q = 12;

    /* renamed from: r */
    private static final int f143r = 13;

    /* renamed from: u */
    private static final int f144u = 14;

    /* renamed from: v */
    private static final short f145v = 1;

    /* renamed from: w */
    private static final short f146w = 2;

    /* renamed from: a */
    private SQLiteDatabase f147a;

    /* renamed from: b */
    private String f148b;

    /* renamed from: c */
    private String f149c;

    /* renamed from: d */
    private String f150d;

    /* renamed from: e */
    private AbstractC0142b f151e;

    /* renamed from: a */
    private long m21510a(AbstractC0231d abstractC0231d, SQLiteStatement sQLiteStatement) {
        m21517a(sQLiteStatement, abstractC0231d);
        m21515a(sQLiteStatement, abstractC0231d.mo21218d());
        m21514a(sQLiteStatement, abstractC0231d.mo21213i());
        try {
            return sQLiteStatement.executeInsert();
        } catch (SQLiteException e) {
            c("Failed to insert loggingEvent", e);
            return -1L;
        }
    }

    /* renamed from: a */
    private void m21517a(SQLiteStatement sQLiteStatement, AbstractC0231d abstractC0231d) {
        sQLiteStatement.bindLong(1, abstractC0231d.mo21208n());
        sQLiteStatement.bindString(2, abstractC0231d.mo21217e());
        sQLiteStatement.bindString(3, abstractC0231d.mo21216f());
        sQLiteStatement.bindString(4, abstractC0231d.mo21220b().toString());
        sQLiteStatement.bindString(5, abstractC0231d.mo21222a());
        sQLiteStatement.bindLong(6, m21507b(abstractC0231d));
    }

    /* renamed from: a */
    private void m21516a(SQLiteStatement sQLiteStatement, String str, short s, long j) {
        sQLiteStatement.bindLong(1, j);
        sQLiteStatement.bindLong(2, s);
        sQLiteStatement.bindString(3, str);
        sQLiteStatement.executeInsert();
    }

    /* renamed from: a */
    private void m21515a(SQLiteStatement sQLiteStatement, Object[] objArr) {
        int length = objArr != null ? objArr.length : 0;
        for (int i = 0; i < length && i < 4; i++) {
            sQLiteStatement.bindString(i + 7, m21506b(objArr[i]));
        }
    }

    /* renamed from: a */
    private void m21514a(SQLiteStatement sQLiteStatement, StackTraceElement[] stackTraceElementArr) {
        StackTraceElement stackTraceElement;
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0 || (stackTraceElement = stackTraceElementArr[0]) == null) {
            return;
        }
        sQLiteStatement.bindString(11, stackTraceElement.getFileName());
        sQLiteStatement.bindString(12, stackTraceElement.getClassName());
        sQLiteStatement.bindString(13, stackTraceElement.getMethodName());
        sQLiteStatement.bindString(14, Integer.toString(stackTraceElement.getLineNumber()));
    }

    /* renamed from: a */
    private void m21511a(AbstractC0231d abstractC0231d, long j) {
        m21508a(m21505c(abstractC0231d), j);
        if (abstractC0231d.mo21214h() != null) {
            m21509a(abstractC0231d.mo21214h(), j);
        }
    }

    /* renamed from: a */
    private void m21509a(AbstractC0232e abstractC0232e, long j) {
        SQLiteStatement compileStatement = this.f147a.compileStatement(this.f149c);
        short s = 0;
        while (abstractC0232e != null) {
            try {
                StringBuilder sb = new StringBuilder();
                C0245r.m21177b(sb, abstractC0232e);
                m21516a(compileStatement, sb.toString(), s, j);
                int mo21168d = abstractC0232e.mo21168d();
                C0243p[] mo21169c = abstractC0232e.mo21169c();
                s = (short) (s + f145v);
                int i = 0;
                while (i < mo21169c.length - mo21168d) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('\t');
                    C0245r.m21176b(sb2, mo21169c[i]);
                    String sb3 = sb2.toString();
                    short s2 = (short) (s + f145v);
                    m21516a(compileStatement, sb3, s, j);
                    i++;
                    s = s2;
                }
                if (mo21168d > 0) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append('\t').append("... ").append(mo21168d).append(" common frames omitted");
                    m21516a(compileStatement, sb4.toString(), s, j);
                    s = (short) (s + f145v);
                }
                abstractC0232e = abstractC0232e.mo21167e();
            } finally {
                compileStatement.close();
            }
        }
    }

    /* renamed from: a */
    private void m21508a(Map<String, String> map, long j) {
        if (map.size() > 0) {
            SQLiteStatement compileStatement = this.f147a.compileStatement(this.f148b);
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    compileStatement.bindLong(1, j);
                    compileStatement.bindString(2, entry.getKey());
                    compileStatement.bindString(3, entry.getValue());
                    compileStatement.executeInsert();
                }
            } finally {
                compileStatement.close();
            }
        }
    }

    /* renamed from: b */
    private String m21506b(Object obj) {
        String str = null;
        if (obj != null) {
            str = obj.toString();
        }
        if (str != null && str.length() > 254) {
            str = str.substring(0, 254);
        }
        return str == null ? "" : str;
    }

    /* renamed from: b */
    private static short m21507b(AbstractC0231d abstractC0231d) {
        short s = 0;
        int size = abstractC0231d.mo21210l() != null ? abstractC0231d.mo21210l().keySet().size() : 0;
        int size2 = abstractC0231d.mo21215g().m21240b() != null ? abstractC0231d.mo21215g().m21240b().size() : 0;
        if (size > 0 || size2 > 0) {
            s = f145v;
        }
        return abstractC0231d.mo21214h() != null ? (short) (s | f146w) : s;
    }

    /* renamed from: c */
    private Map<String, String> m21505c(AbstractC0231d abstractC0231d) {
        HashMap hashMap = new HashMap();
        Map<String, String> m21240b = abstractC0231d.mo21215g().m21240b();
        if (m21240b != null) {
            hashMap.putAll(m21240b);
        }
        Map<String, String> mo21210l = abstractC0231d.mo21210l();
        if (mo21210l != null) {
            hashMap.putAll(mo21210l);
        }
        return hashMap;
    }

    /* renamed from: a */
    public void m21513a(AbstractC0142b abstractC0142b) {
        this.f151e = abstractC0142b;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0554q
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo20164a(AbstractC0231d abstractC0231d) {
        if (g_()) {
            try {
                SQLiteStatement compileStatement = this.f147a.compileStatement(this.f150d);
                this.f147a.beginTransaction();
                long m21510a = m21510a(abstractC0231d, compileStatement);
                if (m21510a != -1) {
                    m21511a(abstractC0231d, m21510a);
                    this.f147a.setTransactionSuccessful();
                }
                if (this.f147a.inTransaction()) {
                    this.f147a.endTransaction();
                }
                compileStatement.close();
            } catch (Throwable th) {
                a("Cannot append event", th);
            }
        }
    }

    protected void finalize() {
        this.f147a.close();
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0554q, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        String str = null;
        boolean z = true;
        this.f1224j = false;
        if (h_() != null) {
            str = h_().mo20211a(C0359h.f689S);
        }
        if (str == null || str.length() == 0) {
            c("Cannot create database without package name");
            return;
        }
        try {
            File file = new File(AbstractC0267a.m21096b(str), "logback.db");
            file.getParentFile().mkdirs();
            this.f147a = SQLiteDatabase.openOrCreateDatabase(file.getPath(), (SQLiteDatabase.CursorFactory) null);
        } catch (SQLiteException e) {
            a("Cannot open database", e);
            z = false;
        }
        if (!z) {
            return;
        }
        if (this.f151e == null) {
            this.f151e = new C0143c();
        }
        this.f149c = C0140a.m21497b(this.f151e);
        this.f148b = C0140a.m21498a(this.f151e);
        this.f150d = C0140a.m21496c(this.f151e);
        try {
            this.f147a.execSQL(C0140a.m21495d(this.f151e));
            this.f147a.execSQL(C0140a.m21494e(this.f151e));
            this.f147a.execSQL(C0140a.m21493f(this.f151e));
            super.mo20156j();
            this.f1224j = true;
        } catch (SQLiteException e2) {
            a("Cannot create database tables", e2);
        }
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0554q, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f147a.close();
    }
}
