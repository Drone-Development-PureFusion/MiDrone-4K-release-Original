package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.fimi.soul.media.player.IMediaPlayer;
import com.tencent.p227mm.sdk.platformtools.Util;
import com.xiaomi.channel.commonutils.android.AbstractC4471h;
import com.xiaomi.channel.commonutils.android.C4464b;
import com.xiaomi.channel.commonutils.android.C4468e;
import com.xiaomi.channel.commonutils.android.C4470g;
import com.xiaomi.channel.commonutils.android.C4473j;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4484f;
import com.xiaomi.channel.commonutils.string.C4507d;
import com.xiaomi.push.service.C4609ah;
import com.xiaomi.push.service.C4633aw;
import com.xiaomi.push.service.C4662h;
import com.xiaomi.push.service.C4670k;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.C4774af;
import com.xiaomi.xmpush.thrift.C4784ak;
import com.xiaomi.xmpush.thrift.C4788am;
import com.xiaomi.xmpush.thrift.C4792ao;
import com.xiaomi.xmpush.thrift.C4823r;
import com.xiaomi.xmpush.thrift.C4838z;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import com.xiaomi.xmpush.thrift.EnumC4803e;
import com.xiaomi.xmpush.thrift.EnumC4827t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static C4551z mSyncMIIDHelper;
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class MiPushClientCallback {
        private String category;

        /* JADX INFO: Access modifiers changed from: protected */
        public String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        protected void setCategory(String str) {
            this.category = str;
        }
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        return TextUtils.equals(getAcceptTime(context), str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences(PREF_EXTRA, 0).getLong("account_" + str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("last_pull_notification", System.currentTimeMillis()).commit();
    }

    private static void addRegRequestTime(Context context) {
        context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("last_reg_request", System.currentTimeMillis()).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        return context.getSharedPreferences(PREF_EXTRA, 0).getLong("alias_" + str, -1L);
    }

    public static void awakeApps(Context context, String[] strArr) {
        new Thread(new RunnableC4538n(strArr, context)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        context.startService(intent);
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREF_EXTRA, 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        C4545u.m4818a(context).m4795f();
    }

    public static void clearNotification(Context context) {
        C4545u.m4818a(context).m4819a(-1);
    }

    public static void clearNotification(Context context, int i) {
        C4545u.m4818a(context).m4819a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        C4545u.m4818a(context).m4811a(str, str2);
    }

    public static void disablePush(Context context) {
        C4545u.m4818a(context).m4803a(true);
    }

    public static void enablePush(Context context) {
        C4545u.m4818a(context).m4803a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized String generatePacketID() {
        String str;
        synchronized (MiPushClient.class) {
            str = C4507d.m4949a(4) + sCurMsgId;
            sCurMsgId++;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences(PREF_EXTRA, 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences(PREF_EXTRA, 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring("alias_".length()));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences(PREF_EXTRA, 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring("topic_".length()));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences(PREF_EXTRA, 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring("account_".length()));
            }
        }
        return arrayList;
    }

    private static boolean getDefaultSwitch() {
        return C4470g.m5074b();
    }

    public static String getRegId(Context context) {
        if (C4520a.m4909a(context).m4895i()) {
            return C4520a.m4909a(context).m4899e();
        }
        return null;
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        boolean z = false;
        checkNotNull(context, C0359h.f700ac);
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        try {
            if (C4633aw.m4319a().m4308b()) {
                C4633aw.m4319a().m4316a(context);
            }
            C4633aw.m4319a().m4314a(new C4523ab(context), "UPLOADER_FROM_MIPUSHCLIENT");
            sContext = context.getApplicationContext();
            if (sContext == null) {
                sContext = context;
            }
            if (miPushClientCallback != null) {
                PushMessageHandler.m4915a(miPushClientCallback);
            }
            if (C4473j.m5064b(context)) {
                C4530h.m4857a(context);
            }
            if (C4520a.m4909a(sContext).m4891m() != Constants.m4924a()) {
                z = true;
            }
            if (!z && !shouldSendRegRequest(sContext)) {
                C4545u.m4818a(context).m4820a();
                AbstractC4478b.m5041a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !C4520a.m4909a(sContext).m4906a(str, str2) || C4520a.m4909a(sContext).m4890n()) {
                String m4949a = C4507d.m4949a(6);
                C4520a.m4909a(sContext).m4896h();
                C4520a.m4909a(sContext).m4910a(Constants.m4924a());
                C4520a.m4909a(sContext).m4905a(str, str2, m4949a);
                clearExtras(sContext);
                C4774af c4774af = new C4774af();
                c4774af.m3676a(generatePacketID());
                c4774af.m3671b(str);
                c4774af.m3661e(str2);
                c4774af.m3664d(context.getPackageName());
                c4774af.m3659f(m4949a);
                c4774af.m3667c(C4464b.m5099a(context, context.getPackageName()));
                c4774af.m3673b(C4464b.m5097b(context, context.getPackageName()));
                c4774af.m3657g("3_2_1");
                c4774af.m3679a(30201);
                c4774af.m3655h(C4468e.m5083b(sContext));
                c4774af.m3677a(EnumC4827t.Init);
                String m5081d = C4468e.m5081d(sContext);
                if (!TextUtils.isEmpty(m5081d)) {
                    if (C4470g.m5074b()) {
                        c4774af.m3653i(m5081d);
                    }
                    c4774af.m3649k(C4507d.m4948a(m5081d));
                }
                c4774af.m3651j(C4468e.m5086a());
                int m5084b = C4468e.m5084b();
                if (m5084b >= 0) {
                    c4774af.m3668c(m5084b);
                }
                C4545u.m4818a(sContext).m4813a(c4774af, z);
            } else {
                if (1 == PushMessageHelper.getPushMode(context)) {
                    checkNotNull(miPushClientCallback, "callback");
                    miPushClientCallback.onInitializeResult(0L, null, C4520a.m4909a(context).m4899e());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(C4520a.m4909a(context).m4899e());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(COMMAND_REGISTER, arrayList, 0L, null, null));
                }
                C4545u.m4818a(context).m4820a();
                if (C4520a.m4909a(sContext).m4911a()) {
                    C4772ae c4772ae = new C4772ae();
                    c4772ae.m3698b(C4520a.m4909a(context).m4901c());
                    c4772ae.m3695c("client_info_update");
                    c4772ae.m3706a(generatePacketID());
                    c4772ae.f19690h = new HashMap();
                    c4772ae.f19690h.put(Constants.EXTRA_KEY_APP_VERSION, C4464b.m5099a(sContext, sContext.getPackageName()));
                    c4772ae.f19690h.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(C4464b.m5097b(sContext, sContext.getPackageName())));
                    c4772ae.f19690h.put("push_sdk_vn", "3_2_1");
                    c4772ae.f19690h.put("push_sdk_vc", Integer.toString(30201));
                    String m4897g = C4520a.m4909a(sContext).m4897g();
                    if (!TextUtils.isEmpty(m4897g)) {
                        c4772ae.f19690h.put("deviceid", m4897g);
                    }
                    C4545u.m4818a(context).m4807a(c4772ae, EnumC4763a.Notification, false, null);
                }
                if (!AbstractC4471h.m5071a(sContext, "update_devId", false)) {
                    updateIMEI();
                    AbstractC4471h.m5069b(sContext, "update_devId", true);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    C4772ae c4772ae2 = new C4772ae();
                    c4772ae2.m3698b(C4520a.m4909a(sContext).m4901c());
                    c4772ae2.m3695c("pull");
                    c4772ae2.m3706a(generatePacketID());
                    c4772ae2.m3702a(false);
                    C4545u.m4818a(sContext).m4806a(c4772ae2, EnumC4763a.Notification, false, null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleGeoFenceRepeatJobs();
            loadPlugin();
            C4549x.m4787a(sContext);
            try {
                if (mSyncMIIDHelper == null) {
                    mSyncMIIDHelper = new C4551z(sContext);
                }
                mSyncMIIDHelper.m4780a(sContext);
            } catch (Exception e) {
                AbstractC4478b.m5036d(e.toString());
            }
            if ("disable_syncing".equals(C4540p.m4845a(sContext).m4846a())) {
                disablePush(sContext);
            }
            if (!"enable_syncing".equals(C4540p.m4845a(sContext).m4846a())) {
                return;
            }
            enablePush(sContext);
        } catch (Throwable th) {
            AbstractC4478b.m5039a(th);
        }
    }

    private static void loadPlugin() {
        if (C4609ah.m4394a(sContext).m4395a(EnumC4803e.DataCollectionSwitch.m3437a(), getDefaultSwitch())) {
            C4484f.m5025a(sContext).m5019a(new RunnableC4536l(), 10);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reInitialize(Context context, EnumC4827t enumC4827t) {
        if (!C4520a.m4909a(context).m4895i()) {
            return;
        }
        String m4949a = C4507d.m4949a(6);
        String m4901c = C4520a.m4909a(context).m4901c();
        String m4900d = C4520a.m4909a(context).m4900d();
        C4520a.m4909a(context).m4896h();
        C4520a.m4909a(context).m4905a(m4901c, m4900d, m4949a);
        C4774af c4774af = new C4774af();
        c4774af.m3676a(generatePacketID());
        c4774af.m3671b(m4901c);
        c4774af.m3661e(m4900d);
        c4774af.m3659f(m4949a);
        c4774af.m3664d(context.getPackageName());
        c4774af.m3667c(C4464b.m5099a(context, context.getPackageName()));
        c4774af.m3677a(enumC4827t);
        C4545u.m4818a(context).m4813a(c4774af, false);
    }

    private static void registerNetworkReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addCategory("android.intent.category.DEFAULT");
        context.registerReceiver(new NetworkStatusReceiver(null), intentFilter);
    }

    public static void registerPush(Context context, String str, String str2) {
        if (!NetworkStatusReceiver.m4114a()) {
            registerNetworkReceiver(context);
        }
        new Thread(new RunnableC4535k(context, str, str2)).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().remove(Constants.EXTRA_KEY_ACCEPT_TIME).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().remove("account_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().remove("alias_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllUserAccount(context)) {
                removeAccount(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllAlias(context)) {
                removeAlias(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllTopic(context)) {
                removeTopic(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().remove("topic_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportIgnoreRegMessageClicked(Context context, String str, C4823r c4823r, String str2, String str3) {
        C4772ae c4772ae = new C4772ae();
        if (TextUtils.isEmpty(str3)) {
            AbstractC4478b.m5036d("do not report clicked message");
            return;
        }
        c4772ae.m3698b(str3);
        c4772ae.m3695c("bar:click");
        c4772ae.m3706a(str);
        c4772ae.m3702a(false);
        C4545u.m4818a(context).m4804a(c4772ae, EnumC4763a.Notification, false, true, c4823r, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        C4823r c4823r = new C4823r();
        c4823r.m3302a(miPushMessage.getMessageId());
        c4823r.m3295b(miPushMessage.getTopic());
        c4823r.m3288d(miPushMessage.getDescription());
        c4823r.m3291c(miPushMessage.getTitle());
        c4823r.m3292c(miPushMessage.getNotifyId());
        c4823r.m3304a(miPushMessage.getNotifyType());
        c4823r.m3297b(miPushMessage.getPassThrough());
        c4823r.m3300a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), c4823r, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportMessageClicked(Context context, String str, C4823r c4823r, String str2) {
        C4772ae c4772ae = new C4772ae();
        if (!TextUtils.isEmpty(str2)) {
            c4772ae.m3698b(str2);
        } else if (!C4520a.m4909a(context).m4903b()) {
            AbstractC4478b.m5036d("do not report clicked message");
            return;
        } else {
            c4772ae.m3698b(C4520a.m4909a(context).m4901c());
        }
        c4772ae.m3695c("bar:click");
        c4772ae.m3706a(str);
        c4772ae.m3702a(false);
        C4545u.m4818a(context).m4807a(c4772ae, EnumC4763a.Notification, false, c4823r);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleGeoFenceRepeatJobs() {
        if (!C4662h.m4248b(sContext)) {
            return;
        }
        C4484f.m5025a(sContext).m5023a((C4484f.AbstractRunnableC4485a) new C4526d(sContext), C4609ah.m4394a(sContext).m4397a(EnumC4803e.UploadWIFIGeoLocFrequency.m3437a(), IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR));
    }

    private static void scheduleOcVersionCheckJob() {
        C4484f.m5025a(sContext).m5022a(new C4539o(sContext), C4609ah.m4394a(sContext).m4397a(EnumC4803e.OcVersionCheckFrequency.m3437a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j = ((((i * 60) + i2) + rawOffset) + 1440) % 1440;
        long j2 = ((rawOffset + ((i3 * 60) + i4)) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, COMMAND_SET_ACCEPT_TIME, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.m4916a(context, str, COMMAND_SET_ACCEPT_TIME, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SET_ACCEPT_TIME, arrayList2, 0L, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, COMMAND_SET_ALIAS, str, str2);
        }
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (COMMAND_SET_ALIAS.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < Util.MILLSECONDS_OF_HOUR) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m4916a(context, str3, str, 0L, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SET_ALIAS, arrayList, 0L, null, null));
            }
        } else if (COMMAND_UNSET_ALIAS.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            AbstractC4478b.m5041a("Don't cancel alias for " + arrayList + " is unseted");
        } else if (COMMAND_SET_ACCOUNT.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < Util.MILLSECONDS_OF_HOUR) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m4916a(context, str3, str, 0L, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SET_ACCOUNT, arrayList, 0L, null, null));
            }
        } else if (!COMMAND_UNSET_ACCOUNT.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, arrayList, str3);
        } else {
            AbstractC4478b.m5041a("Don't cancel account for " + arrayList + " is unseted");
        }
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(C4520a.m4909a(context).m4901c())) {
            return;
        }
        C4838z c4838z = new C4838z();
        c4838z.m3168a(generatePacketID());
        c4838z.m3165b(C4520a.m4909a(context).m4901c());
        c4838z.m3163c(str);
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            c4838z.m3161d(it2.next());
        }
        c4838z.m3157f(str2);
        c4838z.m3159e(context.getPackageName());
        C4545u.m4818a(context).m4809a((C4545u) c4838z, EnumC4763a.Command, (C4823r) null);
    }

    public static void setLocalNotificationType(Context context, int i) {
        C4545u.m4818a(context).m4800b(i & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, COMMAND_SET_ACCOUNT, str, str2);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences(PREF_EXTRA, 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences(PREF_EXTRA, 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return C4545u.m4818a(context).m4798c();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(C4520a.m4909a(context).m4901c()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= Util.MILLSECONDS_OF_DAY) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m4917a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SUBSCRIBE_TOPIC, arrayList, 0L, null, null));
            return;
        }
        C4784ak c4784ak = new C4784ak();
        c4784ak.m3568a(generatePacketID());
        c4784ak.m3565b(C4520a.m4909a(context).m4901c());
        c4784ak.m3563c(str);
        c4784ak.m3561d(context.getPackageName());
        c4784ak.m3559e(str2);
        C4545u.m4818a(context).m4809a((C4545u) c4784ak, EnumC4763a.Subscription, (C4823r) null);
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences(PREF_EXTRA, 0).getLong("topic_" + str, -1L);
    }

    public static void unregisterPush(Context context) {
        if (!C4520a.m4909a(context).m4903b()) {
            return;
        }
        C4788am c4788am = new C4788am();
        c4788am.m3535a(generatePacketID());
        c4788am.m3532b(C4520a.m4909a(context).m4901c());
        c4788am.m3530c(C4520a.m4909a(context).m4899e());
        c4788am.m3526e(C4520a.m4909a(context).m4900d());
        c4788am.m3528d(context.getPackageName());
        C4545u.m4818a(context).m4812a(c4788am);
        PushMessageHandler.m4921a();
        C4520a.m4909a(context).m4893k();
        clearExtras(context);
        clearLocalNotificationType(context);
        clearNotification(context);
        if (mSyncMIIDHelper == null) {
            return;
        }
        C4670k.m4213a(context).m4207b(mSyncMIIDHelper);
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, COMMAND_UNSET_ALIAS, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, COMMAND_UNSET_ACCOUNT, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (!C4520a.m4909a(context).m4903b()) {
            return;
        }
        if (topicSubscribedTime(context, str) < 0) {
            AbstractC4478b.m5041a("Don't cancel subscribe for " + str + " is unsubscribed");
            return;
        }
        C4792ao c4792ao = new C4792ao();
        c4792ao.m3503a(generatePacketID());
        c4792ao.m3500b(C4520a.m4909a(context).m4901c());
        c4792ao.m3498c(str);
        c4792ao.m3496d(context.getPackageName());
        c4792ao.m3494e(str2);
        C4545u.m4818a(context).m4809a((C4545u) c4792ao, EnumC4763a.UnSubscription, (C4823r) null);
    }

    private static void updateIMEI() {
        new Thread(new RunnableC4537m()).start();
    }
}
