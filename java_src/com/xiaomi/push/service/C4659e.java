package com.xiaomi.push.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.services.poisearch.PoiSearch;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4493k;
import com.xiaomi.xmpush.thrift.C4809j;
import com.xiaomi.xmpush.thrift.C4812l;
import com.xiaomi.xmpush.thrift.EnumC4806h;
import com.xiaomi.xmpush.thrift.EnumC4811k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.xiaomi.push.service.e */
/* loaded from: classes.dex */
public class C4659e {

    /* renamed from: b */
    private static volatile C4659e f19085b;

    /* renamed from: c */
    private static String f19086c = "GeoFenceDao.";

    /* renamed from: a */
    private C4660f f19087a;

    private C4659e(Context context) {
        this.f19087a = new C4660f(context);
    }

    /* renamed from: a */
    private synchronized Cursor m4272a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        synchronized (this) {
            C4493k.m5004a(false);
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT * FROM geofence", null);
            } catch (Exception e) {
            }
        }
        return cursor;
    }

    /* renamed from: a */
    public static C4659e m4274a(Context context) {
        if (f19085b == null) {
            synchronized (C4659e.class) {
                if (f19085b == null) {
                    f19085b = new C4659e(context);
                }
            }
        }
        return f19085b;
    }

    /* renamed from: a */
    private synchronized EnumC4811k m4273a(Cursor cursor) {
        EnumC4811k enumC4811k;
        try {
            EnumC4811k[] values = EnumC4811k.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    enumC4811k = null;
                    break;
                }
                enumC4811k = values[i];
                if (TextUtils.equals(cursor.getString(cursor.getColumnIndex("type")), enumC4811k.name())) {
                    break;
                }
                i++;
            }
        } catch (Exception e) {
            AbstractC4478b.m5036d(e.toString());
            enumC4811k = null;
        }
        return enumC4811k;
    }

    /* renamed from: a */
    private synchronized String m4268a(List<C4812l> list) {
        String str;
        if (list != null) {
            if (list.size() >= 3) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (C4812l c4812l : list) {
                        if (c4812l != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("point_lantitude", c4812l.m3370c());
                            jSONObject.put("point_longtitude", c4812l.m3378a());
                            jSONArray.put(jSONObject);
                        }
                    }
                    str = jSONArray.toString();
                } catch (JSONException e) {
                    AbstractC4478b.m5036d(e.toString());
                    str = null;
                }
            }
        }
        AbstractC4478b.m5041a(f19086c + " points unvalidated");
        str = null;
        return str;
    }

    /* renamed from: b */
    private synchronized C4812l m4267b(Cursor cursor) {
        C4812l c4812l;
        c4812l = new C4812l();
        try {
            c4812l.m3373b(Double.parseDouble(cursor.getString(cursor.getColumnIndex("center_lantitude"))));
            c4812l.m3377a(Double.parseDouble(cursor.getString(cursor.getColumnIndex("center_longtitude"))));
        } catch (Exception e) {
            AbstractC4478b.m5036d(e.toString());
            c4812l = null;
        }
        return c4812l;
    }

    /* renamed from: c */
    private synchronized ArrayList<C4812l> m4265c(Cursor cursor) {
        ArrayList<C4812l> arrayList;
        ArrayList<C4812l> arrayList2 = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(cursor.getString(cursor.getColumnIndex("polygon_points")));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                C4812l c4812l = new C4812l();
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                c4812l.m3373b(jSONObject.getDouble("point_lantitude"));
                c4812l.m3377a(jSONObject.getDouble("point_longtitude"));
                arrayList2.add(c4812l);
                i = i2 + 1;
            }
            arrayList = arrayList2;
        } catch (JSONException e) {
            AbstractC4478b.m5036d(e.toString());
            arrayList = null;
        }
        return arrayList;
    }

    /* renamed from: d */
    private synchronized EnumC4806h m4263d(Cursor cursor) {
        EnumC4806h enumC4806h;
        try {
            enumC4806h = EnumC4806h.valueOf(cursor.getString(cursor.getColumnIndex("coordinate_provider")));
        } catch (IllegalArgumentException e) {
            AbstractC4478b.m5036d(e.toString());
            enumC4806h = null;
        }
        return enumC4806h;
    }

    /* renamed from: a */
    public synchronized int m4269a(String str, String str2) {
        int i = 0;
        synchronized (this) {
            C4493k.m5004a(false);
            try {
                if ("Enter".equals(str2) || "Leave".equals(str2) || "Unknown".equals(str2)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("current_status", str2);
                    SQLiteDatabase writableDatabase = this.f19087a.getWritableDatabase();
                    int update = writableDatabase.update("geofence", contentValues, "id=?", new String[]{str});
                    writableDatabase.close();
                    i = update;
                }
            } catch (Exception e) {
                AbstractC4478b.m5036d(e.toString());
            }
        }
        return i;
    }

    /* renamed from: a */
    public synchronized long m4271a(C4809j c4809j) {
        long j;
        C4493k.m5004a(false);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", c4809j.m3417a());
            contentValues.put("appId", Long.valueOf(c4809j.m3398e()));
            contentValues.put("name", c4809j.m3402c());
            contentValues.put("package_name", c4809j.m3396g());
            contentValues.put("create_time", Long.valueOf(c4809j.m3394i()));
            contentValues.put("type", c4809j.m3392k().name());
            contentValues.put("center_longtitude", String.valueOf(c4809j.m3390m().m3378a()));
            contentValues.put("center_lantitude", String.valueOf(c4809j.m3390m().m3370c()));
            contentValues.put("circle_radius", Double.valueOf(c4809j.m3388o()));
            contentValues.put("polygon_point", m4268a(c4809j.m3386q()));
            contentValues.put("coordinate_provider", c4809j.m3384s().name());
            contentValues.put("current_status", "Unknown");
            SQLiteDatabase writableDatabase = this.f19087a.getWritableDatabase();
            j = writableDatabase.insert("geofence", null, contentValues);
            writableDatabase.close();
        } catch (Exception e) {
            AbstractC4478b.m5036d(e.toString());
            j = -1;
        }
        return j;
    }

    /* renamed from: a */
    public synchronized C4809j m4270a(String str) {
        C4809j c4809j;
        C4493k.m5004a(false);
        try {
            Iterator<C4809j> it2 = m4275a().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    c4809j = null;
                    break;
                }
                c4809j = it2.next();
                if (TextUtils.equals(c4809j.m3417a(), str)) {
                    break;
                }
            }
        } catch (Exception e) {
            AbstractC4478b.m5036d(e.toString());
            c4809j = null;
        }
        return c4809j;
    }

    /* renamed from: a */
    public synchronized ArrayList<C4809j> m4275a() {
        ArrayList<C4809j> arrayList;
        C4493k.m5004a(false);
        try {
            SQLiteDatabase writableDatabase = this.f19087a.getWritableDatabase();
            Cursor m4272a = m4272a(writableDatabase);
            arrayList = new ArrayList<>();
            if (m4272a != null) {
                while (m4272a.moveToNext()) {
                    try {
                        C4809j c4809j = new C4809j();
                        c4809j.m3410a(m4272a.getString(m4272a.getColumnIndex("id")));
                        c4809j.m3404b(m4272a.getString(m4272a.getColumnIndex("name")));
                        c4809j.m3415a(m4272a.getInt(m4272a.getColumnIndex("appId")));
                        c4809j.m3401c(m4272a.getString(m4272a.getColumnIndex("package_name")));
                        c4809j.m3406b(m4272a.getInt(m4272a.getColumnIndex("create_time")));
                        EnumC4811k m4273a = m4273a(m4272a);
                        if (m4273a == null) {
                            AbstractC4478b.m5037c(f19086c + "findAllGeoFencing: geo type null");
                        } else {
                            c4809j.m3412a(m4273a);
                            if (TextUtils.equals("Circle", m4273a.name())) {
                                c4809j.m3411a(m4267b(m4272a));
                                c4809j.m3416a(m4272a.getDouble(m4272a.getColumnIndex("circle_radius")));
                            } else if (TextUtils.equals(PoiSearch.SearchBound.POLYGON_SHAPE, m4273a.name())) {
                                ArrayList<C4812l> m4265c = m4265c(m4272a);
                                if (m4265c == null || m4265c.size() < 3) {
                                    AbstractC4478b.m5037c(f19086c + "findAllGeoFencing: geo points null or size<3");
                                } else {
                                    c4809j.m3409a(m4265c);
                                }
                            }
                            EnumC4806h m4263d = m4263d(m4272a);
                            if (m4263d == null) {
                                AbstractC4478b.m5037c(f19086c + "findAllGeoFencing: geo Coordinate Provider null ");
                            } else {
                                c4809j.m3414a(m4263d);
                                arrayList.add(c4809j);
                            }
                        }
                    } catch (Exception e) {
                        AbstractC4478b.m5036d(e.toString());
                    }
                }
                m4272a.close();
            }
            writableDatabase.close();
        } catch (Exception e2) {
            AbstractC4478b.m5036d(e2.toString());
            arrayList = null;
        }
        return arrayList;
    }

    /* renamed from: b */
    public synchronized ArrayList<C4809j> m4266b(String str) {
        ArrayList<C4809j> arrayList;
        C4493k.m5004a(false);
        try {
            ArrayList<C4809j> m4275a = m4275a();
            ArrayList<C4809j> arrayList2 = new ArrayList<>();
            Iterator<C4809j> it2 = m4275a.iterator();
            while (it2.hasNext()) {
                C4809j next = it2.next();
                if (TextUtils.equals(next.m3396g(), str)) {
                    arrayList2.add(next);
                }
            }
            arrayList = arrayList2;
        } catch (Exception e) {
            AbstractC4478b.m5036d(e.toString());
            arrayList = null;
        }
        return arrayList;
    }

    /* renamed from: c */
    public synchronized String m4264c(String str) {
        String str2;
        C4493k.m5004a(false);
        try {
            Cursor m4272a = m4272a(this.f19087a.getWritableDatabase());
            if (m4272a != null) {
                while (m4272a.moveToNext()) {
                    if (TextUtils.equals(m4272a.getString(m4272a.getColumnIndex("id")), str)) {
                        str2 = m4272a.getString(m4272a.getColumnIndex("current_status"));
                        AbstractC4478b.m5037c(f19086c + "findGeoStatueByGeoId: geo current statue is " + str2 + " geoId:" + str);
                        m4272a.close();
                        break;
                    }
                }
                m4272a.close();
            }
            str2 = "Unknown";
        } catch (Exception e) {
            AbstractC4478b.m5036d(e.toString());
            str2 = "Unknown";
        }
        return str2;
    }

    /* renamed from: d */
    public synchronized int m4262d(String str) {
        int i;
        C4493k.m5004a(false);
        try {
            if (m4270a(str) != null) {
                SQLiteDatabase writableDatabase = this.f19087a.getWritableDatabase();
                i = writableDatabase.delete("geofence", "id = ?", new String[]{str});
                writableDatabase.close();
            } else {
                i = 0;
            }
        } catch (Exception e) {
            AbstractC4478b.m5036d(e.toString());
            i = 0;
        }
        return i;
    }

    /* renamed from: e */
    public synchronized int m4261e(String str) {
        int i;
        C4493k.m5004a(false);
        try {
            if (!TextUtils.isEmpty(str)) {
                SQLiteDatabase writableDatabase = this.f19087a.getWritableDatabase();
                i = writableDatabase.delete("geofence", "package_name = ?", new String[]{str});
                writableDatabase.close();
            } else {
                i = 0;
            }
        } catch (Exception e) {
            AbstractC4478b.m5036d(e.toString());
            i = 0;
        }
        return i;
    }
}
