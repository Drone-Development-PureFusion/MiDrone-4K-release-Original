package com.p080b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.fimi.soul.utils.p211a.C3628c;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.tencent.p227mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONObject;
/* renamed from: com.b.bg */
/* loaded from: classes.dex */
public class C1461bg {

    /* renamed from: a */
    private static C1461bg f5076a = null;

    /* renamed from: b */
    private String f5077b = "2.0.201501131131".replace(".", "");

    /* renamed from: c */
    private String f5078c = null;

    /* renamed from: a */
    public static synchronized C1461bg m16100a() {
        C1461bg c1461bg;
        synchronized (C1461bg.class) {
            if (f5076a == null) {
                f5076a = new C1461bg();
            }
            c1461bg = f5076a;
        }
        return c1461bg;
    }

    /* renamed from: a */
    private boolean m16096a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT count(*) as c FROM sqlite_master WHERE type = 'table' AND name = '");
                sb.append(str.trim()).append(this.f5077b).append("' ");
                cursor2 = sQLiteDatabase.rawQuery(sb.toString(), null);
                if (cursor2 != null) {
                    try {
                        if (cursor2.moveToFirst() && cursor2.getInt(0) > 0) {
                            z = true;
                        }
                    } catch (Exception e) {
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        return true;
                    }
                }
                sb.delete(0, sb.length());
            } catch (Exception e2) {
                cursor = cursor2;
            }
        } finally {
            if (cursor2 != null) {
                cursor2.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02c1 A[LOOP:0: B:24:0x007f->B:42:0x02c1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0168 A[EDGE_INSN: B:43:0x0168->B:62:0x0168 ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m16099a(Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        if (context != null) {
            SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            if (m16096a(openOrCreateDatabase, "hist")) {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT feature, nb, loc FROM ");
                sb.append("hist").append(this.f5077b);
                sb.append(" WHERE time > ").append(C1477bs.m16020a() - Util.MILLSECONDS_OF_DAY);
                sb.append(" ORDER BY time ASC").append(";");
                Cursor rawQuery = openOrCreateDatabase.rawQuery(sb.toString(), null);
                StringBuilder sb2 = new StringBuilder();
                if (this.f5078c == null) {
                    this.f5078c = C1456bd.m16134a("MD5", context.getPackageName());
                }
                if (rawQuery != null && rawQuery.moveToFirst()) {
                    int i = 0;
                    while (true) {
                        if (rawQuery.getString(0).startsWith("{")) {
                            jSONObject = new JSONObject(rawQuery.getString(0));
                            sb2.delete(0, sb2.length());
                            if (!TextUtils.isEmpty(rawQuery.getString(1))) {
                                sb2.append(rawQuery.getString(1));
                            } else if (C1477bs.m16000a(jSONObject, "mmac")) {
                                sb2.append("#").append(jSONObject.getString("mmac"));
                                sb2.append(",access");
                            }
                            jSONObject2 = new JSONObject(rawQuery.getString(2));
                            if (C1477bs.m16000a(jSONObject2, "type")) {
                                jSONObject2.put("type", "new");
                            }
                        } else {
                            jSONObject = new JSONObject(new String(C1456bd.m16126d(C1544dr.m15603b(rawQuery.getString(0)), this.f5078c), "UTF-8"));
                            sb2.delete(0, sb2.length());
                            if (!TextUtils.isEmpty(rawQuery.getString(1))) {
                                sb2.append(new String(C1456bd.m16126d(C1544dr.m15603b(rawQuery.getString(1)), this.f5078c), "UTF-8"));
                            } else if (C1477bs.m16000a(jSONObject, "mmac")) {
                                sb2.append("#").append(jSONObject.getString("mmac"));
                                sb2.append(",access");
                            }
                            jSONObject2 = new JSONObject(new String(C1456bd.m16126d(C1544dr.m15603b(rawQuery.getString(2)), this.f5078c), "UTF-8"));
                            if (C1477bs.m16000a(jSONObject2, "type")) {
                                jSONObject2.put("type", "new");
                            }
                        }
                        int i2 = i + 1;
                        AmapLoc amapLoc = new AmapLoc(jSONObject2);
                        if (!C1477bs.m16000a(jSONObject, "mmac") || !C1477bs.m16000a(jSONObject, "cgi")) {
                            if (C1477bs.m16000a(jSONObject, "cgi")) {
                                String str2 = (jSONObject.getString("cgi") + "#") + "network#";
                                if (jSONObject.getString("cgi").contains("#")) {
                                    str = str2 + "cgi";
                                }
                            }
                            if (rawQuery.moveToNext()) {
                                break;
                            }
                            i = i2;
                        } else {
                            String str3 = (jSONObject.getString("cgi") + "#") + "network#";
                            str = jSONObject.getString("cgi").contains("#") ? str3 + "cgiwifi" : str3 + "wifi";
                        }
                        C1459bf.m16116a().m16112a(str + "&" + amapLoc.m16528e() + "&" + amapLoc.m16526f(), sb2, amapLoc, context, false);
                        if (rawQuery.moveToNext()) {
                        }
                    }
                }
                sb2.delete(0, sb2.length());
                if (rawQuery != null) {
                    rawQuery.close();
                }
                sb.delete(0, sb.length());
                if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                    openOrCreateDatabase.close();
                }
            } else if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                openOrCreateDatabase.close();
            }
        }
    }

    /* renamed from: a */
    public void m16098a(Context context, int i) {
        String str;
        String[] strArr = null;
        if (context == null) {
            return;
        }
        SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
        if (!m16096a(openOrCreateDatabase, "hist")) {
            if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
                return;
            }
            openOrCreateDatabase.close();
            return;
        }
        switch (i) {
            case 1:
                str = "time<?";
                strArr = new String[]{String.valueOf(C1477bs.m16020a() - Util.MILLSECONDS_OF_DAY)};
                break;
            case 2:
                str = "1";
                break;
            default:
                str = null;
                break;
        }
        try {
            openOrCreateDatabase.delete("hist" + this.f5077b, str, strArr);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "DB", "clearHist");
            String message = th.getMessage();
            if (TextUtils.isEmpty(message) || message.contains("no such table")) {
            }
        }
        if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
            return;
        }
        openOrCreateDatabase.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void m16097a(Context context, String str, String str2, long j) {
        SQLiteDatabase sQLiteDatabase;
        StringBuilder sb;
        if (!TextUtils.isEmpty(str) && context != null) {
            String m15987c = C1477bs.m15987c(str);
            String m15987c2 = C1477bs.m15987c(str2);
            try {
                sb = new StringBuilder();
                sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = null;
            }
            try {
                sb.append("CREATE TABLE IF NOT EXISTS ").append("hm");
                sb.append(this.f5077b);
                sb.append(" (hash VARCHAR PRIMARY KEY, num INTEGER, extra VARCHAR, time VARCHAR);");
                sQLiteDatabase.execSQL(sb.toString());
                sb.delete(0, sb.length());
                sb.append("SELECT num FROM ").append("hm");
                sb.append(this.f5077b);
                sb.append(" WHERE hash = '").append(m15987c).append("';");
                Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                int i = (rawQuery == null || !rawQuery.moveToNext()) ? 0 : rawQuery.getInt(0);
                if (i > 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("num", Integer.valueOf(i + 1));
                    contentValues.put("extra", m15987c2);
                    contentValues.put(C3628c.C3629a.f14776i, Long.valueOf(j));
                    sQLiteDatabase.update("hm" + this.f5077b, contentValues, "hash = '" + m15987c + "'", null);
                } else {
                    sb.delete(0, sb.length());
                    sb.append("REPLACE INTO ");
                    sb.append("hm").append(this.f5077b);
                    sb.append(" VALUES (?, ?, ?, ?)");
                    sQLiteDatabase.execSQL(sb.toString(), new Object[]{m15987c, 1, m15987c2, Long.valueOf(j)});
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                sb.delete(0, sb.length());
                if (sQLiteDatabase != 0 && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m16095a(String str, AmapLoc amapLoc, StringBuilder sb, Context context) {
        if (context == null) {
            return;
        }
        if (this.f5078c == null) {
            this.f5078c = C1456bd.m16134a("MD5", context.getPackageName());
        }
        JSONObject jSONObject = new JSONObject();
        if (str.contains("&")) {
            str = str.substring(0, str.indexOf("&"));
        }
        String substring = str.substring(str.lastIndexOf("#") + 1);
        if (substring.equals("cgi")) {
            jSONObject.put("cgi", str.substring(0, str.length() - ((C3947a.f16908s.length() + 2) + "cgi".length())));
        } else if (!TextUtils.isEmpty(sb) && sb.indexOf("access") != -1) {
            jSONObject.put("cgi", str.substring(0, str.length() - (substring.length() + (C3947a.f16908s.length() + 2))));
            String[] split = sb.toString().split(",access");
            jSONObject.put("mmac", split[0].contains("#") ? split[0].substring(split[0].lastIndexOf("#") + 1) : split[0]);
        }
        if (!C1477bs.m16000a(jSONObject, "cgi") && !C1477bs.m16000a(jSONObject, "mmac")) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
        sb2.append("CREATE TABLE IF NOT EXISTS ").append("hist");
        sb2.append(this.f5077b);
        sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
        openOrCreateDatabase.execSQL(sb2.toString());
        sb2.delete(0, sb2.length());
        sb2.append("REPLACE INTO ");
        sb2.append("hist").append(this.f5077b);
        sb2.append(" VALUES (?, ?, ?, ?)");
        Object[] objArr = new Object[4];
        objArr[0] = C1456bd.m16127c(jSONObject.toString().getBytes("UTF-8"), this.f5078c);
        objArr[1] = C1456bd.m16127c(sb.toString().getBytes("UTF-8"), this.f5078c);
        objArr[2] = C1456bd.m16127c(amapLoc.m16550F().getBytes("UTF-8"), this.f5078c);
        objArr[3] = Long.valueOf(amapLoc.m16516k());
        for (int i = 0; i < objArr.length - 1; i++) {
            objArr[i] = C1544dr.m15602b((byte[]) objArr[i]);
        }
        openOrCreateDatabase.execSQL(sb2.toString(), objArr);
        sb2.delete(0, sb2.length());
        sb2.append("SELECT COUNT(*) AS total FROM ");
        sb2.append("hist").append(this.f5077b).append(";");
        Cursor rawQuery = openOrCreateDatabase.rawQuery(sb2.toString(), null);
        if (rawQuery == null || rawQuery.moveToFirst()) {
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        sb2.delete(0, sb2.length());
        if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
            return;
        }
        openOrCreateDatabase.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a6 A[Catch: Throwable -> 0x00f1, TRY_LEAVE, TryCatch #2 {all -> 0x00cd, blocks: (B:12:0x000e, B:15:0x0018, B:17:0x001e, B:23:0x0031, B:50:0x00b7, B:26:0x003b, B:28:0x0052, B:30:0x007c, B:32:0x0082, B:34:0x0094, B:35:0x009b, B:39:0x00a6, B:45:0x00e1), top: B:11:0x000e }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized ArrayList<String> m16093b(Context context, int i) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        SQLiteDatabase openOrCreateDatabase;
        String str;
        String[] strArr;
        ArrayList<String> arrayList = null;
        synchronized (this) {
            if (context != null) {
                try {
                    openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                } catch (Throwable th2) {
                    sQLiteDatabase = null;
                    th = th2;
                }
                try {
                    if (!m16096a(openOrCreateDatabase, "hm")) {
                        if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                            openOrCreateDatabase.close();
                        }
                        SQLiteDatabase sQLiteDatabase2 = null;
                        if (0 != 0 && sQLiteDatabase2.isOpen()) {
                            sQLiteDatabase2.close();
                        }
                    } else {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        switch (i) {
                            case 1:
                                str = "time<?";
                                strArr = new String[]{String.valueOf(C1477bs.m16020a() - 1209600000)};
                                break;
                            case 2:
                                str = "1";
                                strArr = null;
                                break;
                            default:
                                strArr = null;
                                str = null;
                                break;
                        }
                        String str2 = "hm" + this.f5077b;
                        if (strArr != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SELECT hash, num, extra FROM ");
                            sb.append(str2);
                            sb.append(" WHERE time < ").append(strArr[0]).append(";");
                            Cursor rawQuery = openOrCreateDatabase.rawQuery(sb.toString(), null);
                            if (rawQuery == null || !rawQuery.moveToFirst()) {
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                                    openOrCreateDatabase.close();
                                }
                                arrayList = arrayList2;
                            } else {
                                do {
                                    String string = rawQuery.getString(0);
                                    String string2 = rawQuery.getString(2);
                                    if (!string2.startsWith("{")) {
                                        string = C1477bs.m15983d(string);
                                        C1477bs.m15983d(string2);
                                    }
                                    arrayList2.add(string);
                                } while (rawQuery.moveToNext());
                                if (rawQuery != null) {
                                }
                                if (openOrCreateDatabase != null) {
                                    openOrCreateDatabase.close();
                                }
                                arrayList = arrayList2;
                            }
                        } else {
                            openOrCreateDatabase.delete(str2, str, strArr);
                            if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                                openOrCreateDatabase.close();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = openOrCreateDatabase;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb A[Catch: all -> 0x00f4, TRY_LEAVE, TryCatch #2 {all -> 0x00f4, blocks: (B:10:0x0013, B:13:0x001d, B:15:0x0023, B:21:0x0036, B:25:0x0077, B:27:0x0080, B:28:0x0084, B:30:0x00a2, B:31:0x00aa, B:35:0x00bb, B:22:0x006c), top: B:9:0x0013 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m16094b(Context context) {
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (this) {
            if (C1443av.f5007a && context != null) {
                try {
                    SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                    try {
                        if (!m16096a(openOrCreateDatabase, "hm")) {
                            if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                                openOrCreateDatabase.close();
                            }
                            SQLiteDatabase sQLiteDatabase2 = null;
                            if (0 != 0 && sQLiteDatabase2.isOpen()) {
                                sQLiteDatabase2.close();
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SELECT hash, num, extra, time FROM ");
                            sb.append("hm").append(this.f5077b);
                            sb.append(" WHERE time > ").append(C1477bs.m16020a() - 1209600000);
                            sb.append(" ORDER BY num DESC LIMIT 0,");
                            sb.append(500).append(";");
                            Cursor rawQuery = openOrCreateDatabase.rawQuery(sb.toString(), null);
                            sb.delete(0, sb.length());
                            if (rawQuery != null) {
                                rawQuery.moveToFirst();
                                int i = 0;
                                do {
                                    i++;
                                    String string = rawQuery.getString(0);
                                    int i2 = rawQuery.getInt(1);
                                    String string2 = rawQuery.getString(2);
                                    long j = rawQuery.getLong(3);
                                    if (!string2.startsWith("{")) {
                                        string = C1477bs.m15983d(string);
                                        string2 = C1477bs.m15983d(string2);
                                    }
                                    C1463bi.m16090a().m16087a(context, string, string2, i2, j, false);
                                } while (rawQuery.moveToNext());
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                                    openOrCreateDatabase.close();
                                }
                            } else {
                                if (rawQuery != null) {
                                }
                                if (openOrCreateDatabase != null) {
                                    openOrCreateDatabase.close();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase = openOrCreateDatabase;
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }
}
