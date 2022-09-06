package com.fimi.soul.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.fimi.soul.drone.p200f.C2845b;
import com.fimi.soul.drone.p203i.C2907bk;
import com.fimi.soul.entity.UpdateDroneItem;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.tencent.p227mm.sdk.conversation.RConversation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.fimi.soul.utils.av */
/* loaded from: classes.dex */
public class C3670av {

    /* renamed from: a */
    public static final String f14874a = "route";

    /* renamed from: b */
    public static final String f14875b = "flydata";

    /* renamed from: f */
    private static final String f14876f = "waypoint";

    /* renamed from: g */
    private static final String f14877g = "latitude";

    /* renamed from: h */
    private static final String f14878h = "longitude";

    /* renamed from: i */
    private static final String f14879i = "height";

    /* renamed from: j */
    private static final String f14880j = "sequence";

    /* renamed from: k */
    private static final String f14881k = "link";

    /* renamed from: l */
    private static final String f14882l = "type";

    /* renamed from: m */
    private static final String f14883m = "flyOver";

    /* renamed from: n */
    private static final String f14884n = "create table if not exists route (id integer primary key autoincrement,planeID varchar(30),record_time varchar(30),user_id long,year integer,month integer,distance double,sportTime double,maxhight double,endddata varchar(30),uploadurl text,flag integer);";

    /* renamed from: o */
    private static final String f14885o = "create table if not exists flydata(id integer primary key autoincrement,user_id long,latitude double,longitude double,record_time varchar(30),altitude double,distance double,speed double,model text,sporttime doule,satellitenum integer,endddata varchar(30));";

    /* renamed from: p */
    private static final String f14886p = "create table if not exists flyid(id integer primary key autoincrement,user_id long,cloud_deck_ID text,receiver_control_ID text,fly_control_ID text,remote_control_ID text);";

    /* renamed from: q */
    private static final String f14887q = "create table if not exists waypoint (latitude double ,longitude double ,height integer ,sequence integer ,link bit ,type integer ,flyOver bit );";

    /* renamed from: r */
    private static final String f14888r = "latitude,longitude,height,sequence,link,type,flyOver";

    /* renamed from: c */
    private C3679h f14889c;

    /* renamed from: d */
    private SQLiteDatabase f14890d;

    /* renamed from: e */
    private Context f14891e;

    public C3670av(Context context) {
        this.f14889c = C3679h.m7485a(context);
        this.f14891e = context;
    }

    /* renamed from: a */
    private ContentValues m7524a(C2907bk c2907bk) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f14883m, Integer.valueOf(c2907bk.m10346g()));
        contentValues.put("height", Integer.valueOf(c2907bk.m10353c()));
        contentValues.put(f14877g, Double.valueOf(c2907bk.m10355b().latitude));
        contentValues.put(f14878h, Double.valueOf(c2907bk.m10355b().longitude));
        contentValues.put(f14881k, Integer.valueOf(c2907bk.m10349e()));
        contentValues.put(f14880j, Integer.valueOf(c2907bk.m10351d()));
        contentValues.put("type", Integer.valueOf(c2907bk.m10347f()));
        return contentValues;
    }

    /* renamed from: a */
    private C2907bk m7526a(Cursor cursor) {
        C2907bk c2907bk = new C2907bk();
        c2907bk.m10348e(cursor.getInt(cursor.getColumnIndex(f14883m)));
        c2907bk.m10358a(cursor.getInt(cursor.getColumnIndex("height")));
        c2907bk.m10357a(new LatLng(cursor.getDouble(cursor.getColumnIndex(f14877g)), cursor.getDouble(cursor.getColumnIndex(f14878h))));
        c2907bk.m10354b(cursor.getInt(cursor.getColumnIndex(f14880j)));
        c2907bk.m10350d(cursor.getInt(cursor.getColumnIndex("type")));
        c2907bk.m10352c(cursor.getInt(cursor.getColumnIndex(f14881k)));
        return c2907bk;
    }

    /* renamed from: a */
    public static void m7525a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f14887q);
        sQLiteDatabase.execSQL(f14884n);
        sQLiteDatabase.execSQL(f14885o);
        sQLiteDatabase.execSQL(f14886p);
    }

    /* renamed from: a */
    public int m7527a(ContentValues contentValues, String str) {
        this.f14890d = this.f14889c.getWritableDatabase();
        return Long.valueOf(this.f14890d.insert(str, null, contentValues)).intValue();
    }

    /* renamed from: a */
    public int m7522a(String str, int i) {
        this.f14890d = this.f14889c.getWritableDatabase();
        return this.f14890d.delete(str, "id=?", new String[]{Integer.toString(i)});
    }

    /* renamed from: a */
    public int m7521a(String str, ContentValues contentValues, String str2, String str3) {
        this.f14890d = this.f14889c.getWritableDatabase();
        return this.f14890d.update(str, contentValues, "record_time=? and user_id=?", new String[]{str2, str3});
    }

    /* renamed from: a */
    public int m7520a(String str, UpdateDroneItem updateDroneItem, String str2) {
        this.f14890d = this.f14889c.getWritableDatabase();
        return this.f14890d.delete(str, "record_time=? and user_id=?", new String[]{updateDroneItem.getRecord_time(), str2});
    }

    /* renamed from: a */
    public int m7518a(String str, List<UpdateDroneItem> list, String str2) {
        this.f14890d = this.f14889c.getWritableDatabase();
        Iterator<UpdateDroneItem> it2 = list.iterator();
        int i = 0;
        while (it2.hasNext()) {
            i = this.f14890d.delete(str, "record_time=? and user_id=?", new String[]{it2.next().getRecord_time(), str2}) == 1 ? i + 1 : i;
        }
        return i;
    }

    /* renamed from: a */
    public List<C2845b> m7523a(String str) {
        ArrayList arrayList = null;
        this.f14890d = this.f14889c.getWritableDatabase();
        Cursor rawQuery = this.f14890d.rawQuery(str, null);
        if (rawQuery.getCount() > 0) {
            arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                C2845b c2845b = new C2845b();
                c2845b.m10816a(rawQuery.getDouble(rawQuery.getColumnIndex(f14877g)));
                c2845b.m10811b(rawQuery.getDouble(rawQuery.getColumnIndex(f14878h)));
                c2845b.m10808c(rawQuery.getDouble(rawQuery.getColumnIndex("altitude")));
                c2845b.m10813a(rawQuery.getString(rawQuery.getColumnIndex("record_time")));
                c2845b.m10805d(rawQuery.getDouble(rawQuery.getColumnIndex("distance")));
                c2845b.m10803e(rawQuery.getDouble(rawQuery.getColumnIndex("speed")));
                c2845b.m10810b(rawQuery.getString(rawQuery.getColumnIndex(C3947a.f16893d)));
                c2845b.m10801f(rawQuery.getDouble(rawQuery.getColumnIndex("sporttime")));
                c2845b.m10815a(rawQuery.getInt(rawQuery.getColumnIndex("satellitenum")));
                c2845b.m10807c(rawQuery.getString(rawQuery.getColumnIndex("endddata")));
                arrayList.add(c2845b);
            }
            rawQuery.close();
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<UpdateDroneItem> m7519a(String str, String str2) {
        ArrayList arrayList = null;
        if (str2 != null) {
            this.f14890d = this.f14889c.getWritableDatabase();
            Cursor query = this.f14890d.query(str, null, "user_id=?", new String[]{str2}, null, null, "month");
            if (query.getCount() > 0) {
                arrayList = new ArrayList();
            }
            while (query.moveToNext()) {
                UpdateDroneItem updateDroneItem = new UpdateDroneItem();
                updateDroneItem.setDistance(query.getDouble(query.getColumnIndex("distance")));
                updateDroneItem.setEndddata(query.getString(query.getColumnIndex("endddata")));
                updateDroneItem.setMaxhight(query.getDouble(query.getColumnIndex("maxhight")));
                updateDroneItem.setMonth(query.getInt(query.getColumnIndex("month")));
                updateDroneItem.setRecord_time(query.getString(query.getColumnIndex("record_time")));
                updateDroneItem.setSportTime(query.getDouble(query.getColumnIndex("sportTime")));
                updateDroneItem.setUploadurl(query.getString(query.getColumnIndex("uploadurl")));
                updateDroneItem.setUser_id(query.getLong(query.getColumnIndex("user_id")));
                updateDroneItem.setUser_id(query.getLong(query.getColumnIndex("planeID")));
                updateDroneItem.setYear(query.getInt(query.getColumnIndex("year")));
                updateDroneItem.setFlag(query.getInt(query.getColumnIndex(RConversation.COL_FLAG)));
                updateDroneItem.setPlaneID(query.getLong(query.getColumnIndex("planeID")) + "");
                arrayList.add(updateDroneItem);
            }
            query.close();
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m7528a() {
        this.f14890d = this.f14889c.getWritableDatabase();
        this.f14890d.execSQL("delete from waypoint");
        this.f14890d.close();
    }

    /* renamed from: a */
    public void m7517a(List<C2907bk> list) {
        m7528a();
        this.f14890d = this.f14889c.getWritableDatabase();
        for (C2907bk c2907bk : list) {
            this.f14890d.insert(f14876f, null, m7524a(c2907bk));
        }
    }

    /* renamed from: a */
    public void m7516a(List<ContentValues> list, String str) {
        Log.e("查数据", "fdfdfdfdfdfd");
        this.f14890d = this.f14889c.getWritableDatabase();
        for (ContentValues contentValues : list) {
            this.f14890d.insert(str, null, contentValues);
        }
    }

    /* renamed from: b */
    public int m7514b(String str, String str2) {
        int i = 0;
        this.f14890d = this.f14889c.getWritableDatabase();
        Cursor rawQuery = this.f14890d.rawQuery(str, null);
        while (rawQuery.moveToNext()) {
            i = rawQuery.getInt(rawQuery.getColumnIndex(str2));
        }
        rawQuery.close();
        return i;
    }

    /* renamed from: b */
    public List<C2907bk> m7515b() {
        this.f14890d = this.f14889c.getReadableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.f14890d.rawQuery("select latitude,longitude,height,sequence,link,type,flyOver from waypoint", null);
        if (rawQuery.getCount() > 0) {
            rawQuery.moveToFirst();
            while (!rawQuery.isAfterLast()) {
                arrayList.add(m7526a(rawQuery));
                rawQuery.moveToNext();
            }
        } else {
            arrayList = null;
        }
        rawQuery.close();
        this.f14889c.close();
        return arrayList;
    }
}
