package com.baidu.tts.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p106k.C1728a;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.SqlTool;
import com.baidu.tts.tools.StringTool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* renamed from: com.baidu.tts.database.a */
/* loaded from: classes.dex */
public class C1691a {

    /* renamed from: a */
    private C1728a f5957a;

    /* renamed from: b */
    private C1692b f5958b;

    /* renamed from: c */
    private ReadWriteLock f5959c = new ReentrantReadWriteLock();

    /* renamed from: d */
    private Lock f5960d = this.f5959c.writeLock();

    /* renamed from: e */
    private Lock f5961e = this.f5959c.readLock();

    public C1691a(C1728a c1728a) {
        this.f5957a = c1728a;
        this.f5958b = new C1692b(this.f5957a.m14817d());
    }

    /* renamed from: a */
    private SQLiteDatabase m14923a() {
        return this.f5958b.getWritableDatabase();
    }

    /* renamed from: b */
    private SQLiteDatabase m14914b() {
        return this.f5958b.getReadableDatabase();
    }

    /* renamed from: a */
    public int m14919a(String str) {
        int i;
        this.f5960d.lock();
        try {
            SQLiteDatabase m14923a = m14923a();
            try {
                i = SpeechModelTable.m14925a(m14923a, str);
                this.f5960d.unlock();
            } catch (Exception e) {
                i = -1;
                this.f5960d.unlock();
            } finally {
                m14923a.close();
            }
            return i;
        } catch (Throwable th) {
            this.f5960d.unlock();
            throw th;
        }
    }

    /* renamed from: a */
    public String m14917a(String str, String str2) {
        Map<String, String> m14916a = m14916a("select b.absPath from speechModel a left join modelFile b on a." + str + "=b.id where a.id=?", new String[]{str2});
        if (m14916a != null) {
            return m14916a.get(EnumC1704g.ABS_PATH.m14896b());
        }
        return null;
    }

    /* renamed from: a */
    public List<Map<String, String>> m14922a(Conditions conditions) {
        String version = conditions.getVersion();
        String str = null;
        String[] strArr = null;
        if (!StringTool.isEmpty(version)) {
            str = "version_min <= ? and version_max >= ?";
            strArr = new String[]{version, version};
        }
        String[] domainArray = conditions.getDomainArray();
        String[] languageArray = conditions.getLanguageArray();
        String[] qualityArray = conditions.getQualityArray();
        String[] genderArray = conditions.getGenderArray();
        String[] speakerArray = conditions.getSpeakerArray();
        String[] modelIdsArray = conditions.getModelIdsArray();
        String buildConditions = SqlTool.buildConditions("and", str, SqlTool.buildInCondition("domain", domainArray), SqlTool.buildInCondition("language", languageArray), SqlTool.buildInCondition("quality", qualityArray), SqlTool.buildInCondition("gender", genderArray), SqlTool.buildInCondition("speaker", speakerArray), SqlTool.buildInCondition("id", modelIdsArray));
        if (StringTool.isEmpty(buildConditions)) {
            return null;
        }
        return m14912b("select * from speechModel where " + buildConditions, DataTool.connect(strArr, domainArray, languageArray, qualityArray, genderArray, speakerArray, modelIdsArray));
    }

    /* renamed from: a */
    public List<Map<String, String>> m14915a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        String[] fromSetToArray = DataTool.fromSetToArray(set);
        return m14912b("select * from modelFile where " + SqlTool.buildInCondition("id", fromSetToArray), fromSetToArray);
    }

    /* renamed from: a */
    public Map<String, String> m14916a(String str, String[] strArr) {
        Exception exc;
        HashMap hashMap;
        HashMap hashMap2;
        this.f5961e.lock();
        try {
            SQLiteDatabase m14914b = m14914b();
            try {
                Cursor rawQuery = m14914b.rawQuery(str, strArr);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        hashMap2 = new HashMap();
                        try {
                            String[] columnNames = rawQuery.getColumnNames();
                            int length = columnNames.length;
                            for (int i = 0; i < length; i++) {
                                hashMap2.put(columnNames[i], rawQuery.getString(rawQuery.getColumnIndex(columnNames[i])));
                            }
                        } catch (Exception e) {
                            hashMap = hashMap2;
                            exc = e;
                            exc.printStackTrace();
                            if (m14914b != null) {
                                m14914b.close();
                            }
                            return hashMap;
                        }
                    } else {
                        hashMap2 = null;
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    hashMap = hashMap2;
                } else {
                    hashMap = null;
                }
                if (m14914b != null) {
                    m14914b.close();
                }
            } catch (Exception e2) {
                exc = e2;
                hashMap = null;
            }
            return hashMap;
        } finally {
            this.f5961e.unlock();
        }
    }

    /* renamed from: a */
    public void m14921a(ModelBags modelBags) {
        this.f5960d.lock();
        try {
            SpeechModelTable.m14926a(m14923a(), modelBags);
        } finally {
            this.f5960d.unlock();
        }
    }

    /* renamed from: a */
    public void m14920a(ModelFileBags modelFileBags) {
        this.f5960d.lock();
        try {
            ModelFileTable.m14930a(m14923a(), modelFileBags);
        } finally {
            this.f5960d.unlock();
        }
    }

    /* renamed from: a */
    public void m14918a(String str, int i) {
        this.f5960d.lock();
        try {
            String[] strArr = {str, String.valueOf(i)};
            SQLiteDatabase m14923a = m14923a();
            m14923a.execSQL("replace into fsFileInfo (absPath,state) values (?, ?)", strArr);
            m14923a.close();
        } finally {
            this.f5960d.unlock();
        }
    }

    /* renamed from: b */
    public int m14913b(String str) {
        int i;
        this.f5960d.lock();
        try {
            SQLiteDatabase m14923a = m14923a();
            try {
                i = ModelFileTable.m14929a(m14923a, str);
                this.f5960d.unlock();
            } catch (Exception e) {
                i = -1;
                this.f5960d.unlock();
            } finally {
                m14923a.close();
            }
            return i;
        } catch (Throwable th) {
            this.f5960d.unlock();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045 A[Catch: all -> 0x0066, Exception -> 0x006d, TRY_LEAVE, TryCatch #0 {Exception -> 0x006d, blocks: (B:5:0x000b, B:7:0x0015, B:9:0x001b, B:10:0x001f, B:12:0x0028, B:14:0x003a, B:18:0x0045), top: B:4:0x000b }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Map<String, String>> m14912b(String str, String[] strArr) {
        Exception e;
        ArrayList arrayList;
        SQLiteDatabase sQLiteDatabase = null;
        this.f5961e.lock();
        try {
            try {
                arrayList = new ArrayList();
                try {
                    sQLiteDatabase = m14914b();
                    Cursor rawQuery = sQLiteDatabase.rawQuery(str, strArr);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            String[] columnNames = rawQuery.getColumnNames();
                            do {
                                HashMap hashMap = new HashMap();
                                int length = columnNames.length;
                                for (int i = 0; i < length; i++) {
                                    hashMap.put(columnNames[i], rawQuery.getString(rawQuery.getColumnIndex(columnNames[i])));
                                }
                                arrayList.add(hashMap);
                            } while (rawQuery.moveToNext());
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                        } else if (rawQuery != null) {
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return arrayList;
                }
            } catch (Exception e3) {
                e = e3;
                arrayList = null;
            }
            return arrayList;
        } finally {
            this.f5961e.unlock();
        }
    }

    /* renamed from: c */
    public Map<String, String> m14911c(String str) {
        return m14916a("select * from fsFileInfo where absPath=?", new String[]{str});
    }

    /* renamed from: d */
    public Map<String, String> m14910d(String str) {
        return m14916a("select * from modelFile where id=?", new String[]{str});
    }

    /* renamed from: e */
    public Map<String, String> m14909e(String str) {
        return m14916a("select * from speechModel where id=?", new String[]{str});
    }
}
