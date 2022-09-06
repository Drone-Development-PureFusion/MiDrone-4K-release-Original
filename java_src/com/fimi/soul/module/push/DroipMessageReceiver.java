package com.fimi.soul.module.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.fimi.kernel.C2238c;
import com.fimi.p139b.AbstractC2089b;
import com.fimi.soul.C2304a;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2578n;
import com.fimi.soul.entity.HistoryPushMessage;
import com.fimi.soul.entity.MessagePush;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.login.LoginActivity;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.p211a.C3628c;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class DroipMessageReceiver extends PushMessageReceiver {

    /* renamed from: a */
    private String f13300a;

    /* renamed from: b */
    private long f13301b = -1;

    /* renamed from: c */
    private String f13302c;

    /* renamed from: d */
    private String f13303d;

    /* renamed from: e */
    private String f13304e;

    /* renamed from: f */
    private String f13305f;

    /* renamed from: g */
    private String f13306g;

    /* renamed from: h */
    private String f13307h;

    /* renamed from: i */
    private String f13308i;

    /* renamed from: j */
    private String f13309j;

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String command = miPushCommandMessage.getCommand();
        List<String> commandArguments = miPushCommandMessage.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
        String str2 = (commandArguments == null || commandArguments.size() <= 1) ? null : commandArguments.get(1);
        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
            if (miPushCommandMessage.getResultCode() != 0) {
                return;
            }
            this.f13300a = str;
            if (this.f13300a == null) {
                return;
            }
            C2578n m11627a = C2578n.m11627a(context);
            MessagePush messagePush = new MessagePush();
            messagePush.setUserID(C2353b.m12507c(context).getUserID());
            messagePush.setMiRegID(this.f13300a);
            messagePush.setAppType("0");
            m11627a.m11625a(messagePush, new AbstractC2538k() { // from class: com.fimi.soul.module.push.DroipMessageReceiver.1
                @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                /* renamed from: a */
                public void mo6501a(PlaneMsg planeMsg, File file) {
                }
            });
        } else if (MiPushClient.COMMAND_SET_ALIAS.equals(command)) {
            if (miPushCommandMessage.getResultCode() != 0) {
                return;
            }
            this.f13306g = str;
        } else if (MiPushClient.COMMAND_UNSET_ALIAS.equals(command)) {
            if (miPushCommandMessage.getResultCode() != 0) {
                return;
            }
            this.f13306g = str;
        } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
            if (miPushCommandMessage.getResultCode() != 0) {
                return;
            }
            this.f13305f = str;
        } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
            if (miPushCommandMessage.getResultCode() != 0) {
                return;
            }
            this.f13305f = str;
        } else if (!MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command) || miPushCommandMessage.getResultCode() != 0) {
        } else {
            this.f13308i = str;
            this.f13309j = str2;
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        this.f13304e = miPushMessage.getContent();
        if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
            this.f13305f = miPushMessage.getTopic();
        } else if (!TextUtils.isEmpty(miPushMessage.getAlias())) {
            this.f13306g = miPushMessage.getAlias();
        } else if (!TextUtils.isEmpty(miPushMessage.getUserAccount())) {
            this.f13307h = miPushMessage.getUserAccount();
        }
        C3628c m7748a = C3628c.m7748a(context);
        HistoryPushMessage historyPushMessage = new HistoryPushMessage();
        historyPushMessage.setId(miPushMessage.getExtra().get("id"));
        if (m7748a.m7746b(historyPushMessage)) {
            return;
        }
        historyPushMessage.setTitle(miPushMessage.getTitle());
        historyPushMessage.setPayload(miPushMessage.getDescription());
        historyPushMessage.setRedirectURL(miPushMessage.getExtra().get("redirectURL"));
        historyPushMessage.setMsgType(miPushMessage.getExtra().get("msgType"));
        historyPushMessage.setTime(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
        m7748a.m7747a(historyPushMessage);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        this.f13304e = miPushMessage.getContent();
        if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
            this.f13305f = miPushMessage.getTopic();
        } else if (!TextUtils.isEmpty(miPushMessage.getAlias())) {
            this.f13306g = miPushMessage.getAlias();
        } else if (TextUtils.isEmpty(miPushMessage.getUserAccount())) {
        } else {
            this.f13307h = miPushMessage.getUserAccount();
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveMessage(Context context, MiPushMessage miPushMessage) {
        super.onReceiveMessage(context, miPushMessage);
        String str = miPushMessage.getExtra().get("redirectURL");
        if (C3658ar.m7617a(context, FlightActivity.class)) {
            if (!C3658ar.m7565q(context)) {
                Intent intent = new Intent(context, MessageDetailActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("redirectURL", str);
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(context, FlightActivity.class);
            intent2.setFlags(268435456);
            Intent intent3 = new Intent(context, MessageDetailActivity.class);
            intent3.putExtra("redirectURL", str);
            context.startActivities(new Intent[]{intent2, intent3});
        } else if (!C3658ar.m7617a(context, LoginActivity.class)) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(C2304a.f7691b);
            launchIntentForPackage.setFlags(270532608);
            Bundle bundle = new Bundle();
            bundle.putString("redirectURL", str);
            bundle.putBoolean("islaunch", true);
            launchIntentForPackage.putExtra("launchBundle", bundle);
            context.startActivity(launchIntentForPackage);
        } else if (!C3658ar.m7565q(context)) {
            Intent intent4 = new Intent(context, MessageDetailActivity.class);
            intent4.setFlags(268435456);
            intent4.putExtra("redirectURL", str);
            context.startActivity(intent4);
        } else {
            Intent intent5 = new Intent(context, LoginActivity.class);
            if (C2238c.m13123e().m12746o() == 0) {
                intent5.putExtra(AbstractC2089b.f6992j, 2);
            } else {
                intent5.putExtra(AbstractC2089b.f6992j, 3);
            }
            intent5.setFlags(268435456);
            Intent intent6 = new Intent(context, MessageDetailActivity.class);
            intent6.putExtra("redirectURL", str);
            context.startActivities(new Intent[]{intent5, intent6});
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        this.f13304e = miPushMessage.getContent();
        if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
            this.f13305f = miPushMessage.getTopic();
        } else if (!TextUtils.isEmpty(miPushMessage.getAlias())) {
            this.f13306g = miPushMessage.getAlias();
        } else if (TextUtils.isEmpty(miPushMessage.getUserAccount())) {
        } else {
            this.f13307h = miPushMessage.getUserAccount();
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String command = miPushCommandMessage.getCommand();
        List<String> commandArguments = miPushCommandMessage.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            commandArguments.get(1);
        }
        if (!MiPushClient.COMMAND_REGISTER.equals(command) || miPushCommandMessage.getResultCode() != 0) {
            return;
        }
        this.f13300a = str;
    }
}
