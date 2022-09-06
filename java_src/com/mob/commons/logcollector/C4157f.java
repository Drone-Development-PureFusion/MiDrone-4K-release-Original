package com.mob.commons.logcollector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
/* renamed from: com.mob.commons.logcollector.f */
/* loaded from: classes.dex */
public class C4157f {
    /* renamed from: a */
    public static synchronized long m5976a(Context context, long j, String str, int i, String str2) {
        long m6007a;
        synchronized (C4157f.class) {
            if (TextUtils.isEmpty(str)) {
                m6007a = -1;
            } else {
                C4153b m6009a = C4153b.m6009a(context);
                ContentValues contentValues = new ContentValues();
                contentValues.put("exception_time", Long.valueOf(j));
                contentValues.put("exception_msg", str.toString());
                contentValues.put("exception_level", Integer.valueOf(i));
                contentValues.put("exception_md5", str2);
                m6007a = m6009a.m6007a("table_exception", contentValues);
            }
        }
        return m6007a;
    }

    /* renamed from: a */
    public static synchronized long m5974a(Context context, ArrayList<String> arrayList) {
        long j;
        synchronized (C4157f.class) {
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
                int m6006a = C4153b.m6009a(context).m6006a("table_exception", "exception_md5 in ( " + sb.toString().substring(0, sb.length() - 1) + " )", null);
                MobLog.getInstance().m5966i("delete COUNT == %s", Integer.valueOf(m6006a));
                j = m6006a;
            }
        }
        return j;
    }

    /* renamed from: a */
    private static synchronized ArrayList<C4156e> m5975a(Context context, String str, String[] strArr) {
        ArrayList<C4156e> arrayList;
        synchronized (C4157f.class) {
            arrayList = new ArrayList<>();
            C4156e c4156e = new C4156e();
            C4153b m6009a = C4153b.m6009a(context);
            String str2 = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception group by exception_md5 having max(_id)";
            if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
                str2 = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception where " + str + " group by exception_md5 having max(_id)";
            }
            Cursor m6005a = m6009a.m6005a(str2, strArr);
            while (true) {
                if (m6005a == null || !m6005a.moveToNext()) {
                    break;
                }
                c4156e.f17336b.add(m6005a.getString(0));
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("type", Integer.valueOf(m6005a.getInt(1)));
                hashMap.put("errat", Long.valueOf(m6005a.getLong(2)));
                hashMap.put(SocialConstants.PARAM_SEND_MSG, Base64.encodeToString(m6005a.getString(3).getBytes(), 2));
                hashMap.put("times", Integer.valueOf(m6005a.getInt(4)));
                c4156e.f17335a.add(hashMap);
                if (c4156e.f17336b.size() == 50) {
                    arrayList.add(c4156e);
                    c4156e = new C4156e();
                    break;
                }
            }
            m6005a.close();
            if (c4156e.f17336b.size() != 0) {
                arrayList.add(c4156e);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0009, code lost:
        if (r5.length <= 0) goto L5;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized ArrayList<C4156e> m5973a(Context context, String[] strArr) {
        ArrayList<C4156e> m5975a;
        synchronized (C4157f.class) {
            String str = "exception_level = ?";
            if (strArr != null) {
            }
            str = null;
            strArr = null;
            m5975a = C4153b.m6009a(context).m6008a("table_exception") > 0 ? m5975a(context, str, strArr) : new ArrayList<>();
        }
        return m5975a;
    }
}
