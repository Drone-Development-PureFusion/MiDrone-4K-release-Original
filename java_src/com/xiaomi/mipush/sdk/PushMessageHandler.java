package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.service.C4633aw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PushMessageHandler extends IntentService {

    /* renamed from: a */
    private static List<MiPushClient.MiPushClientCallback> f18609a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.PushMessageHandler$a */
    /* loaded from: classes.dex */
    public interface AbstractC4519a extends Serializable {
    }

    public PushMessageHandler() {
        super("mipush message handler");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m4921a() {
        synchronized (f18609a) {
            f18609a.clear();
        }
    }

    /* renamed from: a */
    public static void m4920a(long j, String str, String str2) {
        synchronized (f18609a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f18609a) {
                miPushClientCallback.onInitializeResult(j, str, str2);
            }
        }
    }

    /* renamed from: a */
    public static void m4919a(Context context, MiPushMessage miPushMessage) {
        synchronized (f18609a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f18609a) {
                if (m4914a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m4918a(Context context, AbstractC4519a abstractC4519a) {
        String str = null;
        if (abstractC4519a instanceof MiPushMessage) {
            m4919a(context, (MiPushMessage) abstractC4519a);
        } else if (!(abstractC4519a instanceof MiPushCommandMessage)) {
        } else {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) abstractC4519a;
            String command = miPushCommandMessage.getCommand();
            if (MiPushClient.COMMAND_REGISTER.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                m4920a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (MiPushClient.COMMAND_SET_ALIAS.equals(command) || MiPushClient.COMMAND_UNSET_ALIAS.equals(command) || MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command)) {
                m4916a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
            } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                m4917a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), (commandArguments2 == null || commandArguments2.isEmpty()) ? null : commandArguments2.get(0));
            } else if (!MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
            } else {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                m4912b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), (commandArguments3 == null || commandArguments3.isEmpty()) ? null : commandArguments3.get(0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m4917a(Context context, String str, long j, String str2, String str3) {
        synchronized (f18609a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f18609a) {
                if (m4914a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m4916a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (f18609a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f18609a) {
                if (m4914a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m4915a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (f18609a) {
            if (!f18609a.contains(miPushClientCallback)) {
                f18609a.add(miPushClientCallback);
            }
        }
    }

    /* renamed from: a */
    protected static boolean m4914a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    /* renamed from: b */
    protected static void m4912b(Context context, String str, long j, String str2, String str3) {
        synchronized (f18609a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f18609a) {
                if (m4914a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m4913b() {
        return f18609a.isEmpty();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        ResolveInfo resolveInfo;
        try {
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                if (!C4520a.m4909a(this).m4895i()) {
                    return;
                }
                C4545u.m4818a(this).m4820a();
                String stringExtra = intent.getStringExtra("waker_pkgname");
                JSONObject jSONObject = new JSONObject();
                if (TextUtils.isEmpty(stringExtra)) {
                    jSONObject.put("wakerPkgName", stringExtra);
                }
                jSONObject.put("selfPkgName", getPackageName());
                C4633aw.m4319a().m4309a("system_running_log", "wake_up_app", 1L, jSONObject.toString());
            } else if (1 == PushMessageHelper.getPushMode(this)) {
                if (m4913b()) {
                    AbstractC4478b.m5036d("receive a message before application calling initialize");
                    return;
                }
                AbstractC4519a m4827a = C4543s.m4830a(this).m4827a(intent);
                if (m4827a == null) {
                    return;
                }
                m4918a(this, m4827a);
            } else {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(getPackageName());
                intent2.putExtras(intent);
                try {
                    List<ResolveInfo> queryBroadcastReceivers = getPackageManager().queryBroadcastReceivers(intent2, 32);
                    if (queryBroadcastReceivers != null) {
                        Iterator<ResolveInfo> it2 = queryBroadcastReceivers.iterator();
                        while (it2.hasNext()) {
                            resolveInfo = it2.next();
                            if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(getPackageName())) {
                                break;
                            }
                        }
                    }
                    resolveInfo = null;
                    if (resolveInfo != null) {
                        ((PushMessageReceiver) Class.forName(resolveInfo.activityInfo.name).newInstance()).onReceive(getApplicationContext(), intent2);
                    } else {
                        AbstractC4478b.m5036d("cannot find the receiver to handler this message, check your manifest");
                    }
                } catch (Exception e) {
                    AbstractC4478b.m5039a(e);
                }
            }
        } catch (Throwable th) {
            AbstractC4478b.m5039a(th);
        }
    }
}
