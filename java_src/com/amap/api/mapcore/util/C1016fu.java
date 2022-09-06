package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* renamed from: com.amap.api.mapcore.util.fu */
/* loaded from: classes.dex */
public class C1016fu {

    /* renamed from: d */
    private static Map<Class<? extends AbstractC1015ft>, AbstractC1015ft> f3194d = new HashMap();

    /* renamed from: a */
    private C1021fz f3195a;

    /* renamed from: b */
    private SQLiteDatabase f3196b;

    /* renamed from: c */
    private AbstractC1015ft f3197c;

    public C1016fu(Context context, AbstractC1015ft abstractC1015ft) {
        try {
            this.f3195a = new C1021fz(context.getApplicationContext(), abstractC1015ft.mo17858b(), null, abstractC1015ft.mo17857c(), abstractC1015ft);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f3197c = abstractC1015ft;
    }

    /* renamed from: a */
    private ContentValues m17965a(Object obj, AbstractC1017fv abstractC1017fv) {
        Field[] m17967a;
        ContentValues contentValues = new ContentValues();
        for (Field field : m17967a(obj.getClass(), abstractC1017fv.m17949b())) {
            field.setAccessible(true);
            m17963a(obj, field, contentValues);
        }
        return contentValues;
    }

    /* renamed from: a */
    private SQLiteDatabase m17954a(boolean z) {
        try {
            if (this.f3196b == null) {
                this.f3196b = this.f3195a.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (!z) {
                C1002fl.m18028a(th, "DBOperation", "getReadAbleDataBase");
            } else {
                th.printStackTrace();
            }
        }
        return this.f3196b;
    }

    /* renamed from: a */
    public static synchronized AbstractC1015ft m17968a(Class<? extends AbstractC1015ft> cls) {
        AbstractC1015ft abstractC1015ft;
        synchronized (C1016fu.class) {
            if (f3194d.get(cls) == null) {
                f3194d.put(cls, cls.newInstance());
            }
            abstractC1015ft = f3194d.get(cls);
        }
        return abstractC1015ft;
    }

    /* renamed from: a */
    private <T> T m17971a(Cursor cursor, Class<T> cls, AbstractC1017fv abstractC1017fv) {
        Field[] m17967a = m17967a((Class<?>) cls, abstractC1017fv.m17949b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : m17967a) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(AbstractC1018fw.class);
            if (annotation != null) {
                AbstractC1018fw abstractC1018fw = (AbstractC1018fw) annotation;
                int m17947b = abstractC1018fw.m17947b();
                int columnIndex = cursor.getColumnIndex(abstractC1018fw.m17948a());
                switch (m17947b) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        continue;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        continue;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        continue;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        continue;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        continue;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        continue;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        continue;
                }
            }
        }
        return newInstance;
    }

    /* renamed from: a */
    private <T> String m17969a(AbstractC1017fv abstractC1017fv) {
        if (abstractC1017fv == null) {
            return null;
        }
        return abstractC1017fv.m17950a();
    }

    /* renamed from: a */
    public static String m17955a(Map<String, String> map) {
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
    private <T> void m17970a(SQLiteDatabase sQLiteDatabase, T t) {
        ContentValues m17965a;
        AbstractC1017fv m17953b = m17953b(t.getClass());
        String m17969a = m17969a(m17953b);
        if (TextUtils.isEmpty(m17969a) || t == null || sQLiteDatabase == null || (m17965a = m17965a(t, m17953b)) == null) {
            return;
        }
        sQLiteDatabase.insert(m17969a, null, m17965a);
    }

    /* renamed from: a */
    private void m17963a(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(AbstractC1018fw.class);
        if (annotation == null) {
            return;
        }
        AbstractC1018fw abstractC1018fw = (AbstractC1018fw) annotation;
        try {
            switch (abstractC1018fw.m17947b()) {
                case 1:
                    contentValues.put(abstractC1018fw.m17948a(), Short.valueOf(field.getShort(obj)));
                    break;
                case 2:
                    contentValues.put(abstractC1018fw.m17948a(), Integer.valueOf(field.getInt(obj)));
                    break;
                case 3:
                    contentValues.put(abstractC1018fw.m17948a(), Float.valueOf(field.getFloat(obj)));
                    break;
                case 4:
                    contentValues.put(abstractC1018fw.m17948a(), Double.valueOf(field.getDouble(obj)));
                    break;
                case 5:
                    contentValues.put(abstractC1018fw.m17948a(), Long.valueOf(field.getLong(obj)));
                    break;
                case 6:
                    contentValues.put(abstractC1018fw.m17948a(), (String) field.get(obj));
                    break;
                case 7:
                    contentValues.put(abstractC1018fw.m17948a(), (byte[]) field.get(obj));
                    break;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private boolean m17957a(Annotation annotation) {
        return annotation != null;
    }

    /* renamed from: a */
    private Field[] m17967a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        return z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    /* renamed from: b */
    private SQLiteDatabase m17951b(boolean z) {
        try {
            if (this.f3196b == null || this.f3196b.isReadOnly()) {
                if (this.f3196b != null) {
                    this.f3196b.close();
                }
                this.f3196b = this.f3195a.getWritableDatabase();
            }
        } catch (Throwable th) {
            C1002fl.m18028a(th, "DBOperation", "getWriteDatabase");
        }
        return this.f3196b;
    }

    /* renamed from: b */
    private <T> AbstractC1017fv m17953b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(AbstractC1017fv.class);
        if (!m17957a(annotation)) {
            return null;
        }
        return (AbstractC1017fv) annotation;
    }

    /* renamed from: a */
    public <T> List<T> m17960a(String str, Class<T> cls, boolean z) {
        Cursor cursor;
        synchronized (this.f3197c) {
            ArrayList arrayList = new ArrayList();
            AbstractC1017fv m17953b = m17953b(cls);
            String m17969a = m17969a(m17953b);
            if (this.f3196b == null) {
                this.f3196b = m17954a(z);
            }
            if (this.f3196b == null || TextUtils.isEmpty(m17969a) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.f3196b.query(m17969a, null, str, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
            } catch (Throwable th2) {
                th = th2;
                if (!z) {
                    C1002fl.m18028a(th, "DataBase", "searchListData");
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (this.f3196b != null) {
                    this.f3196b.close();
                    this.f3196b = null;
                }
                return arrayList;
            }
            if (cursor == null) {
                this.f3196b.close();
                this.f3196b = null;
                if (cursor != null) {
                    cursor.close();
                }
                if (this.f3196b != null) {
                    this.f3196b.close();
                    this.f3196b = null;
                }
                return arrayList;
            }
            while (cursor.moveToNext()) {
                arrayList.add(m17971a(cursor, cls, m17953b));
            }
            if (cursor != null) {
                cursor.close();
            }
            if (this.f3196b != null) {
                this.f3196b.close();
                this.f3196b = null;
            }
            return arrayList;
        }
    }

    /* renamed from: a */
    public <T> void m17966a(T t) {
        m17962a((C1016fu) t, false);
    }

    /* renamed from: a */
    public void m17964a(Object obj, String str) {
        synchronized (this.f3197c) {
            List m17952b = m17952b(str, obj.getClass());
            if (m17952b == null || m17952b.size() == 0) {
                m17966a((C1016fu) obj);
            } else {
                m17959a(str, obj);
            }
        }
    }

    /* renamed from: a */
    public <T> void m17962a(T t, boolean z) {
        synchronized (this.f3197c) {
            this.f3196b = m17951b(z);
            if (this.f3196b == null) {
                return;
            }
            m17970a(this.f3196b, (SQLiteDatabase) t);
            if (this.f3196b != null) {
                this.f3196b.close();
                this.f3196b = null;
            }
        }
    }

    /* renamed from: a */
    public <T> void m17961a(String str, Class<T> cls) {
        synchronized (this.f3197c) {
            String m17969a = m17969a(m17953b(cls));
            if (TextUtils.isEmpty(m17969a)) {
                return;
            }
            this.f3196b = m17951b(false);
            if (this.f3196b == null) {
                return;
            }
            this.f3196b.delete(m17969a, str, null);
            if (this.f3196b != null) {
                this.f3196b.close();
                this.f3196b = null;
            }
        }
    }

    /* renamed from: a */
    public <T> void m17959a(String str, Object obj) {
        m17958a(str, obj, false);
    }

    /* renamed from: a */
    public <T> void m17958a(String str, Object obj, boolean z) {
        synchronized (this.f3197c) {
            if (obj == null) {
                return;
            }
            AbstractC1017fv m17953b = m17953b(obj.getClass());
            String m17969a = m17969a(m17953b);
            if (TextUtils.isEmpty(m17969a)) {
                return;
            }
            ContentValues m17965a = m17965a(obj, m17953b);
            if (m17965a == null) {
                return;
            }
            this.f3196b = m17951b(z);
            if (this.f3196b == null) {
                return;
            }
            this.f3196b.update(m17969a, m17965a, str, null);
            if (this.f3196b != null) {
                this.f3196b.close();
                this.f3196b = null;
            }
        }
    }

    /* renamed from: a */
    public <T> void m17956a(List<T> list) {
        synchronized (this.f3197c) {
            if (list != null) {
                if (list.size() != 0) {
                    this.f3196b = m17951b(false);
                    if (this.f3196b == null) {
                        return;
                    }
                    this.f3196b.beginTransaction();
                    for (T t : list) {
                        m17970a(this.f3196b, (SQLiteDatabase) t);
                    }
                    this.f3196b.setTransactionSuccessful();
                    if (this.f3196b.inTransaction()) {
                        this.f3196b.endTransaction();
                    }
                    this.f3196b.close();
                    this.f3196b = null;
                }
            }
        }
    }

    /* renamed from: b */
    public <T> List<T> m17952b(String str, Class<T> cls) {
        return m17960a(str, (Class) cls, false);
    }
}
