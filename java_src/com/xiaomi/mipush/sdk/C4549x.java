package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4480b;
import com.xiaomi.channel.commonutils.misc.C4484f;
import com.xiaomi.channel.commonutils.string.C4507d;
import com.xiaomi.push.service.C4609ah;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.EnumC4803e;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
/* renamed from: com.xiaomi.mipush.sdk.x */
/* loaded from: classes2.dex */
public class C4549x {
    /* renamed from: a */
    public static void m4787a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        long j = sharedPreferences.getLong("last_sync_info", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long m4397a = C4609ah.m4394a(context).m4397a(EnumC4803e.SyncInfoFrequency.m3437a(), 1209600);
        if (j == -1) {
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j) <= m4397a) {
        } else {
            m4785a(context, true);
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    /* renamed from: a */
    public static void m4786a(Context context, C4772ae c4772ae) {
        AbstractC4478b.m5041a("need to update local info with: " + c4772ae.m3688i());
        String str = c4772ae.m3688i().get(Constants.EXTRA_KEY_ACCEPT_TIME);
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if (!"00:00".equals(split[0]) || !"00:00".equals(split[1])) {
                    C4520a.m4909a(context).m4904a(false);
                } else {
                    C4520a.m4909a(context).m4904a(true);
                }
            }
        }
        String str2 = c4772ae.m3688i().get(Constants.EXTRA_KEY_ALIASES);
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                for (String str3 : split2) {
                    MiPushClient.addAlias(context, str3);
                }
            }
        }
        String str4 = c4772ae.m3688i().get(Constants.EXTRA_KEY_TOPICS);
        if (str4 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str4)) {
                String[] split3 = str4.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                for (String str5 : split3) {
                    MiPushClient.addTopic(context, str5);
                }
            }
        }
        String str6 = c4772ae.m3688i().get(Constants.EXTRA_KEY_ACCOUNTS);
        if (str6 != null) {
            MiPushClient.removeAllAccounts(context);
            if ("".equals(str6)) {
                return;
            }
            String[] split4 = str6.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str7 : split4) {
                MiPushClient.addAccount(context, str7);
            }
        }
    }

    /* renamed from: a */
    public static void m4785a(Context context, boolean z) {
        C4484f.m5025a(context).m5020a(new RunnableC4550y(context, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static String m4782c(List<String> list) {
        String m4948a = C4507d.m4948a(m4781d(list));
        return (TextUtils.isEmpty(m4948a) || m4948a.length() <= 4) ? "" : m4948a.substring(0, 4).toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static String m4781d(List<String> list) {
        if (C4480b.m5030a(list)) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        String str = "";
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            str = str + str2;
        }
        return str;
    }
}
