package com.fimi.soul.utils.p211a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fimi.soul.entity.HistoryPushMessage;
import com.fimi.soul.utils.C3679h;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.utils.a.c */
/* loaded from: classes.dex */
public class C3628c {

    /* renamed from: a */
    public static final String f14763a = "create table  if not exists history_push_message(orderId int auto_increment primary key ,url varchar(600) ,title varchar(20) ,payload varchar(20) ,id varchar(20) ,msgType varchar(20) ,passThrough varchar(20) ,statue varchar(20) ,time varchar(20))";

    /* renamed from: e */
    private static C3628c f14764e;

    /* renamed from: b */
    private C3679h f14765b;

    /* renamed from: c */
    private SQLiteDatabase f14766c;

    /* renamed from: d */
    private Context f14767d;

    /* renamed from: com.fimi.soul.utils.a.c$a */
    /* loaded from: classes.dex */
    public static class C3629a {

        /* renamed from: a */
        public static final String f14768a = "history_push_message";

        /* renamed from: b */
        public static final String f14769b = "url";

        /* renamed from: c */
        public static final String f14770c = "title";

        /* renamed from: d */
        public static final String f14771d = "payload";

        /* renamed from: e */
        public static final String f14772e = "statue";

        /* renamed from: f */
        public static final String f14773f = "passThrough";

        /* renamed from: g */
        public static final String f14774g = "id";

        /* renamed from: h */
        public static final String f14775h = "msgType";

        /* renamed from: i */
        public static final String f14776i = "time";

        /* renamed from: j */
        public static final String f14777j = "orderId";
    }

    private C3628c(Context context) {
        this.f14767d = context;
        this.f14765b = C3679h.m7485a(context);
        this.f14766c = this.f14765b.getWritableDatabase();
    }

    /* renamed from: a */
    public static C3628c m7748a(Context context) {
        if (f14764e == null) {
            f14764e = new C3628c(context.getApplicationContext());
        }
        return f14764e;
    }

    /* renamed from: a */
    public long m7747a(HistoryPushMessage historyPushMessage) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", historyPushMessage.getRedirectURL());
        contentValues.put("title", historyPushMessage.getTitle());
        contentValues.put(C3629a.f14771d, historyPushMessage.getPayload());
        contentValues.put(C3629a.f14776i, historyPushMessage.getTime());
        contentValues.put(C3629a.f14772e, historyPushMessage.getStatus());
        contentValues.put(C3629a.f14773f, historyPushMessage.getPassThough());
        contentValues.put("id", historyPushMessage.getId());
        contentValues.put("msgType", historyPushMessage.getMsgType());
        return this.f14766c.insert(C3629a.f14768a, null, contentValues);
    }

    /* renamed from: a */
    public List<HistoryPushMessage> m7749a() {
        this.f14766c = this.f14765b.getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.f14766c.rawQuery("select * from history_push_message order by orderId desc", null);
        while (rawQuery.moveToNext()) {
            HistoryPushMessage historyPushMessage = new HistoryPushMessage();
            historyPushMessage.setRedirectURL(rawQuery.getString(rawQuery.getColumnIndex("url")));
            historyPushMessage.setTitle(rawQuery.getString(rawQuery.getColumnIndex("title")));
            historyPushMessage.setPayload(rawQuery.getString(rawQuery.getColumnIndex(C3629a.f14771d)));
            historyPushMessage.setTime(rawQuery.getString(rawQuery.getColumnIndex(C3629a.f14776i)));
            historyPushMessage.setId(rawQuery.getString(rawQuery.getColumnIndex("id")));
            historyPushMessage.setMsgType(rawQuery.getString(rawQuery.getColumnIndex("msgType")));
            historyPushMessage.setPassThough(rawQuery.getString(rawQuery.getColumnIndex(C3629a.f14773f)));
            historyPushMessage.setStatus(rawQuery.getString(rawQuery.getColumnIndex(C3629a.f14772e)));
            arrayList.add(historyPushMessage);
        }
        return arrayList;
    }

    /* renamed from: b */
    public boolean m7746b(HistoryPushMessage historyPushMessage) {
        this.f14766c = this.f14765b.getWritableDatabase();
        try {
            if (this.f14766c.rawQuery("select * from history_push_message where id=?", new String[]{historyPushMessage.getId()}).getCount() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
