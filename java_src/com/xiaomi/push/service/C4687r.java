package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.smack.C4727l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* renamed from: com.xiaomi.push.service.r */
/* loaded from: classes.dex */
public class C4687r {

    /* renamed from: a */
    private static final Map<String, byte[]> f19183a = new HashMap();

    /* renamed from: b */
    private static ArrayList<Pair<String, byte[]>> f19184b = new ArrayList<>();

    /* renamed from: a */
    public static void m4120a(Context context, int i, String str) {
        synchronized (f19183a) {
            for (String str2 : f19183a.keySet()) {
                m4119a(context, str2, f19183a.get(str2), i, str);
            }
            f19183a.clear();
        }
    }

    /* renamed from: a */
    public static void m4119a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, C4643b.m4285a(str));
    }

    /* renamed from: a */
    public static void m4118a(XMPushService xMPushService) {
        try {
            synchronized (f19183a) {
                for (String str : f19183a.keySet()) {
                    C4598aa.m4439a(xMPushService, str, f19183a.get(str));
                }
                f19183a.clear();
            }
        } catch (C4727l e) {
            AbstractC4478b.m5039a(e);
            xMPushService.m4499a(10, e);
        }
    }

    /* renamed from: a */
    public static void m4117a(String str, byte[] bArr) {
        synchronized (f19183a) {
            f19183a.put(str, bArr);
        }
    }

    /* renamed from: b */
    public static void m4116b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f19184b) {
                arrayList = f19184b;
                f19184b = new ArrayList<>();
            }
            Iterator<Pair<String, byte[]>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Pair<String, byte[]> next = it2.next();
                C4598aa.m4439a(xMPushService, (String) next.first, (byte[]) next.second);
            }
        } catch (C4727l e) {
            AbstractC4478b.m5039a(e);
            xMPushService.m4499a(10, e);
        }
    }

    /* renamed from: b */
    public static void m4115b(String str, byte[] bArr) {
        synchronized (f19184b) {
            f19184b.add(new Pair<>(str, bArr));
            if (f19184b.size() > 50) {
                f19184b.remove(0);
            }
        }
    }
}
