package cn.sharesdk.framework.p075b.p076a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import cn.sharesdk.framework.utils.C0683d;
import com.tencent.p227mm.sdk.message.RMsgInfoDB;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* renamed from: cn.sharesdk.framework.b.a.d */
/* loaded from: classes.dex */
public class C0652d {
    /* renamed from: a */
    public static synchronized long m19682a(Context context, String str, long j) {
        long m19686a;
        synchronized (C0652d.class) {
            if (str != null) {
                if (str.trim() != "") {
                    C0650b m19688a = C0650b.m19688a(context);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("post_time", Long.valueOf(j));
                    contentValues.put("message_data", str.toString());
                    m19686a = m19688a.m19686a(RMsgInfoDB.TABLE, contentValues);
                }
            }
            m19686a = -1;
        }
        return m19686a;
    }

    /* renamed from: a */
    public static synchronized long m19680a(Context context, ArrayList<String> arrayList) {
        long j;
        synchronized (C0652d.class) {
            if (arrayList == null) {
                j = 0;
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("'");
                    sb.append(arrayList.get(i));
                    sb.append("'");
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                int m19685a = C0650b.m19688a(context).m19685a(RMsgInfoDB.TABLE, "_id in ( " + sb.toString().substring(0, sb.length() - 1) + " )", null);
                C0683d.m19513a().m5966i("delete COUNT == %s", Integer.valueOf(m19685a));
                j = m19685a;
            }
        }
        return j;
    }

    /* renamed from: a */
    public static synchronized ArrayList<C0651c> m19683a(Context context) {
        ArrayList<C0651c> m19681a;
        synchronized (C0652d.class) {
            m19681a = C0650b.m19688a(context).m19687a(RMsgInfoDB.TABLE) > 0 ? m19681a(context, (String) null, (String[]) null) : new ArrayList<>();
        }
        return m19681a;
    }

    /* renamed from: a */
    private static synchronized ArrayList<C0651c> m19681a(Context context, String str, String[] strArr) {
        ArrayList<C0651c> arrayList;
        synchronized (C0652d.class) {
            arrayList = new ArrayList<>();
            C0651c c0651c = new C0651c();
            StringBuilder sb = new StringBuilder();
            Cursor m19684a = C0650b.m19688a(context).m19684a(RMsgInfoDB.TABLE, new String[]{"_id", "post_time", "message_data"}, str, strArr, null);
            StringBuilder sb2 = sb;
            C0651c c0651c2 = c0651c;
            while (m19684a != null && m19684a.moveToNext()) {
                c0651c2.f1489b.add(m19684a.getString(0));
                if (c0651c2.f1489b.size() == 100) {
                    sb2.append(m19684a.getString(2));
                    c0651c2.f1488a = sb2.toString();
                    arrayList.add(c0651c2);
                    c0651c2 = new C0651c();
                    sb2 = new StringBuilder();
                } else {
                    sb2.append(m19684a.getString(2) + "\n");
                }
            }
            m19684a.close();
            if (c0651c2.f1489b.size() != 0) {
                c0651c2.f1488a = sb2.toString().substring(0, sb2.length() - 1);
                arrayList.add(c0651c2);
            }
        }
        return arrayList;
    }
}
